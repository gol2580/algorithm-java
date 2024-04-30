package deque_0x07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class P5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        boolean success = true; boolean isReversed = false;
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> d = new LinkedList<>();
        for(int i=0;i<n;i++) { //n=100
            success=true; isReversed=false;
            String func = br.readLine();
            //arr 입력받아 deque 초기화
            int m = Integer.parseInt(br.readLine());
            String inStr = br.readLine();
            String[] inStrArr = inStr.substring(1,inStr.length()-1).split(",");
            for(int j=0;j<m;j++) { d.offerLast(Integer.parseInt(inStrArr[j])); }
            //func
            for(int j=0;j<func.length();j++) {
                if(func.charAt(j)=='D') {
                    if(d.isEmpty()) {
                        success = false;
                        sb.append("error").append('\n');
                        break;
                    }
                    if (isReversed) { d.pollLast(); } //뒤집힌 상황이면 : R이 홀수번 나왔다면
                    else { d.pollFirst(); }  //안 뒤집힌 상황이면 : R이 짝수번 나왔다면
                } else { // R
                    if(isReversed) { isReversed=false; }
                    else { isReversed=true; }
                }
            }
            if(success) {
                sb.append("[");
                int size = d.size();
                if(isReversed) {
                    for (int j = 0; j < size; j++) { sb.append(d.pollLast()).append(","); }
                } else {
                    for (int j = 0; j < size; j++) { sb.append(d.pollFirst()).append(","); }
                }
                if(sb.charAt(sb.length()-1)!='['){ sb.deleteCharAt(sb.length()-1); }
                sb.append("]").append('\n');
            }
        }
        System.out.println(sb);
    }
}

