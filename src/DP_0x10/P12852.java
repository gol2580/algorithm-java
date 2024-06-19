package DP_0x10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P12852 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // 1. 테이블 설정
        // b[i] : i가 1이 되기위한 연산의 최솟값
        // q[i] : 경로를 출력하기 위해 저장하는 값,
        int[] b = new int[n+5];
        int[] q = new int[n+5];

        //2. 초기값설정
        b[1]=0; b[2]=1; b[3]=1;
        q[1]=1; q[2]=1; q[3]=1;

        //3. 점화식
        for (int i = 4; i <= n; i++) {
            b[i] = b[i - 1] + 1;
            q[i] = i - 1;
            if (i % 3 == 0) {
                if (b[i / 3]+1 < b[i]) {
                    b[i] = b[i / 3]+1;
                    q[i] = i / 3;
                }
            }
            if (i % 2 == 0) {
                if (b[i / 2]+1 < b[i]) {
                    b[i] = b[i / 2]+1;
                    q[i] = i / 2;
                }
            }
        }
        System.out.println(b[n]);
        int i=n;
        System.out.print(n+" ");
        while(i!=1) {
            System.out.print(q[i]+" ");
            i=q[i];
        }
    }
}
