//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 示例 4: 
//
// 
//输入: s = ""
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 104 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 字符串 滑动窗口 
// 👍 6088 👎 0

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {

//        int maxSize = 0, start = 0 , end = 0;
//        char[] ss = s.toCharArray();
//        int n = ss.length;
//
//        if (n == 1){
//            return 1;
//        }
//
//        Set<Character> container  = new HashSet<>(n);
//        while (start < n && end < n ){
//            if (!container.contains(ss[end])){
//                container.add(ss[end]);
//                end ++;
//            }else {
//                start ++;
//                end = start ;
//                container.clear();
//            }
//
//            if ((end - start) > maxSize){
//                maxSize = end - start;
//            }
//
//            if ((n - start) < maxSize){
//                return maxSize;
//            }
//        }
//        return  maxSize;
        char[] ss = s.toCharArray();
        Deque<Character> deque  = new ArrayDeque<>(ss.length);
        int maxLength = 0;
        for (Character c : ss){
            if (deque.contains(c)){
                while (deque.peekFirst() != c){
                    deque.pollFirst();
                }
                deque.pollFirst();
            }
            deque.offerLast(c);
            if (deque.size() > maxLength){
                maxLength = deque.size();
            }
        }
        return maxLength;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
