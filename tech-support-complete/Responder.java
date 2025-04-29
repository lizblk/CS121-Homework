import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * The responder class represents a response generator object.
 * It is used to generate an automatic response, based on specified input.
 * Input is presented to the responder as a set of words, and based on those
 * words the responder will generate a String that represents the response.
 * 
 * @author     Michael Kölling and David J. Barnes
 * @version    1.0 (2016.02.29)
 */
public class Responder
{
    // Used to map key words to responses.
    
    private HashMap<String, String> responseMap;
    // Default responses to use if we don't recognise a word.
    private ArrayList<String> defaultResponses;
    private Random randomGenerator;

    /**
     * Construct a Responder
     */
    public Responder()
    {
        responseMap = new HashMap<>();
        defaultResponses = new ArrayList<>();
        loadResponsesFromFile("responses.txt");
        //changed from fillResponseMap
        fillDefaultResponses();
        randomGenerator = new Random();
    }
    /**
     * read keyword/response pairs from a text file. assumes alternating lines:
     *     keyword
     *     response
     *     keyword
     *     response
     * and so on
     */
    private void loadResponsesFromFile(String filename)
    {
        //getResourceAsStream works regardless of bluej, jar, ide, etc
        try (BufferedReader br =
        new BufferedReader(new InputStreamReader(
        getClass().getResourceAsStream(filename))))
        {
            String keyword;
            while ((keyword = br.readLine()) != null) {
                String response = br.readLine(); // non null by spec
                if (response != null) {
                    responseMap.put(keyword.trim().toLowerCase(), response.trim());
                }
            }
        }
        catch (NullPointerException npe) {
            System.err.println(filename + " not found");
        }
        catch (IOException ioe) {
            System.err.println("Error reading " + filename + ": " + ioe.getMessage());
        }
    }
    
    public String generateResponse(HashSet<String> words)
    {
        for (String word : words) {
            String response = responseMap.get(word);
            if(response != null) {
                return response;
            }
        }
            return pickDefaultResponse();
        }

    /**
     * Build up a list of default responses from which we can pick one
     * if we don't know what else to say.
     */
    private void fillDefaultResponses()
    {
        defaultResponses.add("That sounds odd. Could you describe that problem in more detail?");
        defaultResponses.add("No other customer has ever complained about this before. \n" +
                             "What is your system configuration?");
        defaultResponses.add("That sounds interesting. Tell me more...");
        defaultResponses.add("I need a bit more information on that.");
        defaultResponses.add("Have you checked that you do not have a dll conflict?");
        defaultResponses.add("That is explained in the manual. Have you read the manual?");
        defaultResponses.add("Your description is a bit wishy-washy. Have you got an expert\n" +
                             "there with you who could describe this more precisely?");
        defaultResponses.add("That's not a bug, it's a feature!");
        defaultResponses.add("Could you elaborate on that?");
    }

    /**
     * Randomly select and return one of the default responses.
     * @return     A random default response
     */
    private String pickDefaultResponse()
    {
        // Pick a random number for the index in the default response list.
        // The number will be between 0 (inclusive) and the size of the list (exclusive).
        int index = randomGenerator.nextInt(defaultResponses.size());
        return defaultResponses.get(index);
    }
}
