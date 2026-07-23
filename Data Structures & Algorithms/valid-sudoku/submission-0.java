class Solution {
    public boolean isValidSudoku(char[][] board) {
        // check row
        for (int i = 0; i < 9; i++) {
            HashSet<Character> set = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                char curr = board[i][j];
                if (Character.isDigit(curr)) {
                    if (set.contains(curr))
                        return false;
                    set.add(curr);
                }
            }
        }

        // check column

        for (int i = 0; i < 9; i++) {
            HashSet<Character> set = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                char curr = board[j][i];
                if (Character.isDigit(curr)) {
                    if (set.contains(curr))
                        return false;
                    set.add(curr);
                }
            }
        }

        // cubes

        int r = 0;
        int c = 0;
        while (c < 9 && r < 9) {
            HashSet<Character> set = new HashSet<>();
            for (int i = r; i < r+3; i++) {
                for (int j = c; j < c+3; j++) {
                    char curr = board[i][j];
                    if (Character.isDigit(curr)) {
                        if (set.contains(curr))
                            return false;
                        set.add(curr);
                    }
                }
            }
            if(r<6){
                r+=3;
            }else{
                r = 0;
                c+=3;
            }

        }

        return true;
    }
}
