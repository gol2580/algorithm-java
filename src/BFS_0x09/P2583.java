package BFS_0x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2583 {
    public static Queue<Pair> q = new LinkedList<>();
    public static int[][] board;
    public static int[][] visited;
    public static int[] dx = {1,-1,0,0};
    public static int[] dy = {0,0,-1,1};
    public static Pair cur;
    public static int n; public static int m;

    public static void BFS() {
        while(!q.isEmpty()) {
            cur = q.poll();
            for(int dir=0;dir<4;dir++) {
                int nx = cur.x+dx[dir];
                int ny = cur.y+dx[dir];
                if(nx<0 || nx<=n || ny<0 || ny<=m) {continue;}
                if(visited[nx][ny]!=-1 || board[nx][ny]==1) {continue;} //이미 방문햇거나 박스면
            }
        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        board = new int[n][m]; visited = new int[n][m];
        Arrays.fill(visited,-1);

        for(int i=0;i<k;i++) {
            int x1=0; int x2=0; int y1=0; int y2=0;
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<4;j++) { //board 초기화
                if(j==0) {y1 = Integer.parseInt(st.nextToken());}
                else if(j==1) {x1 = Integer.parseInt(st.nextToken());}
                else if(j==2) {y2 = Integer.parseInt(st.nextToken())-1;}
                else if(j==3) {x2 = Integer.parseInt(st.nextToken())-1;}

            }
            for(int j=x1;j<=x2;j++) {
                for(int l=y1;l<=y2;l++) {
                    board[j][l]=1;
                }
            }
        }
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(board[i][j]==0  && visited[i][j]==-1) {
                    q.offer(new Pair(i,j));
                    BFS();
                }
            }
        }

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public static class Pair {
        int x; int y;
        Pair(int x, int y) {
            this.x = x; this.y = y;
        }
    }
}
