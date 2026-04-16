class Solution {
    int[][] directions = {{1,0}, {0,1}, {-1,0}, {0, -1}};
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;

        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];

        for(int i=0; i< n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == 1 && !visited[i][j]) {
                    int area = dfs(i, j, grid, visited);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }

    public boolean isValid(int row, int col, int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        if(row < 0 || row >= n || col < 0 || col >= m) return false;
        return true;
    }

    public int dfs(int row, int col, int[][] grid, boolean[][] visited) {
        visited[row][col] = true;

        int maxArea = 1;
        for(int[] dir: directions) {
            int nRow = row + dir[0];
            int nCol = col + dir[1];

            if(isValid(nRow, nCol, grid) && !visited[nRow][nCol] && grid[nRow][nCol] != 0) {
               maxArea += dfs(nRow, nCol, grid, visited);
            }
        }

        return maxArea;
    }
}
