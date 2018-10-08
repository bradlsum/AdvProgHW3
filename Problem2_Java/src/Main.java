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

        System.out.println("\nThere are " + link.getLength() + " elements in the list.");
    }
}
