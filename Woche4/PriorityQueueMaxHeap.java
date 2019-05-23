import java.util.ArrayList;

public class PriorityQueueMaxHeap<K extends Comparable<K>> implements PriorityQueue {
    ArrayList<K> list = new ArrayList<K>();
    
    PriorityQueueMaxHeap(K[] list) {
        for (int i = 0; i < list.length; i++) {
            this.list.add(list[i]);
            for (int j = list.length / 2; j >= 0; j--) {
                heapify(j);
            }
        }
    }
    
    public void heapify(int i) {
        int left = i;
        int right = i + 1;
        int top = 0;
        
        if (left < list.size() && list.get(left).compareTo(list.get(i)) > 0) {
            top = left;
        } else {
            top = i;
        }
        if (left < list.size() && list.get(right).compareTo(list.get(top)) > 0) {
            top = right;
        }
        
        if (top != i) {
            K swap = list.get(i);
            list.add(i, list.get(top));
            list.add(top, swap);
            heapify(top);
        }
    }
    
    @Override
    public void addElement(Comparable element) {
        list.add(0, (K) element);
        list.add(list.get(0));
        heapify(0);
    }
    
    @Override
    public K getFirst() {
        return list.get(0);
    }
    
    @Override
    public void deleteFirst() {
        list.remove(0);
        heapify(0);
    }
    
}
