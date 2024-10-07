class MinStack {

    private int min;
    private int top;
    private int[] stack;

    public MinStack() {
        this.top = -1;
        this.min = 0;
        this.stack = new int[30000];
    }
    
    public void push(int val) {
        this.stack[++top] = val;
        if(top == 0){
            this.min = val;
            return;
        }
        if(val < this.min) {
            this.min = val;
        }
    }
    
    public void pop() {
        if(top == 0) {
            this.top--;
            return;
        }
        if(top > 0) {
            this.top--;
        }
        if(this.stack[this.top+1] == this.min) {
            this.min = Integer.MAX_VALUE;
            for(int i=0; i<=top; i++) {
                this.min = Math.min(this.min, this.stack[i]);
            }
        }
        
    }
    
    public int top() {
        return this.stack[top];
    }
    
    public int getMin() {
        return this.min;
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