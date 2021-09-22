//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
// Related Topics 字符串 
// 👍 1778 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestCommonPrefix(String[] strs) {

        int n = strs.length;
        if (n == 0 ){
            return "";
        }else if (n == 1){
            return strs[0];
        }

        int minimum = Integer.MAX_VALUE ;
        List<char[]> charsList  = new ArrayList<>();
        for (String s : strs){
            minimum = Math.min(s.length(), minimum);
            charsList.add(s.toCharArray());
        }
        int start = 0 ;
        int end = 0;
        for ( end = 0 ; end < minimum; end ++){
            char c = charsList.get(0)[end];
            boolean isStill = true;
            for (int j = 1; j < charsList.size(); j ++){
                if (charsList.get(j)[end] != c){
                    isStill = false;
                    break;
                }
            }
            if (isStill == false){
                break;
            }
        }
        return  strs[0].substring(start, end);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
