import java.util.LinkedList;
import java.util.List;

/**题目：
 *  给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个整数，并返回它们的数组下标。
 （你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。）
 */

public class 二_两数之加 {

    public static void main(String args[]){
        LinkedList l1 = new LinkedList();
        l1.add(8);
        l1.add(5);
        l1.add(5);

        LinkedList l2 = new LinkedList();
        l2.add(2);
        l2.add(5);
        l2.add(3);
        l2.add(3);
        l2.add(3);
        l2.add(3);

        List add = add(l1, l2);
        for (int i=0; i<add.size(); i++){
            System.out.print(add.get(i)+" ");
        }

    }

    public static List add(List a, List b){
        LinkedList temp = new LinkedList();
        int y = 0;
        int x = 0;
        for(int i=0; i<a.size() && i<b.size(); i++){
            int t = (int)a.get(i) + (int)(b.get(i)) + x;
            x = 0;
            if (t < 10){
                temp.add(t);
            }else {
                temp.add(t - 10);
                x++;
            }
        }

        if (a.size() > b.size()){
            for (int i = b.size(); i < a.size(); i++){
                temp.add((int)a.get(i) + y);
                y = 0;
            }
        }else if (a.size() < b.size()){
            for (int i = a.size(); i < b.size(); i++){
                temp.add((int)b.get(i) + y);
                y = 0;
            }
        }
        return temp;
    }



    public static Node add(Node n1, Node n2){
        //构造一个空的链表
        Node head = null;
        Node tail = null;

        return null;

    }


    //定义链表的节点
    class Node{
        //成员变量（属性）
        int val;
        Node next;

        //成员方法
        //无参构造
        public Node(){
        }

        //有参构造
        public Node(int val){
            this.val = val;
        }
        public Node(int val, Node next){
            this.val = val;
            this.next = next;
        }
    }
}
