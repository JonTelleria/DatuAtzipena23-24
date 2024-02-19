package dambi.netflix.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dambi.netflix.exception.ResourceNotFound;
import dambi.netflix.models.Credits;
import dambi.netflix.models.Titles;
import dambi.netflix.repositories.TitleRepository;

/**
 * Service class for interacting with MongoDB repository for Titles.
 */
@Service
public class TitlesService {

    @Autowired
    private TitleRepository titleRepository;

    /**
     * Retrieves all titles from the MongoDB repository.
     * @return a list of all titles.
     */
    public List<Titles> getTitles() {
        return titleRepository.findAll();
    }

    /**
     * Retrieves a title by its identifier.
     * @param ObjectId the identifier of the title to retrieve.
     * @return the title if found, otherwise throws a ResourceNotFound exception.
     */
    public Titles getTitlesByIdentificator(String ObjectId) {
        Optional<Titles> titles = titleRepository.findById(ObjectId);

        if (titles.isPresent()) {
            return titles.get();
        } else {
            throw new ResourceNotFound("Title with id = " + ObjectId + " doesn't exist");
        }
    }

    /**
     * Retrieves all credits from the MongoDB repository.
     * @return a list of all credits.
     */
    public List<Credits> getAllCredits() {
        List<Titles> titles = titleRepository.findAll();
        List<Credits> allActors = new ArrayList<>();

        for (Titles title : titles) {
            allActors.addAll(title.getCredits());
        }
        return allActors;
    }

    /**
     * Retrieves the title with the highest IMDb score from the MongoDB repository.
     * @return the title with the highest IMDb score.
     */
    public Titles getTitleWithMostScore() {
        List<Titles> titles = titleRepository.findAll();
        Titles title = new Titles();
        for (Titles t : titles) {
            if (t.getImdb_score() > title.getImdb_score()) {
                title = t;
            }
        }
        return title;
    }
    
    /**
     * Retrieves titles associated with a specific actor name from the MongoDB repository.
     * @param name the name of the actor to search for.
     * @return a list of titles associated with the actor.
     */
    public List<Titles> getTitlesOfActors(String name) {
        List<Titles> result = new ArrayList<>();
        for (Titles title : titleRepository.findAll()) {
            for (Credits credit : title.getCredits()) {
                if (credit.getName().equalsIgnoreCase(name)) {
                    result.add(title);
                    break; 
                }
            }
        }
        return result;
    }

    /**
     * Creates a new title in the MongoDB repository.
     * @param titles the title to be created.
     * @return the created title.
     */
    public Titles creaTitles(Titles titles) {
        return titleRepository.save(titles);
    }

    /**
     * Updates a title in the MongoDB repository.
     * @param oldTitle the title to be updated.
     * @param newTitle the new title name.
     */
    public void udpateTitles(String oldTitle, String newTitle) {
        Optional<Titles> optionalTitles = titleRepository.findByTitle(oldTitle);

        if (optionalTitles.isPresent()) {
            Titles titles = optionalTitles.get();
            titles.setTitle(newTitle);
            titleRepository.save(titles);
        } else {
            throw new ResourceNotFound("Title with id = " + oldTitle + " doesn't exist");
        }
    }

    /**
     * Deletes a title from the MongoDB repository.
     * @param ObjectId the identifier of the title to be deleted.
     */
    public void deleteTitle(String ObjectId) {
        Optional<Titles> titles = titleRepository.findById(ObjectId);

        if (titles.isPresent()) {
            titleRepository.deleteById(ObjectId);
        } else {
            throw new ResourceNotFound("Title with id = " + ObjectId + " doesn't exist");
        }
    }
    
    /**
     * Deletes all titles from the MongoDB repository.
     */
    public void deleteAll() {
        titleRepository.deleteAll();
    }
}
