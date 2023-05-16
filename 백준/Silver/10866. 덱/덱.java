import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		String s[];
		Deque deq = new ArrayDeque();
		while(T --> 0) {
			s = br.readLine().split(" ");
			

			if(s[0].equals("push_front")) 
				deq.offerFirst(Integer.parseInt(s[1]));
			
			if(s[0].equals("push_back")) 
				deq.offerLast(Integer.parseInt(s[1]));
			
			if(s[0].equals("pop_front")) {
				if(deq.isEmpty())
					sb.append(-1).append('\n');
				else {
					sb.append(deq.peekFirst()).append('\n');
					deq.pollFirst();
				}
			}
			if(s[0].equals("pop_back")) {
				if(deq.isEmpty())
					sb.append(-1).append('\n');
				else {
					sb.append(deq.peekLast()).append('\n');
					deq.pollLast();
				}
			}
			if(s[0].equals("size")) 
				sb.append(deq.size()).append('\n');
			if(s[0].equals("empty")) {
				if(deq.isEmpty())
					sb.append(1).append('\n');
				else
					sb.append(0).append('\n');
			}
			if(s[0].equals("front")) {
				if(deq.isEmpty())
					sb.append(-1).append('\n');
				else
					sb.append(deq.peekFirst()).append('\n');
			}
			
			if(s[0].equals("back")) {
				if(deq.isEmpty())
					sb.append(-1).append('\n');
				else 
					sb.append(deq.peekLast()).append('\n');
			}
		}
		
		System.out.print(sb);
		br.close();
	}
}