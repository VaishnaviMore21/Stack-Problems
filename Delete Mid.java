//{ Driver Code Starts
// Initial template for Java

import java.io.*;
import java.util.*;


// User function Template for Java

class Solution {
    // Function to delete middle element of a stack.
       public static void deleteMiddle(Stack<Integer> stack, int currentIndex, int middleIndex) {
        // Base case: If we reach the middle element, remove it
        if (currentIndex == middleIndex) {
            stack.pop();
            return;
        }

        // Pop the top element and store it
        int top = stack.pop();

        // Recursive call to remove the middle element
        deleteMiddle(stack, currentIndex + 1, middleIndex);

        // Push the element back (except the middle one)
        stack.push(top);
    }

    public static void deleteMid(Stack<Integer> stack) {
        int size = stack.size();
        int middleIndex = size / 2;  // 0-based indexing

        deleteMiddle(stack, 0, middleIndex);
    }
   
}
