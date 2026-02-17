class Solution {
    public boolean isPalindrome(String s) {
         s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        s = s.replace(" ","").replace(",","");
        String k = new StringBuilder(s).reverse().toString();
        return  s.equals(k);
        }
    }