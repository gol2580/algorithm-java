package Challenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P17086 {
    static int N, M;
    static int[][] board;
    static int result=0;
    static int[][] visited;
    static int[] dx = {1,-1, 0, 0, 1, 1, -1, -1};
    static int[] dy = {0, 0, 1, -1, -1, 1, 1, -1};
    static Queue<Pair> q = new LinkedList<>();

    static void BFS() {
        Pair cur;
        while(!q.isEmpty()) {
            cur = q.poll();
            for (int dir = 0; dir < 8; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if(nx<0 || nx>=N || ny<0 || ny>=M) continue;
                if(visited[nx][ny]!=0) continue;
                if(board[nx][ny]==1) {
                    int secDist = visited[cur.x][cur.y]+1;
                    if(secDist>result) result = secDist;
                    q.clear();
                    break;
                }
                visited[nx][ny] = visited[cur.x][cur.y]+1;
                q.offer(new Pair(nx, ny));
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M]; visited = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " " );
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(board[i][j]==0) {
                    q.offer(new Pair(i, j));
                    BFS();
                    visited = new int[N][M];
                }
            }
        }
        System.out.println(result);
    }
    static class Pair {
        int x, y;
        public Pair(int x, int y) {this.x = x; this.y=y;}
    }
}
