import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(new FileReader("Input.txt"));
        String input = "";
        while (scanner.hasNext()) {
            input = scanner.next();
        }
        int santaX = 0;
        int santaY = 0;
        int robotX = 0;
        int robotY = 0;
        int step = 1;
        boolean visited = false;
        String[] directions = input.split("");
        ArrayList<String> santaDirections = new ArrayList<>();
        ArrayList<String> robotDirections = new ArrayList<>();

        for (int i = 0; i < directions.length; i++) {
            if (i % 2 == 0) {
                santaDirections.add(directions[i]);
            } else {
                robotDirections.add(directions[i]);
            }
        }

        ArrayList<int[]> locations = new ArrayList<>();
        locations.add(new int[]{0, 0});

        for (String direction : santaDirections) {
            System.out.print("\nStep " + step + " | ");
            switch (direction) {
                case "^":
                    santaX++;
                    System.out.print("Moving Up    | ");
                    break;
                case ">":
                    santaY++;
                    System.out.print("Moving Right | ");
                    break;
                case "v":
                    santaX--;
                    System.out.print("Moving Down  | ");
                    break;
                case "<":
                    santaY--;
                    System.out.print("Moving Left  | ");
                    break;
            }
            System.out.print("New Position: " + santaX + " , " + santaY + " | ");
            for (int[] location:locations) {
                if (location[0] == santaX && location[1] == santaY){
                    visited = true;
                    break;
                }
            }
            if (!visited) {
                locations.add(new int[]{santaX, santaY});
            }
            System.out.print("Houses Visited: " + locations.size());
            visited = false;
            step++;
        }

        step = 1;

        for (String direction : robotDirections) {
            System.out.print("\nStep " + step + " | ");
            switch (direction) {
                case "^":
                    robotX++;
                    System.out.print("Moving Up    | ");
                    break;
                case ">":
                    robotY++;
                    System.out.print("Moving Right | ");
                    break;
                case "v":
                    robotX--;
                    System.out.print("Moving Down  | ");
                    break;
                case "<":
                    robotY--;
                    System.out.print("Moving Left  | ");
                    break;
            }
            System.out.print("New Position: " + robotX + " , " + robotY + " | ");
            for (int[] location:locations) {
                if (location[0] == robotX && location[1] == robotY){
                    visited = true;
                    break;
                }
            }
            if (!visited) {
                locations.add(new int[]{robotX, robotY});
            }
            System.out.print("Houses Visited: " + locations.size());
            visited = false;
            step++;
        }

        System.out.println("\nNumber of houses that receive at least one present: " + locations.size());

    }
}