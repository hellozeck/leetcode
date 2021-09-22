//请你判断一个 9x9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。 
//
// 
// 数字 1-9 在每一行只能出现一次。 
// 数字 1-9 在每一列只能出现一次。 
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图） 
// 
//
// 数独部分空格内已填入了数字，空白格用 '.' 表示。 
//
// 注意： 
//
// 
// 一个有效的数独（部分已被填充）不一定是可解的。 
// 只需要根据以上规则，验证已经填入的数字是否有效即可。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：board = 
//[["5","3",".",".","7",".",".",".","."]
//,["6",".",".","1","9","5",".",".","."]
//,[".","9","8",".",".",".",".","6","."]
//,["8",".",".",".","6",".",".",".","3"]
//,["4",".",".","8",".","3",".",".","1"]
//,["7",".",".",".","2",".",".",".","6"]
//,[".","6",".",".",".",".","2","8","."]
//,[".",".",".","4","1","9",".",".","5"]
//,[".",".",".",".","8",".",".","7","9"]]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = 
//[["8","3",".",".","7",".",".",".","."]
//,["6",".",".","1","9","5",".",".","."]
//,[".","9","8",".",".",".",".","6","."]
//,["8",".",".",".","6",".",".",".","3"]
//,["4",".",".","8",".","3",".",".","1"]
//,["7",".",".",".","2",".",".",".","6"]
//,[".","6",".",".",".",".","2","8","."]
//,[".",".",".","4","1","9",".",".","5"]
//,[".",".",".",".","8",".",".","7","9"]]
//输出：false
//解释：除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。 但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无
//效的。 
//
// 
//
// 提示： 
//
// 
// board.length == 9 
// board[i].length == 9 
// board[i][j] 是一位数字或者 '.' 
// 
// Related Topics 数组 哈希表 矩阵 
// 👍 602 👎 0

import java.util.HashSet;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValidSudoku(char[][] board) {

        for (int i = 0 ; i < 9 ; ){
            for (int ii = 0; ii < 9; ) {
                Set<Character> charSet = new HashSet<>();
                for (int j = 0; j < 3; j++) {
                    for (int k = 0; k < 3; k++) {
                        char c = board[i + j][ii + k];
                        if (c == '.') {
                            continue;
                        }
                        if (charSet.contains(c)) {
                            return false;
                        }
                        charSet.add(c);
                    }
                }
                charSet.clear();
                ii = ii + 3;
            }
            i = i + 3;
        }

        for (int i = 0 ; i < 9 ; i ++){
            Set<Character> charSet = new HashSet<>();
            for (int j = 0 ; j < 9 ; j ++){
                char c = board[i][j];
                if (c == '.'){
                    continue;
                }
                if (charSet.contains(c)){
                    return false;
                }
                charSet.add(c);
            }
            charSet.clear();
        }

        for (int i = 0 ; i < 9 ; i ++){
            Set<Character> charSet = new HashSet<>();
            for (int j = 0 ; j < 9 ; j ++){
                char c = board[j][i];
                if (c == '.'){
                    continue;
                }

                if (charSet.contains(c)){
                    return false;
                }
                charSet.add(c);
            }
            charSet.clear();
        }




        return true;

    }



}
//leetcode submit region end(Prohibit modification and deletion)
