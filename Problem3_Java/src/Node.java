class Node<t> {
    t data;
    Node prev;
    Node next;

  Node(t d)
    {
        this.data = d;
        this.next = this;
        this.prev = this;
    }
}
