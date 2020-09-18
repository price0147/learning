package datastructure;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: wangxu
 * @date: 2020/8/31 11:29
 */
public class test {
    public static void main(String[] args) {
        int[] nums = new int[]{2,2,7,15};
        int[] ints = twoSum1(nums, 9);
        System.out.println(Arrays.toString(ints));
    }
    //正常算法
    public static int[] twoSum1(int[] nums, int target) {

        int[] reault = new int[2];
        out:for (int a = 0; a < nums.length - 1; a++) {
            for (int b = a + 1; b < nums.length; b++) {
                if ((nums[a] + nums[b]) == target) {
                    reault[0] = a;
                    reault[1] = b;
                    break out;
                }
            }
        }
        return reault;
    }
    //利用hash表
    public static int[] twoSum2(int[] nums, int target) {

        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i<nums.length;i++){
            map.put(nums[i],i);
            int complement = target - nums[i];
            if(map.containsKey(complement) && map.get(complement) != i){
                return new int[]{i,map.get(complement)};
            }

        }
        throw new RuntimeException("No two sum solution");
    }

}
