import java.util.Random;

/**
 * Main class to test the MyHashTable implementation.
 * This class generates random keys (MyTestingClass) and values (Book),
 * stores them in the hash table, and analyzes the distribution of elements across buckets.
 */
public class Main {
    public static void main(String[] args) {
        // Initialize a hash table with 20 buckets
        MyHashTable<MyTestingClass, Book> table = new MyHashTable<>(20);

        // Create a random number generator for generating test data
        Random random = new Random();

        // Insert 10,000 random key-value pairs into the hash table
        for (int i = 0; i < 10000; i++) {
            // Generate a random ID between 0 and 99,999
            int id = random.nextInt(100000);
            // Generate a random name with a numeric suffix (e.g., "Name123")
            String name = "Name" + random.nextInt(1000);
            // Create a key using the generated ID and name
            MyTestingClass key = new MyTestingClass(id, name);

            // Generate a random book title and publication year
            String bookTitle = "Book" + random.nextInt(500); // Random book title
            int bookYear = 1900 + random.nextInt(124); // Random year between 1900 and 2023
            Book value = new Book(bookTitle, bookYear);

            // Insert the key-value pair into the hash table
            table.put(key, value);
        }

        // Analyze and print the sizes of each bucket in the hash table
        int[] bucketSizes = table.bucketSizes();
        for (int i = 0; i < bucketSizes.length; i++) {
            System.out.println("Bucket " + i + ": " + bucketSizes[i] + " elements");
        }
    }
}