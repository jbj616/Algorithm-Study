
package src.baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Baekjoon_1946 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {

            int n = sc.nextInt();

            List<Worker> workers = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                workers.add(new Worker(x, y, Math.min(x, y)));
            }

            int flag = 1;
            int limit_x = n;
            int limit_y = n;
            int count = 0;

            Collections.sort(workers);
            //System.out.println(workers.toString());
            for (int k=0; k<workers.size(); k++){
                Worker worker = workers.get(k);
                //System.out.println(worker.toString()+ flag);
                if(flag == worker.compare){
                    if(flag == worker.offline_test){
                        if(limit_y>worker.online_test){
                            count++;
                            limit_y = worker.online_test;
                        }
                    }else{
                        if(limit_x>worker.offline_test){
                            count++;
                            limit_x = worker.offline_test;
                        }
                    }
                }else{
                    flag++;
                    k--;
                }
            }


            if(n==1)
                count=1;
            System.out.println(count);
        }

    }

}

class Worker implements Comparable<Worker>{

    int compare;
    int online_test;
    int offline_test;

    public Worker(int online_test, int offline_test, int compare) {
        this.online_test = online_test;
        this.offline_test = offline_test;
        this.compare = compare;
    }


    @Override
    public int compareTo(Worker o) {
        return compare - o.compare;
    }

    @Override
    public String toString() {
        return offline_test + " " + online_test+ " ";
    }
}