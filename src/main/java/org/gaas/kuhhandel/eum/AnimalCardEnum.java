package org.gaas.kuhhandel.eum;

public enum AnimalCardEnum {
	HORSE(1,"horse","馬", 1000),
	CATTLE(2,"Cattle","牛", 800),
	PIG(3,"pig","豬", 650),
	DONKEY(4,"donkey","驢", 500),
	GOAT(5,"goat","山羊", 350),
	SHEEP(6,"sheep","羊", 250),
	DOG(7,"dog","狗", 160),
	CAT(8,"cat","貓", 90),
	GOOSE(9,"Goose","鵝", 40),
	ROOSTER(10,"Rooster","公雞", 10);

	
	AnimalCardEnum(int id,String type, String desc,int fraction) {
		this.id = id;
        this.type = type;
        this.desc = desc;
        this.fraction=fraction;
    }
	private int id;
    private String type;
    private String desc;
    private int fraction;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    
    public int getFraction() {
        return fraction;
    }

    public void setFraction(int fraction) {
        this.fraction = fraction;
    }
}
