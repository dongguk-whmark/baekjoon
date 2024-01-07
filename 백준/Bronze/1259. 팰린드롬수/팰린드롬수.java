import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        for (; ;){
            String num = sc.next();
            if (num.equals("0")) break;
            palindrome(num);
        }

        sc.close();


    }

    public static void palindrome(String a){
        StringBuffer sb = new StringBuffer(a);
        String reverse = sb.reverse().toString();

        if (a.equals(reverse)){
            System.out.println("yes");
        }
        else{
            System.out.println("no");
        }
    }
}

