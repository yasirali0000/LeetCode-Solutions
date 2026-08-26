class MinStack {
    Stack<Long> st;
    long min;
    public MinStack() {
        st = new Stack<>();
        min = Long.MAX_VALUE;
    }
    public void push(int val) {
        if(st.size() == 0) min = (long)val;
        if(val>=min) st.push((long)val);
        else {
            st.push((long)val + ((long)val-min));
            min = val;
        }   
    }
    public void pop() {
        if(st.peek()<min) min = min+(min-st.peek());
        st.pop();
    }
    public int top() {
        long a = st.peek();
        if(a<min) return (int)min;
        else return (int)a;
    }
    public int getMin() {
        return (int)min;
    }
}

// class MinStack {
    // Stack<Integer> st;
    // Stack<Integer> minst;
//     public MinStack() {
        // st = new Stack<>();
        // minst = new Stack<>();
//     }

//     public void push(int val) {
//         st.push(val);
//         if(minst.size() == 0 || val<minst.peek()) minst.push(val);
//         else minst.push(minst.peek());
//     }

//     public void pop() {
//         st.pop();
//         minst.pop();
//     }

//     public int top() {
//         return st.peek();
//     }

//     public int getMin() {
//         return minst.peek();
//     }
// }