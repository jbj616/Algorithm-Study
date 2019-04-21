import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HW_2 {
    static int[][] grid;
    static boolean[] include;
    static int[] array;
    static int currentNum;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
//        array = new int[4];
//        include = new boolean[4];
//        int size = 8;
//        grid = new int[size][size];
//
//        tromino(8, 6, 6);
//        for (int i = 0; i < array.length; i++) {
//            array[i] = i + 1;
//        }
//        powerSet(0);

        String str = sc.next();
        System.out.println(palindrome(str));
    }

    public static boolean palindrome(String str){
        if(str.length()==1){
            return true;
        }
        if(str.charAt(0)==str.charAt(str.length()-1)){
            if(str.length()==2){
                return true;
            }
            return palindrome(str.substring(1,str.length()-1));
        }else{
            return false;
        }
    }

    public static int random(int n){
        return new Random().nextInt(n)+1;
    }
    public static void powerSet(int n) {
        if (n == 4) {
            for (int i = 0; i < 4; i++) {
                if (include[i])
                    System.out.print(array[i] + " ");
            }
            System.out.println();
            return;
        }


        include[n] = true;
        powerSet(n + 1);
        include[n] = false;
        powerSet(n + 1);


    }


    public static void tromino(int size, int x, int y) {
        grid[x][y] = -1;
        currentNum = 1;

        tileRec(size, 0, 0);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void tileRec(int size, int topX, int topY) {
        if (size == 2) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    if (grid[topX + i][topY + j] != 0)
                        continue;
                    grid[topX + i][topY + j] = currentNum;
                }
            }
            currentNum++;
            return;
        }

        int holeX = topX;
        int holeY = topY;

        OUTTER:
        for (; holeX < topX + size; holeX++) {
            holeY = topY;
            for (; holeY < topY + size; holeY++) {
                if (grid[holeX][holeY] != 0) {
                    break OUTTER;
                }
            }
        }

        int hsize = size / 2;

        if (!(holeX < topX + hsize && holeY < hsize + topY)) {
            grid[topX + hsize - 1][topY + hsize - 1] = currentNum;
        }

        if (!(holeX >= topX + hsize && holeY < hsize + topY)) {
            grid[topX + hsize][topY + hsize - 1] = currentNum;
        }

        if (!(holeX < topX + hsize && holeY >= hsize + topY)) {
            grid[topX + hsize - 1][topY + hsize] = currentNum;
        }

        if (!(holeX >= topX + hsize && holeY >= hsize + topY)) {
            grid[topX + hsize][topY + hsize] = currentNum;
        }

        currentNum++;
        tileRec(hsize, topX, topY);
        tileRec(hsize, topX + hsize, topY);
        tileRec(hsize, topX, topY + hsize);
        tileRec(hsize, topX + hsize, topY + hsize);


    }

    public static int binarySearch(int[] a, int i, int j, int x) {
        if (i > j)
            return -1;
        int mid = (i + j) / 2;
        if (a[mid] < x) {
            return binarySearch(a, mid + 1, j, x);
        } else if (a[mid] > x) {
            return binarySearch(a, i, mid - 1, x);
        } else {
            return mid;
        }
    }

    public static int fibo(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1)
            return 1;
        return fibo(n - 1) + fibo(n - 2);
    }

    public static int factory(int n) {
        if (n == 0)
            return 1;
        return factory(n - 1) * n;
    }

    public static int ack(int m, int n) {
        if (m == 0) {
            return n + 1;
        }
        if (n == 0) {
            return ack(m - 1, 1);
        }
        return ack(m - 1, ack(m, n - 1));
    }

    public static void hanoiTower(int n, int src, int itr, int dest) {
        if (n == 0) {
            return;
        }
        hanoiTower(n - 1, src, dest, itr);
        System.out.println(src + "가 " + dest + "로 이동");
        hanoiTower(n - 1, itr, src, dest);
    }

    public static void permute(int[] list, int n) {
        if (n == list.length - 1) {
            System.out.println(Arrays.toString(list));
        }

        for (int i = n; i < list.length; i++) {
            swap(list, i, n);
            permute(list, n + 1);
            swap(list, i, n);
        }
    }

    public static void swap(int[] list, int a, int b) {
        int tmp = list[a];
        list[a] = list[b];
        list[b] = tmp;
    }
}
