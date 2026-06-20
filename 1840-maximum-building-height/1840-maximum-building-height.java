class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
        List<int[]> list = new ArrayList<>();

        list.add(new int[]{1, 0});

        for (int[] r : restrictions) {
            list.add(new int[]{r[0], r[1]});
        }

        list.add(new int[]{n, n - 1});

        Collections.sort(list, (a, b) -> a[0] - b[0]);

        for (int i = 1; i < list.size(); i++) {
            int distance = list.get(i)[0] - list.get(i - 1)[0];

            list.get(i)[1] = Math.min(
                list.get(i)[1],
                list.get(i - 1)[1] + distance
            );
        }

        for (int i = list.size() - 2; i >= 0; i--) {
            int distance = list.get(i + 1)[0] - list.get(i)[0];

            list.get(i)[1] = Math.min(
                list.get(i)[1],
                list.get(i + 1)[1] + distance
            );
        }

        int answer = 0;

        for (int i = 1; i < list.size(); i++) {
            int leftHeight = list.get(i - 1)[1];
            int rightHeight = list.get(i)[1];
            int distance = list.get(i)[0] - list.get(i - 1)[0];

            int peak = (leftHeight + rightHeight + distance) / 2;

            answer = Math.max(answer, peak);
        }

        return answer;
    }
}