import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		int num = A * B * C;
		String test = String.valueOf(num);
		
		int arr[] = new int[10];
		
		for (int i = 0; i < test.length(); i++) {
			int idx = test.charAt(i) - '0';
			arr[idx]++;
		}
		
		for (int j = 0; j < arr.length; j++) {
			System.out.println(arr[j]);
		}

	}

}
