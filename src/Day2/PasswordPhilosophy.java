package Day2;

import com.sun.deploy.util.StringUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class PasswordPhilosophy {
    public static void main(String[] args) throws IOException {
        part2();
    }

    public static void part1() {
        int count = 0;
        try {
            File passwords = new File("passwords.txt");
            System.out.println(passwords.getCanonicalPath());
            Scanner readPasswords = new Scanner(passwords);

            while (readPasswords.hasNextLine()) {
                int check = 0;
                String line = readPasswords.nextLine();
                String rule = (line.split(":"))[0];
                String password = line.split(":")[1].trim();

                int lowerBound = Integer.parseInt(line.split("-")[0]);
                int upperBound = Integer.parseInt(line.split("-")[1].split(" ")[0]);
                char value = (line.split("-")[1].split(" ")[1]).charAt(0);

                for (int i = 0; i < password.length(); i++) {
                    if (password.charAt(i) == value)
                        check++;
                }
                System.out.println(password + " LowerBound=" + lowerBound + ">=" + check + "<= UpperLower=" + upperBound);

                if (check >= lowerBound && check <= upperBound)
                    count++;
            }
            readPasswords.close();
            System.out.println("Total valid occurrences: " + count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void part2() {
        int count = 0;
        try {
            File passwords = new File("passwords.txt");
            System.out.println(passwords.getCanonicalPath());
            Scanner readPasswords = new Scanner(passwords);

            while (readPasswords.hasNextLine()) {
                int check = 0;
                String line = readPasswords.nextLine();
                String rule = (line.split(":"))[0];
                String password = line.split(":")[1].trim();

                int lowerBound = Integer.parseInt(line.split("-")[0]);
                int upperBound = Integer.parseInt(line.split("-")[1].split(" ")[0]);
                char value = (line.split("-")[1].split(" ")[1]).charAt(0);

                if ((password.charAt(lowerBound - 1) == value && password.charAt(upperBound - 1) != value) || (password.charAt(lowerBound - 1) != value && password.charAt(upperBound - 1) == value))
                    count++;
            }
            readPasswords.close();
            System.out.println("Total valid occurrences: " + count);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}