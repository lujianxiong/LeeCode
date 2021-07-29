package 入门算法;

/**
 * 题目：
 *      你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的
 *   版本开发的，所以错误的版本之后的所有版本都是错的。
 *      假设你有n个版本[1,2,...,n],你想找出导致之后所有版本出错的第一个错误的版本。
 *      你可以通过调用 bool isBadVersion(version)接口来判断版本号version是否在单元测试中出错。实现一个函数来查找第一个错误的
 *   版本。你应该尽量减少调用API的次数。
 */

/**
 * 思路：采用二分查找
 *      因为要求尽量减少调用检查接口的次数，所以不能每次都调用接口，应该将调用接口的次数降到最低。
 *      注意到一个性质：“每个版本都是基于之前的版本开发的，错误的版本之后的所有版本都是错的。”，那么当一个版本为正确版本，则
 *  该版本之前的所有版本均为正确版本；当一个版本为错误版本，则该版本之后的所有版本均为错误版本。我们可以利用这个性质进行二分查找。
 *      具体地，将左右边界分别初始化为1和n，n是给定的版本数量。
 *      我们每判断一次都可以缩小一次边界，而每次缩紧边界时，边界的距离将变为原来的一半，因此我们至多只需要缩紧O(log n)次
 */

public class 二七八_第一个错误的版本 {

    public static void main(String[] args) {

    }



    //判断错误版本的接口方法
    public static boolean isBadVersion(int x){
        if (x  == 3) return true;
        return false;
    }

    /**
     * 寻找n个版本中第一个错误的版本
     * @param n 版本数量
     * @return  返回第一个错误的版本是第几版本
     */
    public static int firstBadVersion(int n){
        //初始化指针
        int left = 1;
        int right = n;
        while (left < right){ //循环至左右端点都相同
            int mid = left + (right - left)/2;  //计算中间值（并防止计算时溢出）
            if (isBadVersion(mid)){
                right = mid;    //如果mid是错误版本，那么答案在【left，mid】中
            }else {
                left = mid;//如哦mid是正确版本，那么答案在【mid+1，right】中 （这里+1是因为我们找的是错误版本）
            }
        }
        //此时left = right = mid，区间缩为一个点，即为答案
        return left;
    }
}
