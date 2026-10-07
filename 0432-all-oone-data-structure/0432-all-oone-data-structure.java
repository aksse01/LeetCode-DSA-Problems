class AllOne {

    // A bucket: all keys inside have exactly the same count
    private static class Node {
        int count;
        Set<String> keys = new HashSet<>();
        Node prev;
        Node next;

        Node(int count) {
            this.count = count;
        }

        // Insert newNode right after "this" and return it
        Node insertAfter(Node newNode) {
            newNode.prev = this;
            newNode.next = this.next;
            this.next.prev = newNode;
            this.next = newNode;
            return newNode;
        }

        // Unlink "this" from the list
        void remove() {
            this.prev.next = this.next;
            this.next.prev = this.prev;
        }
    }

    private final Node head;                    // dummy, smaller than any real count
    private final Node tail;                    // dummy, larger than any real count
    private final Map<String, Node> keyToNode; // key -> bucket it lives in

    public AllOne() {
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
        keyToNode = new HashMap<>();
    }

    public void inc(String key) {
        Node curr = keyToNode.get(key);

        if (curr == null) {
            // New key -> goes to count 1
            Node target = head.next;
            if (target == tail || target.count > 1) {
                target = head.insertAfter(new Node(1));
            }
            target.keys.add(key);
            keyToNode.put(key, target);
        } else {
            // Existing key -> move to count + 1
            int nextCount = curr.count + 1;
            Node target = curr.next;
            if (target == tail || target.count != nextCount) {
                target = curr.insertAfter(new Node(nextCount));
            }
            target.keys.add(key);
            keyToNode.put(key, target);

            curr.keys.remove(key);
            if (curr.keys.isEmpty()) {
                curr.remove();
            }
        }
    }

    public void dec(String key) {
        Node curr = keyToNode.get(key);
        if (curr == null) return;

        curr.keys.remove(key);

        if (curr.count == 1) {
            // Count would hit 0 -> forget the key
            keyToNode.remove(key);
        } else {
            // Move to count - 1
            int prevCount = curr.count - 1;
            Node target = curr.prev;
            if (target == head || target.count != prevCount) {
                target = target.insertAfter(new Node(prevCount));
            }
            target.keys.add(key);
            keyToNode.put(key, target);
        }

        if (curr.keys.isEmpty()) {
            curr.remove();
        }
    }

    public String getMaxKey() {
        return tail.prev == head ? "" : tail.prev.keys.iterator().next();
    }

    public String getMinKey() {
        return head.next == tail ? "" : head.next.keys.iterator().next();
    }
}