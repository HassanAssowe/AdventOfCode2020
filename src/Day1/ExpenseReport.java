package Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ExpenseReport {
    public static void main(String[] args) throws IOException {
        //part1();
        part2();
    }

    public static void part1() throws IOException {
        ArrayList<Integer> expensesList = new ArrayList<Integer>();
        try {
            File expenses = new File("codes.txt");
            System.out.println(expenses.getCanonicalPath());
            Scanner readExpenses = new Scanner(expenses);

            while (readExpenses.hasNextLine()) {
                expensesList.add(readExpenses.nextInt());
            }
            readExpenses.close();
        } catch (FileNotFoundException e) {
            System.out.println("An Error has occurred");

            e.printStackTrace();
        }
        for (int i = 0; i < expensesList.size(); i++) {
            for (int j = 0; j < expensesList.size(); j++) {
                if (expensesList.get(i) + expensesList.get(j) == 2020) {
                    System.out.println("A Combination has been found!: " + expensesList.get(i) + " , " + expensesList.get(j));
                    System.out.println("Multiplying these we get an answer of: " + expensesList.get(i) * expensesList.get(j));
                    break;
                }
            }
        }

    }

    public static void part2() throws IOException {
        ArrayList<Integer> expensesList = new ArrayList<Integer>();
        try {
            File expenses = new File("codes.txt");
            System.out.println(expenses.getCanonicalPath());
            Scanner readExpenses = new Scanner(expenses);

            while (readExpenses.hasNextLine()) {
                expensesList.add(readExpenses.nextInt());
            }
            readExpenses.close();
        } catch (FileNotFoundException e) {
            System.out.println("An Error has occurred");

            e.printStackTrace();
        }
        int first = 0;
        int second = 0;
        int third = 0;

        for (int i = 0; i < expensesList.size(); i++) {
            first = expensesList.get(i);
            for (int j = 0; j < expensesList.size(); j++) {
                second = expensesList.get(j);
                for (int k = 0; k < expensesList.size(); k++) {
                    third = expensesList.get(k);
                    if (first + second + third == 2020) {
                        System.out.println("Multiplying these we get an answer of: " + first * second * third);
                        break;
                    }
                }
            }
        }
    }
}


