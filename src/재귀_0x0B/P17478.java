package 재귀_0x0B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P17478 {
    static int n;
    static StringBuilder sb = new StringBuilder();
    static String[] str = {
            "\"재귀함수가 뭔가요?\"\n",
            "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n",
            "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n",
            "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n",
            "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n",
            "라고 답변하였지.\n",
            "____"
    };
    static void recursion(int N) {
        if(N==0) {
            for(int k=n-N;k>0;k--) sb.append(str[6]);
            sb.append(str[0]);
            for(int k=n-N;k>0;k--) sb.append(str[6]);
            sb.append(str[4]);
            for(int k=n-N;k>0;k--) sb.append(str[6]);
            sb.append(str[5]);
            return;
        }
        for(int k=n-N;k>0;k--) sb.append(str[6]);
        sb.append(str[0]);
        for(int k=n-N;k>0;k--) sb.append(str[6]);
        sb.append(str[1]);
        for(int k=n-N;k>0;k--) sb.append(str[6]);
        sb.append(str[2]);
        for(int k=n-N;k>0;k--) sb.append(str[6]);
        sb.append(str[3]);
        recursion(--N);
        for(int k=n-N-1;k>0;k--) sb.append(str[6]);
        sb.append(str[5]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
        recursion(n);
        System.out.println(sb);
    }
}
