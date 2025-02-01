

// } Driver Code Ends
class MyStack {
  private:
    StackNode *top;

  public:
    void push(int x) {
        // code here
        StackNode* temp=new StackNode(x);
        temp->next=top;
        top=temp;
        
        
    }

    int pop() {
        // code here
         if (top == NULL) {
      return -1;
    }
    int topdata=top->data;
      StackNode* temp=top;
      top=top->next;
      delete temp;
    
      return topdata;
    
    }

    MyStack() { top = NULL; }
};
