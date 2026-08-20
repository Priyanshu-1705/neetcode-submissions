class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length()){
            return false;
        }
        int[] freq1 = new int[26];
        int[] winFreq = new int[26];
        int k = s1.length();
        for(int i = 0; i < k; i++){
            freq1[s1.charAt(i) - 'a']++;
            winFreq[s2.charAt(i) - 'a']++;
        }
        if(Arrays.equals(freq1, winFreq)){
            return true;
        }
        for(int i = k; i < s2.length(); i++){
            winFreq[s2.charAt(i) - 'a']++;
            winFreq[s2.charAt(i - k) - 'a']--;
            if(Arrays.equals(freq1, winFreq)){
                return true;
            }
        }
        return false;
    }
}
