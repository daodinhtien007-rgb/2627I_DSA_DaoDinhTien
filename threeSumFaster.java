import java.util.Arrays;

public class threeSumFaster {
    public static int countTwoSumFaster(int[] a){
        int left = 0;
        int right =a.length-1;
        int count =0;
        while (left<right) {
            int sum = a[left] + a[right];
            if (sum == 0) {
                left++;
                right--;
                count++;
            } else if (sum<0) {
                left++;
            }else
                right--;
        }
        return count;
    }
    public static int countThreeSumFaster(int[]a){
        Arrays.sort(a);
        int count =0;
        int n=a.length;
        for (int i = 0; i <n-2 ; i++) {
            int left=i+1;
            int right=n-1;
            int target=-a[i];
            while (left<right){
                int sum=a[left]+a[right];
                if(sum==target){
                    count++;
                    left++;
                    right--;

                } else if (sum<target) {
                    left++;
                }else
                    right--;
            }
        }return count;
    }

    public static void main(String[] args) {
        int[] a1={-5,-4,-3,-2,-1,0,1,2,3};
        System.out.println(countTwoSumFaster(a1));

        System.out.println(countThreeSumFaster(a1));
    }
}
