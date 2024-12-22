import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    // NOTE: Collaborated with GamXCs (GitHub) on this problem. Code copied from his GitHub repo

    static List<Integer> list = new ArrayList<>();
    static int counter = 0;

    public static boolean safe(List<Integer> list ) {
        for (int i = 0; i < list.size() - 1; i++){
            int firstNum = list.get(0);
            int secondNum = list.get(1);

            int nextNum1 = list.get(i);
            int nextNum2 = list.get(i + 1);

            if(firstNum == secondNum){
                return false;
            }
            //Increasing logic
            if(firstNum < secondNum){

                if (nextNum1 > nextNum2 || nextNum1 == nextNum2 || (Math.abs(nextNum1 - nextNum2) > 3 )){
                    return false;
                }
            }

            //Decreasing logic
            if(firstNum > secondNum){
                if (nextNum1 < nextNum2 || nextNum1 == nextNum2 || (Math.abs(nextNum1 - nextNum2) > 3)){
                    return false;
                }
            }

        }

        return true;
    }




    public static void main(String[] args) {
        // TODO: Read in text file line by line
        try (Scanner scanner = new Scanner(Paths.get("src/Day2file.txt"))) {
            while (scanner.hasNextLine()) {

                List<String> stringList = new ArrayList<>(List.of(scanner.nextLine().split(" ")));

                for (int i = 0; i < stringList.size(); i++){
                    list.add(Integer.parseInt(stringList.get(i)));
                }

                boolean safe = safe(list);

                if (!safe) {
                    for (int i = 0; i < list.size(); i++){
                        int test = list.get(i);
                        list.remove(i);
                        safe = safe(list);
                        if (safe){
                            break;
                        }
                        list.add(i,test);

                    }

                }
                counter += safe ? 1: 0;
                list.clear();
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.toString());
        }
        System.out.println();
        System.out.println(counter);
    }
}