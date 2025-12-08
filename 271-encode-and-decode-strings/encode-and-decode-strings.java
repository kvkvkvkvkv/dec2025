public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuffer sb = new StringBuffer();
        for(String ele:strs) {
            sb.append("#");
            sb.append(ele.length());
            sb.append("#");
            sb.append(ele);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> temp = new ArrayList();
        if(s.length()==0) {
            return temp;
        }

        int n = s.length();
        int index = 0;
        while(index<n) {
            int start = index+1;
            int num = 0;
            while(s.charAt(start)!='#') {
                num = num*10+(s.charAt(start)-'0');
                start++;
            }
            index = start+num+1;
            String val = s.substring(start+1,start+num+1);
            temp.add(val);
        }
        return temp;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));