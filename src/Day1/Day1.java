package Day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day1 {
    
    public static void main(String[] args) {

        String csvFile = "src/Day1/resources/input_day1.CSV";
        
        try{
            List<int[]> columns = readCSVColumns(csvFile);
            int[] a = columns.get(0);
            int[] b = columns.get(1);

            int[] c = {3, 4, 2, 1, 3, 3};
            int[] d = {4, 3, 5, 3, 9, 3};


            sortArrays(a, b);
            
            int difference = calculateTotalDistance(a, b);
            int similarityScore = calculateSimilarityScore(a, b);
            System.out.println("The result is: " + difference);
            System.out.println("The similarity score is: " + similarityScore);

        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

    public static void sortArrays(int[] a, int[] b){
        Arrays.sort(a);
        Arrays.sort(b);
    }

    public static int calculateTotalDistance(int[] a, int[] b){
        assert a.length == b.length;
        int sum = 0;
        for(int i = 0; i < a.length; i++){
            sum += Math.abs(a[i] - b[i]);
        }
        return sum;
    }

    public static int calculateSimilarityScore(int[] a, int[] b){
        assert a.length == b.length;

        int similarityScore = 0;

        for(int i = 0; i < a.length; i++){
            int currentNumber = a[i];
          
            similarityScore += currentNumber* getOccurrencesOfNumberInArray(currentNumber, b);  
        }

        
        return similarityScore;
    }

    

    private static int getOccurrencesOfNumberInArray(int number, int[] array){
        int occurrences = 0;
        for(int i = 0; i < array.length; i++){
            if(array[i] == number){
                occurrences++;
            }
        }
        return occurrences;
    }

    public static List<int[]> readCSVColumns(String filePath) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(filePath));
        List<int[]> columns = new ArrayList<>();
        if (!lines.isEmpty()) {
            int numColumns = lines.get(0).split(";").length;
            for (int i = 0; i < numColumns; i++) {
                columns.add(new int[lines.size()]);
            }
            for (int i = 0; i < lines.size(); i++) {
                String[] values = lines.get(i).split(";");
                for (int j = 0; j < values.length; j++) {
                    columns.get(j)[i] = Integer.parseInt(values[j]);
                }
            }
        }
        return columns;
    }










}
