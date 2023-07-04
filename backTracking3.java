public class backTracking3 {
    public static void main(String[] args) {
        boolean[][] board = {
                { true, true, true },
                { true, false, true },
                { true, true, true }

        };
        int[][] path = new int[board.length][board[0].length];
        pathall(" ", board, 0, 0,path,1);

    }

    static void pathallPrint(String p, boolean[][] maze, int r, int c,int[][] path,int step) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            path[r][c]=step;
            for(int[] arr: path){
              System.out.println(Arrays.toString(arr));
            }
            System.out.println(p);
            System.out.println();
            
            return;
        }
        if (!maze[r][c]) {
            return;
        }
        // I am considering this path in my path
        maze[r][c] = false;
        path[r][c] = step;
        if (r < maze.length - 1) {
            pathallPrint(p + 'D', maze, r + 1, c,path,step+1);
        }
        if (c < maze[0].length - 1) {
            pathallPrint(p + 'R', maze, r, c + 1,path,step+1);
        }
        if (r > 0) {
            pathallPrint(p + 'U', maze,r - 1, c,path,step+1);
        }
        if (c > 0) {
            pathallPrint(p + 'L', maze, r , c - 1,path,step+1);
        }
        // This is where function is over and will go back so while going back mark
        // the block as true, This is known as BACKTACKING

        maze[r][c] = true;
        path[r][c] = 0;
    }
}
