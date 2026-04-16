class ListNode {
    ListNode next;
    ListNode prev;
    int key;
    int value;

    ListNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
class LRUCache {
    int MAX_CAPACITY;
    HashMap<Integer, ListNode> keyMap;
    ListNode tail;
    ListNode head;

    public LRUCache(int capacity) {
        MAX_CAPACITY = capacity;
        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);
        head.next = tail;
        tail.prev = head;
        keyMap = new HashMap<>();
    }
    
    public int get(int key) {
        if(!keyMap.containsKey(key)) return -1;

        ListNode address = keyMap.get(key);
        removeNode(address);
        insertAtHead(address);
        return address.value;
    }
    
    public void put(int key, int value) {
        if(keyMap.containsKey(key)) {
            ListNode address = keyMap.get(key);
            address.value = value;
            removeNode(address);
            insertAtHead(address);
            return;
        }

        if(keyMap.size() == MAX_CAPACITY) {
            ListNode lru = tail.prev;
            removeNode(lru);
            keyMap.remove(lru.key);
        }

        ListNode address = new ListNode(key, value);
        keyMap.put(key, address);
        insertAtHead(address);
    }

    private void removeNode(ListNode node) {
        ListNode previousNode = node.prev;
        ListNode nextNode = node.next;

        previousNode.next = nextNode;
        nextNode.prev = previousNode;
    }

    private void insertAtHead(ListNode node) {
        ListNode nextElement = this.head.next;

        node.next = nextElement;
        nextElement.prev = node;

        node.prev = head;
        this.head.next = node;
    }
}
