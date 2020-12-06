package Day5;
//ACCIDENTALLY COPIED OVER PART 1. SORRY!
import com.sun.xml.internal.bind.v2.model.core.ID;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class BoardingPass {
    public static void main(String[] args) throws IOException, IllegalAccessException {
        ArrayList<Integer> IDs = new ArrayList<Integer>();
        File data = new File("numbers.txt");
        BufferedReader br = new BufferedReader(new FileReader(data));
        int rows = 127;
        int cols = 7;
        int highest = 0;

        String line;
        while ((line = br.readLine()) != null) {
            String rowLine = line.substring(0, line.length() - 3);
            String colLine = line.substring(line.length() - 3);

            int foundRow = getRow(0, rows, rowLine);
            int foundCol = getCol(0, cols, colLine);

            highest = (foundRow * 8 + foundCol);
            IDs.add(highest);
        }

        for(int i = 0; i < IDs.size(); i++){
            for(int k = 0; k < IDs.size(); k++){
                if((IDs.get(i) - IDs.get(k) == 2 || IDs.get(i) - IDs.get(k) == -2)){
                    int max = Math.max(IDs.get(i), IDs.get(k));
                    int min = Math.min(IDs.get(i), IDs.get(k));
                    int val = min+1;

                    if(!IDs.contains(val))
                    System.out.println("Your Passes: "+max+"-"+min+" Your Boarding Pass ID: " + val);
                    break;
                }
            }
        }

    }

    private static int getCol(int lowerBound, int upperBound, String colLine) {
        char character = colLine.charAt(0);
        if (colLine.length() == 1) {
            if (character == 'R') {
                return upperBound;
            } else {
                return lowerBound;
            }
        } else {
            if (character == 'L') {
                return getCol(lowerBound, (lowerBound + upperBound) / 2, colLine.substring(1));
            } else if (character == 'R') {
                return getCol((lowerBound + upperBound + 1) / 2, upperBound, colLine.substring(1));
            }
        }
        return -1;

    }

    public static int getRow(int lowerBound, int upperBound, String rowLine) {
        char character = rowLine.charAt(0);
        if (rowLine.length() == 1) {
            if (character == 'F') {
                return lowerBound;
            } else {
                return upperBound;
            }
        } else {
            if (character == 'F') {
                return getRow(lowerBound, (lowerBound + upperBound) / 2, rowLine.substring(1));
            } else if (character == 'B') {
                return getRow((lowerBound + upperBound + 1) / 2, upperBound, rowLine.substring(1));
            }
        }
        return -1;
    }

    public static void part2() {

    }
}


