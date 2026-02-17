class Solution {
    public String countAndSay(int n) {
        String s = "1";
        String k = "";

        for (int i = 2; i <= n; i++) {
            k = "";
            int count = 1;

            for (int j = 1; j < s.length(); j++) {

                if (s.charAt(j) == s.charAt(j - 1)) {
                    count++;
                } 
                else {
                    k = k + count + s.charAt(j - 1);
                    count = 1;
                }
            }
            if (s.length() > 0) {
                k = k + count + s.charAt(s.length() - 1);
            }

            s = k;
        }
        return s;
    }
}