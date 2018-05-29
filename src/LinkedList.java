public class LinkedList {

    Node head;

    LinkedList(Node setup){
        head = setup;
    }

    public void append(int data){
        if (head == null){
            head = new Node(data);
            return;

        }
        Node current = head;
        while(current.next != null){
            current = current.next;
        }
        current.next = new Node(data);
    }

    public void prepend(int data){
        Node newHead = new Node(data);
        newHead.next = head;
        head = newHead;
    }

    public void deleteWithValue(int data){
        if(head == null){
            return;
        }

        if (head.data == data){
            head = head.next;
            return;
        }

        Node current = head;
        while(current.next != null){
            if (current.next.data == data){
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    public void listNodes(){
        Node currentNode = head;
        while (currentNode!= null){
            currentNode.printNode();
            currentNode = currentNode.next;
        }
    }


    public static void main(String[] args){

        Node setup = new Node(42);
        LinkedList list = new LinkedList(setup);

        list.append(31);
        list.append(20);
        list.append(9);

        list.listNodes();

        list.prepend(13);
        list.prepend(41);

        list.listNodes();

        list.deleteWithValue(9);
        list.deleteWithValue(13);

        list.listNodes();


    }


}
