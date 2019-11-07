package kakao;

import java.util.Arrays;

public class KakaoBlind2018_sort {

    public static void main(String[] args) {
        String[] test = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};

        solution(test);
        String[] test2 = {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};
        solution(test2);
    }

    public static String[] solution(String[] files) {
        File[] file = new File[files.length];
        for (int i = 0; i < files.length; i++) {
            file[i] = split(files[i]);
        }

        Arrays.sort(file);

        for (int i = 0; i < file.length; i++) {
            files[i] = file[i].getFullName();
        }
        return files;
    }

    public static File split(String file) {
        int left = -1;
        for (int i = 0; i < file.length(); i++) {
            if (Character.isDigit(file.charAt(i))) {
                left = i;
                break;
            }
        }

        int right = -1;
        for (int i = left; i < file.length(); i++) {
            if (!Character.isDigit(file.charAt(i))) {
                right = i;
                break;
            }
        }

        System.out.println(left+" "+ right);
        if (right == -1) {
            return new File(file.substring(0, left), file.substring(left), "");
        }

        if (right - left > 5) {
            return new File(file.substring(0, left), file.substring(left, left + 5), file.substring(left + 5));
        }

        return new File(file.substring(0, left), file.substring(left, right), file.substring(right));
    }
}

class File implements Comparable<File> {

    String name;
    String number;
    String tail;

    File(String name, String number, String tail) {
        this.name = name;
        this.number = number;
        this.tail = tail;
    }

    @Override
    public int compareTo(File o) {

        int compare = name.toLowerCase().compareTo(o.name.toLowerCase());
        if (compare != 0) {
            return compare;
        }

        compare = Integer.parseInt(number) - Integer.parseInt(o.number);

        if (compare != 0) {
            return compare;
        }

        return 0;
    }

    public String getFullName() {
        return name + number + tail;
    }
}
