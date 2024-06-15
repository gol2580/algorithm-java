package DP_0x10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 업보청산 {
    /*
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
    }
     */

    public static void main(String[] args) {

    }
}
