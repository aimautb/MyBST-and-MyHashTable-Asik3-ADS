# 📚 Assignment 3: HashTable & BST Implementation  
**Manual implementations of a HashTable with separate chaining and a non-recursive BST in Java.**  



---

## 📌 Overview  
This project implements two core data structures:  
1. **MyHashTable**: A hash table using separate chaining for collision resolution.  
2. **BST**: A binary search tree with non-recursive operations and in-order iteration.  

---

## 🛠 Features  

### **MyHashTable**  
- **Collision Handling**: Uses linked lists (separate chaining).  
- **Custom Hashing**: `MyTestingClass` defines a unique `hashCode()` for keys.  
- **Operations**:  
  - `put(K key, V value)`  
  - `get(K key)`  
  - `remove(K key)`  
- **Testing**: Insert 10,000 random elements and analyze bucket distribution.  

### **BST**  
- **Non-Recursive Operations**: Insert, delete, and search without recursion.  
- **In-Order Iterator**: Traverse keys in sorted order with access to both keys and values.  
- **Size Tracking**: Returns the number of nodes in the tree.  
