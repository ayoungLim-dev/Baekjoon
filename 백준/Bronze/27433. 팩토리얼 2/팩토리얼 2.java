import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {
	public static void main(String args[]) throws IOException{	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		int N = Integer.parseInt(br.readLine());

		System.out.print(fac(N));
		br.close();
	}
	
	public static long fac(int n) {
		if(n<=1) return 1;
		return n*fac(n-1);
 	}
}