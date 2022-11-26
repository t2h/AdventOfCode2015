import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new FileReader("Input.txt"));
        ArrayList<String> input = new ArrayList<>();
        String[] test = new String[]{"123 -> x", "456 -> y", "x AND y -> d", "x OR y -> e",
                "x LSHIFT 2 -> f", "y RSHIFT 2 -> g", "NOT x -> h", "NOT y -> i"};
        while (scanner.hasNextLine()) {
            input.add(scanner.nextLine());
        }
        HashMap<String, Integer> wires = new HashMap<>();
        String wire;
        int signal;
        for (String str:test) {
            wire = str.split(" -> ")[1];
            if (str.contains("AND")){
                signal = wires.get(str.split(" ")[0]) & wires.get(str.split(" ")[2]);
            } else if (str.contains("OR")) {
                signal = wires.get(str.split(" ")[0]) | wires.get(str.split(" ")[2]);
            } else if (str.contains("NOT")) {
                signal = ~ wires.get(str.split(" ")[1]);
            } else if (str.contains("LSHIFT")) {
                signal = wires.get(str.split(" ")[0]) << Integer.parseInt(str.split(" ")[2]);
            } else if (str.contains("RSHIFT")) {
                signal = wires.get(str.split(" ")[0]) >>> Integer.parseInt(str.split(" ")[2]);
            } else {
                signal = Integer.parseInt(str.substring(0,str.indexOf(' ')));
            }
            wires.put(wire,signal);
        }
        for (String i : wires.keySet()) {
            System.out.println("key: " + i + " value: " + wires.get(i));
        }
    }
}