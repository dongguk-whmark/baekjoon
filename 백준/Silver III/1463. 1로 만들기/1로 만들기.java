import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        System.out.println(recur(N, 0));
    }

    static int recur(int num, int count){
        if (num < 2){
            return count;
        }

        return Math.min(recur(num / 2, count + 1 + (num % 2)), recur(num / 3, count + 1 + (num % 3)));
    }
}
