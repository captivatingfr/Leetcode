class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> merged = new ArrayList<>();
        for(int[] interval : intervals){
            if(merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]){
                merged.add(interval);
            }else{
                int last = merged.size() - 1;
                int maxEnd = Math.max(merged.get(last)[1], interval[1]);
                merged.get(last)[1] = maxEnd;
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}