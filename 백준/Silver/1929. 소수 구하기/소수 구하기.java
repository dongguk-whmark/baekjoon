import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        boolean[] prime = new boolean[N+1];

        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;

        for (int i = 2; i <= Math.sqrt(N); i++) {
            if(prime[i]){
                for (int j = i * i; j <= N; j += i) {
                    prime[j] = false;
                }
            }
        }

        for (int i = M; i <= N; i++) {
            if(prime[i]){
                sb.append(i).append('\n');
            }
        }

        System.out.println(sb);
    }
}
