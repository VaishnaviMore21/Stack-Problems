

// } Driver Code Ends
class Solution {
  public:
    // Function to calculate the span of stockâ€™s price for all n days.
    vector<int> calculateSpan(vector<int>& price) {
        // write code here
        int n=price.size();
        stack<int>st;
        vector<int>span(n);
        st.push(0);
        span[0]=1;
        for(int i=1;i<n;i++)
        {
            int currPrice=price[i];
            while(!st.empty() && currPrice>=price[st.top()])
            {
                st.pop();
            }
            if(st.empty())
            {
                span[i]=i+1;
            }
            else
            {
                span[i]=i-st.top();
            }
            st.push(i);
        }
        return span;
        
        
    }
};

