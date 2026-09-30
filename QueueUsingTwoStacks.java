import java.util.Scanner;
import java.util.Stack;

public class QueueUsingTwoStacks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack1=new Stack<>();
        Stack<Integer> stack2=new Stack<>();
        int q = scanner.nextInt();// Nhap so thao tac truy van
        for (int i = 0; i < q; i++) {
            int type = scanner.nextInt();
            if(type==1){
                int a = scanner.nextInt();
                stack1.push(a);
            } else if (type ==2 || type==3) {
                if (stack2.isEmpty()){
                    while (!stack1.isEmpty()){
                        stack2.push(stack1.pop());
                    }
                }
                if (type ==2){
                    stack2.pop();
                }else
                    System.out.println( stack2.peek());
            }
        }
        scanner.close();
    }
}
