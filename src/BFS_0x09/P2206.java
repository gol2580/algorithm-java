package BFS_0x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2206 {
    public static int[][] board; public static int[][][] dist;
    public static Queue<Pair> q = new LinkedList<>();
    public static Pair cur;
    public static int[] dx = {1,-1,0,0};
    public static int[] dy = {0,0,-1,1};
    public static int n; public static int m;
    public static int result;

    public static void BFS() {
        while(!q.isEmpty()) {
            cur = q.poll();
            for(int dir=0;dir<4;dir++) {
                int nx = cur.x+dx[dir];
                int ny = cur.y+dy[dir];
                if(nx<0 || nx>=n || ny <0 || ny>=m) {continue;} //board 벗어나면
                if(nx==(n-1) && ny==(m-1)) {result = Math.min(result,dist[cur.x][cur.y][cur.cnt]+1); break;} //목적지에 도착하면
                if(dist[nx][ny][cur.cnt]!=0) {continue;} //이미 방문한 데면
                //1이고 아직 안 부셨다면
                if(board[nx][ny]==1 && cur.cnt==0) {
                    q.offer(new Pair(nx,ny,1));
                    dist[nx][ny][1] = dist[cur.x][cur.y][cur.cnt]+1;
                    continue;
                }
                if(board[nx][ny]==1 && cur.cnt!=0) {continue;}
                dist[nx][ny][cur.cnt] = dist[cur.x][cur.y][cur.cnt]+1;
                q.offer(new Pair(nx, ny,cur.cnt));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
        result = n*m+1;
        board = new int[n][m]; dist = new int[n][m][2];
        for(int i=0;i<n;i++) {
            String str = br.readLine();
            for(int j=0;j<m;j++) {
                board[i][j]=str.charAt(j)-'0';
            }
        }
        if(n==1 && m==1) {result=1;} //출발지 = 도착지인 경우
        else {
            q.offer(new Pair(0, 0,0)); dist[0][0][0] = 1;
            BFS();
        }
        if(result==(n*m+1)) {System.out.println("-1");}
        else {System.out.println(result);}
    }
    public static class Pair {
        int x; int y; int cnt;
        public Pair(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}
