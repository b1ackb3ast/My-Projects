import java.util.ArrayList;
public class DoubleHashing {
    String[] hashTable;
    int noOfCellsUsedInHashTable;

    // constructor
    DoubleHashing(int size) {
        hashTable = new String[size];
        noOfCellsUsedInHashTable = 0;
    }
    //hash function to be used on keys
    public int modASCIIHashFunction(String word, int M) {
        char ch[];
        ch = word.toCharArray();
        int i, sum;
        for (sum = 0, i = 0; i< word.length(); i++) {
            sum = sum + ch[i];
        }
        return sum % M;
    }
    // returns load factor 
    public double getLoadFactor() {
        double loadFactor = noOfCellsUsedInHashTable * 1.0/hashTable.length;
        return loadFactor;
    }
    //ReHash
    public void reHashKeys(String word) {
        ArrayList <String> data = new ArrayList<String>();
        for (String s : hashTable) {
            if (s != null) {
                data.add(s);
            }
            data.add(word);
            hashTable = new String[hashTable.length *2];
            for (String k : data) {
                insertInHashTable(k);
            }
        }
    }
    // display the hashtable
    public void displayHashTable() {
        if (hashTable == null) {
            System.out.println("The hash table does not exist!");

        } else {
            System.out.println("\n----------HashTable---------");
            for (int i = 0; i< hashTable.length; i++) {
                System.out.println("Index " + i + ", key:" + hashTable[i]);
            }
        }
    }
    // 2nd hash function
    private int addAllDigitsTogether(int sum) {
        int value = 0;
        while (sum >0) {
            value = sum % 10;
            sum = sum / 10;
        }
        return value;
    }
    public int secondHashFunction(String x, int M) {
        char ch[];
        ch = x.toCharArray();
        int i , sum;
        for (sum = 0, i = 0; i<x.length(); i++) {
            sum += ch[i];

        }
        while (sum > hashTable.length) {
            sum = addAllDigitsTogether(sum);
        }
        return sum % M;
    }
    //insert function with double hashing
    public void insertInHashTable(String word) {
        double loadFactor = getLoadFactor();
        if (loadFactor >= 0.75) {
            reHashKeys(word);
        } else {
            int x = modASCIIHashFunction(word, hashTable.length);
            int y = secondHashFunction(word, hashTable.length);
            for (int i = 0; i< hashTable.length; i++) {
                int newIndex = i + (x + i*y) % hashTable.length;
                if (hashTable[newIndex] == null){
                    hashTable[newIndex] = word;
                    System.out.println("The " + word + " successfully inserted at location: "+ newIndex);
                    break;
                } else {
                    System.out.println(newIndex + " is already occupied. Trying next empty cell.");
    
                } 
            }
        }
        noOfCellsUsedInHashTable++;
    }
    
    // search in hash table
    public boolean searchHashTable(String word) {
        int x = modASCIIHashFunction(word, hashTable.length);
        int y = secondHashFunction(word, hashTable.length);
        for (int i = 0; i< hashTable.length; i++) {
            // whyyyy mod with hashtable.length?????
            int newIndex = i + (x + i*y) % hashTable.length;
            if (hashTable[newIndex] != null && hashTable[newIndex].equals(word)) {
                System.out.println(word+ " found at location "+ newIndex);
                return true;
            }
            
        }
        System.out.println(word +" not found in hashTable");
        return false;
    }
    // delete from hash table method
    public void deleteKeyHashTable(String word) {
        int x = modASCIIHashFunction(word, hashTable.length);
        int y = secondHashFunction(word, hashTable.length);
        for (int i = 0; i< hashTable.length; i++) {
            int newIndex = i + (x + i*y) % hashTable.length;
            if (hashTable[newIndex] != null&& hashTable[newIndex].equals(word)) {
                hashTable[newIndex] = null;
                System.out.println(word+ " has been deleted from hashtable");
                return;

            }
            
        }
        System.out.println(word +" not found in hashTable");
    }
    public static void main(String[] args) {
        DoubleHashing doubleHashing = new DoubleHashing(13);
        doubleHashing.insertInHashTable("The");
        doubleHashing.insertInHashTable("quick");
        doubleHashing.insertInHashTable("brown");
        doubleHashing.insertInHashTable("fox");
        doubleHashing.insertInHashTable("over");
        doubleHashing.insertInHashTable("lazy");
        doubleHashing.displayHashTable();
    }
}
