class Solution {
    class Pair {
        int cell, step;
        Pair(int cell, int step) {
            this.cell = cell;
            this.step = step;
        }
    }

    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean[] visited = new boolean[n * n + 1];
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(1, 0));
        visited[1] = true;

        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            if (p.cell == n * n) return p.step;

            for (int dice = 1; dice <= 6; dice++) {
                int next = p.cell + dice;
                if (next > n * n) continue;

                int[] pos = getCoordinates(next, n);
                if (board[pos[0]][pos[1]] != -1) {
                    next = board[pos[0]][pos[1]];
                }

                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(new Pair(next, p.step + 1));
                }
            }
        }
        return -1;
    }

    private int[] getCoordinates(int cell, int n) {
        int r = n - 1 - (cell - 1) / n;
        int c = (cell - 1) % n;
        if (((n - 1 - r) % 2) == 1) {
            c = n - 1 - c;
        }
        return new int[]{r, c};
    }
}
