package exer.test;

/**
 * @author TJ
 * @create 2021-05-24  1:20
 */
public class test {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2};
        int i = 0;
        while(i < nums.length) {
            if(nums[i] == i) {
                i++;
                continue;
            }
            if(nums[nums[i]] == nums[i]) {
                System.out.println(nums[i]);
                break;
            }
            int tmp = nums[i];//  tmp= 1
            nums[i] = nums[tmp];//2 2 2
            nums[tmp] = tmp;//2 1 2
        }
    }
}
