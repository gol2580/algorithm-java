package DP_0x10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class P9461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        //1. 테이블 정의
        //d[i] : i번째 삼각형을 더하고 가장 긴 나선의 길이
        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(br.readLine());
            long[] d = new long[m+1];

            //2. 초기값 설정
            d[0] = 1; d[1] = 1; if(m>1) d[2] = 1;

            //3. 점화식
           for (int j = 3; j < m; j++) d[j] = d[j-2]+d[j-3];
           //4. 출력
            System.out.println(d[m-1]);
        }
    }
}
