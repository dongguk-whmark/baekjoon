import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        System.out.println(find(N));
    }

    static int find(int num){

        if (num == 4 || num == 7){
            return -1;
        }

        if (num%5 == 0){
            return num/5;
        }

        if (num%5 == 1 || num%5 == 3){
            return num/5 +1;
        }

        if (num%5 == 2 || num%5 == 4){
            return num/5 +2;
        }

        return 0;
    }
}
