class Solution {
    boolean canFlowToPacific = false;
    boolean canFlowToAtlantic = false;

    int[][] directions = {{0,1}, {0,-1}, {1, 0}, {-1, 0}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        List<List<Integer>> res = new ArrayList<>();

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                canFlowToPacific = false;
                canFlowToAtlantic = false;

                dfs(i, j, heights, Integer.MAX_VALUE);

                if(canFlowToPacific && canFlowToAtlantic) {
                    List<Integer> temp = Arrays.asList(i, j);
                    res.add(temp);
                }
            }
        }

        return res;
    }

    public void dfs(int row, int col, int[][] heights, int prevValue) {
        int n = heights.length;
        int m = heights[0].length;
        

        if(row < 0 || col < 0) {
            canFlowToPacific = true;
            return;
        }

        if(row >= n || col >= m) {
            canFlowToAtlantic = true;
            return;
        }

        if(heights[row][col] > prevValue) {
            return;
        }

        int temp = heights[row][col];
        heights[row][col] = Integer.MAX_VALUE;
        
        for(int[] dir: directions) {
            int nRow = row + dir[0];
            int nCol = col + dir[1];
            
            
            dfs(nRow, nCol, heights, temp);
            if(canFlowToPacific && canFlowToAtlantic) break;
                
            
        }
        heights[row][col] = temp;
    }

    
}
