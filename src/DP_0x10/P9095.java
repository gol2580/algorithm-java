package DP_0x10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P9095 {
        //테이블정의 : D[i] = i를 1, 2, 3의 합으로 나타내는 방법
        // 점화식
        // D[i] = (i-1 나타내는 경우의수 : 여기에 +1하면 되니까) D[i-1]
        // + (i-2 나타내는 경우의수 : 여기에 +2 하면 되니까) D[i-2]
        // + (i-3 나타내는 경우의수 : 여기에 +3 하면 되니까) D[i-3]
        // 초기값 : 점화식에 필요한 전 값들이 세 개이므로 세 개를 초기화

    public static void main(String[] args) throws IOException {
        int[] d = new int[100005];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        d[1] = 1; d[2] = 2; d[3] = 4;
        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(br.readLine());
            for (int j = 4; j <= k ; j++) {
                d[j]=d[j-1]+d[j-2]+d[j-3];
            }
            System.out.println(d[k]);
        }
    }
}
