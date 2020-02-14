import java.util.*;
public class Solution {
    public static void main(String args[]){
        int[] nums={2,7,11,15};
        int target = 9;
        int[] result = new Solution().twoSum(nums, target);
        System.out.println(Arrays.toString(result));
    }
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        for(int i = 0; i< len - 1 ; i++ ){
            for(int j =i+1 ; j< len; j++){
                if( (nums[i] +nums[j]) == target){
                    return new int[]{i,j};
                }
            }     
        }
        return new int[]{0,0};
    }
}
