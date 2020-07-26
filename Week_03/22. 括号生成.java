

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(0,0,new char[2*n],res);
        return res;
    }
    public void backtrack(int left, int right, char[] track, List<String> res) {
        if (left + right == track.length) {
            if(left == right) res.add(new String(track));
            
            return;
        }
        if(left < right) return;
        track[left+right]='(';
        backtrack(left+1,right,track,res);
        track[left+right]=')';
        backtrack(left,right+1,track,res);
    }
}