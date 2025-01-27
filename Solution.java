
public class Solution {

    public int subarraySum(int[] input) {
        int subarraySum = 0;
        int[] prefixSum = input.clone();

        for (int i = 0; i < input.length; ++i) {
            int cutIndexForPrefixSum = getStartIndexForCurrentSubarray(i, input[i]) - 1;
            prefixSum[i] += (i > 0) ? prefixSum[i - 1] : 0;
            int cutValueForPrefixSum = cutIndexForPrefixSum >= 0 ? prefixSum[cutIndexForPrefixSum] : 0;
            subarraySum += prefixSum[i] - cutValueForPrefixSum;
        }

        return subarraySum;
    }

    private int getStartIndexForCurrentSubarray(int currentIndex, int currentValue) {
        return Math.max(0, currentIndex - currentValue);
    }
}
