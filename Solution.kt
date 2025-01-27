
import kotlin.math.max

class Solution {

    fun subarraySum(input: IntArray): Int {
        var subarraySum = 0
        val prefixSum = input.clone()

        for (i in input.indices) {
            val cutIndexForPrefixSum = getStartIndexForCurrentSubarray(i, input[i]) - 1
            prefixSum[i] += if (i > 0) prefixSum[i - 1] else 0
            val cutValueForPrefixSum = if (cutIndexForPrefixSum >= 0) prefixSum[cutIndexForPrefixSum] else 0
            subarraySum += prefixSum[i] - cutValueForPrefixSum
        }

        return subarraySum
    }

    private fun getStartIndexForCurrentSubarray(currentIndex: Int, currentValue: Int): Int {
        return max(0, currentIndex - currentValue)
    }
}
