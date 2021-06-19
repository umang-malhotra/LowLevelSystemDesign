package LRUCache;


public class Main {
    private static void LRUCacheTest() {
        LRUCache cache = new LRUCache(4);

        cache.setValueAtKey(1, 11);
        cache.printDll();
        cache.setValueAtKey(2, 13);
        cache.printDll();
        cache.setValueAtKey(3, 31);
        cache.printDll();
        cache.setValueAtKey(4, 41);
        cache.printDll();
        cache.setValueAtKey(5, 51);
        cache.printDll();
        System.out.println(cache.getValueAtKey(3));
        cache.printDll();
        System.out.println(cache.getValueAtKey(2));
        cache.printDll();
        System.out.println(cache.getValueAtKey(5));
        System.out.println(cache.getValueAtKey(4));

        /* Output
         *
         *
->1 11
->2 13->1 11
->3 31->2 13->1 11
->4 41->3 31->2 13->1 11
->5 51->4 41->3 31->2 13
31
->3 31->5 51->4 41->2 13
13
->2 13->3 31->5 51->4 41
51
41
         */

    }

    public static void main(String[] args) {
        LRUCacheTest();
    }
}
