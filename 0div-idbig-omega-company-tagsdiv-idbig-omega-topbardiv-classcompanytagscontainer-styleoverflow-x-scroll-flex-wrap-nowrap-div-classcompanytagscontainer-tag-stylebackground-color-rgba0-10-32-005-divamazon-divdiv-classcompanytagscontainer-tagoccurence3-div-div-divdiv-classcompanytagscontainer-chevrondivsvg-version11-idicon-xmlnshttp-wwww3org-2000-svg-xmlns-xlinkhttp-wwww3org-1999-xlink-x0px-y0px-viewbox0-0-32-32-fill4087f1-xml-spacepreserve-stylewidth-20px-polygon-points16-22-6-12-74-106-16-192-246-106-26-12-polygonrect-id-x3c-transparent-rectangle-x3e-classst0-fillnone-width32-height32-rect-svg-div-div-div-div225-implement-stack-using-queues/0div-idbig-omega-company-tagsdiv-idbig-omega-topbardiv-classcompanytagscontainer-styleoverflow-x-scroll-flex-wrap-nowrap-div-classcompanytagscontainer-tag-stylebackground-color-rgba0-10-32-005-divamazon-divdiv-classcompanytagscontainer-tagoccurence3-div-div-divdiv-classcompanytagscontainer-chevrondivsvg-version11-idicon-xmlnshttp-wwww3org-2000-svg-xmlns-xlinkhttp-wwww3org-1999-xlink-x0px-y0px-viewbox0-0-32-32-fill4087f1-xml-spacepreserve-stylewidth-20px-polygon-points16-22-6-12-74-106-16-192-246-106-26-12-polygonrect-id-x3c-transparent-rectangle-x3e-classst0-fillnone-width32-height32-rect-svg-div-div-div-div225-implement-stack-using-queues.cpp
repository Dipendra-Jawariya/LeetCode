class MyStack {
private:
    queue<int> q1;
    queue<int> q2;
public:
    MyStack() {}
    
    void push(int x) {
        // Add x --> q2
        q2.push(x);
        // q1 -> q2 (element by element)
        while(!q1.empty()) {
            q2.push(q1.front());
            q1.pop();
        }
        // swap q1 -> q2
        q1  = q2;
        while(!q2.empty()) {
            q2.pop();
        }
    }
    
    int pop() {
        int val = q1.front();
        q1.pop();
        return val;
    }
    
    int top() {
        return q1.front();
    }
    
    bool empty() {
        return q1.empty();
    }
};

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack* obj = new MyStack();
 * obj->push(x);
 * int param_2 = obj->pop();
 * int param_3 = obj->top();
 * bool param_4 = obj->empty();
 */