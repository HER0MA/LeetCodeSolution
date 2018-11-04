// t:n s:1
class Solution {
    private static Map<Character, Character> map;
    
    static {
        map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');
    }
    
    public boolean isStrobogrammatic(String num) {
        if (nums==null || nums.length()==0) return true;
        int left = 0, right = num.length() - 1;
        while (left <= right) {
            if (!map.containsKey(num.charAt(left))) return false;
            if (map.get(num.charAt(left)) != num.charAt(right)) return false;
            left ++;
            right --;
        }
        return true;
    }
}

class Solution {
    public boolean isStrobogrammatic(String nums) {
        if (nums==null || nums.length()==0) return true;
        int left = 0;
        int right = nums.length()-1;
        while (left<=right) {
            if (nums.charAt(left)=='6') {
                if (nums.charAt(right)!='9') return false;
            } else if (nums.charAt(left)=='9') {
                if (nums.charAt(right)!='6') return false;
            } else if (nums.charAt(left)=='1' || nums.charAt(left)=='8' || nums.charAt(left)=='0') {
                if (nums.charAt(right)!=nums.charAt(left)) return false;
            } else {
                return false;
            }
            left ++;
            right --;
        }
        return true;
    }
}