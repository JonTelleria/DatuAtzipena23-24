package dambi.netflix.conversor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import dambi.netflix.models.Credits;
import dambi.netflix.models.DataContainer;
import dambi.netflix.models.Genres;
import dambi.netflix.models.Titles;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Converts data from CSV files to JSON format and writes the result to a file.
 */
public class CSVtoJSONConverter {

    /**
     * Main method to execute the CSV to JSON conversion.
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        List<Titles> titles = readTitlesFromCSV("C:\\Users\\Jon\\Desktop\\JonTelleriaNetflix-main\\netflix\\src\\main\\resources\\csv\\titles.csv");
        List<Credits> credits = readCreditsFromCSV("C:\\Users\\Jon\\Desktop\\JonTelleriaNetflix-main\\netflix\\src\\main\\resources\\csv\\credits.csv");
        DataContainer dataContainer = new DataContainer(titles);

        // Associate credits with titles
        associateCreditsWithTitles(titles, credits, dataContainer);

        // Convert to JSON
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        try {
            // Save JSON to a file
            objectMapper.writeValue(new File("output.json"), titles);

            // Also print JSON to console
            String jsonInString = objectMapper.writeValueAsString(titles);
            System.out.println(jsonInString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Reads title data from a CSV file and creates Title objects.
     * @param titlePath Path to the title CSV file.
     * @return List of Titles objects read from the CSV.
     */
    private static List<Titles> readTitlesFromCSV(String titlePath) {
        List<Titles> titles = new ArrayList<>();

        try (CSVReader csvReader = new CSVReader(new FileReader(titlePath))) {
            String[] headers = csvReader.readNext();  // Skip the first line (header)

            String[] line;
            while ((line = csvReader.readNext()) != null) {
                // Parse CSV data
                String identificator = line[0];
                String title = line[1];
                String description = line[3];
                int release_year = Integer.parseInt(line[4]);
                int runtime = Integer.parseInt(line[6]);
                List<String> genres = Arrays.asList(line[7].replaceAll("\\[|\\]", "").split(","));
                double imdb_score = line[11].isEmpty() ? 0.0 : Double.parseDouble(line[11]);

                // Create Titles instance and add it to the list
                Titles titleObj = new Titles(identificator, title, description, release_year, runtime, genres, imdb_score, new ArrayList<>());
                titles.add(titleObj);
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }

        return titles;
    }

    /**
     * Reads credit data from a CSV file and creates Credits objects.
     * @param creditsPath Path to the credits CSV file.
     * @return List of Credits objects read from the CSV.
     */
    private static List<Credits> readCreditsFromCSV(String creditsPath) {
        List<Credits> credits = new ArrayList<>();
        try (CSVReader csvReader = new CSVReader(new FileReader(creditsPath))) {
            String[] headers = csvReader.readNext();  // Skip the first line (header)

            String[] line;
            while ((line = csvReader.readNext()) != null) {
                // Parse CSV data
                int person_id = Integer.parseInt(line[0]);
                String id = line[1];
                String name = line[2];
                String character = line[3];
                String role = line[4];

                // Create Credits instance and add it to the list
                Credits creditObj = new Credits(person_id, id, name, character, role);
                credits.add(creditObj);
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }

        return credits;
    }

    /**
     * Associates credits with titles based on identifier matching.
     * @param titles List of Titles objects.
     * @param credits List of Credits objects.
     * @param dataContainer DataContainer object containing title data.
     */
    private static void associateCreditsWithTitles(List<Titles> titles, List<Credits> credits, DataContainer dataContainer) {
        for (Titles title : titles) {
            for (Credits credit : credits) {
                if (credit.getId().equals(title.getIdentificator())) {
                    title.getCredits().add(credit);
                }
            }
        }
    }
}
