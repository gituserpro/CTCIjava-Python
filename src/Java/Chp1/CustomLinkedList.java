package Java.Chp1;

import java.util.ArrayList;
import java.util.List;

public class CustomLinkedList {

    ListNode head;

    public CustomLinkedList() {
        head = null;
    }

    public class ListNode {

        int data;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.data = val;
            this.next = next;
        }
    }

    public void add(int data) {

        if (head == null) {
            addFirst(data);
        } else {
            addLast(data);
        }


    }

    private void addLast(int data) {

        ListNode ptr = head;
        while (ptr.next != null) {
            ptr = ptr.next;
        }
        ptr.next = new ListNode(data, null);
    }

    private void addFirst(int data) {
        head = new ListNode(data, null);
    }

    private void print() {

        ListNode current = head;

        while (current != null) {

            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println();
    }

    public void remove(int value) {

        if (head.data == value) {
            head = head.next;
        }

        ListNode ptr = head;

        while (ptr.next != null) {

            if (ptr.next.data == value) {
                ptr.next = ptr.next.next;
                break;
            }
            ptr = ptr.next;
        }

    }

    private void removeDuplicates() {

        ListNode ptr = head;
        ListNode curr = head;
        ListNode runn = head;

        while (ptr != null) {

            curr = ptr;

            while (curr.next != null) {

                if (curr.next.data == ptr.data) {
                    runn = curr;
                    while (runn.next != null && runn.next.data == ptr.data) {
                        runn = runn.next;
                    }
                    curr.next = runn.next;
                }

                curr = curr.next;
            }
            ptr = ptr.next;
        }

    }

    private void KThToTheLast(int k) {

    ListNode curr = head;
    ListNode runn = head;
    int i = 0;

        while( i < k && runn!=null){
                runn = runn.next;
                i++;
        }

        while(runn != null){
            curr = curr.next;
            runn = runn.next;
        }

     System.out.println(curr.data);
    }

    private void partitionAround(int key) {

        ListNode newHead = head;
        ListNode prev = head;

        if(head.data == key ){
            newHead = head.next;
            head.next = null;
        }

        while(prev.next!=null){

            if(prev.next.data == key){
                newHead = prev.next;
                prev.next = null;
                break;
            }
            prev = prev.next;

        }



        ListNode p = head;
        ListNode q = newHead;

        while (p!=null){
            System.out.print(  p.data + " -> ");
            p = p.next;
        }
        System.out.println();
        while (q!=null){
            System.out.print(  q.data + " -> ");
            q = q.next;
        }
    }

    private void Intersection(){

        ListNode head1 = head;
        ListNode head2 = head;

        // Get length of both linked list, add/subtract, get both pointers to same head
        // then traverse and see if both pointers point to the next same element

        






    }


    /*private void isPalindrome( ){

        ListNode curr = head;
        ListNode runn = head.next.next;

        List<Integer> list = new ArrayList<Integer>();

        while(runn!=null || runn.next!= null){

            list.add(curr.data);
            curr = curr.next;
            runn = runn.next.next;

        }






    }*/






    public static void main(String args[]) {

        CustomLinkedList ll = new CustomLinkedList();
        ll.add(10);
        ll.add(10);
        ll.add(10);
        ll.add(10);
        ll.add(20);
        ll.add(30);
        ll.add(40);
        ll.add(50);
        ll.add(30);
        ll.add(30);
        ll.add(30);
        ll.add(30);
        ll.add(60);
        ll.add(70);
        ll.add(70);
        ll.add(80);
        ll.add(90);
        ll.add(100);



        ll.removeDuplicates();
//        ll.KThToTheLast(3);

        ll.partitionAround(50);


    }
}
