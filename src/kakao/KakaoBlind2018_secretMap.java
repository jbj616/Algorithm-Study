package kakao;

public class KakaoBlind2018_secretMap {

    public static void main(String[] args) {
        String str = "11101";


    }

    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            int binaryNum = arr1[i] | arr2[i];

            String binaryStr = Integer.toBinaryString(binaryNum);
            while (binaryStr.length() != n) {
                binaryStr = " ".concat(binaryStr);
            }
            binaryStr = binaryStr.replaceAll("1", "#");
            binaryStr = binaryStr.replaceAll("0", " ");

            answer[i] = binaryStr;
        }
        return answer;
    }
}
