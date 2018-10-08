class Node
{
    int data;
    Node prev;
    Node next;

    Node()
    {
        this.data = 0;
        this.next = this;
        this.prev = this;
    }

    Node(int d)
    {
        this.data = d;
        this.next = this;
        this.prev = this;
    }
}