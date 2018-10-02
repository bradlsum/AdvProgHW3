import os

class Piece:
    def __init__(self):
        self.value = 0

    def __init__(self, nValue):
        self.value = nValue

    def getValue(self):
        return self.value

    def flip(self):
        if self.value == 'w':
            self.value = 'b'
        elif self.value == 'b':
            self.value = 'w'
        else:
            print("Piece is not set.")

class Board:
    def __init__(self):
        self.spaces = [[0 for x in range(8)] for y in range(8)]

        for i in range(8):
            self.spaces.append(1)
            for j in range(8):
                self.spaces[i].append(1)
                self.spaces[i][j] = Piece(0)

    def printBoard(self):
        print('\n')
        letters = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h']
        print(' ', '\t', end="")
        for i in range(8):
            print(i + 1, '\t', end="")
        print('\n')

        for i in range(8):
            print(letters[i], '\t', end="")
            for j in range(8):
                print(self.spaces[i][j].getValue(), '\t', end="")
            print('\n')

if __name__ == '__main__':
    s = Board()
    s.printBoard()
    s.spaces[1][1].flip
    s.printBoard()