class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int[][] directions = new int[][] {{0,1}, {0,-1}, {1,0}, {-1,0}};

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == 1 && !visited[i][j]) {
                    int area =  dfs(i, j, visited, grid, directions);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }
        return maxArea;
    }

    private int dfs(int row, int col, boolean[][] visited, int[][] grid, int[][] directions) {
        if(!isValid(row, col, grid) || visited[row][col] || grid[row][col] == 0) return 0;

        int maxArea = 1;
        visited[row][col] = true;
        for(int[] dir: directions) {
            int nRow = row + dir[0];
            int nCol = col + dir[1];
            maxArea += dfs(nRow, nCol, visited, grid, directions);

        }

        return maxArea;

    }

    
    private boolean isValid(int row, int col, int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        if(row < 0 || row >= n || col < 0 || col >= m) return false;
        return true;
    }
}
