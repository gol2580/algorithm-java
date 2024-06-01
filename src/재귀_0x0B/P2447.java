package 재귀_0x0B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2447 {
    //N이 3보다 클 경우,
    // 크기 N의 패턴은 공백으로 채워진 가운데의 (N/3)×(N/3) 정사각형을 크기 N/3의 패턴으로 둘러싼 형태이다.
    // 3의 패턴 : 가운데에 공백이 있고, 가운데를 제외한 모든 칸에 별이 하나씩 있는 패턴
    // : 0 1 2
    //   3 (4) 5
    //   6 7 8  :  한 패턴 그리기 : 9번(3*3) n/3 간격으로 찍다가 4번째만 공백
    // 9의패턴 : 3 * 3 정사각형을 3의 패턴로 둘러쌈
    // 27의 패턴 : 9 * 9의 정사각형을 9의 패턴으로 둘러쌈
    static StringBuilder sb = new StringBuilder();
    static char[][] board;
    static int m;
    static void printStar(int x, int y, int n) {
        if(n==1) {
            board[x][y]='*';
            return;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(i==1 && j==1) continue;
                printStar(x+n/3*i, y+n/3*j, n/3);
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        m = Integer.parseInt(br.readLine());
        board = new char[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j]=' ';
            }
        }
        printStar(0,0, m);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(board[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
