package com.jordinymontanez.challenge.report.common;


public final class Constants {
    public  enum SwaggerType {
        TITLE("swagger.title"),
        DESCRIPTION("swagger.description"),
        VERSION("swagger.version"),
        CONTACT_NAME("swagger.contact.name"),
        CONTACT_URL("swagger.contact.url"),
        CONTACT_EMAIL("swagger.contact.email");

        String value;

        SwaggerType(String value) {
            this.value = value;
        }

       public String getValue() {
            return this.value;
        }
    }
}
