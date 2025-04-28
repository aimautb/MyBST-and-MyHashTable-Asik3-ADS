/**
 * A custom class used as a key in the hash table for testing purposes.
 * This class represents an object with an ID and a name, which are used 
 * to generate a unique hash code and compare objects for equality.
 */
public class MyTestingClass {
    private int id;
    private String name;

    /**
     * Constructor to initialize the object with an ID and a name.
     * @param id   the unique identifier for the object
     * @param name the name associated with the object
     */
    public MyTestingClass(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Overriding hashCode to generate a hash value based on both the ID and name.
     * The goal is to distribute keys uniformly across the hash table buckets.
     * @return a unique hash value for the object
     */
    @Override
    public int hashCode() {
        int result = 17; // Start with a prime number to reduce collisions
        result = 31 * result + id; // Incorporate the ID into the hash

        // Incorporate each character of the name into the hash
        for (char c : name.toCharArray()) {
            result = 31 * result + c;
        }

        return result;
    }

    /**
     * Overriding equals to ensure proper comparison of two MyTestingClass objects.
     * Two objects are considered equal if their IDs and names are identical.
     * @param obj the object to compare with
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Same reference means equality
        if (obj == null || getClass() != obj.getClass()) return false; // Null or different class means inequality

        MyTestingClass other = (MyTestingClass) obj; // Cast to MyTestingClass
        return id == other.id && name.equals(other.name); // Compare ID and name
    }

    /**
     * Overriding toString to provide a readable string representation of the object.
     * The format is "(id, name)".
     * @return a string representation of the object
     */
    @Override
    public String toString() {
        return "(" + id + ", " + name + ")";
    }
}