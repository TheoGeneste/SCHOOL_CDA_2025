public enum Classe {
    CP("CP"), CE1("CE1"), CE2("CE2"), SIXIEME("6EME");

    private final String value;

    Classe(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
    
}
