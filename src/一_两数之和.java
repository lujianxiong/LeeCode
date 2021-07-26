import java.util.HashMap;

/**题目：
 *  给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个整数，并返回它们的数组下标。
 （你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。）
 */

public class 一_两数之和 {
    public static void main(String args[]){
        int[] a = {1,2,3,4,5,6,7,8,9};
        int[] result = sum2(a,3);
        for(int i=0; i<result.length;i++){
            System.out.print(result[i]+",");
        }

    }

    /**
     * 在一个数组中寻找两数之和为target的数,并返回他们的下标
     * @param nums 在该数组中寻找两数
     * @param target  要寻找的两数和的目标值
     * @return
     */
    //1、暴力枚举法
    public static int[] sum1(int nums[], int target){
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                if (nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[0];
    }

    //2、哈希表
    public static int[] sum2(int nums[], int target){
        HashMap<Integer, Integer> map = new HashMap<>();  //key存的是索引处的值，value存的是索引

        for(int i=0; i<nums.length; i++){
            if (map.containsKey( target - nums[i]) ){
                return new int[]{i,map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }

        return new int[0];
    }

}
