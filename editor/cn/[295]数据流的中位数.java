package leetcode.editor.cn;//中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
//
// 例如， 
//
// [2,3,4] 的中位数是 3 
//
// [2,3] 的中位数是 (2 + 3) / 2 = 2.5 
//
// 设计一个支持以下两种操作的数据结构： 
//
// 
// void addNum(int num) - 从数据流中添加一个整数到数据结构中。 
// double findMedian() - 返回目前所有元素的中位数。 
// 
//
// 示例： 
//
// addNum(1)
//addNum(2)
//findMedian() -> 1.5
//addNum(3) 
//findMedian() -> 2 
//
// 进阶: 
//
// 
// 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？ 
// 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？ 
// 
// Related Topics 设计 双指针 数据流 排序 堆（优先队列） 
// 👍 468 👎 0

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

//leetcode submit region begin(Prohibit modification and deletion)
class MedianFinder {

    /** initialize your data structure here. */
    public MedianFinder() {
        queueMin = new PriorityQueue<>((a, b) -> (b - a ));
        queueMax = new PriorityQueue<>((a, b) -> (a - b));
    }
    PriorityQueue<Integer> queueMin, queueMax;

    public void addNum(int num) {
        if (queueMin.isEmpty() || queueMin.peek() > num){
            queueMin.add(num);
        }else {
            queueMax.add(num);

        }

    }
    
    public double findMedian() {
       return 0;
    }

    public static void main(String[] args)
    {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
//        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());

    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
//leetcode submit region end(Prohibit modification and deletion)
