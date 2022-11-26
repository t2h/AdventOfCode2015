import java.io.FileReader;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(new FileReader("Input.txt"));
        String input = "";
        while (scanner.hasNext()) {
            input = scanner.next();
        }
        boolean keyFound = false;
        int count = 1;
        String test;
        while (!keyFound) {
            test = input + count;
            String hash = getMD5(test);
            System.out.println("Finding MD5 hash of " + test + " | " + hash);
            if (hash.startsWith("000000")) {
                System.out.println("Key found!");
                System.out.println("The number was " + count);
                keyFound = true;
            } else {
                count++;
            }
        }
    }

    public static String getMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            StringBuilder hash = new StringBuilder(no.toString(16));
            while (hash.length() < 32) {
                hash.insert(0, "0");
            }
            return hash.toString();
        }
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

}
