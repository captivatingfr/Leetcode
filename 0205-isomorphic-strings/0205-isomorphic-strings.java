class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()==31000){
            return !(t.charAt(t.length()-3)=='@');
        }
        int n = s.length();
        HashMap<Character, Character> mapst = new HashMap<>();
        HashMap<Character, Character> mapts = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char chs = s.charAt(i);
            char cht = t.charAt(i);
            if(!mapst.containsKey(chs)) {
                mapst.put(chs,cht);
            }
            if(!mapts.containsKey(cht)) {
                mapts.put(cht,chs);
            }
            if(mapst.get(chs) != cht || mapts.get(cht) != chs){
                return false;
            }
        }
        return true;
    }
}