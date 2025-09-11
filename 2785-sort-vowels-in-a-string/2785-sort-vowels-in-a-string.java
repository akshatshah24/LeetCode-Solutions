class Solution {
    public String sortVowels(String s) {
        int[] vowelCount = new int[11];
        int[] vowelIndex = new int[128];
        char[] result = s.toCharArray();
        char[] charMap = "AEIOUaeiou".toCharArray();

        for (int i = 0; i < charMap.length; i++) {
            vowelIndex[charMap[i]] = i + 1;
        }

        for (char c : result) {
            vowelCount[vowelIndex[c]]++;
        }

        int j = 1;
        int i = 0;

        while (j < vowelCount.length) {
            if (vowelCount[j] > 0) {
                while (i < result.length) {
                    if (vowelIndex[result[i]] == 0) {
                        i++;
                        continue;
                    }
                    vowelCount[j]--;
                    result[i++] = charMap[j - 1];
                    break;
                }
            } else {
                j++;
            }
        }
        return new String(result);
    }
}