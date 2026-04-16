class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];

        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == 2) {
                    q.offer(new int[]{i,j});
                    visited[i][j] = true;
                }
            }
        }

        
        int[][] directions = {{0,1}, {0,-1}, {1, 0}, {-1,0}};
        int time = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            boolean rottedThisRound = false;

            for(int i=0; i<size; i++) {
                int[] coordinates = q.poll();
                
                int row = coordinates[0];
                int col = coordinates[1];

                for(int[] dir: directions) {
                    int nRow = row + dir[0];
                    int nCol = col + dir[1];

                    if(isValid(nRow, nCol, grid) && !visited[nRow][nCol] && grid[nRow][nCol] == 1) {
                        visited[nRow][nCol] = true;
                        rottedThisRound = true;
                        q.offer(new int[]{nRow, nCol});
                    }
                }

            }
            if(rottedThisRound) time++;
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == 1 && !visited[i][j]) {
                    return -1;
                }
            }
        }
        return time;
    }

    private boolean isValid(int row, int col, int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        if(row < 0 || row >= n || col < 0 || col >=m) return false;
        return true;
    }
}
