class Solution {
    public: int reverse(int x) {
        int n = x;
        long r = 0;
        while(n != 0) {
            r = r*10 + n%10;
            n = n/10;
        }
        return r > 2147483647L || r < -2147483648L ? 0 : (int)r;
    }
};