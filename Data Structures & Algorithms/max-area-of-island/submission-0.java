class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == 1 && !visited[i][j]) {
                    visited[i][j] = true;
                    q.offer(new int[]{i,j});
                    maxArea = Math.max(maxArea, bfs(i, j, visited, q, grid));
                }
            }
        }
        return maxArea;
    }

    private int bfs(int i, int j, boolean[][] visited, Queue<int[]> q, int[][] grid) {
        int[][] directions = new int[][] {{0,1}, {0,-1}, {1,0}, {-1,0}};
        int maxArea = 0;

        while(!q.isEmpty()) {
            int[] coordinates = q.poll();
            int row = coordinates[0];
            int col = coordinates[1];
            maxArea++;
    
            for(int[] dir: directions){
                int nRow = row + dir[0];
                int nCol = col + dir[1];

                if(isValid(nRow, nCol, grid) && !visited[nRow][nCol] && grid[nRow][nCol] == 1) {
                    q.offer(new int[]{nRow, nCol});
                    visited[nRow][nCol] = true;
                }
            }
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
