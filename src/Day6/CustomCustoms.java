package Day6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class CustomCustoms {
    public static void main(String[] args) throws IOException, IllegalAccessException {
        ArrayList<String> customs = new ArrayList<String>();
        File data = new File("customs.txt");
        BufferedReader br = new BufferedReader(new FileReader(data));

        part1(customs, br);
        br = new BufferedReader(new FileReader(data));
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
        int sum = 0;
        float groupCount = 0;

        while ((line = br.readLine()) != null) {
            if (!line.isEmpty()) {
                party += line;
                groupCount++;
            }
            if (line.isEmpty()) {
                if (groupCount == 1) {
                    sum += party.chars().distinct().count();
                } else if (groupCount == party.chars().distinct().count()) {
                    sum += 0;
                } else if (party.chars().distinct().count() == 1) {
                    sum++;
                } else {
                    Map<String, Long> collect = party.chars().mapToObj(i -> (char) i)
                            .collect(Collectors.groupingBy(Object::toString, Collectors.counting()));

                    for (Map.Entry<String, Long> entry : collect.entrySet()) {
                        if (entry.getValue() == groupCount)
                            sum++;
                    }

                }
                party = "";
                groupCount = 0;
            }
        }
        if (groupCount == 1) {
            sum += party.chars().distinct().count();
        } else if (groupCount == party.chars().distinct().count()) {
            sum += 0;
        } else if (party.chars().distinct().count() == 1) {
            sum++;
        } else {
            Map<String, Long> collect = party.chars().mapToObj(i -> (char) i)
                    .collect(Collectors.groupingBy(Object::toString, Collectors.counting()));

            for (Map.Entry<String, Long> entry : collect.entrySet()) {
                if (entry.getValue() == groupCount)
                    sum++;
            }

        }

        System.out.println("Unanimous Votes: " + sum);
    }
}



