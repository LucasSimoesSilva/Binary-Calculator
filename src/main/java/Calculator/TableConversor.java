package Calculator;

import java.util.stream.Stream;

public enum TableConversor {
    ZERO_O("000",0),
    ONE_O("001",1),
    TWO_O("010",2),
    THREE_O("011",3),
    FOR_O("100",4),
    FIVE_O("101",5),
    SIX_O("110",6),
    SEVEN_O("111",7),
    ZERO("0000",0),
    ONE("0001",1),
    TWO("0010",2),
    THREE("0011",3),
    FOR("0100",4),
    FIVE("0101",5),
    SIX("0110",6),
    SEVEN("0111",7),
    EIGHT("1000",8),
    NINE("1001",9),
    A("1010",10),
    B("1011",11),
    C("1100",12),
    D("1101",13),
    E("1110",14),
    F("1111",15);
    private final String group;
    private final int value;

    TableConversor(String group, int value) {
        this.group = group;
        this.value = value;
    }

    public String getGroup() {
        return group;
    }

    public int getValue() {
        return value;
    }

    public static Stream<TableConversor> stream() {
        return Stream.of(TableConversor.values());
    }
}
