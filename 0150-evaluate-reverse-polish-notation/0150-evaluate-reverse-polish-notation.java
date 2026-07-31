class Solution {
    public int evalRPN(String[] tokens) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (String el : tokens) {
            switch (el) {
                case "+": {
                    stack.push(stack.pop() + stack.pop());
                    break;
                }

                case "-": {
                    int first = stack.pop();
                    stack.push(stack.pop() - first);
                    break;
                }

                case "*": {
                    stack.push(stack.pop() * stack.pop());
                    break;
                }

                case "/": {
                    int first = stack.pop();
                    stack.push(stack.pop() / first);
                    break;
                }

                default: {
                    stack.push(Integer.parseInt(el));
                }
            }
        }

        return stack.pop();
    }
}