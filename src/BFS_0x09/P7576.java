package BFS_0x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P7576 {
    public static int[][] box; public static int[][] dist;
    public static Queue<Pair> q = new LinkedList<>();
    public static int[] dx = {1,-1,0,0};
    public static int[] dy = {0,0,-1,1};
    public static Pair cur;
    public static int n; public static int m;

    public static void BFS() {
        while(!q.isEmpty()) {
            cur = q.poll();
            for(int dir=0;dir<4;dir++) {
                int nx = cur.x+dx[dir];
                int ny = cur.y+dy[dir];
                if(nx<0 || nx>=n || ny<0 || ny>=m) {continue;} //범위밖
                if(dist[nx][ny]!=-1 || box[nx][ny]==-1) {continue;} //이미방문했거나 토마토가 없으면
                dist[nx][ny]= dist[cur.x][cur.y]+1;
                q.offer(new Pair(nx,ny));
            }
        }
    }
    public static void main(String[] args) throws IOException {
        int max=0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        //box 초기화
        m = Integer.parseInt(st.nextToken()); n = Integer.parseInt(st.nextToken());
        box = new int[n][m]; dist = new int[n][m];
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<m;j++) {
                int in = Integer.parseInt(st.nextToken());
                box[i][j]=in; dist[i][j]=-1;
                if(in==1) {q.offer(new Pair(i,j)); dist[i][j]=0;}
            }
        }
        BFS();
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(box[i][j]==0 && dist[i][j]==-1) {max=-1; break;}
                if(max!=-1) {max=Math.max(max,dist[i][j]);}
            }
        }
        System.out.println(max);
    }

    public static class Pair {
        int x; int y;
        Pair(int x, int y) {this.x = x; this.y = y;}
    }
}
