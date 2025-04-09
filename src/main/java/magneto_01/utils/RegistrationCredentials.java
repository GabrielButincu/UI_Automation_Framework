package magneto_01.utils;

public enum RegistrationCredentials {

    MAGNETO_VALID_FIRSTNAME("Zitec"),
    MAGNETO_VALID_LASTNAME("Corporate"),
    MAGNETO_VALID_PASSWORD("ZitecCorporate123.!"),
    MAGNETO_VALID_EMAIL_ADDRESS("ZitecTest123INF6@yahoo.com"),

    MAGNETO_INVALID_FIRSTNAME("111111111ZITEC"),
    MAGNETO_INVALID_LASTNAME("CORPORATE123."),
    MAGNETO_INVALID_PASSWORD("0000"),
    MAGNETO_INVALID_EMAIL_ADDRESS("ZitecTest123");


    private final String text;

    RegistrationCredentials(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}

