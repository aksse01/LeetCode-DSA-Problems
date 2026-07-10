class Solution {
    private static int nQueens(int row, char[][] chessBoard) {
        int n= chessBoard.length;
        //valid solution found
        if(row==n){
            return 1;
        }
        int count=0;
        for(int col=0;col<n;col++){
            if(canQueensbePlaced(row,col,chessBoard)){
                chessBoard[row][col]='Q';//marked valid place
                count+=nQueens(row+1,chessBoard);//move the next state
                chessBoard[row][col]='i';//unmarked
            }
        }
        return count;
    }

    private static boolean canQueensbePlaced(int row, int col, char[][] chessBoard) {
        int n = chessBoard.length;
        int i = row - 1;
        //check the col
        while (i >= 0) {
            if (chessBoard[i][col] == 'Q') return false;
            i--;
        }
        //check the left diagonal
        i = row - 1;
        int j = col - 1;
        while (i >= 0 && j >= 0) {
            if (chessBoard[i][j] == 'Q') return false;
            i--;
            j--;
        }
        //check the right diagonal
        i = row - 1;
        j = col + 1;
        while (i >= 0 && j < n) {
            if (chessBoard[i][j] == 'Q') return false;
            i--;
            j++;
        }
        return true;
    }
    public int totalNQueens(int n) {
        
        char[][] chessBoard=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                chessBoard[i][j]='i';
            }
        }
        int ans=nQueens(0,chessBoard);
        return ans;
    }
}