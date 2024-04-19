package queue_0x06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int rear=0;
        for(int i=0;i<n;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            switch (st.nextToken()) {
                case "push" :
                    rear = Integer.parseInt(st.nextToken());
                    q.offer(rear);
                    break;
                case "pop" :
                    if(!q.isEmpty()) {sb.append(q.poll()).append('\n');}
                    else{sb.append(-1).append('\n');}
                    break;
                case "size" :
                    sb.append(q.size()).append('\n');
                    break;
                case "empty" :
                    if(q.isEmpty()) {sb.append(1).append('\n');}
                    else {sb.append(0).append('\n');}
                    break;
                case "front" :
                    if(q.isEmpty()) {sb.append(-1).append('\n');}
                    else {sb.append(q.peek()).append('\n');}
                    break;
                case "back" :
                    if(q.isEmpty()) {sb.append(-1).append('\n');}
                    else {sb.append(rear).append('\n');}
                    break;
            }
        }
        System.out.println(sb);
    }
}
