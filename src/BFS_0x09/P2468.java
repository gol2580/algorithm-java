package BFS_0x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2468 {
    public static int n;
    public static int cnt=0;
    public static Queue<Pair> q = new LinkedList<>();
    public static int[][] board; public static int[][] visited;
    public static int maxH=0; public static int max=0;
    public static int[] dx = {1,-1,0,0};
    public static int[] dy = {0,0,-1,1};
    public static Pair cur;

    public static void BFS(int k) {
        while(!q.isEmpty()) {
            cur = q.poll();
            for(int dir=0;dir<4;dir++) {
                int nx = cur.x+dx[dir];
                int ny = cur.y+dy[dir];
                if(nx<0 || nx>=n || ny<0 || ny>=n) {continue;}
                if(board[nx][ny]<=k || visited[nx][ny]!=0) {continue;}
                visited[nx][ny]=1;
                q.offer(new Pair(nx,ny));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n]; visited = new int[n][n];
        for(int i=0;i<n;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<n;j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                maxH = Math.max(board[i][j],maxH);
            }
        }
        for(int k=0;k<maxH;k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(board[i][j]>k && visited[i][j]==0) {
                        q.offer(new Pair(i,j));
                        BFS(k);
                        cnt++;
                    }
                }
            }
            max = Math.max(cnt,max);
            cnt=0;
            for(int[] a : visited) {Arrays.fill(a,0);}
        }
        System.out.println(max);
    }

    public static class Pair {
        int x; int y;
        Pair(int x, int y) {this.x = x; this.y = y;}
    }
}
