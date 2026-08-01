// import java.util.ArrayList;

class MinStack {
    ArrayList<Integer> arr;
    ArrayList<Integer> mini;

    public MinStack() {
        arr = new ArrayList<>();
        mini = new ArrayList<>();
    }

    public void push(int value) {
        arr.add(value);

        if (mini.isEmpty()) {
            mini.add(value);
        } else {
            mini.add(Math.min(mini.get(mini.size() - 1), value));
        }
    }

    public void pop() {
        if (!arr.isEmpty()) {
            arr.remove(arr.size() - 1);
            mini.remove(mini.size() - 1);
        }
    }

    public int top() {
        if (arr.isEmpty()) {
            return -1;   // or throw exception
        }
        return arr.get(arr.size() - 1);
    }

    public int getMin() {
        if (mini.isEmpty()) {
            return -1;   // or throw exception
        }
        return mini.get(mini.size() - 1);
    }
}