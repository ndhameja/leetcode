//import java.util.ArrayDeque;
//import java.util.ArrayList;
//import java.util.List;
//
//public class Snake_Nest {
//
//    public static void main(String[] args) {
//        char[][] board1 = new char[][] {{'+', '+', '+', '+', '+', '+', '+', '0', '0'},
//                {'+', '+', '0', '0', '0', '0', '0', '+', '+'},
//                {'0', '0', '0', '0', '0', '+', '+', '0', '+'},
//                {'+', '+', '0', '+', '+', '+', '+', '0', '0'},
//                {'+', '+', '0', '0', '0', '0', '0', '0', '+'},
//                {'+', '+', '0', '+', '+', '0', '+', '0', '+'}};
//
//
//
//
//        char[][] board2 = new char[][] {{'+', '+', '+', '+', '+', '+', '+'},
//                {'0', '0', '0', '0', '+', '0', '+'},
//                {'+', '0', '+', '0', '+', '0', '0'},
//                {'+', '0', '0', '0', '+', '+', '+'},
//                {'+', '+', '+', '+', '+', '+', '+'}};
//
//
//
//        char[][] board3 = new char[][] {{'+', '0', '+', '0', '+'},
//                {'0', '0', '+', '0', '0'},
//                {'+', '0', '+', '0', '+'},
//                {'0', '0', '+', '0', '0'},
//                {'+', '0', '+', '0', '+'}};
//
//
//        char[][] board4 = new char[][] {{'+', '0', '+', '0', '+'},
//                {'0', '0', '0', '0', '0'},
//                {'+', '+', '+', '+', '+'},
//                {'0', '0', '0', '0', '0'},
//                {'+', '0', '+', '0', '+'}};
//
//
//        char[][] board5 = new char[][] {{'+', '0', '0', '0', '+'},
//                {'+', '0', '+', '0', '+'},
//                {'+', '0', '0', '0', '+'},
//                {'+', '0', '+', '0', '+'}};
//
//        char[][] straight_board_1 = new char[][]{{'+', '+', '+', '0', '+', '+', '0'},
//                {'0', '0', '0', '0', '0', '0', '+'},
//                {'+', '0', '+', '0', '0', '+', '+'},
//                {'0', '0', '0', '0', '+', '0', '0'},
//                {'+', '+', '+', '0', '+', '0', '+'}
//        };
//
//        //find_number_nest_exits(straight_board_1) returns [4, 1, 2] or [2, 1, 4] or [1, 2, 4] or [4, 2, 1] or [1, 4, 2] or [2, 4, 1]
//
//        //List<Integer> list = findSol(board2);
//        //int ans[] = findSolDp(board1, start1_1, )
//
//        //System.out.println(list.toString());
//
//
//    }
//
//    static boolean  isValid(char[][] board,int i, int j, boolean[][] visited){
//        int n = board.length;
//        int m= board[0].length;
//        if(i<0 || i>=n ||  j<0 || j>=m) return false;
//        if(visited[i][j]) return false;
//        if(board[i][j] ==  '+') return false;
//        return true;
//    }
//
//    static private List<Integer> findSol(char[][] board) {
//        int n = board.length;
//        int m= board[0].length;
//        boolean [][] visited = new boolean[board.length][board[0].length];
//
//        List<Integer> ans = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            int count = getCount(board, i, 0, visited);
//            if(count!=0)
//                ans.add(count);
//        }
//        for (int i = 0; i < n; i++) {
//            int count = getCount(board, i, m-1, visited);
//            if(count!=0)
//                ans.add(count);
//        }
//        for (int i = 0; i < n; i++) {
//            int count = getCount(board, 0, i, visited);
//            if(count!=0)
//                ans.add(count);
//        }
//        for (int i = 0; i < n; i++) {
//            int count = getCount(board, n-1, i, visited);
//            if(count!=0)
//                ans.add(count);
//        }
//
//        return ans;
//    }
//
//    private static int getCount(char[][] board, int i, int j, boolean[][] visited) {
//        int count=0;
//        int n = board.length;
//        int m= board[0].length;
//        if(isValid(board, i,j, visited)){
//            ArrayDeque<int[]> queue = new ArrayDeque<>();
//            queue.offerLast(new int[]{i,j});
//            visited[i][j]= true;
//
//            while(!queue.isEmpty()){
//                int[] pop = queue.pollFirst();
//                int currI = pop[0];
//                int currJ = pop[1];
//                if(currI == 0 || currJ  ==0  || currJ == m -1 ||  currI == n -1){
//                    count++;
//                }
//
//                if(isValid(board, currI+1, currJ, visited)){
//                    visited[currI+1][currJ] = true;
//                    queue.offerLast(new int[]{currI+1,currJ});
//                }
//                if(isValid(board, currI-1, currJ, visited)){
//                    visited[currI-1][currJ] = true;
//                    queue.offerLast(new int[]{currI-1,currJ});
//                }
//                if(isValid(board, currI, currJ+1, visited)){
//                    visited[currI][currJ+1] = true;
//                    queue.offerLast(new int[]{currI,currJ+1});
//                }
//                if(isValid(board, currI, currJ-1, visited)){
//                    visited[currI][currJ-1] = true;
//                    queue.offerLast(new int[]{currI,currJ-1});
//                }
//            }
//        }
//        return count;
//    }
//}
