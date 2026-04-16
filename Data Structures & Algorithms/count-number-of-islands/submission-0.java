class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        int noOfIslands = 0;
        for(int i=0; i<n; i++) {
            for(int j = 0; j<m; j++) {
                if(grid[i][j] == '1' && !visited[i][j]) {
                    noOfIslands++;
                    visited[i][j] = true;
                    q.offer(new int[]{i, j});
                    bfs(i, j, visited, grid, q);
                }
            }
        }

        return noOfIslands;
    }

    private boolean isValid(int row, int col, char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        if(row < 0 || row >= n || col < 0 || col >= m) return false;
        return true;
    }

    private void bfs(int i, int j, boolean[][] visited, char[][] grid, Queue<int[]> q) {
        
        int[][] directions = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};

        while(!q.isEmpty()) {
            int[] coordinates = q.poll();
            int row = coordinates[0];
            int col = coordinates[1];

            for(int[] dir: directions){
                int nRow = row + dir[0];
                int nCol = col + dir[1];

                if(isValid(nRow, nCol, grid) && !visited[nRow][nCol] && grid[nRow][nCol] == '1') {
                    visited[nRow][nCol] = true;
                    q.offer(new int[]{nRow, nCol});
                }
            }
        }
    }
}
