// s:n
class ExamRoom {
    private int size;
    private TreeSet<Integer> set;
    // t:1
    public ExamRoom(int N) {
        size = N;
        set = new TreeSet<>();
    }
    // t:n
    public int seat() {
        if (set.isEmpty()) {
            set.add(0);
            return 0;
        }
        if (set.size()==1) {
            int index = set.first();
            if (size-1-index > index) {
                set.add(size-1);
                return size-1;
            }
            set.add(0);
            return 0;
        }
        Iterator<Integer> iter = set.iterator();
        int left = iter.next();
        int right = iter.next();
        int dis = (right-left)/2;
        int pos = left + dis;
        while (iter.hasNext()) {
            left = right;
            right = iter.next();
            if ((right-left)/2 > dis) {
                dis = (right-left)/2;
                pos = left+dis;
            }
        }
        if (size-1-set.last() > dis) {
            dis = size-1-set.last();
            pos = size-1;
        }
        if (set.first() >= dis) {
            pos = 0;
        }
        set.add(pos);
        return pos;
    }
    // t:logn
    public void leave(int p) {
        set.remove(p);
    }
}

// s:n
class ExamRoom {
    class Range {
        int start;
        int end;
        int dist;
        
        Range(int start, int end) {
            this.start = start;
            this.end = end;
            if (start==-1) {
                dist = end;
            } else if (end==n) {
                dist = n-1-start;
            } else {
                dist = (end-start)/2;
            }
        }
    }
    
    private int n;
    private PriorityQueue<Range> pq;
    // t:1
    public ExamRoom(int N) {
        n = N;
        pq = new PriorityQueue<>( (a,b) -> a.dist==b.dist ? a.start-b.start : b.dist-a.dist);
        pq.offer(new Range(-1, n));
    }
    // t:logn
    public int seat() {
        int res = 0;
        Range range = pq.poll();
        if (range.start==-1) res = 0;
        else if (range.end==n) res = n-1;
        else res = range.start + range.dist;
        pq.offer(new Range(range.start, res));
        pq.offer(new Range(res, range.end));
        return res;
    }
    // t:n
    public void leave(int p) {
        Range head = null;
        Range tail = null;
        for (Range range : pq) {
            if (range.start == p) tail = range;
            if (range.end == p) head = range;
            if (head!=null && tail!=null) break;
        }
        pq.remove(head);
        pq.remove(tail);
        pq.offer(new Range(head.start, tail.end));
    }
}

// s:n
class ExamRoom {
    private int n;
    private List<Integer> list;

    public ExamRoom(int N) {
        n = N;
        list = new ArrayList<>();
    }
    //t:n
    public int seat() {
        if (list.size()==0) {
            list.add(0);
            return 0;
        }
        int distance = list.get(0);
        int pos = 0;
        int index = 0;
        for (int i=0; i<list.size()-1; i++) {
            int currDis = (list.get(i+1)-list.get(i))/2;
            if (currDis > distance) {
                distance = currDis;
                pos = list.get(i) + distance;
                index = i+1;
            }
        }
        if (n-1-list.get(list.size()-1) > distance) {
            pos = n-1;
            index = list.size();
        }
        list.add(index, pos);
        return pos;
    }
    // t:n
    public void leave(int p) {
        for (int i=0; i<list.size(); i++) {
            if (list.get(i)==p) {
                list.remove(i);
                return;
            }
        }
    }
}