import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("Input.txt"));
        String directions = reader.readLine();

        int floor = 0;
        boolean basementEntered = false;

        for(int i = 0; i < directions.length(); i++) {
            if(directions.charAt(i) == '(') {
                floor++;
            } else if (directions.charAt(i) == ')') {
                floor--;
            }
            if (floor == -1 && !basementEntered) {
                System.out.println("Santa has entered the basement at character position " + (i+1));
                basementEntered = true;
            }
        }

        System.out.println("The instructions take Santa to floor " + floor);

    }
}