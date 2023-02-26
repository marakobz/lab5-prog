package models;

public enum Country {
    RUSSIA("Russia"),
    UNITED_KINGDOM("uk"),
    USA("usa"),
    FRANCE("France"),
    SPAIN("Spain");
    public final String name;

    Country(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                '}';
    }
}
