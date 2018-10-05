class Node
{
    int data;
    Node head;
    Node prev;
    Node next;

    Node()
    {
        this.data = 0;
        this.next = this;
        this.head = this;
        this.prev = this;
    }

    Node(int d)
    {
        this.data = d;
        this.next = this;
        this.head = this;
        this.prev = this;
    }

    void AddNext(Node n){
        Node temp = this;
        while (temp.next != head){
            temp = temp.next;
        }

        n.next = temp.head;
        n.prev = temp;
        n.head = temp.head;

        temp.next = n;

        this.next.prev = temp;
    }

    void AddPos(Node n, int i){
        i = i -1;
        Node temp = this.head;
        if (i == 0){
            //temp = temp.head.prev;

            n.next = temp.next;
            n.prev = temp.prev;
            n.head = temp.head;

            temp.next.prev = n;
            temp.next = n;
        }
        else if (i < this.head.getLength()){
            for (int j = 0; j < i; j++){
                temp = temp.next;
            }
            n.next = temp.next;
            n.prev = temp.prev;
            n.head = temp.head;

            temp.next.prev = n;
            temp.next = n;
        }
        else {
            System.out.println("Out of bounds");
        }
    }

    int getLength(){
        Node n = this.head;
        int i = 0;
        do {
            n = n.next;
            i++;
        }while (n != this.head);
        return i;
    }

    void ShiftRight(){
        Node n = head;
        Node temp = new Node();

        do {
            n = n.prev;
            temp = n;
        } while (n != n.head);
    }

    void ShiftLeft(){
        Node n = head;
        do {
            n = n.next;
        } while (n != n.head);
    }
}