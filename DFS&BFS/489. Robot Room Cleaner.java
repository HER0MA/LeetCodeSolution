/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */
// t:m*n s:m*n
class Solution {
    private static int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    
    public void cleanRoom(Robot robot) {
        dfs(0, 0, 0, new HashSet<>(), robot);
    }
    
    private void dfs(int i, int j, int dir, Set<String> visited, Robot robot) {
        String pos = i + "," + j;
        if (visited.contains(pos)) return;
        robot.clean();
        visited.add(pos);
        for (int k = 0; k < 4; k++) {
            if (robot.move()) {
                dfs(i + dirs[dir][0], j + dirs[dir][1], dir, visited, robot);
                robot.turnRight();
                robot.turnRight();
                robot.move();
                robot.turnRight();
                robot.turnRight();
            }
            dir++;
            dir %= 4;
            robot.turnLeft();
        }
    }
}