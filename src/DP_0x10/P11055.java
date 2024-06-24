package DP_0x10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int[] list = new int[n+1];
        for (int i = 0; i < n; i++)  list[i] = Integer.parseInt(st.nextToken());

        //1. 테이블 정의
        //d[i] : list[i] 탐색할 때의 최댓값
        int[] d = new int[n+1];

        //2. 초기값 설정
        d[0] = list[0];
        int max = d[0];

        //3. 점화식
        for (int i = 1; i < n; i++) {
            int j=i-1;
            int max_i = list[i];
            if(list[i] < list[i-1]) {
                //같거나 작은값 있는데까지 찾아감
                while(j>=0 && (list[j] >  list[i])) j--;
                if(j<0) {d[i] = list[i];}
            }
            int k=i-1;
            while(k>=0) {
                if(list[k]<list[i]) max_i = Math.max(max_i, d[k] + list[i]);
                k--;
            }
            d[i] = max_i;
            max = Math.max(d[i], max);
        }
        System.out.println(max);
    }
}
