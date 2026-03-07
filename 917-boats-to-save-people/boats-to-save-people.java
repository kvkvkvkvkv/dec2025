class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int l = 0;
        int r = people.length-1;
        int boat = 0;
        int sum = 0;
        while(l<=r) {
            sum = people[l] + people[r];
            if(sum <= limit) {
                boat++;
                l++;
                r--;
            } else if(sum>limit) {
                r--;
                boat++;
            }
        }
        return boat;
    }
}