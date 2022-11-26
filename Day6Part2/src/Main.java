import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new FileReader("Input.txt"));
        ArrayList<String[]> input = new ArrayList<>();
        while (scanner.hasNextLine()) {
            input.add(scanner.nextLine().split(" "));
        }
        ArrayList<String> actions = new ArrayList<>();
        ArrayList<int[]> coords = new ArrayList<>();
        int[][] grid = new int[1000][1000];
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                grid[i][j] = 0;
            }
        }

        for (String[] str:input) {
            if (str[1].equals("on")) {
                actions.add("on");
                coords.add(new int[]{Integer.parseInt(str[2].split(",")[0]),
                        Integer.parseInt(str[2].split(",")[1]),
                        Integer.parseInt(str[4].split(",")[0]),
                        Integer.parseInt(str[4].split(",")[1])});
            } else if (str[1].contains("off")) {
                actions.add("off");
                coords.add(new int[]{Integer.parseInt(str[2].split(",")[0]),
                        Integer.parseInt(str[2].split(",")[1]),
                        Integer.parseInt(str[4].split(",")[0]),
                        Integer.parseInt(str[4].split(",")[1])});
            } else {
                actions.add("toggle");
                coords.add(new int[]{Integer.parseInt(str[1].split(",")[0]),
                        Integer.parseInt(str[1].split(",")[1]),
                        Integer.parseInt(str[3].split(",")[0]),
                        Integer.parseInt(str[3].split(",")[1])});
            }
        }
        for (int k = 0; k < actions.size(); k++) {
            if (actions.get(k).equals("on")) {
                for (int l = coords.get(k)[0]; l < coords.get(k)[2]+1; l++) {
                    for (int m = coords.get(k)[1]; m < coords.get(k)[3]+1; m++) {
                        grid[l][m]++;
                    }
                }
            } else if (actions.get(k).equals("off")) {
                for (int l = coords.get(k)[0]; l < coords.get(k)[2]+1; l++) {
                    for (int m = coords.get(k)[1]; m < coords.get(k)[3]+1; m++) {
                        if (grid[l][m] > 0) {
                            grid[l][m]--;
                        }
                    }
                }
            } else {
                for (int l = coords.get(k)[0]; l < coords.get(k)[2]+1; l++) {
                    for (int m = coords.get(k)[1]; m < coords.get(k)[3]+1; m++) {
                        grid[l][m] += 2;
                    }
                }
            }
        }
        int brightness = 0;
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                brightness += grid[i][j];
            }
        }
        System.out.println("Total brightness of all lights combined: " + brightness);

    }
}