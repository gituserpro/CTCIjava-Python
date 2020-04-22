package Java;

public class StackLL {

    StackNode top;
    StackNode last;

    public StackLL() {
        top = null;
    }

    public class StackNode {

        int data;
        StackNode next;

        public StackNode(int data) {
            this.data = data;
        }
    }

    private void push(int value) {

        if (top == null) {
            top = new StackNode(value);
            last = top;
        }

        last.next = new StackNode(value);
        last = last.next;
    }

    public void print() {

        StackNode curr = top;

        while (curr != null) {
            System.out.print(curr.data + " ->");
            curr = curr.next;
        }
    }

    private void peek() {
        if(top == null){
            System.out.println(" No elements in stack  ");
        }else{
            System.out.println(" Peek  A boo " + last.data);
        }
    }

    public void pop(){

        if(top == null){
            System.out.println(" No elements in stack  ");
        }

        StackNode curr = top;

        while(curr.next != last){
            curr = curr.next;
        }
        curr.next = null;
        last = curr;
    }


    public static void main(String[] args) {

        // pop push peek isEmpty

        StackLL stackLL = new StackLL();

        stackLL.push(10);
        stackLL.push(20);
        stackLL.push(30);
        stackLL.push(40);
        stackLL.push(50);
        stackLL.push(60);
        stackLL.push(70);
        stackLL.push(80);
        stackLL.push(90);
        stackLL.push(110);

        stackLL.print();

        stackLL.peek();

        stackLL.pop();
        stackLL.pop();
        stackLL.pop();
        stackLL.print();


    }
}
