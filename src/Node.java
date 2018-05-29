public class Node {
    Node next;
    int data;

    public Node(int data){
        this.data = data;
    }

    public void printNode(){
        System.out.println("Node Value:" + data);
    }
}
