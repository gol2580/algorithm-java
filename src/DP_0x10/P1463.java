package DP_0x10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] d = new int[1000005];
        //1. 테이블 정의하기
        //D[i] = ( i -> 1로 만들기 )위해 필요한 연산횟수의 최솟값

        //2. 점화식 찾기
        //3으로 나누거나 / 2로나누거나 / 1빼거나 : 세 경우 중 최솟값

        //3. 초기값 설정 : d[1] = 1을 1로만들기위한 연산횟수의 최솟값 = 0
        d[1]=0;
        for (int i = 2; i <= n; i++) {
            //d[i] =  d[i/3], d[i/2], d[i-1] 중 최솟값
            d[i] = d[i-1]+1;
            if(i%2==0) d[i] = Math.min(d[i], d[i/2]+1);
            if(i%3==0) d[i] = Math.min(d[i], d[i/3]+1);
        }
        System.out.println(d[n]);
    }
}
