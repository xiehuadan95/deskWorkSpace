import java.util.LinkedList;

/**
 * Author:Eric
 * DATE:2022/12/4-16:32
 * Decription: 模拟LinkedList
 */
public  class LinkedListTest {

    public static void main(String[] args) {

        Node head = new Node("Head");
        Node zhang=new Node("张三");
        Node li=new Node("李四");
        head.next=zhang;
        head.next.next=li;
        System.out.println(head.data);
        System.out.println(head.next.data);
        System.out.println("============");
        //删除张三，让第二个节点为李四
        head.next=null;
        head.next=li;
        System.out.println(head.data);
        System.out.println(head.next.data);
    }
}
//节点
class Node {
    public Node next;
    public Object data;
    public Node(Object data) {
        this.data = data;
    }
}
