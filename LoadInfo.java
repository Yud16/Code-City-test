import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class LoadInfo {

    // reads from file and puts info into a hashmap
    public static Map<String, Object> readSpiderWorldInfo(String filePath) {
        Map<String, Object> spiderWorldInfo = new HashMap<>();
        /*
        assuming this is the format of the input file:
        Example Input File:
            3 5             // Spider location (3,5)
            4               // Number of diamonds
            1 2             // Diamond 1 location (1,2)
            3 4             // Diamond 2 location (3,4)
            5 6             // Diamond 3 location (5,6)
            6 8             // Diamond 4 location (6,8)
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

            // Read diamond locations
            List<int[]> diamondLocations = new ArrayList<>();
            for (int i = 0; i < numDiamonds; i++) {
                String[] diamondLocationStr = br.readLine().split(" ");
                int[] diamondLocation = {Integer.parseInt(diamondLocationStr[0]), Integer.parseInt(diamondLocationStr[1])};
                diamondLocations.add(diamondLocation);
            }
            spiderWorldInfo.put("diamond_locations", diamondLocations);

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

    //mostly for testing
    public static void printSpiderWorldInfo(String filePath) {

        Map<String, Object> spiderWorldInfo = readSpiderWorldInfo(filePath);
        int[] spiderLocation = getSpiderLocation(spiderWorldInfo);
        int numDiamonds = getNumDiamonds(spiderWorldInfo);
        int currentLevel = getCurrentLevel(spiderWorldInfo);
        List<int[]> diamondLocations = getDiamondLocations(spiderWorldInfo);

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
        System.out.println("Current Level: " + currentLevel);
    }

}
/*
    public static void main(String[] args) {
        //testing example
        String filePath = "C:/Users/smunt/cs308/spworld/src/test1.txt";
        printSpiderWorldInfo(filePath);
    }
}
*/