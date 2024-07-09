package org.gaas.kuhhandel.controller.demo.websocket;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Type;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;

import org.gaas.kuhhandel.bean.demo.websocket.Message;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.converter.StringMessageConverter;
import org.springframework.messaging.simp.stomp.StompFrameHandler;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;
import org.springframework.web.socket.sockjs.client.SockJsClient;
import org.springframework.web.socket.sockjs.client.WebSocketTransport;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GreetingControllerTest {

  @LocalServerPort private Integer port;

  private WebSocketStompClient webSocketStompClient;

  @BeforeEach
  void setup() {
    this.webSocketStompClient =
        new WebSocketStompClient(
            new SockJsClient(List.of(new WebSocketTransport(new StandardWebSocketClient()))));
  }

  @Test
  void verifyGreetingIsReceived() throws Exception {

    BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(1);

    webSocketStompClient.setMessageConverter(new StringMessageConverter());

    StompSession session =
        webSocketStompClient
            .connectAsync(getWsPath(), new StompSessionHandlerAdapter() {})
            .get(1, SECONDS);

    session.subscribe(
        "/topic/greetings",
        new StompFrameHandler() {

          @Override
          public Type getPayloadType(StompHeaders headers) {
            return String.class;
          }

          @Override
          public void handleFrame(StompHeaders headers, Object payload) {
            blockingQueue.add((String) payload);
          }
        });

    session.send("/app/welcome", "Mike");

    await()
        .atMost(1, SECONDS)
        .untilAsserted(() -> assertEquals("Hello, Mike!", blockingQueue.poll()));
  }

  @Test
  void verifyWelcomeMessageIsSent() throws Exception {
	BlockingQueue<Message> blockingQueue = new ArrayBlockingQueue<>(1);
    CountDownLatch latch = new CountDownLatch(1);

    webSocketStompClient.setMessageConverter(new MappingJackson2MessageConverter());

    StompSession session =
        webSocketStompClient
            .connectAsync(getWsPath(), new StompSessionHandlerAdapter() {})
            .get(1, SECONDS);

    session.subscribe(
        "/app/chat",
        new StompFrameHandler() {

          @Override
          public Type getPayloadType(StompHeaders headers) {
            return Message.class;
          }

          @Override
          public void handleFrame(StompHeaders headers, Object payload) {
            latch.countDown();
            blockingQueue.add((Message) payload);
          }
        });

    await().atMost(1, SECONDS).untilAsserted(() -> assertEquals(0, latch.getCount()));
    System.out.println("blockingQueue.poll().getMessage(): " + blockingQueue.poll().getMessage());
  }

  private String getWsPath() {
    return String.format("ws://localhost:%d/game", port);
  }
}