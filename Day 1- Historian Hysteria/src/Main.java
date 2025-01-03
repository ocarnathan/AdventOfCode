import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Integer> list = new ArrayList<>();
    static List<Integer> list2 = new ArrayList<>();

    // This function reads the lines from the text file and adds each integer to a list.
    public static void readTextFile (List<Integer> list, List<Integer> list2) throws FileNotFoundException {
        Scanner sc = null;
        try {
            sc = new Scanner(new File("src/twolists.txt"));
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        while (sc.hasNextLine()) {
            list.add(sc.nextInt()); // First column
            list2.add(sc.nextInt()); // Second column
        }
    }

    // This function finds the smallest element in an ArrayList
    public static int findSmallest (List<Integer> unsortedList) {
        int smallest = unsortedList.get(0);
        int smallestIndex = 0;

        for (int i = 1; i < unsortedList.size(); i++) {
            if ( unsortedList.get(i) < smallest) {
                smallest = unsortedList.get(i);
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }

    // This function sorts the element in an ArrayList using the findSmallest function as a helper function
    public static List<Integer> selectionSort(List<Integer> unsortedList) {
        List<Integer> sortedList = new ArrayList<>();
//        for (int i = 0; i < unsortedList.size(); i++) {
        for (int i = 0; i < 1000; i++) {
            int smallest = findSmallest(unsortedList);
            sortedList.add(unsortedList.remove(smallest));
        }
        return sortedList;
    }

    public static int findTotalDistanceBetweenValues(List<Integer> list, List<Integer> list2) {
        int listLength = list.size();
        int totalSum = 0;

        for (int i = 0; i < listLength; i++) {
            totalSum+= Math.abs(list.get(i) - list2.get(i));
        }
        return totalSum;
    }

    // TODO:
    //  Calculate a total similarity score by adding up each number in the left list after
    //  multiplying it by the number of times that number appears in the right list

    public static int similarityScoreCalculator(List<Integer> list_1, List<Integer> list_2){
        int totalScore = 0;

        for (int i = 0; i < list_2.size(); i++){
            int multiplyer = 0;
            for (int j = 0; j < list_2.size(); j++){
                if (list_1.get(i).equals(list_2.get(j))){
                    multiplyer++;
                }
            }
            totalScore += (list_1.get(i) * multiplyer);

        }
        return totalScore;
    }



    public static void main(String[] args) throws FileNotFoundException {

        // First read lines from txt file and add them to a list
        readTextFile(list, list2);
        // Sort lists from smallest to largest using selection sort and compute the difference between neighbors while keeping a total

        List<Integer> listCopy = new ArrayList<>(list);
        List<Integer> listCopy2 = new ArrayList<>(list2);

        System.out.println(findTotalDistanceBetweenValues(selectionSort(list),selectionSort(list2)));
        System.out.println("Similarity score: " + similarityScoreCalculator(listCopy,listCopy2));


    }
}
