package BackTracking_0x0C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1759 {
    static int L, C;
    static char[] arr, list;
    static boolean[] isUsed;
    static int vCount=0;
    static StringBuilder sb = new StringBuilder();
    static void getCandidates(int cur, int vCount, int cCount) {
        if(cur==L) {
            if(vCount>=1 && cCount>=2) {
                for (int i = 0; i < L; i++) sb.append(arr[i]);
                sb.append('\n');
            }
            return;
        }

        for (int i = 0; i < C; i++) {
            if(!isUsed[i] && (cur==0 || arr[cur-1]<list[i])) {
                isUsed[i] = true;
                arr[cur] = list[i];
                if(list[i]=='a' || list[i]=='e' || list[i]=='i' || list[i]=='o' || list[i]=='u') {
                    getCandidates(cur+1, vCount+1, cCount);
                } else {
                    getCandidates(cur+1, vCount, cCount+1);
                }
                isUsed[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[L];
        list = new char[C]; isUsed = new boolean[C];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < C; i++) list[i] = st.nextToken().charAt(0);
        Arrays.sort(list);
        getCandidates(0,0,0);
        System.out.println(sb);
    }
}
