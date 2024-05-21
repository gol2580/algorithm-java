package BFS_0x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1600 {
    static int w, h, k, nx, ny;
    static int[][] board; static int[][][] distance;
    static Pair cur;
    static int result;
    static Queue<Pair> q = new LinkedList<>();
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[] hx = {2,1,-2,-1,2,1,-2,-1};
    static int[] hy = {1,2,1,2,-1,-2,-1,-2};

    static int BFS() {
        result = w*h;
        if(w==1 && h==1) {
            result=0;
            return -1;
        }
        while(!q.isEmpty()) {
            cur = q.poll();
            if(cur.x==(h-1)&&cur.y==(w-1)) { result = distance[cur.x][cur.y][cur.cnt]; return -1; }

            for(int dir=0;dir<4;dir++) {
                nx = cur.x+dx[dir];
                ny = cur.y+dy[dir];

                if(nx<0 || nx>=h || ny<0 || ny>=w) {continue;}
                if(board[nx][ny]==1) {continue;}
                if(distance[nx][ny][cur.cnt]!=0) {continue;}

                q.offer(new Pair(nx,ny, cur.cnt));
                distance[nx][ny][cur.cnt] = distance[cur.x][cur.y][cur.cnt]+1;
            }
            if(cur.cnt<k) {
                for (int dir = 0; dir < 8; dir++) {
                    nx = cur.x + hx[dir];
                    ny = cur.y+hy[dir];

                    if(nx<0 || nx>=h || ny<0 || ny>=w) {continue;}
                    if(board[nx][ny]==1) {continue;}
                    //메모리 초과 풀이
                    //if(distance[nx][ny][cur.cnt]!=0) {continue;}
                    if(distance[nx][ny][cur.cnt+1]!=0) {continue;}

                    q.offer(new Pair(nx,ny,cur.cnt+1));
                    distance[nx][ny][cur.cnt+1]=distance[cur.x][cur.y][cur.cnt]+1;
                }

            }
        }
        if(result==w*h) result=-1;
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        w = Integer.parseInt(st.nextToken()); h = Integer.parseInt(st.nextToken());
        board = new int[h][w]; distance = new int[h][w][k+1];
        for (int i=0;i<h;i++) {
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<w;j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        q.offer(new Pair(0,0,0));
        BFS();
        System.out.println(result);
    }

    static class Pair {
        int x, y, cnt;
        public Pair(int x, int y, int cnt) { this.x = x; this.y = y; this.cnt = cnt; }
        public Pair(int x, int y) { this.x = x; this.y = y; }
    }
}
