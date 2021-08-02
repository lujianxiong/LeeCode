package 入门算法.二分查找;

/**
 * 题目：
 *      给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *      （请必须使用时间复杂度为O(log n)）的算法
 */

/**
 * 思路：
 *      注意：题目中说的是排序数组，那么就默认是顺序的。逆序的话这个算法没法玩。
 */

public class 三五_搜索插入位置 {

    public static void main(String[] args) {
        int[] nums = {};
    }


    public static int searchInsert(int[] nums, int target){
        int left = 0;  //左指针
        int right = nums.length - 1;  //右指针
        while (left <= right){
            int mid = left + (right - left) >>1;  //这里的>>1可以替换成/2
            if (nums[mid] < target){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return left;
    }
}
