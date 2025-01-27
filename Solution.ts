
function subarraySum(input: number[]): number {
    let subarraySum = 0;
    const prefixSum = [...input];

    for (let i = 0; i < input.length; ++i) {
        const cutIndexForPrefixSum = getStartIndexForCurrentSubarray(i, input[i]) - 1;
        prefixSum[i] += i > 0 ? prefixSum[i - 1] : 0;
        const cutValueForPrefixSum = cutIndexForPrefixSum >= 0 ? prefixSum[cutIndexForPrefixSum] : 0;
        subarraySum += prefixSum[i] - cutValueForPrefixSum;
    }

    return subarraySum;
};

function getStartIndexForCurrentSubarray(currentIndex: number, currentValue: number): number {
    return Math.max(0, currentIndex - currentValue);
}
