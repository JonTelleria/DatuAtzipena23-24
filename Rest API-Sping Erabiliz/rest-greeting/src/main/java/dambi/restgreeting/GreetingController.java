package dambi.restgreeting;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(
            @RequestParam(value = "name", defaultValue = "World") String name,
            @RequestParam(value = "lang", defaultValue = "es") String language) {

                String content = "";

                switch (language) {
                    case "es":
                        content= "Hola " + name + "!";
                        break;
                    case "eus":
                        content= "Kaixo " + name + "!";
                        break;
                    case "en":
                        content= "Hello " + name + "!";
                        break;
                
                    default:
                        break;
                }
        return new Greeting(counter.incrementAndGet(), content);
    }
}
