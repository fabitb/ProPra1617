package HeadList;

public class HeadList {

    Entry head;

    //constructor empty HeadList
    public HeadList() {
        head = null;
    }

    /**
     * Appends a new element with value info to the end of this list (with helper-method)
     * @param info value of the new element
     */
    public void add(int info) {
        if (head == null){
            head = new Entry(head, null, info);
        }
        else{
            addHelperMethod(info, head);
        }
    }

    private void addHelperMethod(int info, Entry node){
        if (node.next == null){
            node.next = new Entry(head, null, info);
        }
        else{
            addHelperMethod(info, node.next);
        }
    }


    public void addInOneMethod(int info){
        if (head == null){
            head = new Entry(this.head, null, info);
        }
        else {
            Entry currentEntry = head;
            while (currentEntry.next != null) {
                currentEntry = currentEntry.next;
            }
            currentEntry.next = new Entry(head, null, info);
        }
    }


    /**
     * Removes and returns the element at position index from this list.
     * @param index position of the element that is removed
     * @return value of the removed element
     */
    public int remove(int index) {
        int output = Integer.MIN_VALUE;
        if (index == 0){
            output = head.elem;
            head = head.next;
            return output;
        }
        else{
            return remove(index, head, 1);
        }
    }

    private int remove(int index, Entry node, int i){
        if (index == 1){
            int output = node.elem;
            node.next = node.next.next;
            return output;
        }
        else{
            return remove(index, node.next, ++i);
        }
    }


    public int removeInOneMethod(int index){
        int output = Integer.MIN_VALUE;
        if (index == 0){
            output = head.elem;
            head = head.next;
            return output;
        }
        int i = 0;
        Entry currentEntry = head;
        while (currentEntry.next != null){
            if (++i == index){
                output = currentEntry.next.elem;
                currentEntry.next = currentEntry.next.next;
                return output;
            }
            currentEntry = currentEntry.next;
        }
        return Integer.MIN_VALUE;
    }


    /**
     * sets the head of each list element to newHead
     * @param newHead reference to the new head
     */
    private void setHead(Entry newHead) {
        if (head != null)
            head.first = newHead;

        setHead(newHead, head);
    }

    private void setHead(Entry newHead, Entry node){
        if (node.next != null) {
            node.next.first = newHead;
            setHead(newHead, node.next);
        }
    }


    public void setHeadInOneMethod(Entry newHead){
        if (head != null){
            head.first = newHead;
        }
        Entry currentNode = head;
        while (currentNode.next != null){
            currentNode.next.first = newHead;
            currentNode = currentNode.next;
        }
    }


    /**
     * reverse the list
     * example: [1,2,3,4,5] --> [5,4,3,2,1], [] --> [], [1] --> [1]
     */
    public void reverseInOneMethod() {
        Entry previousNode = null;
        Entry currentNode = head;
        while (currentNode != null)
        {
            Entry nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }
        head = previousNode;
    }


    @Override
    public String toString() {
        String out = "[";
        if (head != null) {
            out += head.elem;
            Entry tmp = head.next;
            while (tmp != null) {
                out = out + "," + tmp.elem;
                tmp = tmp.next;
            }
        }
        out += "]";
        return out;
    }

    public static void main(String[] args) {
        HeadList l = new HeadList();
        l.addInOneMethod(1);
        l.addInOneMethod(2);
        l.addInOneMethod(3);
        System.out.println(l);
        l.removeInOneMethod(2);
        l.removeInOneMethod(1);
        l.removeInOneMethod(0);
        System.out.println(l);
    }

    class Entry {

        Entry first;
        Entry next;
        int elem;

        public Entry(Entry first, Entry next, int elem) {
            this.first = first;
            this.next = next;
            this.elem = elem;
        }

    }
}