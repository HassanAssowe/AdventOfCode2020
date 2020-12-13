package Day10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Joltage {
    int count1 = 0;

    public static void main(String[] args) throws IOException, IllegalAccessException {
        File file = new File("joltage.txt");
        List<Integer> data = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;

        while ((line = br.readLine()) != null) {
            data.add(Integer.parseInt(line));
        }


        part1(data);
        part2(data);
    }

    public static void part1(List<Integer> data) {
        int oneCount = 1;
        int threeCount = 0;

        data.add(0);
        Collections.sort(data);

        data.add(data.get(data.size() - 1) + 3);

        for (int i = 1; i < data.size(); i++) {
            if ((data.get(i) - data.get(i - 1)) == 1)
                oneCount++;
            if ((data.get(i) - data.get(i - 1)) == 3)
                threeCount++;
        }

        System.out.println("The number of 1-jolt differences multiplied by the number of 3-jolt differences: " + oneCount * threeCount);
    }

    public static void part2(List<Integer> data) {
        Map<Integer, Long> memoization = new HashMap<>();

        data.add(0);
        Collections.sort(data);
        data.add(data.get(data.size() - 1) + 3);
        memoization.put(data.size() - 1, 1L);

        System.out.println("Number of combinations: " + counter(memoization, data, 0));

    }

    public static long counter(Map<Integer, Long> mem, List<Integer> data, int index) {
        if (mem.containsKey(index)) {
            return mem.get(index);
        } else {
            int adapter = data.get(index);
            System.out.println(adapter);
            long count = 0;
            for (int j = 1; j <= 3; j++) {
                int next = data.indexOf(adapter + j);
                if (next != -1) {
                    count += counter(mem, data, next);
                    System.out.println(count);
                }
            }
            mem.put(index, count);
            return count;
        }
    }
}



