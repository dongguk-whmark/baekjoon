// 2024-01-27

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static Queue<Integer> q = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        josep(N,K);

        System.out.println(sb);
    }

    public static void josep(int N, int K) {

        for (int i = 1; i <= N; i++) {
            q.add(i);
        }

        sb.append('<');

        while (q.size() > 1) {

            for (int i = 0; i < K - 1; i++) {
                int tmp = q.remove();
                q.add(tmp);
            }

            sb.append(q.remove()).append(", ");
        }

        sb.append(q.remove()).append('>');
    }
}
