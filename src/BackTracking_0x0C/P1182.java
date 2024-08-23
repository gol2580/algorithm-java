package BackTracking_0x0C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1182 {
    static int N, M;
    static int[] arr;
    static int result=0;
    static void getResult(int cur, int total) {
        if(cur==N) {
            if(total==M) result++;
            return;
        }
        //N개의 수에 대해서 선택 or 선택 안함 -> 2^N
        getResult(cur+1, total);
        getResult(cur+1, total+arr[cur]);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        getResult(0, 0);
        if(M==0) result--;
        System.out.println(result);
    }
}
