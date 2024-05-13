package BFS_0x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P9466 {
    public static int n;
    public static int m;
    public static int result;
    public static int[] board;
    public static int[] visited;
    public static Queue<Integer> q = new LinkedList<>();
    public static int getGroup() {
        visited = new int[m];
        int members=0;
        int cur=0; int next=0; int start =0;
        while(!q.isEmpty()) {
            cur = q.poll(); board[cur]=0;
            next = board[cur];
            //이미 그룹이 지어진 사람이거나 or 방문했던 경우
            if(visited[next]==1 || board[next]==-1 || board[next]==0) {break;}
            //visited : 이번 싸이클에서의 방문여부 표시
            if(visited[board[next]]==1) {
                start = board[next]; // ->
                cur = next;
                q.offer(board[next]);
                while(cur!=start) {
                    cur = q.poll(); result--;
                }
            }
            q.offer(next);
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        while(n-->0) {
            m = Integer.parseInt(br.readLine());
            result = m;
            st = new StringTokenizer(br.readLine()," ");
            board = new int[m];
            for(int i=0;i<m;i++) {board[i]=Integer.parseInt(st.nextToken())-1;}
            for(int i=0;i<m;i++) {
                if(board[i]==i) { result--; board[i]=-1; continue; } //board[i]==-1 : 이미 짝이 지어졌다
                //이미 짝이 지어졌거나 방문했던 곳인 경우 (전 싸이클에서 검사했던 경우)
                if(board[i]==-1 || board[i]==0) { continue; }
                q.offer(i);
                getGroup();
            }
            System.out.println(result);
        }
    }
}
