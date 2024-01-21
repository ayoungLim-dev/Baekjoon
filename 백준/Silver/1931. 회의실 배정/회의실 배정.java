import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

// 그리드 알고리즘
public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine()); // 연산의 개수 (1<=N<=100,000)
		int room[][] = new int[N][2]; // 회의 예약 시간
		int i = 0, count = 0;
		
		for(i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			room[i][0] = Integer.parseInt(st.nextToken()); // 시작 시간
			room[i][1] = Integer.parseInt(st.nextToken()); // 종료 시간
		}
		
		// 정렬 알고리즘을 사용할 경우, O(n^2)를 초과하게 됨. 따라서 Comparator 인터페이스로 정렬
        Arrays.sort(room, new Comparator<int[]>() {
            @Override
            public int compare(int[] time1, int[] time2) {
            	// 종료 시간을 기준으로 정렬하되, 종료 시간이 같다면 시작 시간 정렬
                if(time1[1]==time2[1]) {
                    return time1[0]-time2[0];
                }
                return time1[1]-time2[1];
            }
        });
		
        int can = 0; // 배정 가능 최소 시간
       
		for(i=0; i<N; i++) 
            // 정렬을 기준으로 최소 시간이 회의 시작 시간보다 작거나 같다면 회의실 배정
			if(can <= room[i][0]) {
				can = room[i][1];
				count++;
			}
		
		System.out.print(count);
		
		br.close();
	}
}
