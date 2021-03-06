package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class _1966 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		while(T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			LinkedList<int[]> queue = new LinkedList<int[]>();
			st = new StringTokenizer(br.readLine());
			
			// LinkedList를 만들어서 int[문서 번호, 문서 중요도]를 저장한다.
			for(int i=0; i<N; i++) {
				queue.offer(new int[] {i, Integer.parseInt(st.nextToken())});
			}
			
			// 출력되는 문서 수
			int count = 0;
			
			while(!queue.isEmpty()) {
				// 첫번째 값을 꺼낸다
				int[] first = queue.poll();
				boolean isMax = true;
				
				// 첫번째 문서보다 중요도가 높은 문서가 있는지 찾는다
				for(int i=0; i<queue.size(); i++) {
					// 중요도가 더 높은 문서가 있으면 맨 뒤로 다시 넣어주고 반복을 끝낸다
					if(first[1] < queue.get(i)[1]) {
						queue.offer(first);
						// 중요도가 가장 높은 문서가 아닐 경우 false
						isMax = false;
						break;
					}
				}
				
				if(isMax == false) {
					continue;
				} else {
					// 중요도가 가장 높을 경우 인쇄
					count++;
					// 찾는 문서의 번호일 경우 count 출력
					if(first[0] == M) {
						sb.append(count).append("\n");
						break;
					}
				}
			}
		}

		System.out.println(sb);
		
	}

}
