import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        System.out.println(seek(N,K));
    }

    static int seek(int n, int k){
        if(n >= k){
            return n - k;
        }

        else if(k == 1){
            return 1;
        }

        else if(k % 2 == 1){
            return 1 + Math.min(seek(n,k-1), seek(n, k+1));
        }

        else{
            return Math.min(k-n, 1 + seek(n, k/2));
        }
    }
}
