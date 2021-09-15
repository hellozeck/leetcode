//给你一个字符串 s 和一个字符串数组 dictionary 作为字典，找出并返回字典中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。 
//
// 如果答案不止一个，返回长度最长且字典序最小的字符串。如果答案不存在，则返回空字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
//输出："apple"
// 
//
// 示例 2： 
//
// 
//输入：s = "abpcplea", dictionary = ["a","b","c"]
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// 1 <= dictionary.length <= 1000 
// 1 <= dictionary[i].length <= 1000 
// s 和 dictionary[i] 仅由小写英文字母组成 
// 
// Related Topics 数组 双指针 字符串 排序 
// 👍 212 👎 0

import java.util.HashSet;
import java.util.List;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution
{
    public String findLongestWord(String s, List<String> dictionary)
    {
        if (dictionary.isEmpty()) {
            return "";
        }
        String result = "";

        for (String d : dictionary) {
            if (d.length() > s.length()){
                continue;
            }
            int dIndex = 0 ;
            int sIndex = 0 ;
            while (dIndex < d.length() && sIndex < s.length()){
                while (sIndex < s.length() && d.charAt(dIndex) != s.charAt(sIndex)){
                    sIndex ++;
                }
                sIndex ++;
                dIndex ++;
            }
            //可以通过删除来获得子串
            if (dIndex == d.length() && sIndex <= s.length()){
                if ((d.length() > result.length()) || (d.length() == result.length() && d.compareToIgnoreCase(result) < 0)){
                    result = d;
                }
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
