import java.util.HashMap;
import java.util.Map;

/**题目：
 *     给定一个整数数组nums和一个整数目标值target，请你在该数组中找出和为目标值target的那两个整数，并返回他们的数组下标
 */

public class 一_两数之和 {
    public static void main(String[] args) {
        int[] a = {99,22,12,56,32,88,102,2,6,7,0};
        int[] results = twoSum2(a, 120);
        for(int i=0; i<results.length; i++){
            System.out.print(results[i]+" ");
        }

    }

    public static int[] twoSum1(int[] nums, int target){
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                if(nums[i]+nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[0];
    }

    public static int[] twoSum2(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();  //map的key存的是数组的值，map的value存的是数组的索引
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(target - nums[i])){   //如果map中存在键和当前索引i处的值相加为target
                return new int[]{map.get(target - nums[i]),i};  //那么返回：map的键target-nums[i]的value和索引i
            }
            map.put(nums[i],i);  //如果map中没有满足条件的，则将当前索引处的元素存入map中
        }
        return new int[0];
    }


}
