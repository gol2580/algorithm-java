package DP_0x10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int[] list = new int[n+1];
        //1. 테이블 설정
        // d[i] : list[i]번째 수를 탐색할 때 누적합의 최댓값
        int[] d = new int[n];

        for (int i = 0; i < n; i++) list[i] = Integer.parseInt(st.nextToken());

        //2. 초기값 설정
        d[0] = list[0];
        int max = d[0];
        //d[1] = Math.max(d[0]+list[1], list[1]);

        //3. 점화식
        // 다음숫자도 누적합 or 다음숫자로 새로 시작
        for (int i = 1; i < n; i++) {
            d[i] = Math.max(d[i - 1] + list[i], list[i]);
            max = Math.max(max, d[i]);
        }

        //4. 출력
        System.out.println(max);
    }
}
