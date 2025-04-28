/**
 * Custom hash table implementation using separate chaining.
 *
 * @param <K> the type of keys
 * @param <V> the type of values
 */
public class MyHashTable<K, V> {

    /**
     * A node class used to store key-value pairs and link to the next node.
     */
    private class HashNode<K, V> {
        private K key;
        private V value;
        private HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" + key + " " + value + "}";
        }
    }

    private HashNode<K, V>[] chainArray; // Array of chains (linked lists)
    private int M = 11; // Default number of buckets
    private int size; // Number of elements stored

    /**
     * Default constructor: uses 11 buckets.
     */
    @SuppressWarnings("unchecked")
    public MyHashTable() {
        chainArray = new HashNode[M];
        size = 0;
    }

    /**
     * Constructor with specified number of buckets.
     */
    @SuppressWarnings("unchecked")
    public MyHashTable(int M) {
        this.M = M;
        chainArray = new HashNode[M];
        size = 0;
    }

    /**
     * Hash function: generates bucket index from key.
     */
    private int hash(K key) {
        return Math.abs(key.hashCode()) % M;
    }

    /**
     * Inserts a key-value pair into the hash table.
     * Updates value if key already exists.
     */
    public void put(K key, V value) {
        int bucketIndex = hash(key);
        HashNode<K, V> head = chainArray[bucketIndex];

        // Check if the key exists, update value if found
        for (HashNode<K, V> node = head; node != null; node = node.next) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
        }

        // Key not found: insert new node at beginning
        HashNode<K, V> newNode = new HashNode<>(key, value);
        newNode.next = head;
        chainArray[bucketIndex] = newNode;
        size++;
    }

    /**
     * Returns value associated with given key, or null if not found.
     */
    public V get(K key) {
        int bucketIndex = hash(key);
        for (HashNode<K, V> node = chainArray[bucketIndex]; node != null; node = node.next) {
            if (node.key.equals(key)) {
                return node.value;
            }
        }
        return null;
    }

    /**
     * Removes key-value pair and returns value, or null if not found.
     */
    public V remove(K key) {
        int bucketIndex = hash(key);
        HashNode<K, V> current = chainArray[bucketIndex];
        HashNode<K, V> prev = null;

        while (current != null) {
            if (current.key.equals(key)) {
                if (prev != null) {
                    prev.next = current.next;
                } else {
                    chainArray[bucketIndex] = current.next;
                }
                size--;
                return current.value;
            }
            prev = current;
            current = current.next;
        }
        return null;
    }

    /**
     * Checks if value exists in hash table.
     */
    public boolean contains(V value) {
        for (int i = 0; i < M; i++) {
            for (HashNode<K, V> node = chainArray[i]; node != null; node = node.next) {
                if (node.value.equals(value)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Returns the key associated with a value, or null if not found.
     */
    public K getKey(V value) {
        for (int i = 0; i < M; i++) {
            for (HashNode<K, V> node = chainArray[i]; node != null; node = node.next) {
                if (node.value.equals(value)) {
                    return node.key;
                }
            }
        }
        return null;
    }

    /**
     * Returns array of bucket sizes.
     */
    public int[] bucketSizes() {
        int[] sizes = new int[M];
        for (int i = 0; i < M; i++) {
            int count = 0;
            for (HashNode<K, V> node = chainArray[i]; node != null; node = node.next) {
                count++;
            }
            sizes[i] = count;
        }
        return sizes;
    }

    /**
     * Returns current size of hash table.
     */
    public int size() {
        return size;
    }
}
