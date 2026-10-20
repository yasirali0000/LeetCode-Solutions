class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] chessboard = new char[n][n];
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
               chessboard[i][j] = '.';
            }
        }
        queens(0, chessboard,ans);
        return ans;
    }

    public void queens(int row, char[][] chessboard, List<List<String>> ans) {
        int n = chessboard.length;
        if (row == n) {
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                    temp.add(new String(chessboard[i]));
            }
            ans.add(temp);
            return;
        }
        for(int col=0;col<n;col++) {
            if(canqueenplace(row,col,chessboard)) {
                chessboard[row][col] = 'Q';  // mark
                queens(row+1,chessboard,ans);   //move to the next row
                chessboard[row][col] = '.';   // unmark
            }
        }
    }
    public boolean canqueenplace(int row,int col,char[][] chessboard) {
        int n = chessboard.length;
        // check col
        int i = row-1;
        while(i>=0) {
            if(chessboard[i][col]=='Q') return false;
            i--;
        }
        // check left diagonal
        i=row-1;
        int j=col-1;
        while(i>=0 && j>=0) {
            if(chessboard[i][j] == 'Q') return false;
            i--;
            j--;
        }
        // check right diagonal
        i=row-1;
        j=col+1;
        while(i>=0 && j<n) {
            if(chessboard[i][j] == 'Q') return false;
            i--;
            j++;
        }
        return true;
    }
}