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
        boolean[][] grid = new boolean[1000][1000];
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                grid[i][j] = false;
            }
        }

        for (String[] str:input) {
            if (str[1].equals("on")) {
                for (int l = Integer.parseInt(str[2].split(",")[0]);
                     l < Integer.parseInt(str[4].split(",")[0])+1;
                     l++) {
                    for (int m = Integer.parseInt(str[2].split(",")[1]);
                         m < Integer.parseInt(str[4].split(",")[1])+1;
                         m++) {
                        grid[l][m] = true;
                    }
                }
            } else if (str[1].contains("off")) {
                for (int l = Integer.parseInt(str[2].split(",")[0]);
                     l < Integer.parseInt(str[4].split(",")[0])+1;
                     l++) {
                    for (int m = Integer.parseInt(str[2].split(",")[1]);
                         m < Integer.parseInt(str[4].split(",")[1])+1;
                         m++) {
                        grid[l][m] = false;
                    }
                }
            } else {
                for (int l = Integer.parseInt(str[1].split(",")[0]); l <
                        Integer.parseInt(str[3].split(",")[0])+1; l++) {
                    for (int m = Integer.parseInt(str[1].split(",")[1]);
                         m < Integer.parseInt(str[3].split(",")[1])+1; m++) {
                        grid[l][m] = !grid[l][m];
                    }
                }
            }
        }
        int count = 0;
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                if(grid[i][j]) {
                    count++;
                }
            }
        }
        System.out.println("Number of lights lit: " + count);

    }
}