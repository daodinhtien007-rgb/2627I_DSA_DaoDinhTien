package week4;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class InsertionSort2 {
    public static void insertionsort2(int n, List<Integer> arr){
        for (int i = 1; i <n ; i++) {
            int temp = arr.get(i);
            int j=i-1;
            while(j>=0 && arr.get(j)>temp){
                arr.set(j+1,arr.get(j));
                j--;
            }
            arr.set(j+1,temp);
            for (int k = 0; k <n ; k++) {
                System.out.print(arr.get(k)+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        InsertionSort2.insertionsort2(n, arr);

        bufferedReader.close();
    }
}
