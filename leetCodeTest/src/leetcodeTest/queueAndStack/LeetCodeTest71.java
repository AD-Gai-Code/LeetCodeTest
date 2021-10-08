package leetcodeTest.queueAndStack;

import java.util.Stack;

public class LeetCodeTest71 {
    public static void main(String[] args) {
        String path = "/../";
        String res = simplifyPath(path);
        System.out.println(res);
    }

    public static String simplifyPath(String path) {
        String[] paths = path.trim().split("/");
        Stack<String> stack = new Stack<>();
        for(String s : paths){
            if(s.equals(".") || s.equals("")){
                continue;
            } else if (s.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                    stack.pop();
                }
            } else {
                stack.push(s);
                stack.push("/");
            }
        }
        StringBuffer res = new StringBuffer("/");
        if(stack.isEmpty()){
            return res.toString();
        }
        while(stack.peek().equals("/") && !stack.isEmpty()){
            stack.pop();
        }
        for(String s : stack){
            res.append(s);
        }
        return res.toString().equals(" ") ? "/" : res.toString();
    }
}
