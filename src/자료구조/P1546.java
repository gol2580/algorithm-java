
package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String inNum = br.readLine();
        double sum=0; double max=0;
        String[] inNums = inNum.split(" ");
        double[] intArr=new double[n];

        for(int i=0;i<n;i++) {
            intArr[i] = Long.parseLong(inNums[i]);
        }
        for(int i=0;i<n;i++) {
            if(intArr[i]>max) {
                max=intArr[i];
            }
            sum+=intArr[i];
        }
        System.out.println(sum*100/max/n);
    }
}

