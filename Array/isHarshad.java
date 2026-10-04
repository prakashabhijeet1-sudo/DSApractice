class Solution {
    public boolean isHarshad(int n) {
        int original = n;
        int sum = 0;

        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }

        return original % sum == 0;
    }
}