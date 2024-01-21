import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder[] person = new StringBuilder[201]; // 나이 200세까지

        for (int i = 0; i < person.length; i++) {
            person[i] = new StringBuilder(); // 각 인덱스에 StringBuilder 생성
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            // 나이를 인덱스로 하는 카운팅 정렬
            person[age].append(age).append(" ").append(name).append('\n');
        }

        StringBuilder sb = new StringBuilder();

        for(StringBuilder val : person){
            sb.append(val);
        }

        System.out.println(sb);
    }
}
