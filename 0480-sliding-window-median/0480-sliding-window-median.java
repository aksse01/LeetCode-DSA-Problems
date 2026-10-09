class Solution {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    HashMap<Integer, Integer> map = new HashMap<>();
    int leftSize = 0;
    int rightSize = 0;
    /*
    One more thing: you may have noticed that we use the `leftSize` 
and`rightSize` variables. `leftSize` tracks the size of the max heap, while
 `rightSize` tracks the size of the median heap. Why can't we simply use 
the heap’s `size` function,
 and why do we maintain these sizes separately?
=====>>>>>
We employ lazy deletion, which means we do not remove an element 
immediately because removal from a heap costs O(n). Instead, 
we mark the element as deleted. To keep an accurate count of the undeleted
 elements, we maintain the two size variables. When the top element is 
marked for deletion, we remove it from the heap in O(log n) time.
    */

    public double[] medianSlidingWindow(int[] nums, int k) {
        int i = 0;
        int j = 0;
        int n = nums.length;
        int idx = 0;

        List<Double> ans = new ArrayList<>();

        while (j < nums.length) {

            add(nums[j]);

            if (j - i + 1 == k) {

                ans.add(getMedian());
                remove(nums[i]);
                i++;

            }
            j++;
        }
        double res[] = new double[ans.size()];
        for (double num : ans) {
            res[idx++] = num;
        }
        return res;

    }
    /*
What we are trying to do in the getMedian() function:
1. Prune both the max heap and the min heap to determine whether the top element of the max/min heap has already been discarded or marked as deleted.
2. The prune function removes such elements in O(log n) time.
3. Check whether the max heap and the min heap have the same size. If they do, the total number of elements is even, so we need the average of the two middle values. The max heap provides the smaller middle value, and the min heap provides the larger; we take their average.
4. If the total number of elements is odd, return the top of the max heap, because we keep the max heap with one more element than the min heap(i.e maxHeap contains the middle value).
*/
    double getMedian() {

        prune(maxHeap);
        prune(minHeap);

        if (leftSize == rightSize) {
            return ((long) maxHeap.peek() + (long) minHeap.peek()) / 2.0;
        }

        return (double) maxHeap.peek();
    }

    void add(int num) {
        if (maxHeap.isEmpty() || maxHeap.peek() >= num) {
            maxHeap.add(num);
            leftSize++;
        } else {
            minHeap.add(num);
            rightSize++;
        }

        balance();
        prune(maxHeap);
        prune(minHeap);

    }

    void remove(int num) {

        map.put(num, map.getOrDefault(num, 0) + 1);

        if (num <= maxHeap.peek()) {
            leftSize--;

            if (num == maxHeap.peek()) {
                prune(maxHeap);
            }

        } else {

            rightSize--;

            if (!minHeap.isEmpty() && num == minHeap.peek()) {
                prune(minHeap);
            }
        }

        balance();
    }

    void prune(PriorityQueue<Integer> pq) {
        while (!pq.isEmpty()) {
            int x = pq.peek();
            if (!map.containsKey(x)) {
                return;
            }
            pq.poll();
            map.put(x, map.get(x) - 1);
            if (map.get(x) == 0) {
                map.remove(x);
            }
        }
    }

    void balance() {
        while (leftSize > rightSize + 1) {
            minHeap.add(maxHeap.poll());
            leftSize--;
            rightSize++;
            prune(maxHeap);
        }

        while (leftSize < rightSize) {
            maxHeap.add(minHeap.poll());
            leftSize++;
            rightSize--;
            prune(minHeap);
        }
    }
}