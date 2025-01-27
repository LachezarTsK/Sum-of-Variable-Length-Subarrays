
#include <vector>
#include <algorithm>
using namespace std;

class Solution {

public:
    int subarraySum(const vector<int>& input) const {
        int subarraySum = 0;
        vector<int> prefixSum(input);

        for (int i = 0; i < input.size(); ++i) {
            int cutIndexForPrefixSum = getStartIndexForCurrentSubarray(i, input[i]) - 1;
            prefixSum[i] += i > 0 ? prefixSum[i - 1] : 0;
            int cutValueForPrefixSum = cutIndexForPrefixSum >= 0 ? prefixSum[cutIndexForPrefixSum] : 0;
            subarraySum += prefixSum[i] - cutValueForPrefixSum;
        }

        return subarraySum;
    }

private:
    int getStartIndexForCurrentSubarray(int currentIndex, int currentValue) const {
        return max(0, currentIndex - currentValue);
    }
};
