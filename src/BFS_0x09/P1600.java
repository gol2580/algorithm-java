package BFS_0x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1600 {
    static int w, h, k;
    static int[][] board, distance;
    static Pair cur;
    static Queue<Pair> q = new LinkedList<>();
    static int[] dx = {1,-1,0,0,2,1,-1,-2,2,1,-2,-1};
    static int[] dy = {0,0,-1,1,1,2,2,1,-1,-2,-1,-2};

    static void BFS() {
        while(!q.isEmpty()) {
            cur = q.poll();
            for(int dir=0;dir<12;dir++) {
                int nx = cur.x+dx[dir];
                int ny = cur.y+dy[dir];

                if(nx<0 || nx>=h || ny<0 || ny>=w) {continue;}
                if(dir>=4 && cur.cnt>k) {continue;}

                if(nx==(h-1)&&ny==(w-1)) { System.out.println(distance[cur.x][cur.y]+1); }

                distance[nx][ny]=distance[cur.x][cur.y]+1;
                if(dir>=4) q.offer(new Pair(nx,ny,cur.cnt+1));
                else q.offer(new Pair(nx,ny, cur.cnt));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        w = Integer.parseInt(st.nextToken()); h = Integer.parseInt(st.nextToken());
        board = new int[h][w]; distance = new int[h][w];
        for (int i=0;i<h;i++) {
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<w;j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        q.offer(new Pair(0,0,0));
        BFS();
    }

    static class Pair {
        int x, y, cnt;
        public Pair(int x, int y, int cnt) { this.x = x; this.y = y; this.cnt = cnt; }
        public Pair(int x, int y) { this.x = x; this.y = y; }
    }
}
