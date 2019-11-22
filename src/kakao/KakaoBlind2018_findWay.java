package kakao;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import javax.swing.tree.TreeNode;
import sun.reflect.generics.tree.Tree;

public class KakaoBlind2018_findWay {

    public static void main(String[] args) {

        int[][] test = {{5, 3}, {11, 5}, {13, 3}, {3, 5}, {6, 1}, {1, 3}, {8, 6}, {7, 2}, {2, 2}};

        solution(test);
    }


    public static int[][] solution(int[][] nodeinfo) {
        PriorityQueue<Node> nodes = new PriorityQueue<>((x, y) -> y.y - x.y == 0 ? x.x - y.x : y.y - x.y);
        for (int i = 0; i < nodeinfo.length; i++) {
            nodes.add(new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1));
        }

        while (!nodes.isEmpty()){
            System.out.println(nodes.poll().toString());
        }
        return new int[1][1];


    }
//
//    public static Tree makeTree(List<Node> subList) {
//        if (subList.size() == 0) {
//            return new Tree(null);
//        }
//        if (subList.size() == 1) {
//            return new Tree(subList.get(0));
//        }
//        int max = -1;
//        int id = 0;
//        for (int i=0; i<subList.size(); i++) {
//            if (max < subList.get(i).y) {
//                max = subList.get(i).y;
//                id = i;
//            }
//        }
//
//        Tree tree = new Tree(subList.get(id));
//        tree.left = makeTree(subList.subList(0, id));
//        tree.right = makeTree(subList.subList(id, subList.size()));
//
//        return tree;
//    }
}

class Node {

    int x;
    int y;
    int index;
    Node left;
    Node right;

    public Node(int x, int y, int index) {
        this.x = x;
        this.y = y;
        this.index = index;
    }
    void addNode(Node parent, Node child){
        if(child.x < parent.x){
            if(parent.left == null){
                parent.left = child;
            }else
                addNode(parent.left, child);
        }else{
            if(parent.right == null)
                parent.right = child;
            else
                addNode(parent.right, child);
        }
    }
    @Override
    public String toString() {
        return x+" "+ y + " index = " + index;
    }
}



