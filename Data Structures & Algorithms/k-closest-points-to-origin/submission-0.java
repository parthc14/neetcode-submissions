class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[] origin = new int[]{0, 0};

        Map<Long, List<int[]>> distancesMap = new TreeMap<>();

        for(int[] num: points) {
            int row = num[0];
            int col = num[1];

            long dist = calculateDistance(row, col);
            if(!distancesMap.containsKey(dist)) {
                distancesMap.put(dist, new ArrayList<>());
            }

            distancesMap.get(dist).add(new int[]{row, col});
        }

        List<int[]> coordinatesList = new ArrayList<>();
        int count = 0;
        for(Map.Entry<Long, List<int[]>> entries: distancesMap.entrySet()) {
            List<int[]> coordinates = entries.getValue();

            for(int[] val: coordinates) {
                if(count < k) {
                    coordinatesList.add(val);
                    count++;
                } else {
                    break;
                }
            }

            if(count == k) break;
        }

        int[][] res = new int[k][2];
        int resIdx = 0;
        for(int[] coord: coordinatesList) {
            res[resIdx++] = coord;
        }

        return res;
    }

    private static long calculateDistance(int x, int y) {
        return (long) x * x + (long) y * y;
    }
}
