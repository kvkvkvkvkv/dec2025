class Solution {
    public String mergeAlternately(String word1, String word2) {
        
        int l = 0;
        StringBuilder sb = new StringBuilder();
        while(l<word1.length() || l<word2.length()) {

            if(l<word1.length()) {
                sb.append(word1.charAt(l));
            }

            if(l<word2.length()) {
                sb.append(word2.charAt(l));
            }
            l++;
        }

        return sb.toString();
    }
}