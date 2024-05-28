package 재귀_0x0B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2630 {
    static int[][] board;
    static int blue=0;
    static int white=0;
    static boolean isSame(int x, int y, int n) {
        int i = board[x][y];
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < n; k++) {
                if(board[x+j][y+k]!=i) return false;
            }
        }
        return true;
    }
    static void count(int x, int y, int n) {
        //함수 ; x,y에서 시작하는 n*n만큼의 영역이 같은지 판별하고, 영역의 색 숫자만큼 더함
        //base condition
        if(n==1 || isSame(x,y,n)) {
            if(board[x][y]==0) white++;
            else blue++;
            return;
        }

        count(x,y,n/2);
        count(x+n/2,y,n/2);
        count(x,y+n/2,n/2);
        count(x+n/2, y+n/2, n/2);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        count(0,0,n);
        System.out.println(white);
        System.out.println(blue);
    }
}
