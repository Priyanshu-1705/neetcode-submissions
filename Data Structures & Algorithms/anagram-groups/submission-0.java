class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String word : strs){
            int[] count = new int[26];
            for(char ch : word.toCharArray()){
                count[ch - 'a']++;
            }
            StringBuilder key = new StringBuilder();
            for(int i = 0; i < 26; i++){
                key.append(count[i]).append('#');
            }
            map.putIfAbsent(key.toString(), new ArrayList<>());
            map.get(key.toString()).add(word);
        }
        return new ArrayList<>(map.values());
    }
}
