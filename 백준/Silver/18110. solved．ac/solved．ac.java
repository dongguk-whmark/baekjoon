import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(diff(arr, n));
    }

    static int diff(int[] num, int n){

        Arrays.sort(num);

        int trim = (int) Math.round(n*0.15);

        double sum = 0;

        for (int i = trim; i < num.length-trim; i++) {
            sum += num[i];
        }

        int result = (int)Math.round(sum / (num.length-trim*2));

        return result;
    }
}
