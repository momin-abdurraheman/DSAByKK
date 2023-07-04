public class backTracking2 {
    public static void main(String[] args) {
        boolean[][] board = {
                { true, true, true },
                { true, false, true },
                { true, true, true }

        };
        pathall(" ", board, 0, 0);

    }

    static void pathall(String p, boolean[][] maze, int r, int c) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            System.out.println(p);
            return;
        }
        if (!maze[r][c]) {
            return;
        }
        // I am considering this path in my path
        maze[r][c] = false;

        if (r < maze.length - 1) {
            pathall(p + 'D', maze, r + 1, c);
        }
        if (c < maze[0].length - 1) {
            pathall(p + 'R', maze, r, c + 1);
        }
        if (r > 0) {
            pathall(p + 'U', maze,r - 1, c);
        }
        if (c > 0) {
            pathall(p + 'L', maze, r , c - 1);
        }
        // This is where function is over and will go back so while going back mark
        // the block as true, This is known as BACKTACKING

        maze[r][c] = true;
    }
}
