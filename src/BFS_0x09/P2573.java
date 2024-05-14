package BFS_0x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2573 {
    public static int[][] board, visited, ex_board;
    public static int n, m, nx, ny;
    public static int result=0;
    public static Queue<Pair> q = new LinkedList<>();
    public static Queue<Pair> q_ice = new LinkedList<>();
    public static int size; public static Pair cur;
    public static int cnt=0;
    public static int[] dx = {1,-1,0,0};
    public static int[] dy = {0,0,-1,1};

    public static void after() {
        // 1. 1년후 상태 만들기
        // 2. 덩어리 수 체크하기 : 개수만큼 cnt++
        // 3. cnt>1이면 성공 / q_ice가 비면 불가능
        // n, m < 300 : 배열크기 90000  / 빙하는 10000 이하 : 물이 80000 -> 빙하인 곳을 저장하자

        // 1. 1년후 상태 만들기
        //문제1. 같은 턴에 0이 돼버린 부분이 이웃한 빙산에 영향을 줌 : 1,1 -> 1,2
        size=0;
        while(size++<q_ice.size()) {
            cur = q_ice.poll();
            visited[cur.x][cur.y]=0;
            for(int dir=0;dir<4;dir++) {
                nx = cur.x+dx[dir];
                ny = cur.y+dy[dir];
                if(nx<0 || nx>=n || ny<0 || ny>=m) {continue;}
                //바다 만난만큼 감소
                if(ex_board[nx][ny]==0) {
                    if(board[cur.x][cur.y]>0) {board[cur.x][cur.y]-=1;}
                }
            }
            q_ice.offer(cur);
        }

        //복사
        for(int i=0;i< (size-1);i++) {
            cur = q_ice.poll();
            ex_board[cur.x][cur.y] = board[cur.x][cur.y];
            if(board[cur.x][cur.y]!=0) { q_ice.offer(cur); }
        }
    }

    // 2. 덩어리 수 체크하기
    public static void BFS() {
        cnt=0;
        size = q_ice.size();
        while(size-->0) {
            int breadth=0;
            cur = q_ice.poll();
            q.offer(cur); q_ice.offer(cur);
            while (true) {
                cur = q.poll();
                if(visited[cur.x][cur.y]!=1) {breadth++;}
                for (int dir = 0; dir < 4; dir++) {
                    nx = cur.x + dx[dir];
                    ny = cur.y + dy[dir];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m) {continue;}
                    if (visited[nx][ny] == 1 || board[nx][ny] == 0) {continue;}
                    visited[nx][ny]=1;
                    q.offer(new Pair(nx,ny));
                }
                //문제2. 끊어져서 q가 비었을때만 카운트 되는게 아니라 일단 q_ice의 모든 점을 조사하기 때문에 q_ice의 크기만큼 cnt++돼버림
                if(q.isEmpty()) {
                    if(breadth!=0) {cnt++;}
                    break;
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        int years=0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
        board = new int[n][m]; visited = new int[n][m]; ex_board =  new int[n][m];
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<m;j++) {
                board[i][j]=Integer.parseInt(st.nextToken());
                ex_board[i][j] = board[i][j];
                if(board[i][j]!=0) {q_ice.offer(new Pair(i,j));}
            }
        }
        while(true) {
            after(); years++;
            BFS();
            // 성공시
            if(cnt>1) { System.out.println(years); break; }
            // -> 전부 다 녹아버리면
            if(q_ice.isEmpty()) { System.out.println(0); break; }
        }
    }

    static class Pair {
        int x; int y;
        public Pair(int x, int y) {this.x = x;this.y = y;}
    }
}
