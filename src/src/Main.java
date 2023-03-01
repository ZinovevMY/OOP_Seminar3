import java.util.Iterator;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkList intList = new LinkList();
        intList.add(10);
        intList.add(15);
        intList.add(20);
        intList.add(25);

        Iterator iter = intList.iterator();

        intList.remove(15);
        while (iter.hasNext()){
            System.out.println(iter.next().toString());
        }


    }
}