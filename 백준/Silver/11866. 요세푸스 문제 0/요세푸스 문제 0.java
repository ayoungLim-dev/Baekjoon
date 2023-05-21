import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.LinkedList;

public class Main {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		Queue<Integer> que = new LinkedList<>();

		for(int i=1;i<N+1;i++) 
			que.add(i);
		
		sb.append("<");
		while(que.size()!=1) {
			for(int i=1; i<k;i++) {
				que.add(que.peek());
				que.poll();
			}
			
			sb.append(que.peek()).append(", ");
			que.poll();

		}
		sb.append(que.peek()).append(">");
		
		System.out.print(sb);

		br.close();
	}
}