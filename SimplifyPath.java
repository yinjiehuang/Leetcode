// Leetcode: Simplify Path
// Author: Yinjie Huang
// Date: 12/03/2014
//
import java.util.*;

public class SimplifyPath {
        public static void main(String[] args) {
                System.out.println("Leetcode: Simplify Path!!!");
                SimplifyPath sp = new SimplifyPath();
                String s1 = "/home/";
                String s2 = "/a/./b/../../c/";
                String s3 = "/../";
                String s4 = "/home//foo/";

                System.out.println(sp.simplifyPath(s1));
                System.out.println(sp.simplifyPath(s2));
                System.out.println(sp.simplifyPath(s3));
                System.out.println(sp.simplifyPath(s4));
        }
        
        public String simplifyPath(String path) {
                if (path == null || path.length() == 0) {
                        return path;
                }
                // First, we need a stack
                // Shit, I never know I could use split function...
                String[] strs = path.split("/");
                LinkedList<String> stack = new LinkedList<String>();
                for (String s : strs) {
                        if (s.equals(".") || s.equals("")) {
                                continue;
                        } else if (s.equals("..")) {
                                if (!stack.isEmpty()) {
                                        stack.pop();
                                }
                        } else {
                                stack.push(s);
                        }
                }
                if (stack.isEmpty()) {
                        return "/";
                }
                String res = "/";
                while (!stack.isEmpty()) {
                        res += stack.removeLast() + "/";
                }
                return res.substring(0, res.length() - 1);
        }
}
