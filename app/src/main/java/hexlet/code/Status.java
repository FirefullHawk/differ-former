package hexlet.code;

public enum Status {
    updated(" ".repeat(2) + "+-"),
    removed(" ".repeat(2) + "- "),
    added(" ".repeat(2) + "+ "),
    unchanged(" ".repeat(4));

    private final String sign;

    Status(String sign) {
        this.sign = sign;
    }

    public String getSigh() {
        return sign;
    }

    public String returnSigh(String inptString) {
        return switch (inptString) {
            case "added" -> Status.added.getSigh();
            case "removed" -> Status.removed.getSigh();
            default -> Status.unchanged.getSigh();
        };
    }
}
