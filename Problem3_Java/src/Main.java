public class Main {
    public static void main(String [ ] args){
        LinkList link = new LinkList(new Node(1));
        link.AddNext(new Node(2));
        link.AddNext(new Node(4));
        link.AddPos(new Node(3),3);
        link.PrintListDetailed();

        link.ShiftRight();
        link.PrintList();

        link.ShiftLeft();
        link.PrintList();

        System.out.println("\nThere are " + link.getLength() + " elements in the list.\n");

        LinkList link2 = new LinkList(new Node('a'));
        link2.AddNext(new Node('b'));
        link2.AddNext(new Node('d'));
        link2.AddPos(new Node('c'),3);
        link2.PrintListDetailed();

        link2.ShiftRight();
        link2.PrintList();

        link2.ShiftLeft();
        link2.PrintList();

        System.out.println("\nThere are " + link.getLength() + " elements in the list.");
    }
}
