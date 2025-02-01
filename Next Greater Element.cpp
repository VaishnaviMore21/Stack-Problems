

// } Driver Code Ends
class Solution {
  public:
    // Function to find the next greater element for each element of the array.
    vector<int> nextLargerElement(vector<int>& arr) {
        // code here
        int n=arr.size();
        stack<int>st;
        vector<int>res(n);
        for(int i=n-1;i>=0;i--)
        {
            int currval=arr[i];
            while(!st.empty() && st.top()<=currval)
            {
                st.pop();
            }
            res[i]=st.empty()?-1:st.top();
            st.push(currval);
        }
        return res;
    }
};

