package 入门算法.双指针;

import java.util.Arrays;

/**
 * 题目：
 *      给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序
 */

public class 九七七_有序数组的平方 {

    public static void main(String args[]){
        int[] num1 = {-9,-4,0,3,6,5};
        int[] square1 = sortedSquares1(num1);
        System.out.println(Arrays.toString(square1));

        int[] num2 = {-9,-4,0,3,5,6};
        int[] square2 = sortedSquares2(num2);
        System.out.println(Arrays.toString(square2));



    }


    //方法一：用java自带的类库直接排序  【方法一没有利用数组是按非递减顺序排序的，即数组是升序的这个条件】
    //时间复杂度：O(nlog n)，其中n是数组nums的长度          空间复杂度：O(log n)，除了存储答案的数组之外，我们需要O(log n)的栈空间进行排序
    public static int[] sortedSquares1(int[] nums){
        int[] sortnums = new int[nums.length];
        for (int i=0; i<nums.length; i++){
            sortnums[i] = nums[i] * nums[i];
        }
        Arrays.sort(sortnums);
        return sortnums;
    }



    //方法二：双指针
    /**
     * 算法思路：
     *      先找到数组nums中负数与非负数的分界线neg，那么数组平方后，nums[0]到nums[neg]是单调递减的，nums[neg+1]到nums[n-1]是
     * 单调递增的，使用归并的方法进行排序，两个指针分别指向neg和neg+1，每次比较两个指针对应的数，将小的放入新的数组中并移动指针
     */
    //negative 负数
    public static int[] sortedSquares2(int[] nums){
        int n = nums.length;
        int negative = -1;  //定义一个负数和非负数的分解点的指针，negative指向最大的负数
        for (int i=0; i<n; i++){  //从前往后遍历，如果当前数小于0，则将索引赋给negative
            if (nums[i] < 0){
                negative = i;
            } else {
                break;  //如果当前数不小于0了，就跳出循环。（因为数组是升序的）
            }
        }

        int[] ans = new int[n];
        int index = 0;  //新数组的索引，从0开始
        int i = negative;  //定义一个指针指向负数与非负数的分界处（负数）
        int j = negative + 1;  //定义一个指针指向非负数的开始处（包含0）
        while (i >= 0 || j < n){
            if (i < 0){
                ans[index] = nums[j] * nums[j];
                j++;
            }else if (j == n){
                ans[index] = nums[i] * nums[i];
                i--;
            }else if (nums[i]*nums[i] < nums[j]*nums[j]){
                ans[index] = nums[i] * nums[i];
                i--;
            } else{
                ans[index] = nums[j] * nums[j];
                j++;
            }
            index ++;  //每循环一次，就意味着将一个元素放到了新数组中，索引就就+1
        }
        return ans;
    }



    //方法三：双指针
    public static int[] sortedSquares3(int[] nums){



        return new int[0];
    }




}
