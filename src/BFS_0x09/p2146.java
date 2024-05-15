package BFS_0x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p2146 {
    //1. map을 섬의 번호로 초기화한다
    //2. 거리 재는 BFS 하다가 다른 섬으로 도착하면 기록 -> 최소값 갱신
    static int n;
    static int result;
    static int[][] map, visited;
    static Queue<Pair> q = new LinkedList<>();
    static Pair cur;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,-1,1};

    static void BFS_cnt(int k) {
        while(!q.isEmpty()) {
            cur = q.poll();
            for(int dir=0;dir<4;dir++) {
                int nx = cur.x+dx[dir];
                int ny = cur.y+dy[dir];
                if(nx<0 || nx>=n || ny<0 || ny>=n) {continue;}
                if(visited[nx][ny]==1 || map[nx][ny]==0) {continue;}
                visited[nx][ny]=1; map[nx][ny]=k;
                q.offer(new Pair(nx,ny));
            }
        }
    }

    static void BFS(int k) {
        while(!q.isEmpty()) {
            int cnt=0;
            cur = q.poll();
            //현재 최소거리보다 길어지면 어차피 탐색할 필요 X
            if(cnt>visited[cur.x][cur.y]) {break;}
            for(int dir=0;dir<4;dir++) {
                int nx = cur.x+dx[dir];
                int ny = cur.y+dy[dir];
                if(nx<0 || nx>=n || ny<0 || ny>=n) {continue;}
                if(visited[nx][ny]!=0 || map[nx][ny]==k) {continue;}
                //다른 섬 만남
                if(map[nx][ny]!=k && map[nx][ny]!=0) {result = Math.min(result,visited[cur.x][cur.y]);}
                visited[nx][ny]=visited[cur.x][cur.y]+1;
                q.offer(new Pair(nx,ny));
            }
        }
        visited = new int[n][n];
    }

    static void clear() {
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                visited[i][j]=0;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        int k=1;
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n]; visited = new int[n][n];
        result=n*n;
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<n;j++) {
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(map[i][j]==1 && visited[i][j]==0) {
                    q.offer(new Pair(i,j));
                    visited[i][j]=1;
                    map[i][j]=k;
                    BFS_cnt(k);
                    k++;
                }
            }
        }
        clear();
        //visited를 매 번 초기화해서 재사용?????
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(map[i][j]!=0 && visited[i][j]==0) {
                    q.offer(new Pair(i,j));
                    BFS(map[i][j]);
                }
            }
        }
        System.out.println(result);
    }

    static class Pair {
        int x; int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
