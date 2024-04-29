package se.enso.hokku.configuration;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import java.io.IOException;
import java.io.InputStream;
import javax.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FirebaseConfig {

  @PostConstruct
  public void initialize() {
    try {
      InputStream serviceAccount = getClass().getClassLoader()
          .getResourceAsStream("ServiceAccountKey.json");

      FirebaseOptions options = null;
      if (serviceAccount != null) {
        options = new FirebaseOptions.Builder()
            .setCredentials(GoogleCredentials.fromStream(serviceAccount))
            .setDatabaseUrl("https://mindful-ai-guru.firebaseio.com")
            .build();
      }

      if (FirebaseApp.getApps().isEmpty()) {
        FirebaseApp.initializeApp(options);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}


