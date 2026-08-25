class StockSpanner {

    Stack<Integer> st;
    ArrayList<Integer> arr;

    public StockSpanner() {
        st = new Stack<>();
        arr = new ArrayList<>();
    }

    public int next(int price) {

        arr.add(price);

        int i = arr.size() - 1;

        while (st.size() > 0 && arr.get(st.peek()) <= price) {
            st.pop();
        }

        int span;

        if (st.size() == 0) {
            span = i - (-1);
        } else {
            span = i - st.peek();
        }

        st.push(i);

        return span;
    }
}