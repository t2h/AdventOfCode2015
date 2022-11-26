import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(new FileReader("Input.txt"));
        ArrayList<String> input = new ArrayList<>();
        while (scanner.hasNextLine()) {
            input.add(scanner.nextLine());
        }
        int niceStrings = 0;
        boolean containsPairTwice, containsRepeatLetter;
        String pair = null, repeatLetter = null;

        for (String str:input) {
            containsPairTwice = false;
            containsRepeatLetter = false;
            for (int i = 0; i < str.length()-1; i++) {
                pair = String.valueOf(str.charAt(i)) + str.charAt(i + 1);
                if (str.substring(i+2).contains(pair)) {
                    containsPairTwice = true;
                    break;
                }
            }
            if (containsPairTwice) {
                for (int j = 0; j < str.length()-2; j++) {
                    if (str.charAt(j) == str.charAt(j+2)) {
                        repeatLetter = String.valueOf(str.charAt(j));
                        containsRepeatLetter = true;
                        break;
                    }
                }
            }
            if (containsPairTwice && containsRepeatLetter) {
                niceStrings++;
                System.out.print(str + " | ");
                System.out.print("Pair appeared twice: " + pair + " | ");
                System.out.println("Repeated letter: " + repeatLetter);
            }
        }

        System.out.println("Number of nice strings: " + niceStrings);

    }
}