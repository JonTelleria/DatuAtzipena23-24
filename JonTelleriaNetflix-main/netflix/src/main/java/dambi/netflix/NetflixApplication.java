package dambi.netflix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main class for starting the Netflix application.
 */
@SpringBootApplication
public class NetflixApplication {

    /**
     * Main method to start the Netflix application.
     * @param args command-line arguments.
     */
    public static void main(String[] args) {
        SpringApplication.run(NetflixApplication.class, args);
    }
}
