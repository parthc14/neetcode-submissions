class Solution {
    public int leastInterval(char[] tasks, int n) {

        int[] freqMap = new int[26];
        for(int i = 0; i<tasks.length; i++) {
            int charIdx = tasks[i] - 'A';
            freqMap[charIdx]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> Integer.compare(b,a));

        for(int ch: freqMap){
            if(ch > 0) pq.offer(ch);
        }

        int count = 0;
        while(!pq.isEmpty()) {
            List<Integer> tempList = new ArrayList<>();
            for(int i=1; i<= n+1; i++) {
                if(!pq.isEmpty()) {
                    int freq = pq.poll();
                    freq--;
                    tempList.add(freq);
                }
            }

            for(int freq : tempList){
                if(freq > 0) pq.offer(freq);
            }

            if(pq.isEmpty()) {
                count += tempList.size();
            } else {
                count += n+1;
            }
        }

        return count;
    }
}
