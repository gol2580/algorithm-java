package Challenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1182 {
    static int N, S, cnt=0;
    static int[] list;
    public static void subset(int idx, int sum) {
        if(idx== list.length) {
            //부분집합이 S와 일치하면 cnt++
            if(sum==S) cnt++;
            return;
        }
        //현재 값을 선택하지 않은 경우
        subset(idx+1, sum);
        //현재 값을 선택한 경우
        subset(idx+1, sum+list[idx]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        list = new int[N];
        st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        subset(0,0);
        if(S==0) cnt--;
        System.out.println(cnt);
    }
}
