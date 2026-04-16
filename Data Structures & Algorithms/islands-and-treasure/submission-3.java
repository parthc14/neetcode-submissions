class Solution {
    private int INF = 2147483647;
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == 0) {
                    q.offer(new int[]{i, j});
                }
            }
        }
        int[][] directions = new int[][] {{0,1}, {0,-1}, {1,0}, {-1,0}};

        int steps = 0;
        while(!q.isEmpty()) {
            
            int size = q.size();

            for(int i=0; i<size; i++) {
                int[] coordinates = q.poll();

                int row = coordinates[0];
                int col = coordinates[1];

                for(int[] dir: directions) {
                    int nRow = row + dir[0];
                    int nCol = col + dir[1];

                    if(isValid(nRow, nCol, grid) && grid[nRow][nCol] == INF) {
                        grid[nRow][nCol] = steps + 1;
                        q.offer(new int[]{nRow, nCol});
                    }
                }
            }
            steps++;

            
            
        }

    }

    private boolean isValid(int row, int col, int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        if(row < 0 || row >= n || col < 0 || col >= m) return false;
        return true;
    }
}
