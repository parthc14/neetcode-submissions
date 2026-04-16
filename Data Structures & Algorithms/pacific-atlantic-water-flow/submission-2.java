class Solution {
    int[][] directions = {{0,1}, {0, -1}, {1,0}, {-1,0}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];

        for(int i=0; i<n; i++) {
            bfs(i, 0, pacific, heights);
            bfs(i, m-1, atlantic, heights);
        }

        for(int i=0; i<m; i++) {
            bfs(0, i, pacific, heights);
            bfs(n-1, i, atlantic, heights);
        }

        List<List<Integer>> res = new ArrayList<>();

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(pacific[i][j] && atlantic[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    private void bfs(int i, int j, boolean[][] ocean, int[][] heights) {
        Queue<int[]> oceanQueue = new LinkedList<>();
        oceanQueue.offer(new int[]{i, j});
        ocean[i][j] = true;

        while(!oceanQueue.isEmpty()) {
            int[] coordinates = oceanQueue.poll();
            int row = coordinates[0];
            int col = coordinates[1];

            for(int[] dir: directions) {
                int nRow = row + dir[0];
                int nCol = col + dir[1];

                if(isValid(nRow, nCol, heights) && !ocean[nRow][nCol] && heights[nRow][nCol] >= heights[row][col]) {
                    ocean[nRow][nCol] = true;
                    oceanQueue.offer(new int[]{nRow, nCol});
                }
            }
        }
    }

    private boolean isValid(int row, int col, int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        if(row < 0 || row >= n || col < 0 || col >=m) return false;
        return true;
    }
}
