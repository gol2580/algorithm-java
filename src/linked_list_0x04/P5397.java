package linked_list_0x04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class P5397 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] inStr = new String[n];
        LinkedList<Character> list = new LinkedList<>();

        for(int i=0;i<n;i++) {
            inStr[i] =  br.readLine();
            ListIterator iter = list.listIterator();
            for(int j=0;j<inStr[i].length();j++) {
                char c = inStr[i].charAt(j);
                switch(c) {
                    case '>' :
                        if(iter.hasNext()) {iter.next();}
                        break;
                    case '<' :
                        if(iter.hasPrevious()) {iter.previous();}
                        break;
                    case '-' :
                        if(iter.hasPrevious()) {iter.previous(); iter.remove();}
                        break;
                    default:
                        iter.add(c);
                }
            }
            StringBuilder sb = new StringBuilder();
            for(char c : list) {sb.append(c);}
            inStr[i] = sb.toString();
            list.clear();
        }
        for(String s : inStr) {
            System.out.println(s);
        }
    }
}
