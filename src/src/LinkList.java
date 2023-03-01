import java.util.Iterator;

public class LinkList<T> implements Iterable<T>{
    private Node head;
    private int size;

    public LinkList(){
        head = null;
        size = 0;
    }

    public int getSize(){
        return size;
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
        size++;
    }

    @Override
    public Iterator<T> iterator() {
//        Iterator iter = new Iterator() {
//            Node current = head;
//            @Override
//
//            @Override
//            public T next() {
//                if (elementIndex != -1){
//                    current = current.next;
//                }
//                elementIndex++;
//                return (T) current.data;
//            }
//        };
        return new Iter();
    }

    protected class Iter implements Iterator<T>{
        private static int elementIndex = -1;

        public static int getIndex(){
            return elementIndex;
        }

        @Override
        public boolean hasNext() {
            return elementIndex < getSize() - 1;
        }

            @Override
            public T next() {
                if (elementIndex != -1){
                    head = head.next;
                }
                elementIndex++;
                return (T) head.getData();
            }


    }


    public class Node<T>{
        private T data;
        private Node next;

        public Node(T data){
            this.data = data;
            this.next = null;
        }

        public T getData(){
            return data;
        }

        @Override
        public String toString() {
            return (String)data;
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
                size--;
            }
            previous = current;
            current = current.next;
        }
    }

}
