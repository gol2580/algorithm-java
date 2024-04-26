package queue_0x06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class P15828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        while(true) {
            int t = Integer.parseInt(br.readLine());
            if(t ==-1) {break;}

            if(t==0) {q.poll();}
            else if(q.size()<n) {q.offer(t);}
        }
        if(q.size()==0) {sb.append("empty");}
        while(!q.isEmpty()) {sb.append(q.poll()).append(" ");}
        System.out.println(sb);
    }
}
