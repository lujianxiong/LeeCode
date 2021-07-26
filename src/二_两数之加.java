import java.util.LinkedList;
import java.util.List;

public class 二_两数之加 {

    /**题目：
     *     给你两个非空的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只存储一位数字。
     *     请你将两个数相加，并以相同的形式返回一个表示他们和的链表。
     *     （你可以假设除了数字0之外，这两个数都不会以0开头）
     */

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
}
