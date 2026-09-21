class Solution {
    public boolean isAnagram(String a, String b) {
        if(a.length() != b.length()) return false;
        HashMap<Character,Integer> amap = new HashMap<>();
        for(char ele : a.toCharArray()) {
            if(amap.containsKey(ele)) {
                int freq = amap.get(ele);
                amap.put(ele,freq+1);
            } else {
                amap.put(ele,1);
            }
        }
        HashMap<Character,Integer> bmap = new HashMap<>();
        for(char ele : b.toCharArray()) {
            if(!amap.containsKey(ele)) return false;
            if(bmap.containsKey(ele)) {
                int freq = bmap.get(ele);
                bmap.put(ele,freq+1);
            } else {
                bmap.put(ele,1);
            }
        }
        for(char ele : amap.keySet()) {
            int bfreq = bmap.getOrDefault(ele, 0);
            int afreq = amap.get(ele);
            if(afreq < bfreq) return false;
        }
        return true;
    }
}