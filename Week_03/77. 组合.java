class Solution {
    private int m_n;
    private int m_k;
    private List<List<Integer>> res= new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        m_n = n;
        m_k = k;
        backTrack(1,new LinkedList<Integer>());
        return res;
    }

    public void backTrack(int first, LinkedList<Integer> curr) {
        if (curr.size() == m_k) {
            res.add(new LinkedList<Integer>(curr));
        }
        for (int i = first; i < m_n + 1; ++i) {
            curr.add(i);

            backTrack(i+1,curr);
            curr.removeLast();
        }
    }

}