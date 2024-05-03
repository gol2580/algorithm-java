package BFS_0x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2178 {
    public static int[][] maze;
    public static int[][] visited;
    public static Queue<Pair> q = new LinkedList<>();
    public static int result = 0;
    public static int[] dx = {1,-1,0,0};
    public static int[] dy = {0,0,-1,1};
    public static Pair cur;
    public static int n; public static int m;

    public static int BFS() {
        int length = 1;
        q.offer(new Pair(0,0,length));
        visited[0][0]=1;
        while(!q.isEmpty()) {
            cur = q.poll();
            length = cur.length+1;
            //System.out.println("cur.x : "+cur.X+", cur.Y : "+cur.Y+" / length : "+length);
            for(int dir=0;dir<4;dir++) {
                int nx = cur.X+dx[dir];
                int ny = cur.Y+dy[dir];
                if(nx<0||nx>=n||ny<0||ny>=m) {

                    System.out.println("nx : "+nx+", ny : "+ny);
                    continue;}
                if(visited[nx][ny]!=0 || maze[nx][ny]==0) {

                    System.out.println("nx : "+nx+", ny : "+ny);
                    continue;}
                visited[nx][ny] = 1;
                //System.out.println("nx : "+nx+", ny : "+ny+" / visited : "+visited[nx][ny]);
                System.out.println(nx+", "+ny);
                q.offer(new Pair(nx,ny,length));
            }
        }
        return visited[n-1][m-1];
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
        maze = new int[n][m]; visited = new int[n][m];
        //미로 초기화
        for(int i=0;i<n;i++) {
            String str = br.readLine();
            for(int j=0;j<m;j++) { maze[i][j] = str.charAt(j)-'0'; }
        }
        System.out.println(BFS());
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                System.out.print(visited[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static class Pair {
        int X;
        int Y;
        int length=0;
        Pair(int X, int Y) {
            this.X = X; this.Y = Y;
        }
        Pair(int X, int Y, int length) {
            this.X = X; this.Y = Y; this.length = length;
        }
    }
}
