package LRUCache;

public class DLL {
    private Node head;
    private Node tail;

    private Integer current_size;

    static class Node {
        Integer key;
        Integer value;

        Node next;
        Node prev;

        Node() {
        }

        Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }

    DLL() {
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        current_size = 0;
    }

    /***
     * Removes a node present in the LRUCache.LRUCache.DLL
     * @param node
     */
    public void removeNode(Node node) {
        Node nodeNext = node.next;
        Node nodePrev = node.prev;

        nodePrev.next = nodeNext;
        nodeNext.prev = nodePrev;

        current_size --;
    }

    public void removeLastNode() {
        if(current_size < 1) {
            return ;
        }
        Node lastNode = tail.prev;
        removeNode(lastNode);
        current_size--;
    }

    public void addNodeAtFront(Node node) {
        Node headNext = head.next;

        node.next = headNext;
        node.prev = head;

        head.next = node;
        headNext.prev = node;
        current_size++;
    }

    public Integer getCurrent_size() {
        return current_size;
    }

    public Node getLastNode() {
        if(current_size >=1) {
            return tail.prev;
        }
        return null;
    }

    public void printDLL(){
        Node currNode = head.next;
        while(currNode != tail) {
            System.out.print("->");
            System.out.print(currNode.key + " " + currNode.value );
            currNode = currNode.next;
        }
        System.out.println("");
    }
}
