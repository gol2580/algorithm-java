package BackTracking_0x0C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P6603 {
    static int N;
    static int[] list, arr;
    static boolean[] isUsed;
    static StringBuilder sb = new StringBuilder();
    static void getCandidates(int cur) {
        if(cur==6) {
            for(int i: arr) sb.append(i).append(" ");
            sb.append('\n');
            return;
        }
        for (int i = 0; i < N; i++) {
            if(!isUsed[i] && (cur==0 || arr[cur-1]<list[i])){
                arr[cur] = list[i];
                isUsed[cur] = true;
                getCandidates(cur+1);
                isUsed[cur] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        while(N!=0) {
            list = new int[N]; 
            isUsed = new boolean[N];
            arr= new int[6];
            for (int i = 0; i < N; i++) list[i] = Integer.parseInt(st.nextToken());
            Arrays.sort(list);
            getCandidates(0);
            sb.append('\n');
            st = new StringTokenizer(br.readLine()," ");
            N = Integer.parseInt(st.nextToken());
        }
        System.out.println(sb);
    }
}
