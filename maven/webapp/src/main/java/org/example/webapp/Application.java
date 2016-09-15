package org.example.webapp;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.document.JsonDocument;
import com.couchbase.client.java.document.json.JsonObject;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @arungupta
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(Bucket bucket) {
        return args -> {
            JsonObject jsonObject = JsonObject.create();
            jsonObject.put("isbn", "978-1-4919-1889-0");
            jsonObject.put("name", "Minecraft Modding with Forge");
            jsonObject.put("cost", "29.99");
            JsonDocument document = JsonDocument.create("minecraft", jsonObject);
            bucket.upsert(document);

            JsonDocument doc = bucket.get("minecraft");
            System.out.println(doc.content());
        };
    }
}
