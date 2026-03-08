class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // Map<Character,Integer> c1 = new HashMap<>();
        // Map<Character,Integer> c2 = new HashMap<>();

        // if(s1.length()>s2.length()) {
        //     return false;
        // }

        // for(char ele:s1.toCharArray()) {
        //     c1.put(ele, c1.getOrDefault(ele, 0)+1);
        // }

        // for(int i=0;i<s1.length();i++) {
        //     char ele = s2.charAt(i);
        //     c2.put(ele, c2.getOrDefault(ele, 0)+1);
        // }

        // for(int i=0;i<s2.length()-s1.length();i++) {
        //     if(c2.equals(c1)) {
        //         return true;
        //     }
        //     char ele = s2.charAt(i+s1.length());
        //     c2.put(ele, c2.getOrDefault(ele, 0)+1);
        //     c2.put(s2.charAt(i), c2.getOrDefault(s2.charAt(i), 0)-1);

        //     if (c2.get(s2.charAt(i))==0) {
        //         c2.remove(s2.charAt(i));
        //     }
        // }

        // if(c2.equals(c1)) {
        //     return true;
        // }

        int[] c1 = new int[26];
        int[] c2 = new int[26];

        if(s1.length()>s2.length()) {
            return false;
        }

        for(char ele:s1.toCharArray()) {
            c1[ele-'a']++;
        }

        for(int i=0;i<s1.length();i++) {
            char ele = s2.charAt(i);
            c2[ele-'a']++;
        }

        int count = 0;
        for(int i=0;i<26;i++) {
            if(c2[i] == c1[i]) {
                count++;
            }
        }

        for(int i=0;i<s2.length()-s1.length();i++) {
            char front = s2.charAt(i);
            char end = s2.charAt(i+s1.length());
            if(count == 26) {
                return true;
            }

            if(c2[front-'a'] == c1[front-'a']) {
                count--;
            } else if(c2[front-'a']-1 == c1[front-'a']) {
                count++;
            }
            c2[front-'a']--;
                

            if(c2[end-'a'] == c1[end-'a']) {
                count--;
            } else if(c2[end-'a']+1==c1[end-'a']) {
                count++;
            }
            c2[end-'a']++;

        }

        if(count == 26) {
            return true;
        }


        return false;
    }
}