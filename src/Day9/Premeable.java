package Day9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Premeable {
    public static void main(String[] args) throws IOException, IllegalAccessException {
        Long Value = Long.valueOf(1038347917);

        List<Long> q = new ArrayList<>();
        List<Long> data = new ArrayList<>();
        File file = new File("premable.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null) {
            data.add(Long.parseLong(line));
        }

        //part1(q, data, 25);
        part2(q, data, Value);

    }

    public static void part1(List<Long> q, List<Long> data, int prem) {
        for (int qSize = 0; qSize < prem; qSize++)
            q.add(data.get(qSize));


        int currentLine = prem;

        for (int counter = 0; counter < data.size(); counter++) {
            for (int i = 0; i < q.size(); i++) {
                for (int j = 0; j < q.size(); j++) {
                    if ((q.get(i) + q.get(j)) == data.get(currentLine) && (q.get(i) != q.get(j))) {
                        q.remove(0);
                        q.add(data.get(currentLine));
                        currentLine++;
                        i = 0;
                        j = 0;
                        break;
                    }
                }
            }
            System.out.println(data.get(currentLine) + " Is causing the issue!");
            break;
        }
    }

    public static void part2(List<Long> q, List<Long> data, Long val) {
        Long sum = Long.valueOf(0);
        List subList = new ArrayList();
        int counter = 0;
        int firstIndex = 0;
        int endIndex = 0;
        Boolean flag = true;

        while(flag == true) {
            subList = data.subList(firstIndex,endIndex);
            if(data.subList(firstIndex,endIndex).stream().mapToLong(Long::longValue).sum() != val){
                if(data.subList(firstIndex,endIndex).stream().mapToLong(Long::longValue).sum() < val) {
                    endIndex++;
                }
                else {
                    firstIndex = firstIndex+1;
                    endIndex = firstIndex+2;
                }
            }else
                flag = false;

        }
        System.out.println("Smallest: "+ Collections.min(subList) + " & "+ "Largest: "+ Collections.max(subList) +" Total: "+ ((Long)Collections.min(subList) + (Long)Collections.max(subList)));
    }
}

