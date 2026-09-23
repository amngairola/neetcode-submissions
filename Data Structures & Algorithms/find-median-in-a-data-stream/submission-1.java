class MedianFinder {
    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;

    public MedianFinder() {
        max = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        min = new PriorityQueue<>((a, b) -> Integer.compare(a, b));
    }

    public void addNum(int num) {
        if (max.isEmpty() || num <= max.peek()) {
            max.offer(num);
        } else {
            min.offer(num);
        }

        if (max.size() > min.size() + 1) {
            min.offer(max.poll());
        } else if (min.size() > max.size()) {
            max.offer(min.poll());
        }
    }

    public double findMedian() {
        if (min.size() == max.size()) {
            return ((double) max.peek() + min.peek()) / 2;
        }

        return max.peek();
    }
}
