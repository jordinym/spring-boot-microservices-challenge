package com.jordinymontanez.challenge.customer.service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import com.jordinymontanez.challenge.customer.common.Constants;
import com.jordinymontanez.challenge.customer.config.CustomerConfiguration;
import com.jordinymontanez.challenge.customer.config.PropertiesConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Service
public class FirebaseInitializer {

    private static PropertiesConfig propertiesConfig;
    @Autowired
    public FirebaseInitializer(PropertiesConfig propertiesConfig) {
        FirebaseInitializer.propertiesConfig = propertiesConfig;
    }

    @PostConstruct
    private void initDB() throws IOException {
        InputStream serviceAccount = this.getClass().getClassLoader()
                .getResourceAsStream(propertiesConfig.getConfigValue(Constants.FirebaseType.ACCOUNT_SERVICE.getValue()));

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl(propertiesConfig.getConfigValue(Constants.FirebaseType.DATABASE_URL.getValue())).build();

        if (FirebaseApp.getApps().isEmpty()) {
            FirebaseApp.initializeApp(options);
        }
    }

    public Firestore getFirebase() {
        return FirestoreClient.getFirestore();
    }
}
