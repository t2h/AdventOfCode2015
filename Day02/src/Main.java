import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(new FileReader("Input.txt"));
        ArrayList<String> presents = new ArrayList<>();
        while (scanner.hasNextLine()){
            presents.add(scanner.nextLine());
        }

        int l, w, h, smallestFaceArea, a, b;
        int paper = 0, ribbon = 0;

        for (String present:presents) {
            String[] dimensions = present.split("x");
            l = Integer.parseInt(dimensions[0]);
            w = Integer.parseInt(dimensions[1]);
            h = Integer.parseInt(dimensions[2]);
            a = Math.min(Math.min(l, w), h);
            b = Math.max(Math.min(l,w), Math.min(Math.max(l,w),h));
            smallestFaceArea = a*b;

            paper += 2*l*w + 2*w*h + 2*h*l + smallestFaceArea;
            ribbon += a+a+b+b + l*w*h;
        }

        System.out.println("Total square feet of wrapping paper required: " + paper);
        System.out.println("Total feet of ribbon required: " + ribbon);

    }
}