class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        Set<String> set = new HashSet<>();
        for (int[] obstacle : obstacles) {
            set.add(obstacle[0] + " " + obstacle[1]);
        }
        int x = 0, y = 0, dir = 0, res = 0;
        for (int command : commands) {
            if (command == -2) {
                dir = (dir + 3) % 4;
            } else if (command == -1) {
                dir = (dir + 1) % 4;
            } else {
                int[] cur = dirs[dir];
                for (int i = 0; i < command; i++) {
                    int nextX = x + cur[0];
                    int nextY = y + cur[1];
                    if (set.contains(nextX + " " + nextY)) {
                        break;
                    }
                    x = nextX;
                    y = nextY;
                    res = Math.max(res, x * x + y * y);
                }
            }
        }
        return res;
    }
}