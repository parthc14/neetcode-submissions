class Solution {
    private int INF = 2147483647;
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == 0) {
                    visited[i][j] = true;
                    q.offer(new int[]{i, j, 0});
                }
            }
        }
        int[][] directions = new int[][] {{0,1}, {0,-1}, {1,0}, {-1,0}};
    
        while(!q.isEmpty()) {
            int[] coordinates = q.poll();

            int row = coordinates[0];
            int col = coordinates[1];
            int distance = coordinates[2];

            if(grid[row][col] == INF) {
                grid[row][col] = distance;
            }

            for(int[] dir: directions) {
                int nRow = row + dir[0];
                int nCol = col + dir[1];

                if(isValid(nRow, nCol, grid) && !visited[nRow][nCol] && grid[nRow][nCol] == INF) {
                    q.offer(new int[]{nRow, nCol, distance + 1});
                }
            }
            
        }

    }

    private boolean isValid(int row, int col, int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        if(row < 0 || row >= n || col < 0 || col >= m) return false;
        return true;
    }
}
