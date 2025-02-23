import java.util.Stack;

public class MaxDifference {
    public static int maxDifference(int[] arr) {
        int n = arr.length;
        int[] leftSmaller = new int[n];
        int[] rightSmaller = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Finding nearest smaller element to the left
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }
            leftSmaller[i] = stack.isEmpty() ? 0 : stack.peek();
            stack.push(arr[i]);
        }

        stack.clear();  // Reset stack for finding right smaller elements

        // Finding nearest smaller element to the right
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }
            rightSmaller[i] = stack.isEmpty() ? 0 : stack.peek();
            stack.push(arr[i]);
        }

        // Compute max absolute difference
        int maxDiff = 0;
        for (int i = 0; i < n; i++) {
            maxDiff = Math.max(maxDiff, Math.abs(leftSmaller[i] - rightSmaller[i]));
        }

        return maxDiff;
    }

    // Driver Code
    public static void main(String[] args) {
        int[] arr1 = {2, 1, 8};
        int[] arr2 = {2, 4, 8, 7, 7, 9, 3};

        System.out.println(maxDifference(arr1)); // Output: 1
        System.out.println(maxDifference(arr2)); // Output: 4
    }
}
