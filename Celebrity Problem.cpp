

class Solution {
    // Function to find if there is a celebrity in the party or not.
    public int celebrity(int mat[][]) {
        int n = mat.length; // Correct way to get the size of the matrix
        int top = 0, down = n - 1;

        // Find potential celebrity
        while (top < down) {
            if (mat[top][down] == 1) {
                // Top knows Down, so Top cannot be a celebrity
                top++;
            } else {
                // Down cannot be a celebrity
                down--;
            }
        }

        int candidate = top;

        // Verify if the candidate is a celebrity
        for (int i = 0; i < n; i++) {
            if (i != candidate) {
                // A celebrity should be known by everyone and should know no one
                if (mat[candidate][i] == 1 || mat[i][candidate] == 0) {
                    return -1;
                }
            }
        }

        return candidate;
    }
}

