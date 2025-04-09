package magneto_01.utils;

public enum LoginCredentials {

    MAGNETO_VALID_FIRSTNAME("TEST"),
    MAGNETO_VALID_LASTNAME("AUTO"),
    MAGNETO_VALID_EMAIL_ADDRESS("TESTAUTO@YAHOO.COM"),
    MAGNETO_VALID_PASSWORD("TESTAUTO12345!.");

    private final String text;

    LoginCredentials(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}