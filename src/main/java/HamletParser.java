import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.String;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private String hamletData;


    public HamletParser() {
        this.hamletData = loadFile();
    }

    private String loadFile() {
        File file = new File("/Users/mike/dev/week6/labs/Maven.Regex-Hamlet-Parser/src/main/resources/hamlet.txt");
        StringBuilder result = new StringBuilder("");

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result.toString();
    }

    public String getHamletData() {
        return hamletData;
    }

    public String changeHamletToLeon(String stringToParse) {
        String regex = "(?i)hamlet";
        Pattern pattern = Pattern.compile(regex);
        Matcher m = pattern.matcher(stringToParse);
        String newSentence = m.replaceAll("Leon");

        return newSentence;
    }

    public String changeHoratioToTariq(String stringToParse) {
        String regex = "(?i)horatio";
        Pattern pattern = Pattern.compile(regex);
        Matcher m = pattern.matcher(stringToParse);
        String newSentence = m.replaceAll("Tariq");
        return newSentence;

    }

    public Boolean findHamlet(String stringToParse) {
        String regex = "(?i)Hamlet";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcherHam = pattern.matcher(stringToParse);
        return matcherHam.find();
    }

    public Boolean findHoratio(String stingToParse) {
        String regex2 = "(?i)Horatio";
        Pattern pattern2 = Pattern.compile(regex2);
        Matcher matcherHor = pattern2.matcher(stingToParse);
        return matcherHor.find();
    }

}
