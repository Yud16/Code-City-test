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
         3 5  //spiderlocation
         1    //num of red diamonds
         1 2  //red diamond location
         2    //num of blue diamonds
         2 3  //blue diamond location
         4 5  //blue diamond location
         0    //num of green diamonds
         2    //current level
         */
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Read spider location
            String[] spiderLocationStr = br.readLine().split(" ");
            int[] spiderLocation = {Integer.parseInt(spiderLocationStr[0]), Integer.parseInt(spiderLocationStr[1])};
            spiderWorldInfo.put("spider_location", spiderLocation);

            // Read diamond information
            List<int[]> diamondLocations = new ArrayList<>();
            List<String> diamondColors = new ArrayList<>();

            readDiamonds(br, "Red", spiderWorldInfo);
            readDiamonds(br, "Blue", spiderWorldInfo);
            readDiamonds(br, "Green", spiderWorldInfo);

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
    private static void readDiamonds(BufferedReader br, String color, Map<String, Object> spiderWorldInfo) throws IOException {
        int numDiamonds = Integer.parseInt(br.readLine());
        List<int[]> diamondLocations = new ArrayList<>();
        int count = 0;

        for (int i = 0; i < numDiamonds; i++) {
            String[] diamondInfo = br.readLine().split(" ");
            int[] diamondLocation = {Integer.parseInt(diamondInfo[0]), Integer.parseInt(diamondInfo[1])};
            diamondLocations.add(diamondLocation);
            count++;
        }

        spiderWorldInfo.put(color.toLowerCase() + "_diamond_locations", diamondLocations);
        spiderWorldInfo.put(color.toLowerCase() + "_diamond_count", count);
    }


    //get functions
    public static int[] getSpiderLocation(Map<String, Object> map) {
        return (int[]) map.get("spider_location");
    }

    public static int getDiamondCount(String color, Map<String, Object> map) {
        return (int) map.get(color.toLowerCase() + "_diamond_count");
    }

    public static int getCurrentLevel(Map<String, Object> map) {
        return (int) map.get("current_level");
    }

    @SuppressWarnings("unchecked")

    public static List<int[]> getDiamondLocationsByColor(String color, Map<String, Object> map) {
        return (List<int[]>) map.get(color.toLowerCase() + "_diamond_locations");
    }

    //mostly for testing
    public static void printSpiderWorldInfo(String filePath) {

        Map<String, Object> spiderWorldInfo = readSpiderWorldInfo(filePath);
        int[] spiderLocation = getSpiderLocation(spiderWorldInfo);
        int currentLevel = getCurrentLevel(spiderWorldInfo);

        System.out.println("Spider Location: [" + spiderLocation[0] + ", " + spiderLocation[1] + "]");
        System.out.println("Current Level: " + currentLevel);

        printDiamonds("Red", spiderWorldInfo);
        printDiamonds("Blue", spiderWorldInfo);
        printDiamonds("Green", spiderWorldInfo);
    }

    private static void printDiamonds(String color, Map<String, Object> spiderWorldInfo) {
        int count = getDiamondCount(color, spiderWorldInfo);
        List<int[]> diamondLocations = getDiamondLocationsByColor(color, spiderWorldInfo);

        System.out.println("Number of " + color + " Diamonds: " + count);
        System.out.print(color + " Diamond Locations: ");

        if (count > 0) {
            for (int i = 0; i < diamondLocations.size(); i++) {
                int[] diamondLocation = diamondLocations.get(i);
                System.out.print(Arrays.toString(diamondLocation));

                if (i < count - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        } else {
            System.out.println("No " + color + " Diamonds.");
        }
    }


    /** to make it easier to test, i added 2 different main methods, the first one takes in the filepath
     * directly written in the code. the second one takes in the filepath from the command line. we can use whichever
     * is more convenient.
     */

    public static void main(String[] args) {
        //testing example
        String filePath = "./loadinfotest.txt";
        printSpiderWorldInfo(filePath);

    }


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
