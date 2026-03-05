class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int c1 = 0;
        int c2 =0;
        int n1 = Integer.MIN_VALUE;
        int n2 = Integer.MIN_VALUE;

        for(int ele:nums) {

            if(n1 == ele) {
                c1++;
            } else if(n2 == ele) {
                c2++;
            } else if(c1 == 0) {
                n1 = ele;
                c1++;
            } else if(c2 == 0) {
                n2 = ele;
                c2++;
            } else {
                c1--;
                c2--;
            }
        }

        List<Integer> ans = new ArrayList<>();
        c1=0;
        c2 = 0;
        for(int ele:nums) {
            if(n1 == ele) {
                c1++;
            }
            if(n2 == ele) {
                c2++;
            }
        }
        if(c1 > nums.length/3) {
            ans.add(n1);
        } 

        if(c2 > nums.length/3) {
            ans.add(n2);
        } 

        return ans;
    }
}