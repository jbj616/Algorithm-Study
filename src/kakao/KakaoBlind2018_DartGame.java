package kakao;

public class KakaoBlind2018_DartGame {

    public static void main(String[] args) {

        String[] test = {"1S2D*3T", "1D2S#10S", "1D2S0T", "1S*2T*3S", "1D#2S*3S", "1T2D3D#", "1D2S3T*"}; //정규식 사용하기!


        for (String testCode : test) {
            System.out.println(solution(testCode));
        }
    }

    public static int solution(String dartResult) {

        Operation[] operations = new Operation[3];
        for (int i=0; i<3; i++){
            operations[i] = new Operation();
        }

        int index = -1;
        int i = 0;
        StringBuffer stringBuffer = new StringBuffer();
        while (i < dartResult.length()) {
            char tmp = dartResult.charAt(i);

            if (tmp >= '0' && tmp <= '9') {
                stringBuffer.append(tmp);
            } else if (tmp == 'S' || tmp == 'D' || tmp == 'T') {
                index++;
                operations[index].operator = tmp;
                operations[index].num = Integer.parseInt(stringBuffer.toString());
                stringBuffer = new StringBuffer();
            } else if (tmp == '*' || tmp == '#') {
                operations[index].bonus = tmp;
            }
            i++;
        }

        for (Operation op : operations) {
            op.calc();
        }

        for (i = 0; i < 3; i++) {
            calc2(operations, operations[i].bonus, i);
        }

        return Operation.getAnswer(operations);
    }

    private static void calc2(Operation[] operations, char operation, int index) {

        if (operation == '*') {
            operations[index].num *= 2;

            if (index != 0) {
                operations[index - 1].num *= 2;
            }
        } else if (operation == '#') {
            operations[index].num *= -1;
        }
    }
}

class Operation {

    int num;
    char operator;
    char bonus;


    public void calc() {
        switch (operator) {
            case 'S':
                break;

            case 'D':
                num = (int) Math.pow(num, 2);
                break;

            case 'T':
                num = (int) Math.pow(num, 3);

        }
    }

    public static int getAnswer(Operation[] operations){
        int result = 0;
        for (Operation operation: operations){
            result+=operation.num;
        }

        return result;
    }
}
