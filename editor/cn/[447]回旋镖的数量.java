//给定平面上 n 对 互不相同 的点 points ，其中 points[i] = [xi, yi] 。回旋镖 是由点 (i, j, k) 表示的元组 ，其中
// i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。 
//
// 返回平面上所有回旋镖的数量。 
// 
//
// 示例 1： 
//
// 
//输入：points = [[0,0],[1,0],[2,0]]
//输出：2
//解释：两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
// 
//
// 示例 2： 
//
// 
//输入：points = [[1,1],[2,2],[3,3]]
//输出：2
// 
//
// 示例 3： 
//
// 
//输入：points = [[1,1]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// n == points.length 
// 1 <= n <= 500 
// points[i].length == 2 
// -104 <= xi, yi <= 104 
// 所有点都 互不相同 
// 
// Related Topics 数组 哈希表 数学 
// 👍 176 👎 0

import com.apple.laf.AquaTreeUI;

import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int sum = 0;
        for (int[] p : points){
            Map<Integer, Integer> cnt = new HashMap<>();
            for (int[] q: points){
                int distance = (p[0] - q[0]) *  (p[0] - q[0]) + (p[1] - q[1]) * (p[1] - q[1]);
                cnt.put(distance, cnt.getOrDefault(distance, 0) + 1);
            }
            for (Map.Entry<Integer, Integer> entry: cnt.entrySet()){
                int m  = entry.getValue();
                sum += m * (m - 1) ;
            }
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
