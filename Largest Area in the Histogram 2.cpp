class Solution {
public:

 // Function to find next smaller for every element
vector<int> nextSmaller(vector<int>& hist) {
    int n = hist.size();
  
    // Initialize with n for the cases when next smaller
    // does not exist
    vector<int> nextS(n, n);
  
    stack<int> st;
 
    // Traverse all array elements from left to right
    for (int i = 0; i < n; ++i) {
        while (!st.empty() && hist[i] < hist[st.top()]) {

            // Setting the index of the next smaller element
            // for the top of the stack
            nextS[st.top()] = i;
            st.pop();
        }
        st.push(i);
    }
    return nextS;
}

// Function to find previous smaller for every element
vector<int> prevSmaller(vector<int>& hist) {
    int n = hist.size();
  
    // Initialize with -1 for the cases when prev smaller
    // does not exist
    vector<int> prevS(n, -1);
  
    stack<int> st;
 
    // Traverse all array elements from left to right
    for (int i = 0; i < n; ++i) {
        while (!st.empty() && hist[i] < hist[st.top()]) {

            // Setting the index of the previous smaller element
            //  for the top of the stack
            st.pop();
        }
        if (!st.empty()) {
            prevS[i] = st.top();
        }
        st.push(i);
    }
    return prevS;
}


    int largestRectangleArea(vector<int>& heights) {
        vector<int>prevS=prevSmaller(heights);
        vector<int>nextS=nextSmaller(heights);
        int maxArea=0;
         for (int i = 0; i < heights.size(); ++i) {
        int width = nextS[i] - prevS[i] - 1; 
        int area = heights[i] * width;          
        maxArea = max(maxArea, area);        
    }
    
    return maxArea;
    }

    
};
