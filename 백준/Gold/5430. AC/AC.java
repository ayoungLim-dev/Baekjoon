import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static LinkedList<Integer> deq;
	static StringBuilder sb = new StringBuilder();
	static int flag; // R
	public static void main(String args[]) throws IOException{
		// R : 뒤집기
		// D : 버리기 (배열이 비어있는 경우 에러)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		loof: while (T-->0) {
			flag =0; 
			String p[] = br.readLine().split(""); // 함수
			int n = Integer.parseInt(br.readLine()); // 배열의 개수
			
			st = new StringTokenizer(br.readLine(), "[],");
			
			deq = new LinkedList<Integer>();
			for(int i=0; i<n; i++) 
				deq.offer(Integer.parseInt(st.nextToken()));
			
			int len = p.length;
			for(int i=0; i<len;i++) {
				
				if(p[i].equals("R")) 
					flag++;
				else {
					if(deq.size()==0) {
						sb.append("error\n");
						continue loof;
					}	
					else 
						D();
				}
			}
			DEQ();
		}
		System.out.print(sb);
		br.close();
	}
	// 버리기
	static void D() {
		if(flag % 2 ==0) // 짝수라면 그대로 poll()
			deq.pollFirst();
		else // 홀수라면 뒤집고 poll()
			deq.pollLast();
	}
	
	// 출력문
	static void DEQ() {
		int size = deq.size();
		if(size ==0) {
			sb.append("[]\n");
		}
		else {
			sb.append("[");
			for(int i=0; i<size-1;i++) 
				if(flag % 2 ==0) 
					sb.append(deq.pollFirst()).append(",");
				else 
					sb.append(deq.pollLast()).append(",");

			if(flag % 2 ==0) 
				sb.append(deq.pollFirst());
			else 
				sb.append(deq.pollLast());

			sb.append("]\n");
		}
	}
}