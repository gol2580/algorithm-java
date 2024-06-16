package DP_0x10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 업보청산 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        /*
        //1. 테이블정의
        //d[i] : d를 1로 만들기 위해 필요한 연산횟수
        int[] d = new int[1000005];
        int n = Integer.parseInt(br.readLine());

        //2. 초기값설정
        d[1]=0; d[2]=1; d[3]=1;

        //3. 점화식찾기 : 반복문
        for (int i = 4; i <= n; i++) {
            d[i] = d[i-1]+1;
            if(i%3==0) d[i]=Math.min(d[i/3]+1, d[i]);
            if(i%2==0) d[i]=Math.min(d[i], d[i/2]+1);
        }
        System.out.println(d[n]);
    */
        int n = Integer.parseInt(br.readLine());
        int[] s = new int[305];
        for (int i = 1; i <= n; i++) s[i] = Integer.parseInt(br.readLine());

        //1. 테이블정의
        // d[i][3] : 계단을 밟았을 때 점수합의 최댓값, 2차원은 연속해서 n번 밟았을 때
        int[][] d = new int[305][2];

        //2. 초기값 설정
        d[1][0] = s[1]; d[1][1] = s[1];
        d[2][0] = s[2]; d[2][1] = s[1]+s[2];

        //3. 점화식 찾기
        //d[3][0] = Math.max(d[1][0], d[1][1])+s[3];
        //d[3][1] = d[2][0]+s[3];
        for (int i = 3; i <= n; i++) {
            d[i][0] = Math.max(d[i-2][0], d[i-2][1])+s[i];
            d[i][1] = d[i-1][0]+s[i];
        }

        System.out.println(Math.max(d[n][0], d[n][1]));
    }

}
