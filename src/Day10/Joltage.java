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

    public static Long recursion(List<Long> data, int val) {
        int oneCount = 1;
        int threeCount = 0;

        data.add(data.get(data.size() - 1) + 3);
        List<Long> temp = new ArrayList<>();


        for (int i = 1; i < data.size(); i++) {
            System.out.println("Comparing " + data.get(i) + " to " + data.get(i - 1) + " = " + (data.get(i) - data.get(i - 1)));
            if ((data.get(i) - data.get(i - 1)) == val)
                return data.get(i);
        }

        return null;
    }

    public static void part2(List<Long> data) {

        data.add(data.get(data.size() - 1) + 3);

        List<Long> temp = new ArrayList<>();
        List<List<Long>> collection = new ArrayList<>();

        collection = powerSet(data);
        System.out.println("Powerset created!");

        for(int i = 0; i < collection.size(); i++){
            for(int j = 1; j < collection.get(j).size(); j++){
                if((collection.get(i).get(j) - collection.get(i).get(j-1) != 1 || collection.get(i).get(j) - collection.get(i).get(j-1) != 2 || collection.get(i).get(j) - collection.get(i).get(j-1) != 3))
                    collection.remove(i);
            }
        }

        System.out.println("There are "+ collection.size()+ " Combinations");
    }

    public static <T> List<List<T>> powerSet(List<T> input) {
        List<List<T>> sets = new ArrayList<>();
        for (T element : input) {
            for (ListIterator<List<T>> setsIterator = sets.listIterator(); setsIterator.hasNext(); ) {
                List<T> newSet = new ArrayList<>(setsIterator.next());
                newSet.add(element);
                setsIterator.add(newSet);
            }
            sets.add(new ArrayList<>(Arrays.asList(element)));
        }
        sets.add(new ArrayList<>());
        return sets;
    }

}

