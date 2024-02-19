package dambi.netflix.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception to be thrown when a requested resource is not found.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFound extends RuntimeException {

    /**
     * Constructs a new ResourceNotFound exception with the specified detail message.
     * @param message the detail message.
     */
    public ResourceNotFound(String message) {
        super(message);
    }
}
