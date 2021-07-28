package _10_dsa_danh_sach.bai_tap.trien_khai_phuong_thuc_cua_linkedlist;

public class MyLinkedList<E> {
    private Node head;
    private int numNodes;

    public MyLinkedList(Object data) {
        head = new Node(data);
    }

    public MyLinkedList() {

    }

    private class Node {
        private Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return data;
        }
    }

    public void add(int index, E data) {
        Node temp = head;
        Node hoder;

        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        hoder = temp.next;
        temp.next = new Node(data);
        temp.next.next = hoder;
        numNodes++;
    }

    public void addFirst(E data) {
        Node temp = head;
        head = new Node(data);
        numNodes++;
    }

    public void addLast(E data) {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(data);
        numNodes++;
    }

    public Object get(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    public int size() {
        return numNodes;
    }

    public E remove(int index){
        if(index<0||index>numNodes){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index);
        }
        Node temp = head;
        Object data;
        if(index==0){
            data = temp.data;
            head = head.next;
        } else {
            for(int i=0; i<index-1 && temp.next!=null; i++){
                temp = temp.next;
            }
            data = temp.next.data;
            temp.next = temp.next.next;
            numNodes--;
        }
        return (E) data;
    }

    public boolean remove(E element){
        if(head.data.equals(element)){
            remove(0);
        } else {
            Node temp = head;
            while (temp.next!=null){
                if(temp.next.data.equals(element)){
                    temp.next = temp.next.next;
                    numNodes--;
                    return true;
                }
                temp = temp.next;
            }
        }
        return false;
    }

    public MyLinkedList<E> clone (){
        if(numNodes==0){
            throw new NullPointerException("LinkedList is null");
        }
        MyLinkedList<E> returnLinkedList = new MyLinkedList<>();
        Node temp = head;
        returnLinkedList.addFirst((E) temp);
        temp = temp.next;
        while(temp!=null){
            returnLinkedList.addLast((E) temp.data);
            temp = temp.next;
        }
        return returnLinkedList;
    }

    public boolean contains(E element){
        Node temp = head;
        while(temp.next!=null){
            if(temp.data.equals(element)){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public int indexOf(E element){
        Node temp = head;
        for(int i=0; i<numNodes; i++){
            if(temp.getData().equals(element)){
                return i;
            }
        }
        return -1;
    }
}
