class Solution {
    public boolean isValidSudoku(char[][] board) {
        // row/colums
        for (int i = 0; i < 9; i++) {
            HashSet<Character> set = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                char curr = board[i][j];
                if (curr != '.' && !set.add(curr))
                    return false;
            }
            set.clear();
            for (int j = 0; j < 9; j++) {
                char curr = board[j][i];
                if (curr != '.' && !set.add(curr))
                    return false;
            }
        }

        // cubes

        for (int row = 0; row < 9; row += 3) {
            for (int col = 0; col < 9; col += 3) {
                HashSet<Character> set = new HashSet<>();
                for (int i = row; i < row + 3; i++) {
                    for (int j = col; j < col + 3; j++) {
                        char curr = board[i][j];
                        if (curr != '.' && curr != '.') {
                            if (!set.add(curr)) {
                                return false;
                            }
                        }
                    }
                }
            }
        }

        return true;
    }
}
