public class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
        System.out.println("The trie has been created!");
    }
    // insert method trie
    public void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
          
            if (node == null) {
                node = new TrieNode();
                current.children.put(ch, node);

            }
            current = node;
        }
        current.endOfString = true;
        System.out.println("The string "+ word+" has been inserted!");
        
    }
    // search for a word in trie
    public boolean search(String word) {
        TrieNode currentNode = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = currentNode.children.get(ch);
            if (node == null) {
                System.out.println("Word: "+word+ " does not exist in Trie");
                return false;
            }
            currentNode = node;

        }
        if (currentNode.endOfString = true) {
            System.out.println("Word: "+word+ " exists in Trie");
            return true;

        } else {
            System.out.println(word+ " is a prefix of another string and does not exist as a complete string in the trie.");
        }
        return currentNode.endOfString;
    }
    // delete method for deleting string from trie
    private boolean delete(TrieNode parentNode, String word, int index) {
        char ch  = word.charAt(index);
        TrieNode currentNode = parentNode.children.get(ch);
        boolean canThisNodeBeDeleted;
        // Case 1: Some other prefix of string is same as the one that we want to delete.
        if (currentNode.children.size() > 1) {
            delete(currentNode, word, index+1);
            return false;

        }// the string to be deleted is a prefix of another string
        if (index == word.length()-1) {
            if (currentNode.children.size()>=1) {
                 currentNode.endOfString = false;
                 return false;
            } else {
                parentNode.children.remove(ch);
                return true;
            }
        }// another string is a prefix of this string
        if (currentNode.endOfString == true) {
            delete(currentNode, word, index+1);
            return false;
        }// not any node depends on this string
        canThisNodeBeDeleted = delete(currentNode, word, index+1);
        if (canThisNodeBeDeleted == true) {
            parentNode.children.remove(ch);
            return true;
        } else {
            return false;
        }
         
    }
    public void delete(String word) {
        if (search(word) == true) {
           delete(root, word, 0);
        }
    }
    public static void main(String[] args) {
        Trie newTrie = new Trie();
        newTrie.insert("APIS");
        newTrie.insert("API");
        newTrie.search("APIS");
        newTrie.delete("APIS");
        newTrie.search("APIS");

    }
}
