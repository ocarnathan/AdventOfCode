import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

// Resources
    // https://www.digitalocean.com/community/tutorials/regular-expression-in-java-regex-example

    // TODO: read file and scan for a mul(X,Y) sequence. When a sequence is found compute the result and add it to a total. Return the total.
    public static int uncorruptedMulCommandsSum(File file){
        int totalSum = 0;
        String regex = ".";
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(regex);
        try {
            Scanner sc = new Scanner(file);

            while(sc.hasNextLine()){
                System.out.println(sc.nextLine());
            }
            

        } catch (FileNotFoundException e){
            System.out.println("Error: " + e);
        }

        return totalSum;
    }

    public static void main(String[] args) {

        File corruptedFile = new File("src/Day3File.txt");
        System.out.println(uncorruptedMulCommandsSum(corruptedFile));
    }
}
