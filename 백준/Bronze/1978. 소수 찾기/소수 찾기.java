import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int test_case = sc.nextInt();
        int count = 0;

        for (int i = 0; i < test_case; i++){
            int num = sc.nextInt();
            if(is_Prime(num) == true){
                count++;
            }
        }

        System.out.println(count);


    }

    public static boolean is_Prime(int a){

        boolean prime = true;
        if (a == 1) prime = false;

        for (int i = 2; i < a; i++){
            if (a%i == 0) prime = false;
        }

        return prime;
    }
}