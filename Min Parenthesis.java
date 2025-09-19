class Solution {
    public int minParentheses(String s) {
        // code here
        Stack<Character>st=new Stack<>();
         
         for(int i=0;i<s.length();i++)
         
         {
                char ch = s.charAt(i);
             if(!st.isEmpty())
             {
                 if(ch=='(')
                 {
                     st.push(ch);
                 }
                 else if(ch==')')
                 {
                     st.pop();
                 }
                 else 
                 {
                      st.push(ch);
                 }
             }
             else
             {
                  st.push(ch);
             }
         }
         return st.size();
    }
}
