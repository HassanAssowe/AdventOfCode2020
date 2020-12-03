package Day3;

import java.io.*;
import java.util.ArrayList;

public class TobogganTrajectory {
    public static void main(String[] args) throws IOException {
        ArrayList<String> list = new ArrayList<>();
        try {
            File coordinates = new File("trees.txt");
            FileWriter writeTrees = new FileWriter("trees2.txt");
            BufferedReader br = new BufferedReader(new FileReader(coordinates));

            int rise = 1;
            int run = 1;
            int x = 1;
            int y = 0;
            int encounter = 0;
            String line;

            while ((line = br.readLine()) != null) {
                String var = "";
                for (int i = 0; i < 90; i++)
                    var = var + line;
                list.add(var);

            }
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }

            while (y - 1 != list.size()) {
                if (list.get(y).charAt(x - 1) == '#')
                    encounter++;
                x = x + run;
                y = y + rise;
            }
            System.out.println("Encounters: " + encounter);
        } catch (FileNotFoundException e) {
            System.out.println("An Error has occurred");

            e.printStackTrace();
        }

    }
}
