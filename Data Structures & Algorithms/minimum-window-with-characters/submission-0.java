class Solution {
    public String minWindow(String s, String t) {
        int[] freq = new int[128];
        // What characters do we need?
        for (char ch : t.toCharArray()) {
            freq[ch]++;
        }
        int left = 0;
        int count = t.length();
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            // We found a character that we needed
            if (freq[ch] > 0) {
                count--;
            }
            // Use this character
            freq[ch]--;
            // Window is valid
            while (count == 0) {
                // Save the smallest window
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }
                // Remove left character
                char leftChar = s.charAt(left);
                freq[leftChar]++;
                // We now need this character again
                if (freq[leftChar] > 0) {
                    count++;
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE
                ? ""
                : s.substring(start, start + minLen);
    }
}