import java.util.ArrayList;
public class QuadraticProbing {
    String[] hashTable;
    int usedCellNumber;

    // constructor
    QuadraticProbing(int size) {
        hashTable = new String[size];
        usedCellNumber = 0;
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
        double loadFactor = usedCellNumber * 1.0/hashTable.length;
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
    public void insertInHashTable(String word) {
        double loadFactor = getLoadFactor();
        if (loadFactor >= 0.75) {
            reHashKeys(word);
        } else {
            int index = modASCIIHashFunction(word, hashTable.length);
            int counter  = 0;
            for (int i = index; i< index+hashTable.length; i++) {
                int newIndex = i + (counter*counter) % hashTable.length;
                if (hashTable[newIndex] == null){
                    hashTable[newIndex] = word;
                    System.out.println("The " + word + " successfully inserted at location: "+ newIndex);
                    break;
                } else {
                    System.out.println(newIndex + " is already occupied. Trying next empty cell.");
    
                }
                counter++; 
            }
        }
        usedCellNumber++;
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
    // search in hash table
    public boolean searchHashTable(String word) {
        int index = modASCIIHashFunction(word, hashTable.length);
        int counter = 0;
        for (int i = index; i< index+hashTable.length; i++) {
            // whyyyy mod with hashtable.length?????
            int newIndex = i + (counter*counter) % hashTable.length;
            if (hashTable[newIndex] != null && hashTable[newIndex].equals(word)) {
                System.out.println(word+ " found at location "+ newIndex);
                return true;
            }
            counter++;
            
        }
        System.out.println(word +" not found in hashTable");
        return false;
    }
    // delete from hash table method
    public void deleteKeyHashTable(String word) {
        int index = modASCIIHashFunction(word, hashTable.length);
        int counter = 0;
        for (int i = index; i< index+ hashTable.length; i++) {
            int newIndex = i + (counter*counter) % hashTable.length;
            if (hashTable[newIndex] != null&& hashTable[newIndex].equals(word)) {
                hashTable[newIndex] = null;
                System.out.println(word+ " has been deleted from hashtable");
                return;

            }
            counter++;
            
        }
        System.out.println(word +" not found in hashTable");
    }
    public static void main(String[] args) {
        QuadraticProbing QuadraticProbing = new QuadraticProbing(13);
        QuadraticProbing.insertInHashTable("The");
        QuadraticProbing.insertInHashTable("quick");
        QuadraticProbing.insertInHashTable("brown");
        QuadraticProbing.insertInHashTable("fox");
        QuadraticProbing.insertInHashTable("over");
        QuadraticProbing.deleteKeyHashTable("fox");
        QuadraticProbing.displayHashTable();
    }
}