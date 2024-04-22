package queue_0x06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class P2161 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); int l=0;
        Queue<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=n;i++) {q.offer(i);}
        while(true) {
            if(q.size()==1) { l=q.poll(); break;}
            sb.append(q.poll()).append(' ');
            q.offer(q.poll());
        }
        sb.append(l);
        System.out.println(sb);
    }
}
