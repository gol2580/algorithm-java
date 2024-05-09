package BFS_0x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2206 {
    public static int[][] board; public static int[][] dist;
    public static Queue<Pair> q = new LinkedList<>();
    public static Pair cur;
    public static int[] dx = {1,-1,0,0};
    public static int[] dy = {0,0,-1,1};
    public static int n; public static int m;
    public static int result=-1;
    public static int min_d;

    public static void BFS() {
        min_d = n*m;
        while(!q.isEmpty()) {
            cur = q.poll();
            for(int dir=0;dir<4;dir++) {
                int nx = cur.x+dx[dir];
                int ny = cur.y+dy[dir];
                if(nx<0 || nx>=n || ny <0 || ny>=m) {continue;}
                if(nx==(n-1) && ny==(m-1)) {result = dist[cur.x][cur.y]+1; break;}
                if(dist[nx][ny]!=0) {continue;}
                if(board[nx][ny]==1) {try_bfs(new Pair(nx, ny), cur); continue;}
                dist[nx][ny] = dist[cur.x][cur.y]+1;
                q.offer(new Pair(nx, ny));
            }
        }
    }
    public static void try_bfs(Pair now, Pair ex) {
        int result=n*m;
        Pair cur;
        Queue<Pair> try_q = new LinkedList<>();
        try_q.offer(now);
        int[][] try_dist = new int[n][m];
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                try_dist[i][j]=dist[i][j];
            }
        }
        try_dist[now.x][now.y] = dist[ex.x][ex.y]+1;
        while(!try_q.isEmpty()) {
            cur = try_q.poll();
            for(int dir=0;dir<4;dir++) {
                int nx = cur.x+dx[dir];
                int ny = cur.y+dy[dir];
                if(nx<0 || nx>=n || ny <0 || ny>=m) {continue;}
                if(nx==(n-1) && ny==(m-1)) {result = try_dist[cur.x][cur.y]+1; break;}
                if(board[nx][ny]==1 || try_dist[nx][ny]!=0) {continue;}
                try_dist[nx][ny] = try_dist[cur.x][cur.y]+1;
                try_q.offer(new Pair(nx, ny));
            }
        }
        min_d = Math.min(min_d, result);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
        board = new int[n][m]; dist = new int[n][m]; min_d=n*m;
        for(int i=0;i<n;i++) {
            String str = br.readLine();
            for(int j=0;j<m;j++) {
                board[i][j]=str.charAt(j)-'0';
            }
        }
        if(n==1 && m==1) {result=1;} //출발지 = 도착지인 경우
        else {
            q.offer(new Pair(0, 0)); dist[0][0] = 1;
            BFS();
        }
        if(result==-1 && min_d==n*m) {
            System.out.println("-1");
        } else {
            if(result!=-1) {System.out.println(Math.min(result, min_d));}
            else {System.out.println(min_d);}
        }

    }
    public static class Pair {
        int x; int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
