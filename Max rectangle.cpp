class Solution {
public:
int getMaxArea(vector<int>& arr) {
    int n = arr.size();
    stack<int> s;
    int res = 0;
    int tp, curr;
    for (int i = 0; i < n; i++) {      
         
        while (!s.empty() && arr[s.top()] >= arr[i]) {
          
            // The popped item is to be considered as the 
            // smallest element of the histogram
            tp = s.top(); 
            s.pop();
          
            // For the popped item previous smaller element is 
            // just below it in the stack (or current stack top)
            // and next smaller element is i
            int width = s.empty() ? i : i - s.top() - 1;
          
            res = max(res,  arr[tp] * width);
        }
        s.push(i);
    }

    // For the remaining items in the stack, next smaller does
    // not exist. Previous smaller is the item just below in
    // stack.
    while (!s.empty()) {
        tp = s.top(); s.pop();
        curr = arr[tp] * (s.empty() ? n : n - s.top() - 1);
        res = max(res, curr);
    }

    return res;
}
     int maximalRectangle(vector<vector<char>>& mat) 
     {
    int n = mat.size(), m = mat[0].size();
    
    // Array to store matrix 
    // as a histogram.
    vector<int> arr(m, 0);
    
    int ans = 0;
    
    // Traverse row by row.
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (mat[i][j] == '1') {  // Compare with character '1'
                arr[j]++;
            } else {
                arr[j] = 0;
            }
        }
        
        ans = max(ans, getMaxArea(arr));
    }
    
    return ans;
}

};
