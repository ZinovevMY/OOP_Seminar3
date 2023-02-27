import java.util.Iterator;

public class LinkList<T> implements Iterable<T>{
    private Node head;

    public LinkList(){
        head = null;
    }

    public void add(T data){
        Node newNode = new Node<>(data);
        Node currNode = head;

        if (head == null){
            head = newNode;
        }else {
            while (currNode.next != null){
                currNode = currNode.next;
            }
            currNode.next = newNode;
        }
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> iter = new Iterator<T>() {
            Node current = head;
            @Override
            public boolean hasNext() {
                return current.next == null;
            }

            @Override
            public T next() {
                return (T) current.next;
            }
        };
        return iter;
    }


    public class Node<T>{
        private T data;
        private Node next;

        public Node(T data){
            this.data = data;
            this.next = null;
        }
    }

    public void remove(T data){
        Node current = head;
        Node previous = null;

        while (current.next != null){
            if (current.data == data){
                if (current == head){
                    head = current.next;
                } else {
                    previous.next = current.next;
                }
            }
            previous = current;
            current = current.next;
        }
    }

    public void print(){
        Node current = head;

        if (head != null){
            System.out.println(head.data);
        }
        while (current.next != null){
            current = current.next;
            System.out.println(current.data);
        }
    }
}
