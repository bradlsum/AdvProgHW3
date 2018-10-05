public class LinkList {
    Node head;

    LinkList(){
        this.head = new Node();
    }

    LinkList(Node n){
        this.head = n;
    }

    void PrintList(){
        Node n = head;
        do{
            System.out.println(n.data);
            n = n.next;
        } while (n != head);
        System.out.println();
    }
}