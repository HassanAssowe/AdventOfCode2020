package Day4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Passports {
    public static void main(String[] args) throws IOException, IllegalAccessException {
        readData();
    }

    public static void readData() throws IOException, IllegalAccessException {
        File data = new File("passports.txt");
        BufferedReader br = new BufferedReader(new FileReader(data));
        int count = 0;
        Passport p = new Passport();
        String line;
        while ((line = br.readLine()) != null) {
            if (!line.isEmpty()) {
                String[] lineData = line.split(" ");
                for (int i = 0; i < lineData.length; i++) {
                    switch (lineData[i].split(":")[0]) {
                        case "byr": {
                            if ((lineData[i].split(":")[1]).length() == 4 && ((Integer.parseInt(lineData[i].split(":")[1])) >= 1920) && ((Integer.parseInt(lineData[i].split(":")[1])) <= 2002))
                                p.setBirthYear((lineData[i].split(":")[1]));
                            break;
                        }
                        case "iyr": {
                            if ((lineData[i].split(":")[1]).length() == 4 && (Integer.parseInt(lineData[i].split(":")[1])) >= 2010 && (Integer.parseInt(lineData[i].split(":")[1])) <= 2020)
                                p.setIssueYear(lineData[i].split(":")[1]);
                            break;
                        }
                        case "eyr": {
                            if ((lineData[i].split(":")[1]).length() == 4 && (Integer.parseInt(lineData[i].split(":")[1])) >= 2020 && (Integer.parseInt(lineData[i].split(":")[1])) <= 2030)
                                p.setExpYear(lineData[i].split(":")[1]);
                            break;
                        }
                        case "hgt": {
                            if ((lineData[i].split(":")[1]).contains("cm") && Integer.parseInt(lineData[i].split(":")[1].substring(0, (lineData[i].split(":")[1]).length() - 2)) >= 150 && Integer.parseInt(lineData[i].split(":")[1].substring(0, (lineData[i].split(":")[1]).length() - 2)) <= 193) {
                                    p.setHeight(lineData[i].split(":")[1]);
                                if ((lineData[i].split(":")[1]).contains("in") && Integer.parseInt(lineData[i].split(":")[1].substring(0, (lineData[i].split(":")[1]).length() - 2)) >= 59 && Integer.parseInt(lineData[i].split(":")[1].substring(0, (lineData[i].split(":")[1]).length() - 2)) <= 76) {
                                    p.setHeight(lineData[i].split(":")[1]);
                                }
                            }
                            break;
                        }
                        case "hcl": {
                            if ((lineData[i].split(":")[1]).contains("#") && (lineData[i].split(":")[1]).substring(1).length() == 6 && (lineData[i].split(":")[1]).substring(1).matches("[0-9]") && (lineData[i].split(":")[1]).substring(1).matches("[a-f]"))
                                p.setHairColour(lineData[i].split(":")[1]);
                            break;
                        }
                        case "ecl": {
                            if ((lineData[i].split(":")[1]).matches("amb|blu|brn|gry|grn|hzl|oth"))
                                p.setEyeColour(lineData[i].split(":")[1]);
                            break;
                        }
                        case "pid": {
                            try {
                                if (String.format("%09d", Integer.parseInt(lineData[i].split(":")[1])).length() == 9)
                                    p.setPassportID((lineData[i].split(":")[1]));
                            } catch (NumberFormatException e) {

                            }
                            break;
                        }
                        case "cid": {
                            p.setCountryID((lineData[i].split(":")[1]));
                            break;
                        }
                        default:
                            break;
                    }

                }
            } else {
                if (p.validatePassport())
                    count++;
                p = new Passport();
            }
        }
        System.out.println(count);


    }


}

class Passport {
    String birthYear = null;
    String issueYear = null;
    String expYear = null;

    String height = null;
    String hairColour = null;
    String eyeColour = null;

    String passportID = null;
    String countryID = null;

    public Passport() {

    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getIssueYear() {
        return issueYear;
    }

    public void setIssueYear(String issueYear) {
        this.issueYear = issueYear;
    }

    public String getExpYear() {
        return expYear;
    }

    public void setExpYear(String expYear) {
        this.expYear = expYear;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getHairColour() {
        return hairColour;
    }

    public void setHairColour(String hairColour) {
        this.hairColour = hairColour;
    }

    public String getEyeColour() {
        return eyeColour;
    }

    public void setEyeColour(String eyeColour) {
        this.eyeColour = eyeColour;
    }

    public String getPassportID() {
        return passportID;
    }

    public void setPassportID(String passportID) {
        this.passportID = passportID;
    }

    public String getCountryID() {
        return countryID;
    }

    public void setCountryID(String countryID) {
        this.countryID = countryID;
    }

    public Boolean validatePassport() {
        if (birthYear == null || issueYear == null || expYear == null || height == null || hairColour == null || eyeColour == null || passportID == null)
            return false;

        return true;
    }

}


