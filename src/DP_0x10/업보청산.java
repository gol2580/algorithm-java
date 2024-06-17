package DP_0x10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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
    /*
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
     */
        /*
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[] r = new int[1005];
        int[] g = new int[1005];
        int[] b = new int[1005];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine()," ");
            r[i] = Integer.parseInt(st.nextToken());
            g[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
        }

        // 1. 테이블 설정
        // d[i][3] : i번째 집이 각각 r / g / b일 때 합의 최솟값을 저장
        int[][] d = new int[1005][3];

        //2. 초기값 설정
        d[1][0] = r[1]; d[1][1] = g[1]; d[1][2] = b[1];

        // 3. 점화식
        for (int i = 2; i <= n; i++) {
            d[i][0] = Math.min(d[i-1][1], d[i-1][2]) + r[i];
            d[i][1] = Math.min(d[i-1][0], d[i-1][2]) + g[i];
            d[i][2] = Math.min(d[i-1][0], d[i-1][1]) + b[i];
        }
        System.out.println(Math.min(Math.min(d[n][0], d[n][1]), d[n][2]));

         */
        int n = Integer.parseInt(br.readLine());

        // 1. 테이블 설정
        // d[i] : 2 X i 짜리 타일을 채우는 경우의 수
        int[] d = new int[100005];
        int mod = 10007;

        // 2. 초기값 설정
        d[1] = 1;
        d[2] = 2;

        // 3. 점화식
        // 3-1. 0,0에 1X2짜리 타일을 넣는 경우 = d[i-2]이 된다
        // 3-2. 0,0에 2X1짜리 타일을 넣는 경우 = d[i-1]이 된다
        for (int i = 3; i <= n; i++) d[i] = (d[i - 1] + d[i - 2]) % mod;

        //출력
        System.out.println(d[n]);
    }
}
