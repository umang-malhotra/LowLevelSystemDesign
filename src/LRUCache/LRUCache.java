package LRUCache;

import java.util.HashMap;
import java.util.Map;


public class LRUCache {
    private DLL doublyQueue;
    private Map<Integer, DLL.Node> hashMap;

    private final Integer CACHE_SIZE;

    public LRUCache(Integer cacheSize) {
        this.doublyQueue = new DLL();
        this.hashMap = new HashMap<>(cacheSize);
        this.CACHE_SIZE = cacheSize;
    }

    /***
     * Method to get value at a Key
     * Returns null if key is not found in the cache
     * @param key -> key for which value to be returned
     * @return -> value at key
     */
    public Integer getValueAtKey(Integer key) {
        DLL.Node node =  hashMap.get(key);
        if(node != null) {
            doublyQueue.removeNode(node);
            doublyQueue.addNodeAtFront(node);
            return node.value;
        } else {
            return null;
        }
    }

    /***
     * Method to store key, value in the cache
     * returns true if stored successfully
     * returns false if not stored in the cache ( May be due to cache storage flow)
     * @param key
     * @param value
     * @return
     */
    public void setValueAtKey(Integer key, Integer value) {
        if(hashMap.containsKey(key)) {
           DLL.Node node = hashMap.get(key);
           node.value = value;
           doublyQueue.removeNode(node);
           doublyQueue.addNodeAtFront(node);
           hashMap.put(key, node);
        } else {
            if(doublyQueue.getCurrent_size().equals(CACHE_SIZE)) {
                DLL.Node node = new DLL.Node(key, value);
                DLL.Node lastNode = doublyQueue.getLastNode();
                hashMap.remove(lastNode.key);
                doublyQueue.removeLastNode();
                doublyQueue.addNodeAtFront(node);
                hashMap.put(key, node);
            } else {
                DLL.Node node = new DLL.Node(key, value);
                hashMap.put(key, node);
                doublyQueue.addNodeAtFront(node);
            }
        }
    }

    public void printDll() {
        doublyQueue.printDLL();
    }
}
