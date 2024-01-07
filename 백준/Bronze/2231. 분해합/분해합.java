import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int con = 0;

        for (int i = 1; i < num; i++){
            if (i + dec_sum(i) == num) {
                con = i;
                break;
            }
        }

        System.out.println(con);
    }

    public static int dec_sum(int a){
        int digit_sum = 0;

        for (int i = 0; a > 0; i++){
            digit_sum += a%10;
            int tmp = a/10;
            a = tmp;
        }

        return digit_sum;
    }
}
