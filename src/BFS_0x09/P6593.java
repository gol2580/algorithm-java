package BFS_0x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


//'상' 방향으로 이동하는 경우는 뭐가 있을까

public class P6593 {
    public static int l, r, c;
    public static int[][][] building; public static int[][][] visited;
    public static Queue<Pair> q = new LinkedList<>();
    public static int result=-1;
    public static int[] dy = {1,-1,0,0,0,0};
    public static int[] dz = {0,0,-1,1,0,0};
    public static int[] dx = {0,0,0,0,1,-1};
    public static Pair cur;

    public static int BFS() {
        while(!q.isEmpty()) {
            cur = q.poll();
            for(int dir=0;dir<6;dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                int nz = cur.z + dz[dir];
                if(nx<0 || nx>=l || ny<0 || ny>=r || nz<0 || nz>=c) {continue;}
                if(visited[nx][ny][nz]!=0 || building[nx][ny][nz]=='#') {continue;}
                visited[nx][ny][nz] = visited[cur.x][cur.y][cur.z]+1;
                if(building[nx][ny][nz]=='E') {System.out.println("Escaped in "+(visited[nx][ny][nz]-1)+" minute(s)."); return -1;}
                q.offer(new Pair(nx, ny, nz));
            }
        }
        System.out.println("Trapped!");
        return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            if(!st.hasMoreTokens()) { st = new StringTokenizer(br.readLine()); }
            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            if(l==0 && r==0 && c==0) {break;}
            building = new int[l][r][c]; visited = new int[l][r][c];
            for(int i=0;i<l;i++) {
                for(int j=0;j<r;j++) {
                    String str = br.readLine();
                    if(str.equals("")) { str = br.readLine(); }
                    for(int k=0;k<c;k++) {
                        building[i][j][k] = str.charAt(k);
                        if(building[i][j][k]=='S') {q.offer(new Pair(i,j,k)); visited[i][j][k]=1;}
                    }
                }
            }
            BFS();
            q.clear();
        }
    }
    static class Pair {
        int x; int y; int z;
        Pair(int x, int y, int z) {this.x = x; this.y = y; this.z = z;}
    }
}
