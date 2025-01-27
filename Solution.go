
package main

import "slices"

func subarraySum(input []int) int {
    subarraySum := 0
    prefixSum := slices.Clone(input)

    for i := range input {
        cutIndexForPrefixSum := getStartIndexForCurrentSubarray(i, input[i]) - 1
        if i > 0 {
            prefixSum[i] += prefixSum[i-1]
        }

        cutValueForPrefixSum := 0
        if cutIndexForPrefixSum >= 0 {
            cutValueForPrefixSum = prefixSum[cutIndexForPrefixSum]
        }
        subarraySum += prefixSum[i] - cutValueForPrefixSum
    }

    return subarraySum
}

func getStartIndexForCurrentSubarray(currentIndex int, currentValue int) int {
    return max(0, currentIndex-currentValue)
}
