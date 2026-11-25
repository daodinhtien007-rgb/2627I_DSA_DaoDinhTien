package week11;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class RunningMedian {

    static class Element implements Comparable<Element> {
        int val;
        int index;

        Element(int val, int index) {
            this.val = val;
            this.index = index;
        }

        @Override
        public int compareTo(Element other) {
            if (this.val != other.val) {
                return Integer.compare(this.val, other.val);
            }
            return Integer.compare(this.index, other.index);
        }
    }

    public static List<Double> runningMedian(List<Integer> a) {
        List<Double> medians = new ArrayList<>();
        TreeSet<Element> tree = new TreeSet<>();
        Element left = null;
        Element right = null;

        for (int i = 0; i < a.size(); i++) {
            Element curr = new Element(a.get(i), i);
            tree.add(curr);

            if (i == 0) {
                left = curr;
                right = curr;
            } else if (left == right) {
                if (curr.compareTo(left) < 0) {
                    left = tree.lower(left);
                } else {
                    right = tree.higher(right);
                }
            } else {
                if (curr.compareTo(left) < 0) {
                    right = left;
                } else if (curr.compareTo(right) > 0) {
                    left = right;
                } else {
                    left = curr;
                    right = curr;
                }
            }

            medians.add((left.val + right.val) / 2.0);
        }

        return medians;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a.add(scan.nextInt());
        }
        scan.close();

        List<Double> result = runningMedian(a);
        for (double median : result) {
            System.out.printf("%.1f\n", median);
        }
    }
}