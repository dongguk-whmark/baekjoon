import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){

            String str = br.readLine();

            if(str.equals(".")) break;

            sb.append(VPS(str)).append('\n');
        }

        System.out.println(sb);
    }

    static String VPS(String str){
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            
            // 여는 괄호일 경우 스택에 추가
            if (c == '(' || c == '['){
                stack.push(c);
            }
            
            // 닫는 소괄호일 경우 스택이 비어있거나 여는 소괄호가 스택에 없을 경우 no
            else if (c == ')'){

                if(stack.empty() || stack.peek() != '('){
                    return "no";
                }
                else{
                    stack.pop();
                }
            }
            
            // 닫는 대괄호일 경우에도 동일
            else if (c == ']'){

                if(stack.empty() || stack.peek() != '['){
                    return "no";
                }
                else{
                    stack.pop();
                }
            }
        }
        
        // 모든 과정을 마친 후 스택이 비어 있을 시 yes
        if(stack.empty()){
            return "yes";
        }
        else{
            return "no";
        }
    }
}
