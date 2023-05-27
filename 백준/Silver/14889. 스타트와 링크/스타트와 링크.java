import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class Main {
	static int[][] arr;
	static int N;
	static int start, link;
	static boolean visit[];
	static int min = Integer.MAX_VALUE;
	public static void main(String args[]) throws IOException{	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		
		visit = new boolean[N];
		arr = new int[N][N];
		
		StringTokenizer st;
		for(int i=0; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N;j++) 
				arr[i][j] = Integer.parseInt(st.nextToken());
		} 
		
		dfs(0, 0);
		System.out.print(min);
		
		br.close();
	}

	// i!=j
	// 1~N 중에 start가 선택한 i,j는 link가 뽑을 수 없음
	// 인원은 반반
	// i, j의 합을 구하고, 최소값을 알아내야 함(최소 찾을 때까지 재귀)
	// 
	
	public static void dfs(int depth, int num) {
		if(depth == N/2) {
			search();
			return;
		}
		
		for(int i=num; i<N; i++) {
			visit[i] = true;
			dfs(depth+1, i+1);
			visit[i]=false;
		}
	}
	
	public static void search() {
		int start = 0; 
		int link = 0;
		int sum;
		for(int i=0;i<N - 1;i++) {
			for(int j=i+1; j<N;j++) {
				if(visit[i] == true && visit[j] == true) {
					start += arr[i][j];
					start += arr[j][i];
				}
				else if(visit[i] == false && visit[j] == false) {
					link += arr[i][j];
					link += arr[j][i];
				}
			}
		}
		
		sum = Math.abs(start - link);
		
		if(sum ==0)
			min = 0;
		else
			min = Math.min(sum, min);
	}
}