//运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制 。 
//
// 
// 
// 实现 LRUCache 类： 
//
// 
// LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存 
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。 
// void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上
//限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。 
// 
//
// 
// 
// 
//
// 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？ 
//
// 
//
// 示例： 
//
// 
//输入
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//输出
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//解释
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // 缓存是 {1=1}
//lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//lRUCache.get(1);    // 返回 1
//lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//lRUCache.get(2);    // 返回 -1 (未找到)
//lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//lRUCache.get(1);    // 返回 -1 (未找到)
//lRUCache.get(3);    // 返回 3
//lRUCache.get(4);    // 返回 4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 10000 
// 0 <= value <= 105 
// 最多调用 2 * 105 次 get 和 put 
// 
// Related Topics 设计 哈希表 链表 双向链表 
// 👍 1615 👎 0

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

//leetcode submit region begin(Prohibit modification and deletion)
class LRUCache {

    int[] values ;
    long[] times;

    private int capacity;
    private int size;
    private int maxLength = 10001;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.values = new int[maxLength];
        for (int index = 0 ; index < maxLength; index ++){
            this.values[index] = -1;
        }
        this.times = new long[maxLength];
        for (int index = 0 ; index < maxLength; index ++){
            this.times[index] = -1;
        }
    }
    
    public int get(int key) {
        return values[key];
    }
    
    public void put(int key, int value)
    {
        int v = this.values[key];
        if (v == -1 && this.size == this.capacity){// 如果没有put过而且位置满了，需要腾出一个空间
            int maxOld = 0, index = 0;
            for (Long a : times){
                if (a != -1){
                    maxOld = index;
                    break;
                }
                index ++;
            }

            for (int i = index; i < maxLength; i++) {
                if (times[i] == -1)//-1 证明没有初始化过
                    continue;
                maxOld = times[maxOld] > times[i] ? i : maxOld;
            }

            this.values[maxOld] = -1;
            this.times[maxOld] = -1;
            size--;
        }

        this.values[key] = value;
        this.times[key] = System.currentTimeMillis();
        this.size ++;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)
