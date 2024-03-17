import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String A = st.nextToken();
        String B = st.nextToken();

        StringBuffer sb = new StringBuffer(A);
        A = sb.reverse().toString();

        sb = new StringBuffer(B);
        B = sb.reverse().toString();

        int a = Integer.parseInt(A);
        int b = Integer.parseInt(B);

        System.out.println(Math.max(a,b));
    }
}
