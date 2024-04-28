package deque_0x07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P1021 {
    public static void main(String[] args) throws IOException {
        int cnt=0; int[] list = new int[50];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken()); int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<k;i++) {list[i]=Integer.parseInt(st.nextToken());}
        Deque<Integer> d = new LinkedList<>();
        for(int i=1;i<=n;i++) {d.offerLast(i);}

        for(int i=0;i<k;i++) {
            int target = list[i];
            while(true) {
                if(target==d.peekFirst()) { //1번연산
                    d.pollFirst();
                    break;
                } else if() { //2번연산
                    d.offerLast(d.pollFirst());
                    cnt++;
                } else if() { //3번연산
                    d.offerFirst(d.pollLast());
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
