package 재귀_0x0B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1992 {
    static int[][] video;
    static StringBuilder sb = new StringBuilder();
    static boolean isSame(int x, int y, int n) {
        int cur = video[x][y];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(cur!=video[x+i][y+j]) return false;
            }
        }
        return true;
    }
    static void compress(int x, int y, int n) {
        //base condition
        if(isSame(x,y,n) || n==1) {
            if(video[x][y]==0) sb.append("0");
            else sb.append("1");
            return;
        }
        sb.append("(");
        compress(x,y,n/2);
        compress(x, y+n/2, n/2);
        compress(x+n/2, y, n/2);
        compress(x+n/2, y+n/2, n/2);
        sb.append(")");
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        video = new int[n][n];
        for (int i = 0; i < n; i++) {
            String st = br.readLine();
            for (int j = 0; j < n ; j++) {
                video[i][j] = st.charAt(j)-'0';
            }
        }
        compress(0,0,n);
        System.out.println(sb);
    }
}
