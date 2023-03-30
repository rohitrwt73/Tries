public class search {
    static class Node{
        Node children[]=new Node [26]; //making a trie
         boolean eow=false;
         public Node(){
            for(int i=0;i<26;i++){
                children[i]=null;
            }
         }
    }
    public static Node root =new Node();
    public static boolean searching(String key){
        Node curr=root;
        for(int level=0;level<key.length();level++){
            int idx=key.charAt(level)-'a';
            if(curr.children[idx]==null)
            return false;
            curr=curr.children[idx];
        }
        return curr.eow==true;
    }
    public static void insert(String word){
        Node curr=root;
        for(int level=0;level<word.length();level++){
            int idx=word.charAt(level)-'a';
            if(curr.children[idx]==null)
            curr.children[idx]=new Node();
            curr=curr.children[idx];
        }
        curr.eow=true;
    }
    public static void main(String[] args) {
        String words[]={"the","a","there","their","any","thee"};
        for(int i=0;i<words.length;i++){
            insert(words[i]);  //words are stored in trie
        }
        System.out.println(searching("thee"));
        System.out.println(searching("thor"));

    }
}
