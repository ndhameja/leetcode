import java.util.ArrayList;
import java.util.List;

class Solution17 {
    public List<String> letterCombinations(String digits) {
        String[] map = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> res = new ArrayList<>();
        if (digits.length() == 0)  return res;
        dfs(res, "", map, digits, 0);
        return res;
    }

    private void dfs(List<String> res, String tmp, String[] map, String digits, int start) {
        if (start == digits.length()) {
            res.add(tmp);
            return;
        }
        for (int i = 0; i < map[digits.charAt(start) - '0'].length(); i++) { // -'0'
            dfs(res, tmp + map[digits.charAt(start) - '0'].charAt(i), map, digits, start + 1);
        }
    }
}