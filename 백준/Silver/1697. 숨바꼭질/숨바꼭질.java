import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	private static int[] visited;
	private static int N, K;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		K = Integer.parseInt(input[1]);
		
		visited = new int[100001];
		
		int result=0;
		if(N == K)
			result = 0;
		else
			result = bfs(N);
		System.out.print(result);
	}
	
	public static int bfs(int N) {
		Queue<Integer> que = new LinkedList<>();
		
		// 현재 node 방문한 것으로 표시하고 que에 삽입
		que.add(N);
		visited[N] = 1;
		
		int i, root, tmp;
		// queue가 빌 때까지 반복
		while(!que.isEmpty()) {
			tmp = que.poll();
			
			for(i=0; i<3; i++) {
				if(i == 0)
					root = tmp - 1;
				else if(i == 1)
					root = tmp + 1;
				else //i==2
					root = tmp * 2;
				
				if(root == K)
					return visited[tmp];
				
				if(root < 0 || root > 100000) continue;
				if(visited[root] != 0) continue;
				
				que.add(root);
				visited[root] = visited[tmp] + 1;
			}
		}
		return -1;
	}
}
