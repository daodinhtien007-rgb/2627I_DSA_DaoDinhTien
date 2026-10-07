package week4;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class InsertionSort1 {

    public static void insertionSort1(int n, List<Integer> arr) {
        int a=arr.get(n-1);
        int i=n-2;
        while (i>=0 && arr.get(i)>a){
            arr.set(i+1,arr.get(i));
            for(int j=0;j<n;j++){
                System.out.print(arr.get(j)+" ");
            }
            System.out.println();
            i--;
        }
        arr.set(i+1,a);
        for(int j=0;j<n;j++){
            System.out.print(arr.get(j)+" ");
        }
    }

}
class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        InsertionSort1.insertionSort1(n, arr);

        bufferedReader.close();
    }
}
