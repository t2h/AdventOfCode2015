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
        int vowels, niceStrings = 0;
        boolean threeVowels, letterTwice, badStrings;
        for (String str:input) {
            System.out.println(str);
            vowels = 0;
            threeVowels = false;
            letterTwice = false;
            badStrings = false;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == 'a'
                        || str.charAt(i) == 'e'
                        || str.charAt(i) == 'i'
                        || str.charAt(i) == 'o'
                        || str.charAt(i) == 'u') {
                    vowels++;
                }
                if (vowels == 3) {
                    threeVowels = true;
                    break;
                }
            }
            for (int j = 0; j < str.length()-1; j++) {
                if (str.charAt(j) == str.charAt(j + 1)) {
                    letterTwice = true;
                    break;
                }
            }
            if (str.contains("ab") || str.contains("cd") || str.contains("pq") || str.contains("xy")) {
                badStrings = true;
            }
            if (threeVowels && letterTwice && !badStrings) {
                niceStrings++;
            }
        }

        System.out.println("Number of nice strings: " + niceStrings);

    }

}