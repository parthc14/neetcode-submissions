class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int noOfIslands = 0;
        int[][] directions = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
        for(int i=0; i<n; i++) {
            for(int j = 0; j<m; j++) {
                if(grid[i][j] == '1' && !visited[i][j]) {
                    noOfIslands++;
                    dfs(i, j, grid, visited, directions);
                }
            }
        }

        return noOfIslands;
    }

    private void dfs(int row, int col, char[][] grid, boolean[][] visited, int[][] directions) {
        if(!isValid(row, col, grid) || visited[row][col] || grid[row][col] == '0') {
            return;
        }

        visited[row][col] = true;
        for(int[] dir: directions) {
            int nRow = row + dir[0];
            int nCol = col + dir[1];
            dfs(nRow, nCol, grid, visited, directions);
        }
    }

    private boolean isValid(int row, int col, char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        if(row < 0 || row >= n || col < 0 || col >= m) return false;
        return true;
    }

}
