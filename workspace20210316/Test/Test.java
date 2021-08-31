package Test;

/**
 * @author TJ
 * @create 2021-08-12  19:09
 */
public class Test {
    public static void main(String[] args) {
        Solution sol = new Solution();
        char[][] ans = new char[][]{{'a','b','c'},{'a','e','d'},{'a','f','g'}};
        String ansWord = "abcdefg";
        System.out.println(sol.exist(ans,ansWord));
    }
}
class Solution {
    int[][] dfs;
    int m,n;
    char[][] board;
    String word;
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        m = board.length;
        n = board[0].length;
        dfs = new int[m][n];
        if(board[0][0] == word.charAt(0) && word.length() == 1) return true;
        for(int i = 0 ; i < m ; i++){ // i = m
            for(int j = 0 ; j < n; j++){  // j = n
                if(board[i][j] == word.charAt(0)){
                    dfs[i][j] = 1;
                    for(int k = 1 ; k < word.length() ; k++){
                        if(existWord(i,j,k)){
                            if(k == word.length()-1) return true;
                        }else{
                            dfs = new int[m][n];
                            break;
                        }
                    }
                }
            }
        }
        return false;
    }
    public boolean existWord(int i,int j,int k){
        int[] dx = new int[]{1,0,-1,0};
        int[] dy = new int[]{0,-1,0,1};
        for(int d = 0; d < 4 ; d++){
            int x = i + dx[d];
            int y = j + dy[d];
            if(x < 0 || y < 0 || x >= m || y >= n) continue;
            if(board[x][y] == word.charAt(k) && dfs[x][y] == 0 ) {
                dfs[x][y] = 1;
                return true;
            }
        }
        return false;
    }
}
