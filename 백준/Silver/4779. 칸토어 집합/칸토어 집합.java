import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {
	public static char[] arr = new char[531442];
	public static void main(String args[]) throws IOException{	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N, thr;	
		String s = "";
		
		while(true) {
			s = br.readLine();
			
			if(s == null || s.equals(""))
				break;
			
			N = Integer.parseInt(s);
			
			thr = (int) Math.pow(3, N);
			for(int i=0; i<thr; i++)
				arr[i] = ' ';
			
			kan(0, thr-1, thr);
			
			for(int i=0; i<thr;i++) 
				sb.append(arr[i]);
			
			sb.append('\n');
		}
		
		System.out.print(sb);
		br.close();
	}
	
	public static void kan(int start, int end, int point) {
		if(point == 1) 
			arr[start] = '-';
		
		else {
			int div = point/3;
			
			kan(start, start+div-1, div);
			kan(end-div+1, end, div);
		}
		
 	}
}