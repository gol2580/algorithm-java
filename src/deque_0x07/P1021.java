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
        int tmpcnt=0; boolean success = false;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken()); int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<k;i++) {list[i]=Integer.parseInt(st.nextToken());}
        Deque<Integer> d = new LinkedList<>();
        for(int i=1;i<=n;i++) {d.offerLast(i);}

        for(int i=0;i<k;i++) {
            success=false; tmpcnt=0;
            int target = list[i];
            while(true) {
                if(target==d.peekFirst()) { //1번연산
                    d.pollFirst();
                    break;
                } else {
                    for(int j=0;j<(d.size()/2+1);j++) { //덱 사이즈 반쪽만큼 왼쪽 츄라이츄라이
                        if(target!=d.peekFirst()) {d.offerLast(d.pollFirst()); tmpcnt++;}
                        else {success=true; cnt+=tmpcnt; break;}
                    }
                    if(!success) { //왼쪽 아니면
                        for(int j=0;j<tmpcnt;j++) {d.offerFirst(d.pollLast());} //원상복구
                        tmpcnt=0;
                        for(int j=0;j<(d.size()/2+1);j++) { //오른쪽으로
                            if(target!=d.peekFirst()) {d.offerFirst(d.pollLast()); tmpcnt++;}
                            else {cnt+=tmpcnt; break;}
                        }
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}
