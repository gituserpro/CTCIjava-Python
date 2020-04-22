package Java;

public class QueueLL {

    QueueNode first;
    QueueNode last;

    public QueueLL() {
        first = null;
        last = null;
    }

    public class QueueNode {

        int data;
        QueueNode next;

        public QueueNode(int data) {
            this.data = data;
        }
    }

    public void add(int value) {

        if (first == null && last == null) {
            QueueNode newNode = new QueueNode(value);
            first = newNode;
            last = first;
        } else {

            QueueNode newNode = new QueueNode(value);
            last.next = newNode;
            last = newNode;
        }
    }

    public void print() {

        QueueNode curr = first;
        System.out.println(" ");
        while (curr.next != null) {
            System.out.print(" <-> " + curr.data);
            curr = curr.next;
        }

    }

    public void remove() {

        if (first == null) {
            System.out.print("no Element");
        }

        first = first.next;

    }


    public static void main(String[] args) {

        // queue add(First) remove(last)  isEmpty()   peek(first)
        QueueLL queueLL = new QueueLL();

        queueLL.add(5);
        queueLL.add(10);
        queueLL.add(20);
        queueLL.add(30);
        queueLL.add(40);
        queueLL.add(50);

        queueLL.print();

        queueLL.remove();

        queueLL.print();
        queueLL.add(60);
        queueLL.print();
    }
}
