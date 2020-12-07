package Day7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Bags {
    public static void main(String[] args) throws IOException, IllegalAccessException {
        Map<String, String[]> rules = new HashMap<>();

        File data = new File("bags.txt");
        BufferedReader br = new BufferedReader(new FileReader(data));
        int total = 0;

        String line;
        while ((line = br.readLine()) != null) {
            String ruleBag = line.substring(0, line.indexOf("contain")).trim();
            String[] bagrules = (line.substring(line.indexOf("contain") + "contain".length()).trim().replace(".", "").split(", "));
            rules.put(ruleBag, bagrules);
        }
        List<String> list = new ArrayList<String>();
        for (Map.Entry<String, String[]> values : rules.entrySet()) {
            if (Arrays.asList(values.getValue()).toString().contains("shiny gold")) {
                list.add(values.getKey());
                total++;
            }
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("_____________________________________________________");
        for (int i = 0; i < list.size(); i++) {
            total = instanceCount(total, rules, list.get(i));
        }

        System.out.println(total + " bags can contain at least ONE shiny gold bag");
    }

    public static int instanceCount(int count, Map<String, String[]> rules, String instance) {
        for (Map.Entry<String, String[]> values : rules.entrySet()) {
            if (Arrays.asList(values.getValue()).toString().contains(instance.substring(0, instance.length() - 1))) {
                count++;
            }
        }
        return count;
    }
}
