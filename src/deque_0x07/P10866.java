package deque_0x07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> d = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            switch (st.nextToken()) {
                case "push_back" :
                    d.offerLast(Integer.parseInt(st.nextToken()));
                    break;
                case "push_front" :
                    d.offerFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_back" :
                    if(!d.isEmpty()) {sb.append(d.pollLast()).append('\n');}
                    else {sb.append("-1").append('\n');}
                    break;
                case "pop_front" :
                    if(!d.isEmpty()) {sb.append(d.pollFirst()).append('\n');}
                    else {sb.append("-1").append('\n');}
                    break;
                case "size" :
                    sb.append(d.size()).append('\n');
                    break;
                case "empty" :
                    if(d.isEmpty()) {sb.append("1").append('\n');}
                    else {sb.append("0").append('\n');}
                    break;
                case "front" :
                    if(!d.isEmpty()) {sb.append(d.peekFirst()).append('\n');}
                    else {sb.append("-1").append('\n');}
                    break;
                case "back" :
                    if(!d.isEmpty()) {sb.append(d.peekLast()).append('\n');}
                    else {sb.append("-1").append('\n');}
                    break;
            }
        }
        System.out.println(sb);
    }
}
