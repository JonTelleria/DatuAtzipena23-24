package dambi.netflix.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import dambi.netflix.models.Titles;

/**
 * Repository interface for Titles entity, extending MongoRepository.
 * Provides CRUD operations for Titles.
 */
public interface TitleRepository extends MongoRepository<Titles, String> {

    /**
     * Finds a title by its title name.
     * @param oldTitle the title name to search for.
     * @return an Optional containing the title if found, otherwise empty.
     */
    Optional<Titles> findByTitle(String oldTitle);
}
