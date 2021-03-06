package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1260_DFSBFS2 {

	static List<Integer>[] list; // 인접리스트
	static boolean[] visited; // 방문 여부
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		list = new List[N+1];
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<>();
		}
		visited = new boolean[N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			// 양방향 연결
			list[a].add(b);
			list[b].add(a);
		}
		
		// 인접리스트는 정렬을 해주어야 한다.
		for(int i=1; i<=N; i++) {
			Collections.sort(list[i]);
		}
		
		dfs(V);
		sb.append("\n");
		
		for(int i=1; i<=N; i++) {
			visited[i] = false;
		}
		
		bfs(V);
		System.out.println(sb);
	}
	
	// 깊이우선탐색(DFS) : 한 점에 연결되있는 점에 재귀로 계속 탐색
	public static void dfs(int v) {
		
		visited[v] = true;
		sb.append(v).append(" ");
		
		for(int val : list[v]) {
			if(visited[val] == false) {
				dfs(val);
			}
		}
		
	}
	
	// 너비우선탐색(BFS) : 큐를 이용하여 구현
	// 한 점에 연결된 점들을 큐에 다 넣고 하나씩 빼서 다시 탐색
	public static void bfs(int v) {
		Queue<Integer> q = new LinkedList<>();
		
		q.offer(v);
		visited[v] = true;
		
		while(!q.isEmpty()) {
			// 큐의 첫원소를 빼서 다시 탐색
			int temp = q.poll();
			sb.append(temp).append(" ");
			
			for(int val : list[temp]) {
				if(visited[val] == false) {
					q.offer(val);
					visited[val] = true;
				}
			}
		}
	}

}
