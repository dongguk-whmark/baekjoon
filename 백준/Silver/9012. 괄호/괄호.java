import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static Stack<Character> stack = new Stack<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String str = br.readLine();
            sb.append(isVPS(str)).append('\n');
        }

        System.out.println(sb);

    }

    static String isVPS(String str) {

        for (int i = 0; i < str.length(); i++) {

            char c = str.charAt(i);
            
            // 여는 괄호일 경우 스택에 추가
            if (c == '(') {
                stack.push(c);
            }
            
            // 닫는 괄호일 경우 앞에 여는 괄호가 없음(스택이 비어있음)
            else if (stack.empty()) {
                return "NO";
            }
            
            // 여는 괄호가 있을 경우 스택 pop
            else {
                stack.pop();
            }

        }
        
        // 모든 과정을 마치고 스택이 비어있을 경우 YES, 아닐 경우 여는 괄호가 많으므로 NO
        if (stack.empty()) {
            return "YES";
        }

        else {
            stack.clear(); //전역변수로 스택 선언했기 때문에 초기화, 하지 않을 시 뒤의 모든 결과 NO
            return "NO";
        }
    }
}
