import java.util.Scanner;

public class BalancedBrackets {
    public static boolean isBalanced(String s){
        String[] stack = new String[s.length()];
        int top = -1;//Khoi tao ban dau chuoi rong
        for (int i = 0; i <s.length() ; i++) {
            String c = s.substring(i,i+1);
            if (c.equals("(") || c.equals("[") || c.equals("{")){
                top++;
                stack[top]=c;
            } else if (c.equals(")") || c.equals("]") || c.equals("}")) {
                if(top==-1)  //Neu chuoi rong thi thuc hien vong lap tiep theo   |
                    return false;
                String open = stack[top];
                top--;
                if((c.equals(")") && !open.equals("(")) || (c.equals("]") && !open.equals("[")) || c.equals("}") && !open.equals("{"))
                    return false;

            }
        }if(top==-1) // Kiem tra chuoi cuoi cung co thua ra hay khong
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap : ");
        String s = scanner.nextLine();
        System.out.println(isBalanced(s));
        scanner.close();

    }
}
