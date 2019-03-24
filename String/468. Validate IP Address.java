// t:n s:1
class Solution {
    public String validIPAddress(String IP) {
        if (isIPv4(IP)) return "IPv4";
        if (isIPv6(IP)) return "IPv6";
        return "Neither";
    }
    
    private boolean isIPv4(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '.') {
                count++;
            } else if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        if (count != 3) return false;
        String[] fields = s.split("\\.");
        if (fields.length != 4) return false;
        for (String field : fields) {
            if (field.length() > 3 || field.length() == 0 || 
                field.charAt(0) == '0' && field.length() != 1) return false;
            int num = Integer.valueOf(field);
            if (num > 255) return false;
        }
        return true;
    }
    
    private boolean isIPv6(String s) {
        s = s.toLowerCase();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ':') {
                count++;
            } else if (!(Character.isDigit(s.charAt(i)) 
                    || s.charAt(i) >= 'a' && s.charAt(i) <= 'f')) {
                return false;
            }
        }
        if (count != 7) return false;
        String[] fields = s.split(":");
        if (fields.length != 8) return false;
        for (String field : fields) {
            if (field.length() > 4 || field.length() == 0) return false;
        }
        return true;
    }
}