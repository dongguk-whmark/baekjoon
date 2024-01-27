// 2024-01-28

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static Deque<Integer> deq = new LinkedList<>();


    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Rev_Josep(N, K, M);

        System.out.println(sb);
    }

    public static void Rev_Josep(int N, int K, int M) {
        boolean direction = true;

        for (int i = 1; i <= N; i++) {
            deq.add(i);
        }

        for (int i = 1; deq.size() > 1; i++) {

            int tmp = 0;

            for (int j = 0; j < K - 1; j++) {

                if (direction) {
                    tmp = deq.removeFirst();
                    deq.addLast(tmp);
                } else {
                    tmp = deq.removeLast();
                    deq.addFirst(tmp);
                }
            }

            if (direction) {
                sb.append(deq.removeFirst()).append('\n');
            } else {
                sb.append(deq.removeLast()).append('\n');
            }

            if (i % M == 0) {
                direction = !direction;
            }
        }
        
        sb.append(deq.remove());
    }
}
