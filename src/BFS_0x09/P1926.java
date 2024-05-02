package BFS_0x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1926 {
    public static int n; public static int m;
    public static int[] dx = {1,-1,0,0};
    public static int[] dy = {0,0,-1,1};
    public static int[][] board;
    public static int[][] visited;
    public static Queue<Pair> q = new LinkedList<>();
    public static int cnt =0;
    public static int max = 0;
    public static Pair cur;


    public static void BFS() {
        int b = 0;
        q.offer(cur); // 0,0
        while(!q.isEmpty()) {
            cur = q.poll(); b++;
            for(int dir=0;dir<4;dir++) {
                int nx = cur.x+dx[dir];
                int ny = cur.y+dy[dir];
                if(nx<0 || nx>=n || ny<0 || ny>=m) {continue;}
                if(board[nx][ny]==0 || visited[nx][ny]==1) {continue;}
                visited[nx][ny]=1;
                q.offer(new Pair(nx,ny));
            }
        }
        if(b>max) {max=b;}
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        visited = new int[n][m];
        for(int i=0;i<n;i++) { //board 초기화
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<m;j++) {board[i][j] = Integer.parseInt(st.nextToken());}
        }
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                cur = new Pair(i,j);
                if(visited[i][j]==0 && board[i][j]==1) {
                    visited[i][j]=1;
                    BFS(); cnt++; }
            }
        }
        System.out.println(cnt);
        System.out.println(max);
    }

    static class Pair {
        int x;
        int y;
        Pair(int x,int y) {
            this.x = x; this.y=y;
        }
    }
}
