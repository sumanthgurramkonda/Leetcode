class LRUCache {

    class Node{
        int key;
        int val;
        Node next;
        Node prev;
        public Node(){

        }
        public Node(int key, int val){
            this.key = key;
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }
    private int capacity;
    private Map<Integer, Node> cacheMap = new HashMap<>();
    private Node tail;
    private Node head;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node();
        this.tail=head;
    }
    
    public int get(int key) {
        Node node = cacheMap.getOrDefault(key, null);
        if(node==null)return -1;
        removeNode(node);
        addFirst(node);
        return node.val;
    }
    
    public void put(int key, int value) {

        if(cacheMap.containsKey(key)){
            Node node = cacheMap.get(key);
            removeNode(node);
            addFirst(node);
            node.val = value;
            return;
        }
        if(cacheMap.size()==capacity){
            Node node = removeLast();
            cacheMap.remove(node.key);
        }
        Node node = new Node(key,value);
        cacheMap.put(key,node);
        addFirst(node);
        
    }

    public void addFirst(Node node){
        if(head==tail){
            node.prev = head;          
            head.next = node;
            tail = node;
            return;
        }
        Node currentNode = head.next;     // head -> currentNode 
        currentNode.prev = node;
        node.next = currentNode;
        node.prev = head;
        head.next = node;
    }

    public Node removeLast(){
        if(tail==head) return null;
        Node lastNode = tail;
        Node prevNode = tail.prev;
        prevNode.next=null;
        tail.prev=null;
        tail = prevNode;
        return lastNode;
    }

    private void removeNode(Node node){
        if(node==tail){
            removeLast();
        }else{
            Node prevNode = node.prev;
            Node nextNode = node.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            node.prev = null;
            node.next = null;
        }
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */