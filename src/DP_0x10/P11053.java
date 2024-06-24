package DP_0x10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] list = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < n; i++) list[i] = Integer.parseInt(st.nextToken());

        //1. 테이블정의
        //d[i] : list[i]를 선택했을 때 오름차순 수열 길이의 최댓값
        int[] d = new int[n+1];

        //2. 초기값 설정
        d[0] = 1;
        int max = d[0];

        //3. 점화식
        for (int i = 1; i < n; i++) {
            int j = i;
            int max_i = 1;
            while(--j>=0) {
                if(list[i]>list[j]) max_i = Math.max(max_i, d[j]+1);
            }
            d[i] = max_i;
            max = Math.max(d[i], max);
        }
        System.out.println(max);
    }
}
