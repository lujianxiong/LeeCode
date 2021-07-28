import java.util.LinkedList;
import java.util.List;

/**题目：（题目有误）
 *  给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *  请你将两个数相加，并以相同形式返回一个表示和的链表。
 *  （你可以假设除了数字 0 之外，这两个数都不会以 0 开头。）
    参考：https://blog.csdn.net/newayue/article/details/114532986?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522162690937116780261959470%2522%252C%2522scm%2522%253A%252220140713.130102334.pc%255Fall.%2522%257D&request_id=162690937116780261959470&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~first_rank_v2~rank_v29-2-114532986.first_rank_v2_pc_rank_v29&utm_term=public+ListNode+addTwoNumbers%28ListNode+l1%2C+ListNode+l2%29+%7B+++++++++ListNode+head+%3D+null%2C+tail+%3D+null%3B+++++++++int+carry+%3D+0%3B+++++++++while+%28l1+%21%3D+null+%7C%7C+l2+%21%3D+null%29+%7B+++++++++++++int+n1+%3D+l1+%21%3D+null+%3F&spm=1018.2226.3001.4187
 */

public class 二_两数之加 {

    public static void main(String args[]){
//        LinkedList l1 = new LinkedList();
//        l1.add(8);
//        l1.add(5);
//        l1.add(5);
//
//        LinkedList l2 = new LinkedList();
//        l2.add(2);
//        l2.add(5);
//        l2.add(3);
//        l2.add(3);
//        l2.add(3);
//        l2.add(3);
//
//        List add = add1(l1, l2);
//        for (int i=0; i<add.size(); i++){
//            System.out.print(add.get(i)+" ");
//        }

        Node n1 = new Node(8);
        n1.next = new Node(9);
        n1.next.next = new Node(1);

        Node n2 = new Node(1);
        n2.next = new Node(0);
        n2.next.next = new Node(1);

        Node result = add2(n1, n2);

        System.out.print(result.val+" "+result.next.val+" "+result.next.next.val);

    }

    //第一种：自己基于链表LinkedList实现的
    public static List add1(List a, List b){
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


    //第二种：力扣官方解法-自定义一个Node节点类
    public static Node add2(Node n1, Node n2){
        //构造一个空的链表
        Node head = null;
        Node tail = null;

        //定义进位的数
        int carry = 0;

        while(n1 != null || n2 != null){
            int e1 = n1 == null ? 0 : n1.val;
            int e2 = n2 == null ? 0 : n2.val;
            int num = e1 + e2 + carry;
            if (head == null){
                head = tail = new Node(num % 10);  //余数
            }else {
                tail.next = new Node(num % 10);
                tail = tail.next;
            }
            carry = num / 10;  //商
            if (n1 != null){
                n1 = n1.next;
            }
            if (n2 != null){
                n2 = n2.next;
            }
        }
        if (carry > 0){
            tail.next = new Node(carry);
        }
        return head;
    }


    //定义链表的节点
    static class Node{
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
