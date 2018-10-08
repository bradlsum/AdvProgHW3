class Node:
    def __init__(self, d):
        self.data = d
        self.next = self
        self.prev = self


class LinkList:
    def __init__(self, n):
        self.head = n

    def print_list(self):
        n = self.head
        print(n.data, end="")
        print(' ', end="")
        n = n.next
        while n != self.head:
            print(n.data, end="")
            print(' ', end="")
            n = n.next
        print()

    def print_list_detailed(self):
        n = self.head
        print(n.data, end="")
        print(" (", end="")
        print(n.next.data, end="")
        print('/', end="")
        print(n.prev.data, end="")
        print(") ", end="")
        n = n.next
        while n != self.head:
            print(n.data, end="")
            print(" (", end="")
            print(n.next.data, end="")
            print('/', end="")
            print(n.prev.data, end="")
            print(") ", end="")
            n = n.next
        print()

    def add_next(self, n):
        n.next = self.head
        if self.head.prev == self.head:
            n.prev = self.head
            self.head.next = n
            self.head.prev = n
        else:
            n.prev = self.head.prev
            self.head.prev.next = n
            self.head.prev = n

    def add_pos(self, n, i):
        i = i -1
        temp = self.head
        if i == 0:
            n.next = temp.next
            n.prev = temp.prev

            temp.next.prev = n
            temp.next = n

        elif i < self.get_length():
            for j in range(0, i - 1):
                temp = temp.next

            n.next = temp.next
            n.prev = temp.prev

            temp.next.prev = n
            temp.next = n

        else:
            print("Out of bounds")

    def get_length(self):
        n = self.head.next
        i = 1
        while n != self.head:
            n = n.next
            i = i + 1
        return i

    def shift_left(self):
        print("Shift left")
        self.head = self.head.next

    def shift_right(self):
        print("Shift right")
        self.head = self.head.prev


if __name__ == '__main__':
    link = LinkList(Node(1))
    link.add_next(Node(2))
    link.add_next(Node(4))
    link.print_list()

    link.add_pos(Node(3), 3)
    link.print_list()

    link.shift_left()
    link.print_list()

    link.shift_right()
    link.print_list()

    link.shift_left()
    link.shift_left()
    link.print_list_detailed()