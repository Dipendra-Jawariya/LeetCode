class MinStack {
    Stack<Integer> ms;
    Stack<Integer> as;
    public MinStack() {
        ms = new Stack<>();
        as = new Stack<>();
    }
    
    public void push(int val) {
        if(as.isEmpty()){
            ms.add(val);
            as.add(val);
            return;
        }
            ms.push(val);
            if(as.peek()>=val){
                as.add(val);
            }
    }
    
    public void pop() {
        if(ms.peek().equals(as.peek())){
            as.pop();
        }
        ms.pop();
    }
    
    public int top() {
        return ms.peek();
    }
    
    public int getMin() {
        return as.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */