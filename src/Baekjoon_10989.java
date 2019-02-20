import java.io.*;
import java.util.Scanner;

public class Baekjoon_10989 {
    public static void main(String[] args) throws IOException {
        Scanner sc =new Scanner(System.in);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] array = new int[10001];

        for(int i=0; i<n; i++)
        array[Integer.parseInt(br.readLine())]++;


        for(int i=1; i<=10000; i++){
            for(int j=0; j<array[i]; j++)
                bw.write(i+"\n");
        }

        br.close();
        bw.close();
    }
}
