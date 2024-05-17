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
    static int[] dx = {1,-1,0,0,2,1,-2,-1,2,1,-2,-1};
    static int[] dy = {0,0,-1,1,1,2,1,2,-1,-2,-1,-2};

    static int BFS() {
        result = w*h;
        if(w==1 && h==1) {
            result=0;
            return -1;
        }
        while(!q.isEmpty()) {
            cur = q.poll();
            for(int dir=0;dir<12;dir++) {
                nx = cur.x+dx[dir];
                ny = cur.y+dy[dir];

                if(nx<0 || nx>=h || ny<0 || ny>=w) {continue;}
                if(dir>=4 && cur.cnt>=k) {continue;}
                if(board[nx][ny]==1) {continue;}
                //distance[x][y][0] : 거리 , distance[x][y][1] : 그 거리에 도달했을때 cnt
                if(distance[cur.x][cur.y][1] >= distance[nx][ny][1] && distance[nx][ny][0]!=0) {continue;}
                // 도착
                if(nx==(h-1)&&ny==(w-1)) result = Math.min(result,distance[cur.x][cur.y][0]);


                distance[nx][ny][0]=distance[cur.x][cur.y][0]+1;
                if(dir>=4) {
                    distance[nx][ny][1]=distance[cur.x][cur.y][1]+1;
                    q.offer(new Pair(nx,ny,cur.cnt+1));
                } else {
                    distance[nx][ny][1]=distance[cur.x][cur.y][1];
                    q.offer(new Pair(nx,ny, cur.cnt));
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
        board = new int[h][w]; distance = new int[h][w][2];
        for (int i=0;i<h;i++) {
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<w;j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        q.offer(new Pair(0,0,0));
        distance[0][0][0] = 1; distance[0][0][1]=0;
        BFS();
        System.out.println(result);
    }

    static class Pair {
        int x, y, cnt;
        public Pair(int x, int y, int cnt) { this.x = x; this.y = y; this.cnt = cnt; }
        public Pair(int x, int y) { this.x = x; this.y = y; }
    }
}
