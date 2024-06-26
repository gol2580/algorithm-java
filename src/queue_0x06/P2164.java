package queue_0x06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class P2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<=n;i++) {  q.offer(i);   }
        while(true) {
            if(q.size()==1) {break;}
            q.poll();
            q.offer(q.poll());
        }
        System.out.println(q.poll());
    }
}
