class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) return result;
        List<Integer> innerList = new ArrayList<>();
        innerList.add(1);
        result.add(innerList);
        for (int i = 1; i < numRows; i++) {
            List<Integer> previousRowList = result.get(i - 1);
            List<Integer> currentRowList = new ArrayList<>();
            currentRowList.add(1);
            for (int j = 1; j < i; j++) {
                currentRowList.add(previousRowList.get(j - 1) + previousRowList.get(j));
            }
            currentRowList.add(1);
            result.add(currentRowList);
        }
        return result;
    }
}