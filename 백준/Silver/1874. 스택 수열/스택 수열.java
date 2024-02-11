import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        check(arr);
    }

    static void check(int[] arr){
        Stack<Integer> stack = new Stack<>();
        Stack<Character> result = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            stack.add(arr[i]);
            result.add('-');

            while(!stack.isEmpty()) {
                if (stack.peek() == n) {
                    stack.pop();
                    result.add('+');
                    n--;
                }
                else{
                    break;
                }
            }
        }

        if(!stack.isEmpty()){
            System.out.println("NO");
        }
        else{
            while(!result.isEmpty()){
                sb.append(result.pop()).append('\n');
            }
            System.out.println(sb);
        }
    }
}
