public class word_break {
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
        curr.eow=true; // set the end of word flag to true for the last node
    }
    public static boolean wordBreak(String key){
        if(key.length()==0)     //second part becomes empty
        return true;
            for(int i=1;i<=key.length();i++){
            if(searching(key.substring(0,i)) && 
            wordBreak(key.substring(i))){           //by default it takes ending idx as last idx of the substring
                
            return true;
        }
        }
        return false;
    }
    public static void main(String[] args) {
        String arr[]={"i","like","sam","samsung","mobile","ice"};
        for(int i=0;i<arr.length;i++){
            insert(arr[i]);
        }       
        String key="ilikesamsung";
        System.out.println(wordBreak(key));

    }
}
