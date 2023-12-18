import java.util.Iterator;

// leicht veränderte Version von pgdp2324w06p01-solution; 
public class HelperClassDLL<T> implements Iterable<HelperClassDLL<T>.DoublyLinkedListElement> {
    private DoublyLinkedListElement head;
    private DoublyLinkedListElement tail;
    private int size = 0;

    public HelperClassDLL() {
        head = null;
        tail = null;
    }

    public void append(T info) {
        DoublyLinkedListElement newElement = new DoublyLinkedListElement(info);
        if (size == 0) {
            // if list empty set both head and tail
            head = newElement;
            tail = newElement;
        } else {
            // otherwise append to last element
            tail.next = newElement;
            newElement.prev = tail;
            tail = newElement;
        }
        size++;
    }

    public int size() {
        return size;
    }

    /**
     * Internal getter for a specific list element
     * 
     * @param index the position to get, assumed to be valid
     * @return the internal element at the given position
     */
    private DoublyLinkedListElement getElement(int index) {
        if (index < 0 || size <= index) {
            System.out.println("Position ist größer als Liste!");
            return null;
        }

        // optimize access time
        if (index < size / 2) {
            DoublyLinkedListElement temp = head;
            for (int i = 0; i < index; i++, temp = temp.next)
                ;
            return temp;
        } else {
            DoublyLinkedListElement temp = tail;
            for (int i = size - 1; i > index; i--, temp = temp.prev)
                ;
            return temp;
        }
    }

    public T get(int index) {
        if (index < 0 || size <= index) {
            System.out.println("Position ist größer als Liste!");
            return null;
        }
        return getElement(index).getInfo();
    }

    public void remove(int index) {
        if (size <= index || index < 0) {
            // error if pos is invalid
            System.out.println("Position ist größer als Liste!");
        } else {
            // otherwise link element index-1 with index+1
            DoublyLinkedListElement toRemove = getElement(index);

            // it might delete the head, check if prev exists
            if (toRemove.prev != null) {
                toRemove.prev.next = toRemove.next;
            } else {
                head = toRemove.next;
            }

            // it might be the tail as well, check if next exists
            if (toRemove.next != null) {
                toRemove.next.prev = toRemove.prev;
            } else {
                tail = toRemove.prev;
            }
            size--;
        }
    }

    public void appendList(HelperClassDLL<T> other) {
        // if this list has elements, append
        if (size != 0) {
            tail.next = other.head;
            // otherwise set new head
        } else {
            head = other.head;
        }
        // if the other list is empty nothing needs to be done
        if (other.size != 0) {
            other.head.prev = tail;
            tail = other.tail;
            size += other.size;
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        // iterate over the list
        for (DoublyLinkedListElement temp = head; temp != null; temp = temp.next) {
            result.append(temp.getInfo());
            // only append ',' if not last element
            if (temp.next != null) {
                result.append(',');
            }
        }

        return result.toString();
    }

    public boolean isEqualRecursive(HelperClassDLL<T> other) {
        if (other == null) {
            return false;
        }

        if (head == null) {
            return other.head == null;
        }

        return head.isEqual(other.head);
    }

    public boolean isEqual(HelperClassDLL<T> other) {
        if (other == null) {
            return false;
        }

        DoublyLinkedListElement mytemp = head;
        DoublyLinkedListElement othertemp = other.head;

        while (mytemp != null) {
            if (!mytemp.isEqual(othertemp)) {
                return false;
            }
            mytemp = mytemp.next;
            othertemp = othertemp.next;
        }

        return othertemp == null;
    }

    /*
     * public int sumIfIntegers() {
     * int result = 0;
     * 
     * for (DoublyLinkedListElement<T> temp = head; temp != null; temp = temp.next)
     * {
     * result += temp.getInfo();
     * }
     * 
     * return result;
     * }
     */

    public HelperClassDLL<T> copy() {
        HelperClassDLL<T> result = new HelperClassDLL<>();

        for (DoublyLinkedListElement temp = head; temp != null; temp = temp.next) {
            result.append(temp.getInfo());
        }

        return result;
    }

    public class DoublyLinkedListElement {
        private T info;

        public T getInfo() {
            return info;
        }

        // These attributes are public because the elements are only supposed to be
        // used by the list which keeps the invariants. The list does not expose its
        // elements to the outside
        public DoublyLinkedListElement next;
        public DoublyLinkedListElement prev;

        public DoublyLinkedListElement(T startInfo) {
            info = startInfo;
            next = null;
            prev = null;
        }

        public boolean isEqual(DoublyLinkedListElement other) {
            return other != null && info == other.info;
        }

        @Override
        public String toString() {
            return info.toString();
        }
    }

    @Override
    public Iterator<HelperClassDLL<T>.DoublyLinkedListElement> iterator() {
        return new HelperClassDLLIterator<>(head);
    }

    private static class HelperClassDLLIterator<T> implements Iterator<HelperClassDLL<T>.DoublyLinkedListElement> {
        private HelperClassDLL<T>.DoublyLinkedListElement current;

        HelperClassDLLIterator(HelperClassDLL<T>.DoublyLinkedListElement head) {
            current = head;
        }

        @Override
        public boolean hasNext() {
            if (current != null) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public HelperClassDLL<T>.DoublyLinkedListElement next() {
            HelperClassDLL<T>.DoublyLinkedListElement curr = current;

            current = current.next;

            return curr;
        }
    }

    public static void main(String[] args) {
        HelperClassDLL<String> list = new HelperClassDLL<>();
        list.append("first1");
        list.append("second2");
        // for (HelperClassDLL<String>.DoublyLinkedListElement el : list) {
        // System.out.println(el);
        // }

        // System.out.println(list.size);

        HelperClassDLL<String> list2 = list.copy();
        System.out.println(list);
        System.out.println(list2);
        System.out.println("---");
        list.append("what");
        System.out.println(list);
        System.out.println(list2);

    }
}
