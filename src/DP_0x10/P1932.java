package DP_0x10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        //1. 테이블설정 : d[i][j] : i번째 줄에서 j번째 숫자를 선택했을 때 최댓값
        int[][] d = new int[n+1][n+1];
        //2. 초기값 설정
        d[1][1] = Integer.parseInt(br.readLine());

        //3. 점화식
        for (int i = 2; i <= n; i++) {
            st = new StringTokenizer(br.readLine()," ");
            for (int j = 1; j <= i; j++) {
                if(j==1) d[i][1] = d[i-1][1] + Integer.parseInt(st.nextToken());
                else if(j==i) d[i][i] = d[i-1][i-1] + Integer.parseInt(st.nextToken());
                else d[i][j] = Math.max(d[i-1][j], d[i-1][j-1]) + Integer.parseInt(st.nextToken());
            }
        }
        //4. 출력
        Arrays.sort(d[n]);
        System.out.println(d[n][n]);
    }
}
