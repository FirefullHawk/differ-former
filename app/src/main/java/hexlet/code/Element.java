package hexlet.code;

class Element<T> {
    private final Status status;
    private final String name;
    private final T contentFirstMap;
    private final T contentSecondMap;

    Element(Status status, String name, T contentFirstMap, T contentSecondMap) {
        this.status = status;
        this.name = name;
        this.contentFirstMap = contentFirstMap;
        this.contentSecondMap = contentSecondMap;
    }
    Element(Status status, String name, T contentFirstMap) {
        this.status = status;
        this.name = name;
        this.contentFirstMap = contentFirstMap;
        this.contentSecondMap = null;
    }
    Element() {
        this.status = null;
        this.name = null;
        this.contentFirstMap = null;
        this.contentSecondMap = null;
    }

    public String getFullElement() {
        return status + "%" + name + "%" + contentFirstMap + "%" + contentSecondMap;
    }

}
