package com.baeldung.mockito.bddmockito;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.BDDMockito.willThrow;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;


/**
 * https://www.baeldung.com/bdd-mockito
 * https://www.baeldung.com/mockito-junit-5-extension
 */
@ExtendWith(MockitoExtension.class)
public class BDDMockitoUnitTest {

    PhoneBookService phoneBookService;
    PhoneBookRepository phoneBookRepository;

    String momContactName = "Mom";
    String momPhoneNumber = "01234";
    String xContactName = "x";
    String tooLongPhoneNumber = "01111111111111";

    @BeforeEach
    public void init() {
        phoneBookRepository = Mockito.mock(PhoneBookRepository.class);
        phoneBookService = new PhoneBookService(phoneBookRepository);
    }

    @Test
    public void givenValidContactName_whenSearchInPhoneBook_thenRetunPhoneNumber() {
        given(phoneBookRepository.contains(momContactName)).willReturn(true);
        given(phoneBookRepository.getPhoneNumberByContactName(momContactName))
                .will((InvocationOnMock invocation) -> {
                    if(invocation.getArgument(0).equals(momContactName)) {
                        return momPhoneNumber;
                    } else {
                        return null;
                    }
                });

        String phoneNumber = phoneBookService.search(momContactName);

        then(phoneBookRepository).should().contains(momContactName);
        then(phoneBookRepository).should().getPhoneNumberByContactName(momContactName);
    }

    @Test
    public void givenInvalidContactName_whenSearch_thenRetunNull() {
        given(phoneBookRepository.contains(xContactName)).willReturn(false);

        String phoneNumber = phoneBookService.search(xContactName);

        then(phoneBookRepository).should().contains(xContactName);
        then(phoneBookRepository).should(never()).getPhoneNumberByContactName(xContactName);
    }

    @Test
    public void givenValidContactNameAndPhoneNumber_whenRegister_thenSucceed() {
        given(phoneBookRepository.contains(momContactName)).willReturn(false);

        phoneBookService.register(momContactName, momPhoneNumber);

        verify(phoneBookRepository).insert(momContactName, momPhoneNumber);
    }

    @Test
    public void givenEmptyPhoneNumber_whenRegister_thenFail() {
//    	given(phoneBookRepository.contains(momContactName)).willReturn(false);

        phoneBookService.register(xContactName, "");

        then(phoneBookRepository).should(never()).insert(momContactName, momPhoneNumber);
    }

    @Test
    public void givenLongPhoneNumber_whenRegister_thenFail() {
        given(phoneBookRepository.contains(xContactName)).willReturn(false);
        willThrow(new RuntimeException())
                .given(phoneBookRepository).insert(any(String.class), eq(tooLongPhoneNumber));

        try {
            phoneBookService.register(xContactName, tooLongPhoneNumber);
            fail("Should throw exception");
        } catch (RuntimeException ex) { }

        then(phoneBookRepository).should(never()).insert(momContactName, tooLongPhoneNumber);
    }

    @Test
    public void givenExistentContactName_whenRegister_thenFail() {
        given(phoneBookRepository.contains(momContactName))
                .willThrow(new RuntimeException("Name already exist"));

        try {
            phoneBookService.register(momContactName, momPhoneNumber);
            fail("Should throw exception");
        } catch(Exception ex) { }

        then(phoneBookRepository).should(never()).insert(momContactName, momPhoneNumber);
    }

}