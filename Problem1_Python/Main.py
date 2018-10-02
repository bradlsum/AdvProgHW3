letter_value = { 'a': 1,
                'b': 2,
                'c': 3,
                'd': 4,
                'e': 5,
                'f': 6,
                'g': 7,
                'h': 8}
letters = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h']
numbers = [1, 2, 3, 4, 5, 6, 7, 8]

class Piece:
    def __init__(self):
        self.value = '0'

    def __init__(self, nValue):
        self.value = nValue

    def flip(self):
        if self.value == '0':
            self.value = '1'
        elif self.value == '1':
            self.value = '0'
        else:
            print("Piece is not set.")

    def place(self, i):
        self.value = i


class Board:
    def __init__(self):
        self.spaces = [[0 for x in range(8)] for y in range(8)]

        for i in range(8):
            self.spaces.append(1)
            for j in range(8):
                self.spaces[i].append(1)
                self.spaces[i][j] = Piece('-')
        self.spaces[3][3] = Piece('1')
        self.spaces[3][4] = Piece('0')
        self.spaces[4][3] = Piece('0')
        self.spaces[4][4] = Piece('1')

    def print_board(self):
        print('\n')
        print(' ', '\t', end="")
        for i in range(8):
            print(i + 1, '\t', end="")
        print('\n')

        for i in range(8):
            print(letters[i], '\t', end="")
            for j in range(8):
                print(self.spaces[i][j].value, '\t', end="")
            print('\n')

    def valid_move(self, input, c):
        if len(input) == 2:
            if input[0] in letters:
                if int(input[1]) in numbers:
                    row = letter_value[input[0]] - 1
                    col = int(input[1]) - 1

                    self.spaces[row][col].place(c)

                    if col != 7:    # Check right of the input
                        if self.spaces[row][col + 1].value == self.not_value(c):
                            for i in range(col, 8):
                                if self.spaces[row][col + i].value != '-':
                                    if self.spaces[row][col + i].value == c:
                                        for j in range(col + 1, col + i):
                                            self.spaces[row][j].flip()
                                        break

                    if col != 0:    # Check left of the input
                        if self.spaces[row][col - 1].value == self.not_value(c):
                            for i in range(0, col):
                                if self.spaces[row][i].value != '-':
                                    if self.spaces[row][i].value == c:
                                        for j in range(i + 1, col + i):
                                            self.spaces[row][j].flip()
                                        break

                    if row != 7:    # Check below the input
                        if self.spaces[row + 1][col].value == self.not_value(c):
                            for i in range(row + 1, 8):
                                if self.spaces[i][col].value != '-':
                                    if self.spaces[i][col].value == c:
                                        for j in range(row + 1, row + i):
                                            if self.spaces[j][col].value != c:
                                                self.spaces[j][col].flip()
                                        break

                    if row != 0:    # Check above the input
                        if self.spaces[row - 1][col].value == self.not_value(c):
                            for i in range(0, row):
                                if self.spaces[row - i][col].value != '-':
                                    if self.spaces[i][col].value == c:
                                        for j in range(0, row - i):
                                            if self.spaces[j][col].value != c:
                                                self.spaces[row][j].flip()
                                        break


    def not_value(self, i):
        if i == '1':
            return '0'
        elif i == '0':
            return '1'

if __name__ == '__main__':
    s = Board()
    s.print_board()

    s.valid_move("d6", '1')
    s.print_board()
