package Day6;

import com.sun.deploy.util.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomCustoms {
    public static void main(String[] args) throws IOException, IllegalAccessException {
        ArrayList<String> customs = new ArrayList<String>();
        File data = new File("customs.txt");
        BufferedReader br = new BufferedReader(new FileReader(data));

        part2(customs, br);
    }

    public static void part1(ArrayList<String> customs, BufferedReader br) throws IOException {
        String line;
        String party = "";
        String last = "";
        int sum = 0;

        while ((line = br.readLine()) != null) {
            if (!line.isEmpty()) {
                party += line;
                System.out.println(party);
            }
            if (line.isEmpty()) {
                sum += party.chars().distinct().count();
                party = "";
            }
        }
        System.out.println("Sum total equals: " + (sum + party.chars().distinct().count()));
    }

    public static void part2(ArrayList<String> customs, BufferedReader br) throws IOException {
        String line;
        String party = "";
        String last = "";
        int sum = 0;
        int ppl = 0;

        while ((line = br.readLine()) != null) {
            if (!line.isEmpty()) {
                party += line;
                ppl++;
            }
            if (line.isEmpty()) {
                for (int i = 0; i < party.length(); i++) {
                    int count = 0;
                    for (int j = 0; j < party.length(); j++) {
                        if (party.charAt(i) == party.charAt(j))
                            count++;
                    }
                    if (count == ppl) {
                        party.replace(String.valueOf(party.charAt(i)), "");
                        sum += 1;
                    }

                }
                party = "";
                ppl = 0;
            }
        }
        System.out.println("Sum: "+sum);
    }
}


