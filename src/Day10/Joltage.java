package Day10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Joltage {
    public static void main(String[] args) throws IOException, IllegalAccessException {
        File file = new File("joltage.txt");
        List<Long> data = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;

        while ((line = br.readLine()) != null) {
            data.add(Long.parseLong(line));
        }

        Collections.sort(data);

        //part1(data);
        part2(data);
    }

    public static void part1(List<Long> data) {
        int oneCount = 1;
        int threeCount = 0;

        data.add(data.get(data.size() - 1) + 3);

        for (int i = 1; i < data.size(); i++) {
            if ((data.get(i) - data.get(i - 1)) == 1)
                oneCount++;
            if ((data.get(i) - data.get(i - 1)) == 3)
                threeCount++;
        }

        System.out.println("The number of 1-jolt differences multiplied by the number of 3-jolt differences: " + oneCount * threeCount);
    }

    public static void part2(List<Long> data) {

        data.add(data.get(data.size() - 1) + 3);
        System.out.println("Number of combinations: " + countPart2(data, 0));

    }

    public static int countPart2(List<Long> data, int count) {

        if (data.size() == 1)
            count++;

        if (data.contains(data.get(0) + 1)) {
            //System.out.println(data.subList(data.indexOf((data.get(0) + 1)), data.size()));
            count = countPart2(data.subList(data.indexOf((data.get(0) + 1)), data.size()), count);
        }
        if (data.contains(data.get(0) + 2)) {
            //System.out.println(data.subList(data.indexOf((data.get(0) + 2)), data.size()));
            count = countPart2(data.subList(data.indexOf((data.get(0) + 2)), data.size()), count);
        }
        if (data.contains(data.get(0) + 3)) {
            //System.out.println(data.subList(data.indexOf((data.get(0) + 3)), data.size()));
            count = countPart2(data.subList(data.indexOf((data.get(0) + 3)), data.size()), count);
        }
        return count;
    }


}


