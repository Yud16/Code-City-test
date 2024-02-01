import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.Scanner;


/**
 * LoadInfo involves a function readSpiderWorldInfo() that reads a .txt file that includes data about the SpiderWorld
 * game and returns the data in a hashmap. I have also created get methods that simplify the retrieval of the data in the hashmap
 */
public class LoadInfo {
    /**
     * reads from file and puts info into a hashmap
     */


    public static Map<String, Object> readSpiderWorldInfo(String filePath) {

        Map<String, Object> spiderWorldInfo = new HashMap<>();
        /**
         assuming this is the format of the input file:
         Example Input File:
         3 5             // Spider location (3,5)
         4               // Number of diamonds
         1 2 RED         // Diamond 1 location (1,2)
         3 4 BLUE        // Diamond 2 location (3,4)
         5 6 GREEN       // Diamond 3 location (5,6)
         6 8 BLACK       // Diamond 4 location (6,8)
         2               // Current level
         */
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Read spider location
            String[] spiderLocationStr = br.readLine().split(" ");
            int[] spiderLocation = {Integer.parseInt(spiderLocationStr[0]), Integer.parseInt(spiderLocationStr[1])};
            spiderWorldInfo.put("spider_location", spiderLocation);

            // Read the number of diamonds
            int numDiamonds = Integer.parseInt(br.readLine());
            spiderWorldInfo.put("num_diamonds", numDiamonds);

            // Read diamond locations, colors, and store in separate lists
            List<int[]> diamondLocations = new ArrayList<>();
            List<String> diamondColors = new ArrayList<>();
            for (int i = 0; i < numDiamonds; i++) {
                String[] diamondInfo = br.readLine().split(" ");
                int[] diamondLocation = {Integer.parseInt(diamondInfo[0]), Integer.parseInt(diamondInfo[1])};
                diamondLocations.add(diamondLocation);
                String diamondColor = diamondInfo[2].trim();
                diamondColors.add(diamondColor);
            }
            spiderWorldInfo.put("diamond_locations", diamondLocations);
            spiderWorldInfo.put("diamond_colors", diamondColors);

            // Read the current level
            int currentLevel = Integer.parseInt(br.readLine());
            spiderWorldInfo.put("current_level", currentLevel);

        } catch (IOException e) {
            e.printStackTrace();
        }
        //returns a hashmap
        return spiderWorldInfo;
    }

    //get functions
    public static int[] getSpiderLocation(Map<String, Object> map) {
        return (int[]) map.get("spider_location");
    }

    public static int getNumDiamonds(Map<String, Object> map) {
        return (int) map.get("num_diamonds");
    }

    public static int getCurrentLevel(Map<String, Object> map) {
        return (int) map.get("current_level");
    }

    @SuppressWarnings("unchecked")
    public static List<int[]> getDiamondLocations(Map<String, Object> map) {
        return (List<int[]>) map.get("diamond_locations");
    }

    //index of each diamond correlates to the index of the diamond color
    public static List<String> getDiamondColors(Map<String, Object> map) {
        return (List<String>) map.get("diamond_colors");
    }

    //mostly for testing
    public static void printSpiderWorldInfo(String filePath) {

        Map<String, Object> spiderWorldInfo = readSpiderWorldInfo(filePath);
        int[] spiderLocation = getSpiderLocation(spiderWorldInfo);
        int numDiamonds = getNumDiamonds(spiderWorldInfo);
        int currentLevel = getCurrentLevel(spiderWorldInfo);
        List<int[]> diamondLocations = getDiamondLocations(spiderWorldInfo);
        List<String> diamondColors = getDiamondColors(spiderWorldInfo);

        // Print Spider World information
        System.out.println("Spider Location: [" + spiderLocation[0] + ", " + spiderLocation[1] + "]");
        System.out.println("Number of Diamonds: " + numDiamonds);
        System.out.print("Diamond Locations: ");
        if (diamondLocations != null) {
            for (int[] diamondLocation : diamondLocations) {
                System.out.print(Arrays.toString(diamondLocation) + " ");
            }
        } else {
            System.out.println("Invalid diamond locations");
        }
        System.out.println();
        System.out.println("Diamond Colors: " + diamondColors);
        System.out.println("Current Level: " + currentLevel);
    }

    /** to make it easier to test, i added 2 different main methods, the first one takes in the filepath
     * directly written in the code. the second one takes in the filepath from the command line. we can use whichever
     * is more convenient.
     */
/*
    public static void main(String[] args) {
        //testing example
        String filePath = "C:/Users/smunt/cs308/spworld/src/test1.txt";
        printSpiderWorldInfo(filePath);

    }
*/

/*  //alternate main method that runs takes test file from command line
    public static void main(String[] args) {

        String filePath;
        if (args.length == 1) {
            // If a file path is provided as a command-line argument
            filePath = args[0];
        } else {
            // If no command-line argument is provided, prompt the user to enter the file path
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the file path: ");
            filePath = scanner.nextLine();
        }

        printSpiderWorldInfo(filePath);
    }

*/

}
