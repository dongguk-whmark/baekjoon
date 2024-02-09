import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] priority;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int test_case = Integer.parseInt(br.readLine());

        for (int i = 0; i < test_case; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            priority = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                priority[j] = Integer.parseInt(st.nextToken());
            }

            sb.append(print_order(M)).append('\n');
        }

        System.out.println(sb);
    }

    static int print_order(int num) {

        Queue<Integer> q = new LinkedList<>();

        int count = 0;

        for (int i = 0; i < priority.length; i++) {
            q.offer(i);
        }

        while(!q.isEmpty()){
            int cur = q.poll();
            boolean isPrinted = true;

            for (int doc : q){
                if(priority[cur] < priority[doc]){
                    q.offer(cur);
                    isPrinted = false;
                    break;
                }
            }

            if(isPrinted){
                count++;

                if(cur == num){
                    return count;
                }
            }

        }

        return 0;
    }
}