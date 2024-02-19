package dambi.netflix;

import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

/**
 * Configuration class for MongoDB connection setup using Spring.
 */
@Configuration
public class SpringConfiguration {
    
    @Value("${spring.data.mongodb.uri}")
    private String connectionString;

    /**
     * Bean method to create and configure the MongoClient instance.
     * @return MongoClient instance.
     */
    @Bean  
    public MongoClient mongoClient() {
        // Configure POJO codec registry for mapping Java objects to BSON documents
        CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
        // Combine default codec registry and POJO codec registry
        CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);
        
        // Create and return MongoClient with configured settings
        return MongoClients.create(MongoClientSettings.builder()
                                                      .applyConnectionString(new ConnectionString(connectionString))
                                                      .codecRegistry(codecRegistry)
                                                      .build());
    }
}
