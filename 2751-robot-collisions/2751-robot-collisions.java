class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        List<Integer> result = new ArrayList<>();
        int n = positions.length;
        List<int[]> robots = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            robots.add(new int[]{positions[i], healths[i], directions.charAt(i), i});
        }

        Collections.sort(robots, (a, b) -> Integer.compare(a[0], b[0]));

        Stack<int[]> stack = new Stack<>();

        for (int[] robot : robots) {
            if (robot[2] == 'R' || stack.isEmpty() || stack.peek()[2] == 'L') {
                stack.push(robot);
                continue;
            }

            if (robot[2] == 'L') {
                boolean collision = true;
                while (collision && !stack.isEmpty() && stack.peek()[2] == 'R') {
                    int lastHealth = stack.peek()[1];

                    if (robot[1] > lastHealth) {
                        stack.pop();
                        robot[1] -= 1;
                    } else if (robot[1] < lastHealth) {
                        stack.peek()[1] -= 1;
                        collision = false;
                    } else {
                        stack.pop();
                        collision = false;
                    }
                }
                if (collision) {
                    stack.push(robot);
                }
            }
        }

        List<int[]> survivors = new ArrayList<>(stack);
        survivors.sort(Comparator.comparingInt(a -> a[3]));

        for (int[] survivor : survivors) {
            result.add(survivor[1]);
        }

        return result;
    }
}