package 入门算法;

/**
 * 题目：
 *      给定一个n个元素有序的(升序)整型数组nums和一个目标值target，写一个函数搜索nums中的target，如果目标值存在返回下标，否则返回-1
 */

/**
 * 二分查找：
 *     二分查找是一种基于比较目标值和数组中间元素的教科书式算法。
 *     · 如果目标值等于中间元素，则找到目标值
 *     · 如果目标值较小，继续往左侧搜索
 *     · 如果目标值较大，继续往右侧搜索
 */

public class 七零四_二分查找 {
    public static void main(String[] args) {

    }

    public static int search(int[] nums, int target){
        //初始化指针
        int pivot;  //pivot是中心点的意思
        int left = 0;  //左指针
        int right = nums.length - 1;  //右指针

        while (left <= right){
            pivot = left + (right - left)/2;
            if (target == nums[pivot]){
                return pivot;
            }
            if (target < nums[pivot]){
                right = pivot - 1;
            }else {
                left = pivot + 1;
            }
        }
        return -1;
    }

}
