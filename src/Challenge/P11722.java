package Challenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11722 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // 1. 테이블 설정 : i번째 숫자를 선택했을 때 내림차순 수열 길이의 최솟값
        int[] d = new int[N];
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        // 2. 초기값 세팅
        d[0] = 1;
        // d[i] 중 최댓값(가장긴길이)를 저장하기 위한 변수
        int max = d[0];

        for (int i = 1; i < N; i++) {
            int j=i;
            //수열의 최대길이 : 비교용
            int max_i=1;
            while(--j>=0) {
                if(arr[j]>arr[i]) {
                    max_i = Math.max(d[j]+1, max_i);
                }
            }
            d[i] = max_i;
            max = Math.max(d[i], max);
        }
        System.out.println(max);
    }
}
