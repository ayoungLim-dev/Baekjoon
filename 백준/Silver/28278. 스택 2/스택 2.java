import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine()); // 입력 받을 명령의 수
		Stack<Integer> s = new Stack<Integer>();

		int order = 0;
		String[] num;
		for(int i=0; i<N; i++) {
			num = br.readLine().split(" ");
			order = Integer.parseInt(num[0]);
			
			switch(order) {
                 //1 X: 정수 X를 스택에 넣는다. (1 ≤ X ≤ 100,000)
				case 1:
					s.add(Integer.parseInt(num[1]));
					break;
	            //2: 스택에 정수가 있다면 맨 위의 정수를 빼고 출력한다. 없다면 -1을 대신 출력한다.
				case 2:
					if(s.empty()) sb.append("-1");
					else {
						if(s.empty()) sb.append("-1");
						else sb.append(s.peek());
						s.pop();
					}
					sb.append("\n");
					break;
	            //3: 스택에 들어있는 정수의 개수를 출력한다.
				case 3:
					sb.append(s.size());
					sb.append("\n");
					break;
			    //4: 스택이 비어있으면 1, 아니면 0을 출력한다.
				case 4:
					if(s.empty()) sb.append("1");
					else sb.append("0");
					sb.append("\n");
					break;
		        //5: 스택에 정수가 있다면 맨 위의 정수를 출력한다. 없다면 -1을 대신 출력한다.
				case 5:
					if(s.empty()) sb.append("-1");
					else sb.append(s.peek());
					sb.append("\n");
					break;
			}


		}
		System.out.println(sb);
	}
}