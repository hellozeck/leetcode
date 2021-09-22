//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 
// 👍 4068 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {

        int len = s.length();
        if (len < 2){
            return s;
        }

        int maxLen = 1 ;
        int begin = 0;
        char[] charArray = s.toCharArray();

        for (int i = 0 ; i < len - 1; i ++){
            int oddLen = expandAroundCenter(charArray, i , i);
            int evenLen = expandAroundCenter(charArray, i , i + 1);
            int curMaxLen  = Math.max(oddLen, evenLen);
            if (curMaxLen > maxLen){
                maxLen = curMaxLen;
                begin = i - (maxLen - 1) / 2;
            }
        }
        return s.substring(begin, begin + maxLen);
    }

   private int expandAroundCenter(char[] charArray, int left, int right){
        int len = charArray.length;
        int i = left ;
        int j = right;
        while (i >= 0 && j < len){
            if (charArray[i] == charArray[j]){
                i -- ;
                j ++;
            }else {
                break;
            }
        }
        return j - i - 1;
   }
}
//leetcode submit region end(Prohibit modification and deletion)
