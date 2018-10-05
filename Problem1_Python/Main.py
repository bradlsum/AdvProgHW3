letter_value = {'a': 1, 'b': 2,  'c': 3, 'd': 4, 'e': 5, 'f': 6, 'g': 7, 'h': 8}
letters = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h']
numbers = [1, 2, 3, 4, 5, 6, 7, 8]


class Piece:
    def __init__(self, n_value):
        self.value = n_value

    def flip(self):
        if self.value == '0':
            self.value = '1'
        elif self.value == '1':
            self.value = '0'
        else:
            print("Piece is not set.")

    def place(self, n_value):
        self.value = n_value


class Board:
    def __init__(self):
        self.spaces = [[0 for x in range(8)] for y in range(8)]

        for index in range(8):
            self.spaces.append(1)
            for index_2 in range(8):
                self.spaces[index].append(1)
                self.spaces[index][index_2] = Piece('-')
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
        row = letter_value[input[0]] - 1
        col = int(input[1]) - 1
        self.spaces[row][col].place(c)

        if col <= 7:    # Check right of the input
            if self.spaces[row][col + 1].value == self.not_value(c):
                for i in range(col + 2, 8):
                    if self.spaces[row][i].value != '-':
                        if self.spaces[row][i].value == c:
                            for j in range(col + 1, col + i):
                                self.spaces[row][j].flip()
                            break

        if col >= 0:    # Check left of the input
            if self.spaces[row][col - 1].value == self.not_value(c):
                for i in range(1, col):
                    if self.spaces[row][col - i].value != '-':
                        if self.spaces[row][col - i].value == c:
                            for j in range(1, i):
                                self.spaces[row][col - j].flip()
                            break

        if row <= 7:    # Check below the input
            if self.spaces[row + 1][col].value == self.not_value(c):
                for i in range(row + 1, 8):
                    if self.spaces[i][col].value != '-':
                        if self.spaces[i][col].value == c:
                            for j in range(row + 1, row + i):
                                if self.spaces[j][col].value != c:
                                    self.spaces[j][col].flip()
                            break

        if row >= 0:    # Check above the input
            if self.spaces[row - 1][col].value == self.not_value(c):
                for i in range(1, row):
                    if self.spaces[row - i][col].value != '-':
                        if self.spaces[row - i][col].value == c:
                            for j in range(1, row - i):
                                if self.spaces[row - j][col].value != c:
                                    self.spaces[row - j][col].flip()
                            break

    def valid(self, move, c):
        valid = 0
        if len(move) == 2:
            if move[0] in letters:
                if int(move[1]) in numbers:
                    row = letter_value[move[0]] - 1
                    col = int(move[1]) - 1

                    if col <= 7:  # Check right of the input
                        if self.spaces[row][col + 1].value == self.not_value(c):
                            for i in range(col + 2, 8):
                                if self.spaces[row][i].value != '-':
                                    if self.spaces[row][i].value == c:
                                        valid = 1
                                        break

                    if col >= 0:  # Check left of the input
                        if self.spaces[row][col - 1].value == self.not_value(c):
                            for i in range(2, col):
                                if self.spaces[row][col - i].value != '-':
                                    if self.spaces[row][col - i].value == c:
                                        valid = 1
                                        break

                    if row <= 7:  # Check below the input
                        if self.spaces[row + 1][col].value == self.not_value(c):
                            for i in range(row + 2, 8):
                                if self.spaces[i][col].value != '-':
                                    if self.spaces[i][col].value == c:
                                        valid = 1
                                        break

                    if row >= 0:  # Check above the input
                        if self.spaces[row - 1][col].value == self.not_value(c):
                            for i in range(2, row):
                                if self.spaces[row - i][col].value != '-':
                                    if self.spaces[row - i][col].value == c:
                                        valid = 1
                                        break

                    if valid == 1:
                        return 1
                    else:
                        return 0

    @staticmethod
    def not_value(value):
        if value == '1':
            return '0'
        elif value == '0':
            return '1'


if __name__ == '__main__':
    s = Board()
    s.print_board()
    check = 0
    p = 1

    while 0 < 1:
        print("Player", p, "please enter you move:", end="")
        i = input()

        if (s.valid(i, '1') == 1) & (p == 1):
            s.valid_move(i, '1')
            s.print_board()
            p = 2
        elif (s.valid(i, '0') == 1) & (p == 2):
            s.valid_move(i, '0')
            s.print_board()
            p = 1
        else:
            print("Invalid input, try again.")
            s.print_board()
