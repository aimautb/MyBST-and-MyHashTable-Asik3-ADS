import java.util.Random;

/**
 * Main class to test both MyHashTable and MyBST implementations.
 *
 * This class performs the following:
 * 1. Generates random keys (MyTestingClass) and random values (Book),
 *    inserts them into a hash table, and analyzes the bucket distribution.
 * 2. Creates a Binary Search Tree (BST), inserts key-value pairs,
 *    tests retrieval, deletion, and performs in-order traversal.
 */
public class Main {
    public static void main(String[] args) {
        testHashTable(); // Test the functionality of MyHashTable
        testBST();       // Test the functionality of MyBST
    }

    /**
     * Method to test the functionality of MyHashTable.
     * Inserts 10,000 random key-value pairs and prints bucket distribution.
     */
    private static void testHashTable() {
        System.out.println("======== TESTING HASH TABLE ========");

        // Initialize a hash table with 20 buckets
        MyHashTable<MyTestingClass, Book> table = new MyHashTable<>(20);
        Random random = new Random();

        // Insert 10,000 random key-value pairs into the hash table
        for (int i = 0; i < 10000; i++) {
            // Generate random ID and name for the key
            int id = random.nextInt(100000);
            String name = "Name" + random.nextInt(1000);
            MyTestingClass key = new MyTestingClass(id, name);

            // Generate random Book object for the value
            String bookTitle = "Book" + random.nextInt(500);
            int bookYear = 1900 + random.nextInt(124); // Year between 1900 and 2023
            Book value = new Book(bookTitle, bookYear);

            // Insert the generated key-value pair into the hash table
            table.put(key, value);
        }

        // Analyze and print the number of elements in each bucket
        int[] bucketSizes = table.bucketSizes();
        for (int i = 0; i < bucketSizes.length; i++) {
            System.out.println("Bucket " + i + ": " + bucketSizes[i] + " elements");
        }
    }

    /**
     * Method to test the functionality of MyBST (Binary Search Tree).
     * Inserts key-value pairs, retrieves values, deletes a key, and performs in-order traversal.
     */
    private static void testBST() {
        System.out.println("\n\n======== TESTING BST ========");

        // Initialize an empty BST
        MyBST<Integer, String> bst = new MyBST<>();

        // Insert key-value pairs into the BST
        bst.put(5, "Five");
        bst.put(3, "Three");
        bst.put(7, "Seven");
        bst.put(2, "Two");
        bst.put(4, "Four");
        bst.put(6, "Six");
        bst.put(8, "Eight");

        // Print the size of the BST
        System.out.println("BST size: " + bst.size()); // Expected: 7

        // Retrieve and print value by key
        System.out.println("Value for key 3: " + bst.get(3)); // Should print "Three"

        // Perform and print in-order traversal (should be sorted by keys)
        System.out.println("In-order traversal:");
        for (MyBST<Integer, String>.NodeEntry entry : bst) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        // Delete a key and test the structure again
        bst.delete(7);
        System.out.println("\nAfter deleting key 7:");
        System.out.println("BST size: " + bst.size()); // Expected: 6
        System.out.println("Value for key 7: " + bst.get(7)); // Should print "null"

        // Perform in-order traversal again to verify the deletion
        System.out.println("In-order traversal after deletion:");
        for (MyBST<Integer, String>.NodeEntry entry : bst) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }
}
