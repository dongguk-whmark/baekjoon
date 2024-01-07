import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        for (; ;){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            if(a==0 && b==0 && c==0) break;

            right(a,b,c);

        }
    }

    public static void right(int a, int b, int c){
        int a_square = (int) Math.pow(a,2);
        int b_square = (int) Math.pow(b,2);
        int c_square = (int) Math.pow(c,2);

        if (a_square + b_square == c_square || a_square == b_square + c_square || b_square == a_square + c_square){
            System.out.println("right");
        }
        else {
            System.out.println("wrong");
        }
    }
}
