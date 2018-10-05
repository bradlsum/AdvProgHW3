public class Main {
    public static void main(String [ ] args){
        LinkList link = new LinkList(new Node(1));
        link.head.AddNext(new Node(2));
        link.head.AddNext(new Node(3));
        link.head.AddNext(new Node(4));
        link.PrintList();

        link.head.AddPos(new Node(2), 4);
        link.PrintList();

        link.head.AddPos(new Node(0), 1);
        link.PrintList();

        System.out.println("\nThere are " + link.head.getLength() + " elements in the list.");
    }
}
