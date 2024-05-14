package BFS_0x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2573 {
    public static int[][] board, visited;
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
        // 2. 덩어리 수 체크하기
        // 3. 1덩어리면 return -1 / 2덩어리 이상이면 return result (전역) / 다 녹았으면 return 0
        // n, m < 300 : 배열크기 90000  / 빙하는 10000 이하 : 물이 80000 -> 빙하인 곳을 저장하자

        // 1. 1년후 상태 만들기
        // 10000*4

        //문제2. 같은 턴에 0이 돼버린 부분이 이웃한 빙산에 영향을 줌 : 1,1 -> 1,2
        size=q_ice.size();
        while(size-->0 && !q_ice.isEmpty()) {
            cur = q_ice.poll();
            visited[cur.x][cur.y]=0;
            for(int dir=0;dir<4;dir++) {
                nx = cur.x+dx[dir];
                ny = cur.y+dy[dir];
                if(nx<0 || nx>=n || ny<0 || ny>=m) {continue;}
                //바다 만난만큼 감소
                if(board[nx][ny]==0) {
                    if(board[cur.x][cur.y]>0) {board[cur.x][cur.y]-=1;}
                }
            }
            if(board[cur.x][cur.y]!=0) {q_ice.offer(cur);}
        }



    }

    // 2. 덩어리 수 체크하기
    public static int BFS() {
        cnt=0;
        size = q_ice.size();
        while(size-->0) {
            cur = q_ice.poll();
            q.offer(cur); q_ice.offer(cur);
            while (true) {
                cur = q.poll();
                for (int dir = 0; dir < 4; dir++) {
                    nx = cur.x + dx[dir];
                    ny = cur.y + dy[dir];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m) {continue;}
                    if (visited[nx][ny] == 1 || board[nx][ny] == 0) {continue;}
                    visited[nx][ny]=1;
                    q.offer(new Pair(nx,ny));
                }
                //문제1. 끊어져서 q가 비었을때만 카운트 되는게 아니라 일단 q_ice의 모든 점을 조사하기 때문에 q_ice의 크기만큼 cnt++돼버림
                if(q.isEmpty()) {
                    cnt++;
                    break;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        int result; int years=0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
        board = new int[n][m]; visited = new int[n][m];
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<m;j++) {
                board[i][j]=Integer.parseInt(st.nextToken());
                if(board[i][j]!=0) {q_ice.offer(new Pair(i,j));}
                //visited : 바다거나 방문했으면 1
                //else {visited[i][j]=1;}
            }
        }

        int ten =10;
        // 10 이하
        while(ten-->0) {
            after(); years++;
            result = BFS();
            // 성공시
            if(result!=1) {
                System.out.println(years);
            }
            // -> 전부 다 녹아버리면
            if(q_ice.isEmpty()) {
                System.out.println(0);
            }
        }
    }

    static class Pair {
        int x; int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
