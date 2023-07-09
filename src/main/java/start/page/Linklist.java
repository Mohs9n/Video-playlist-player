
package start.page;

class Node {

    String name, link, Team, Player, Action;
    Node next;

    Node(String name, String Team,String Player,String Action,String link) {
        this.name = name;
        this.link = link;
        this.Team = Team;
        this.Player = Player;
        this.Action = Action;
        next = null;
    }
//    Node(Node head) {
//       head=null;
//    }
    
}

public class Linklist {

    Node head, last, ptr;
    int size; 

    Linklist() {
        head = last = ptr = null;
        size = 0;
    }

 
    boolean isEmpty() {
        return size == 0; 
    }

 
//    void inset(String name, String link) {
//        
//        Node newNode = new Node(name, link);
//        if (isEmpty()) {
//            head = last = newNode; 
//            newNode.next = null;
//        } else {
//            newNode.next = head;
//            head = newNode;
//        }
//        size++; 
//    }
    
    void insert(String name, String link,String Team,String Player,String Action) { // insert last
       
        Node newNode = new Node(name, link, Team, Player, Action);
        if (isEmpty()) {
            head = last = newNode;
            newNode.next = null;
        } else {
            ptr = head;
            last.next = newNode;
            newNode.next = null;
            last = newNode; 
        }
        size++;  
    }

    
   
    String nextLink(String Link) {
        Node current = head;

            while (current!=null){
                if (current.link.equals(Link)){
                    return current.next.link; 
                }
                current = current.next;    
            }
            return null;  
    }
    
    void delete(String name) {
         if (head.name.equals(name)) {
            head = head.next;
            size--;
            if (size == 0) last = null;
        } else {
            Node current = head.next;
            Node previous = head;
            while (current != null) {
                if (current.name.equals(name)) break;
                previous = current;
                current = current.next;
            }
            if (current == null) return;
            else {
                previous.next = current.next;
                if (last == current) last = previous;
                size--;
                return;
            }
        }
        return;
    }
                                 //                    
    
    
    
//    String search(String name){
//        if (head.name.equals(name)) return head.link;
//        else{
//            Node current = head.next;
//            while(current!=null){
//                if (current.name.equals(name)) return current.link;
//                current = current.next;
//            }
//        }
//        return null;
//    }
        
    String[] search(String name){
        
            Node current = head;
            String[] test_search = new String[5];
            
            while (current!=null){
                if (current.name.equals(name)){
                    test_search[0] = current.name ;
                    test_search[1] = current.Team;
                    test_search[2] = current.Player;
                    test_search[3] = current.Action;
                    test_search[4] = current.link;
                    return test_search ; 
                }
                current = current.next;
            }
            return null;
        }
   

    
//    public String[] getStringArray() {
//  String[] stringArray = new String[3];
//  stringArray[0] = "Apple";
//  stringArray[1] = "Banana";
//  stringArray[2] = "Orange";
//  return stringArray;
//}

//    String search(String name){
//            
//            Node current = head;
//            while (current!=null){
//                if (current.name.equals(name))
//                    return current.link;       
//                current = current.next;
//            }
//            return null;
//        }

    void update(String name, String link){
            Node current = head;
            while (current!=null){
                if (current.link.equals(link))
                    current.name = name;
                current = current.next;
            }
            return;
        }
    


    void print() {
        Node current = head;
       System.out.println("Videos in Program = "+size);
        while (current != null) {
            System.out.println(current.name);
            current = current.next;  
        }
        System.out.println("========================");
        System.out.println("");
        
    }


    void sortLinkedListasc() {
    Node current = head;
    while (current != null) {
        Node minNode = current;
        Node temp = current.next;
        while (temp != null) {
            if (temp.name.compareTo(minNode.name) < 0) {
                minNode = temp;
            }
            temp = temp.next;
        }
        String tempData = current.name;
        current.name = minNode.name;
        minNode.name = tempData;
        current = current.next;
    }
}
    void sortLinkedListdsc() {
    Node current = head;
    while (current != null) {
        Node minNode = current;
        Node temp = current.next;
        while (temp != null) {
            if (temp.name.compareTo(minNode.name) > 0) {
                minNode = temp;
            }
            temp = temp.next;
        }
        String tempData = current.name;
        current.name = minNode.name;
        minNode.name = tempData;
        current = current.next;
    }
}
    
}