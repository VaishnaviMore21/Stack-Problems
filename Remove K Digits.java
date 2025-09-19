class Solution {
    public String removeKdig(String s, int k) {
        // code here
        int n=s.length();
        
         Deque<Character> stack = new ArrayDeque<>();
         for(int i=0;i<n;i++)
         {
             char c=s.charAt(i);
              while (!stack.isEmpty() && k > 0 && stack.peekLast() > c) 
              {
                stack.removeLast();
                k--;
              }
              
            if (!stack.isEmpty() || c != '0')
            {
                stack.addLast(c);
            }
            
         }
           // if removals left, remove from end
        while (k > 0 && !stack.isEmpty()) {
            stack.removeLast();
            k--;
        }
         // build result
        if (stack.isEmpty()) return "0";

        StringBuilder sb = new StringBuilder();
        for (char ch : stack) {
            sb.append(ch);
        }

        return sb.toString();
    }
}
