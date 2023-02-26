package models;

public enum TicketType {
    VIP("vip"),
    USUAL("usual"),
    BUDGETARY("budgetary"),
    CHEAP("cheap");

    public final String type;
    TicketType(String type) {
        this.type = type;
    }

    public String getName() {
        return type;
    }

    @Override
    public String toString() {
        return "Ticket's type{" +
                "name='" + type + '\'' +
                '}';
    }
}
