package Challenge;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P16937 {
    static int H,W,N,result;
    static ArrayList<Pair> arr = new ArrayList<>();

    static void tryFirst(){
        for(int i = 0; i< arr.size(); i++){
            int firstH = arr.get(i).h; int firstW = arr.get(i).w;
            if(H>=firstH && W>=firstW) trySecond( H - firstH, W - firstW, firstH * firstW, i);
            if(H>=firstW && W>=firstH) trySecond( H - firstW, W - firstH, firstH * firstW, i);
        }
    }
    static void trySecond(int h, int w, int size,int i){
        int secondSize=0;
        for(int j=i+1;j<arr.size();j++){
            int secondH = arr.get(j).h; int secondW = arr.get(j).w;
            if((secondH <= h && secondW <= W) || (secondW <=h && secondH <=W)
                    || (secondH <= H && secondW <= w) || (secondW <=H && secondH <= w))
                secondSize = Math.max(secondSize, secondH * secondW);
        }
        if(secondSize!=0) result = Math.max(result, size+secondSize);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        H = Integer.parseInt(st.nextToken());W = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            //붙일 수 없는 스티커는 제외
            if((h > H && h > W) || (w > W && w > H)) continue;
            arr.add(new Pair(h, w));
        }
        tryFirst();
        System.out.println(result);
    }

    static class Pair {
        int h, w;
        public Pair(int h, int w) {this.h = h;this.w = w;}
    }

}

