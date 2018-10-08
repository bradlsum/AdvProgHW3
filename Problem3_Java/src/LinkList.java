public class LinkList {
    Node head;

    LinkList(Node n){
        this.head = n;
    }

    void PrintList(){
        Node n = head;
        do{
            System.out.print(n.data);
            System.out.print(' ');
            n = n.next;
        } while (n != head);
        System.out.println();
    }

    void PrintListDetailed(){
        Node n = head;
        do{
            System.out.print(n.data);
            System.out.print(" (");
            System.out.print(n.next.data);
            System.out.print('/');
            System.out.print(n.prev.data);
            System.out.print(") ");
            n = n.next;
        } while (n != head);
        System.out.println();
    }

    void AddNext(Node n){
        n.next = head;
        if (head.prev == head) {
            n.prev = head;
            head.next = n;
            head.prev = n;
        }
        else {
            n.prev = head.prev;
            head.prev.next = n;
            head.prev = n;
        }
    }

    void AddPos(Node n, int i){
        i = i -1;
        Node temp = this.head;
        if (i == 0){
            //temp = temp.head.prev;

            n.next = temp.next;
            n.prev = temp.prev;

            temp.next.prev = n;
            temp.next = n;
        }
        else if (i < this.getLength()){
            for (int j = 0; j < i - 1; j++){
                temp = temp.next;
            }
            n.next = temp.next;
            n.prev = temp.prev;

            temp.next.prev = n;
            temp.next = n;
        }
        else {
            System.out.println("Out of bounds");
        }
    }

    int getLength(){
        Node n = head;
        int i = 0;
        do {
            n = n.next;
            i++;
        }while (n != head);
        return i;
    }

    void ShiftLeft(){
        System.out.println("Shift left");
        head = head.next;
    }

    void ShiftRight() {
        System.out.println("Shift right");
        head = head.prev;
    }
}