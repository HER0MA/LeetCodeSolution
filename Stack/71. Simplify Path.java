// t:n s:n
class Solution {
    public String simplifyPath(String path) {
        String[] nodes = path.split("/+");
        Stack<String> stack = new Stack<>();
        for (String node : nodes) {
            if (node.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!node.equals(".") && !node.equals("")) {
                stack.push(node);
            }
        }
        String res = "";
        while (!stack.isEmpty()) {
            res = "/" + stack.pop() + res;
        }
        if (res.length() == 0) return "/";
        return res;
    }
}