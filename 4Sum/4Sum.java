/*
 * Problem: 4Sum
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/4sum/description/
 * Language: java
 * Date: 2026-01-03
 */

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList();

        for(int l=0;l<nums.length;l++){
            if(l>0 && nums[l] == nums[l-1]){
                continue;
            }

            int h = nums.length-1;
            while(l<h){
                int midL = l+1;
                int midH = h-1;

                while(midL<midH){
                    long sum = (long)nums[l]+(long)nums[midL]+(long)nums[midH]+(long)nums[h];

                    if(sum == target){
                        ans.add(Arrays.asList(nums[l], nums[midL], nums[midH], nums[h]));
                        midL++;
                        midH--;
                        while(midL<midH && nums[midL] == nums[midL-1]){
                            midL++;
                        }
                        while(midL<midH && nums[midH] == nums[midH+1]){
                            midH--;
                        }
                    } else if(sum>target){
                        midH--;
                    } else{
                        midL++;
                    }
                } 
                h--;
                while(l<h && h<nums.length-1 && nums[h] == nums[h+1]){
                    h--;
                }
            }
        }
        return ans;
    }
}
