package dambi.netflix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import dambi.netflix.models.Credits;
import dambi.netflix.models.Titles;
import dambi.netflix.services.TitlesService;

import java.util.List;

/**
 * Controller to manage operations related to titles and credits.
 */
@RestController
@RequestMapping("/api/titles")
public class Controller {

    @Autowired
    private TitlesService mongoRepository;

    /**
     * Gets all available titles.
     * @return List of Titles objects.
     */
    @GetMapping(path = "/all")
    public List<Titles> getTitles() {
        return mongoRepository.getTitles();
    }

    /**
     * Gets a title by its identifier.
     * @param ObjectId Identifier of the title.
     * @return Titles object corresponding to the provided identifier.
     */
    @GetMapping(path = "/{ObjectId}")
    public Titles getTitlesByIdentificator(@PathVariable String ObjectId) {
        return mongoRepository.getTitlesByIdentificator(ObjectId);
    }

    /**
     * Gets all available credits.
     * @return List of Credits objects.
     */
    @GetMapping("/credits/")
    public List<Credits> getAllCredits() {
        return mongoRepository.getAllCredits();
    }

    /**
     * Gets the title with the highest score.
     * @return Titles object with the highest score.
     */
    @GetMapping("/titlesWithMoreScore")
    public Titles getTitleWithMostScore() {
        return mongoRepository.getTitleWithMostScore();
    }

    /**
     * Gets the titles in which an actor has participated.
     * @param name Name of the actor.
     * @return ResponseEntity with the list of titles in which the actor has participated.
     */
    @GetMapping("/titlesOfActors/{name}")
    public ResponseEntity<List<Titles>> getTitlesOfActors(@PathVariable("name") String name) {
        List<Titles> titles = mongoRepository.getTitlesOfActors(name);
        return ResponseEntity.ok(titles);
    }
    
    /**
     * Adds a new title.
     * @param titles Titles object to add.
     * @return Added Titles object.
     */
    @PostMapping("/new")
    public Titles addTitles(@RequestBody Titles titles) {
        return mongoRepository.creaTitles(titles);
    }

    /**
     * Updates an existing title.
     * @param oldTitle Old title.
     * @param newTitle New title.
     */
    @PutMapping("/update title/{oldTitle}")
    public void updaTitles(@PathVariable String oldTitle, @RequestParam String newTitle) {
        mongoRepository.udpateTitles(oldTitle, newTitle);
    }

    /**
     * Deletes a title by its identifier.
     * @param ObjectId Identifier of the title to delete.
     */
    @DeleteMapping("/{ObjectId}")
    public void deleteTitle(@PathVariable String ObjectId) {
        mongoRepository.deleteTitle(ObjectId);
    }
    /**
     * Deletes all titles.
     */
    @DeleteMapping("/all")
    public void deleteAll() {
        mongoRepository.deleteAll();
    }
}
