//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
// Related Topics 哈希表 字符串 回溯 
// 👍 1498 👎 0

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public static String[] phoneArray = new String[]{"0", "0", "abc", "def" ,"ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if(digits.isEmpty()){
            return list;
        }

        for (char digit : digits.toCharArray()){
            String s = phoneArray[Character.getNumericValue(digit)];
            if (list.isEmpty()) {
                for (char a : s.toCharArray()) {
                    list.add(String.valueOf(a));
                }
            }
            else {
                List<String> tempList = new ArrayList<>();
                for (String str : list) {
                    for (char a : s.toCharArray()) {
                        String newStr = str +a;
                        tempList.add(newStr);
                    }
                }
                list = tempList;
            }
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
