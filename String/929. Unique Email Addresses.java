// t:n s:n
class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            String[] parts = email.split("@");
            // regular expression: \+ means +
			// ^$()[]{}.?+*|
			// in java: \\ means \
            String prefix = parts[0].split("\\+")[0];
            set.add(prefix.replace(".", "") + "@" + parts[1]);
        }
        return set.size();
    }
}