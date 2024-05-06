package BFS_0x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P2667 {
    public static Queue<Pair> q = new LinkedList<>();
    public static int[][] board; public static int[][] visited;
    public static int cnt=0;
    public static ArrayList dists = new ArrayList();
    public static int[] dx = {1,-1,0,0};
    public static int[] dy = {0,0,-1,1};
    public static int n;

    public static void BFS() {
        int dist = 0;
        Pair cur;
        while(!q.isEmpty()) {
            cur = q.poll(); dist++;
            for(int dir=0;dir<4;dir++) {
                int nx = cur.x+dx[dir];
                int ny = cur.y+dy[dir];
                if(nx<0 || nx>=n || ny<0 || ny>=n) {continue;}
                if(board[nx][ny]==0 || visited[nx][ny]==1) {continue;}
                visited[nx][ny]=1;
                q.offer(new Pair(nx,ny));
            }
        }
        dists.add(dist);
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n]; visited = new int[n][n];
        for(int i=0;i<n;i++) {
            String str = br.readLine();
            for(int j=0;j<n;j++) {
                board[i][j] = str.charAt(j)-'0';
            }
        }
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(board[i][j]==1 && visited[i][j]==0) { //집이면서 && 방문하지 않은 곳
                    q.offer(new Pair(i, j)); visited[i][j]=1;
                    cnt++;
                    BFS();
                }
            }
        }
        Collections.sort(dists);
        ListIterator iter = dists.listIterator();
        sb.append(cnt).append('\n');
        while(iter.hasNext()) {sb.append(iter.next()).append('\n');}
        System.out.println(sb);
    }
    public static class Pair {
        int x; int y;
        Pair(int x, int y) {this.x = x; this.y = y;}
    }
}
