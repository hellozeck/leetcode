//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 
// 👍 2645 👎 0

import java.util.Map;
import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution
{
    public boolean isValid(String s)
    {
        if (s.length() == 0) {
            return true;
        }
        if (s.length() % 2 != 0){
            return false;
        }

        Stack<Character> stack = new Stack<>();

        for (Character c : s.toCharArray()) {
            if ('(' == c ||  '[' == c || '{' == c) {
                stack.push(c);
            }
            else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character top = stack.peek();
                if ((top == '(' && c == ')' ) || ( top == '[' && c == ']' ) || (top == '{' && c == '}')) {
                   stack.pop();
                }else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
