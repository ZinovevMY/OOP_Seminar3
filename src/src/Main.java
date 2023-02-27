public class Main {
    public static void main(String[] args) {
        LinkList<Integer> intList = new LinkList<>();
        intList.add(10);
        intList.add(15);
        intList.add(20);
        intList.add(25);

        intList.print();
        System.out.println("-------");

        intList.remove(20);
        intList.print();
    }
}