import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        System.out.println(beehive(num));
    }

    public static int beehive(int a){
        int max_num = 1;
        for (int i = 1; true; i++){
            max_num += (6 * (i-1));

            if (max_num >= a){
                return i;
            }

        }
    }
}
