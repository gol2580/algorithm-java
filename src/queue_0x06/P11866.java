package queue_0x06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        StringBuilder sb = new StringBuilder().append("<");
        Queue<Integer> q = new LinkedList<>();
        int n = Integer.parseInt(st.nextToken()); int k = Integer.parseInt(st.nextToken());
        for(int i=1;i<=n;i++) {q.offer(i);}
        while(true) {
            if(q.isEmpty()) {sb.append(">"); break;}
            for(int i=1;;i++) {
                if(i%k==0) { sb.append(q.poll()); break;}
                else { q.offer(q.poll()); }
            }
            if(!q.isEmpty()) {sb.append(", ");}
        }
        System.out.println(sb);
    }
}
