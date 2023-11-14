package javaToKotlin.javas;

public enum Country {

    KOREA("KR"),
    AMERICA("US");

    private final String code;

    Country(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
