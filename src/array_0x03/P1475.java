package array_0x03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result=0; int max=0; double hap=0;
        String num = br.readLine();
        int[] arr = new int[10];
        for(int i=0;i<num.length();i++) {
            arr[num.charAt(i)-'0']++;
        }

        for(int i =0 ; i<10 ; i++) {
            if(max<arr[i] && i!=6 && i!=9 ) {max = arr[i];}
            if(i==6 || i==9) {hap+=arr[i];}
        }
        hap = (Math.ceil(hap/2.0));
        if(hap<max) {System.out.println(max);}
        else {System.out.println((int)hap);}

    }
}
