package BFS_0x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P4179 {
    public static int n; public static int m;
    public static char[][] board; public static int[][] dist_f; public static int[][] dist_j;
    public static Queue<Pair> q = new LinkedList<>();
    public static int[] dx = {1,-1,0,0};
    public static int[] dy = {0,0,-1,1};
    public static Pair J;

    public static void BFS_F() {
        while(!q.isEmpty()) {
            Pair cur=q.poll();
            for(int dir=0;dir<4;dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y+dy[dir];
                if(nx<0 || nx>=n || ny<0 || ny>=m) {continue;}
                if(board[nx][ny]=='#' || dist_f[nx][ny]!=-1) {continue;}//벽이거나 이미 옮긴경우
                dist_f[nx][ny] = dist_f[cur.x][cur.y]+1;
                q.offer(new Pair(nx,ny));
            }
        }
    }

    public static int BFS_J() {
        while(!q.isEmpty()) {
            Pair cur = q.poll();
            for(int dir=0;dir<4;dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                int distance = dist_j[cur.x][cur.y]+1;
                //탈출성공
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    System.out.println(distance);
                    return 0;
                }
                //벽이거나 이미 불이 옮겼거나 이미 갔던곳인경우
                if(board[nx][ny]=='#' || (dist_f[nx][ny]<=distance && dist_f[nx][ny]!=-1) || dist_j[nx][ny]!=-1) {continue;}
                dist_j[nx][ny]=distance;
                q.offer(new Pair(nx,ny));
            }
        }
        System.out.println("IMPOSSIBLE");
        return 0;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
        board = new char[n][m]; dist_j = new int[n][m]; dist_f = new int[n][m];
        for(int i=0;i<n;i++) {
            String str = br.readLine();
            for(int j=0;j<m;j++) {
                board[i][j] = str.charAt(j);
                dist_f[i][j]=-1; dist_j[i][j]=-1;
                if (str.charAt(j)=='F') {
                    dist_f[i][j]=0; q.offer(new Pair(i,j));}
                else if(str.charAt(j)=='J') {
                    J = new Pair(i,j);
                    dist_j[i][j]=0;
                }
            }
        }
        BFS_F();
        q.offer(J);
        BFS_J();
    }
    public static class Pair {
        int x; int y;
        public Pair(int x, int y) {this.x = x; this.y = y;}
    }
}
