package com.jordinymontanez.challenge.customer.common;


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
    public  enum FirebaseType {
        ACCOUNT_SERVICE("firebase.account.service"),
        DATABASE_URL("firebase.database.url");

        String value;

        FirebaseType(String value) {
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }
    }
}
