package Challenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class P2529 {
    static int N;
    static String[] signs;
    static int[] result;
    static boolean[] isUsed = new boolean[10];
    static ArrayList<Long> results = new ArrayList<>();
    static void check(int length) {
        if(length==N+1) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N+1; i++) {sb.append(result[i]);}
            results.add(Long.parseLong(sb.toString()));
            return;
        }
        for (int i = 0; i <= 9; i++) {
            if(!isUsed[i]) {
                if(length==0) {
                    result[0] = i;
                    isUsed[i]=true;
                    check(1);
                    isUsed[i] = false;
                } else {
                    if(signs[length-1].equals("<")) {
                        if(result[length-1]<i) {
                            result[length] = i;
                            isUsed[i]=true;
                            check(length + 1);
                            isUsed[i] = false;
                        } else continue;
                    } else {
                        if(result[length-1]>i) {
                            result[length] = i;
                            isUsed[i]=true;
                            check(length+1);
                            isUsed[i] = false;
                        } else continue;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        result = new int[N+1]; signs = new String[N];
        for (int i = 0; i < N; i++) {
            signs[i] = st.nextToken();
        }
        check(0);
        Long max = Collections.max(results);
        Long min = Collections.min(results);
        if((max/(Math.pow(10,N)))<1) System.out.println(new StringBuilder().append(0).append(max));
        else System.out.println(max);
        if((min/(Math.pow(10,N)))<1) System.out.println(new StringBuilder().append(0).append(min));
        else System.out.println(min);
    }
}
