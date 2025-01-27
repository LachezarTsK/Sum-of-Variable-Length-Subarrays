
using System;

public class Solution
{
    public int SubarraySum(int[] input)
    {
        int subarraySum = 0;
        int[] prefixSum = (int[])input.Clone();

        for (int i = 0; i < input.Length; ++i)
        {
            int cutIndexForPrefixSum = GetStartIndexForCurrentSubarray(i, input[i]) - 1;
            prefixSum[i] += i > 0 ? prefixSum[i - 1] : 0;
            int cutValueForPrefixSum = cutIndexForPrefixSum >= 0 ? prefixSum[cutIndexForPrefixSum] : 0;
            subarraySum += prefixSum[i] - cutValueForPrefixSum;
        }

        return subarraySum;
    }

    private int GetStartIndexForCurrentSubarray(int currentIndex, int currentValue)
    {
        return Math.Max(0, currentIndex - currentValue);
    }
}
