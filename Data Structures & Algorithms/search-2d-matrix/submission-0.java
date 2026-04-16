class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowIdx = findRowIdx(matrix, target);
        if (rowIdx < 0) return false;
        return findInCol(matrix[rowIdx], target);
    }

    private int findRowIdx(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int low = 0;
        int high = n-1;
        while (low <= high) {
            int mid = low + (high-low) /2;
            int firstColValue = matrix[mid][0];
            if(firstColValue == target) return mid;
            else if(firstColValue <= target) {
                low = mid + 1;

            } else {
                high = mid - 1;
            }
        }
        return high;
    }

    private boolean findInCol(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high-low) / 2;
            if(arr[mid] == target) return true;
            else if(arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
}
