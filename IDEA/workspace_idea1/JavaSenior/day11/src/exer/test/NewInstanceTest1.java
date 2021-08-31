package exer.test;

/**
 * @author TJ
 * @create 2021-05-19  17:36
 */
public class NewInstanceTest1 {
    public static void main(String[] args) {
        int a = 5%2;
        System.out.println(a);
    }
}
//class Solution {
//    public int majorityElement(int[] nums) {
//        if (nums.length == 1 || nums.length == 2) {
//            return nums[0];
//        } else {
//            Map<Integer, Integer> res = new HashMap<Integer, Integer>();
//            for (int i = 0; i < nums.length; i++) {
//                if (res.containsKey(nums[i])) {
//                    res.put(nums[i], (int) res.get(nums[i]) + 1);
//                    if (res.get(nums[i]) > nums.length / 2) {
//                        return nums[i];
//                    }
//                } else {
//                    res.put(nums[i], 1);
//                }
//            }
//        }
//    }
//}
