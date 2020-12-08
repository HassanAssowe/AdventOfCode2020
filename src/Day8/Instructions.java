package Day8;

import java.io.*;
import java.util.*;

public class Instructions {
    public static void main(String[] args) throws IOException, IllegalAccessException {
        part1();
        part2();
    }

    public static void part1() throws IOException {
        List<Integer> rules = new ArrayList<Integer>();
        File data = new File("instructions.txt");
        BufferedReader br = new BufferedReader(new FileReader(data));

        int acc = 0;
        int currentLine = 0;
        String line;
        outerloop:
        while ((line = br.readLine()) != null) {
            String key = line.split(" ")[0];
            Integer value = Integer.valueOf(line.split(" ")[1]);
            for (int i = 0; i < rules.size(); i++) {

                if (rules.get(i) == currentLine) {
                    br = null;
                    break outerloop;
                }

            }


            switch (key) {
                case "nop":
                    rules.add(currentLine);
                    currentLine++;
                    break;
                case "acc":
                    acc += value;
                    rules.add(currentLine);
                    currentLine++;
                    break;
                case "jmp":
                    br = new BufferedReader(new FileReader(data));
                    for (int i = 0; i < (value + currentLine); i++)
                        br.readLine();
                    rules.add(currentLine);
                    currentLine = value + currentLine;
                    break;

            }
        }
        outerloop:
        System.out.println("Value of accumulator: " + acc);
    }

    public static void part2() throws IOException {

    }
}