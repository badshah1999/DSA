package LinkedList;

public class Double {
    private Node head;
    private Node tail;

    private class Node{
        int value;
        Node next;
        Node prev;
        public Node(int value){
            this.value=value;
        }
        public Node(int value,Node prev,Node next){
            this.value=value;
            this.prev=prev;
            this.next=next;
        }
    }
    public void insertFirst(int val){
        Node node = new Node(val);
        node.next=head;
        node.prev=null;
        if(head!=null) {
            head.prev = node;
        }
        head=node;
    }
    public void insertLast(int val){
        Node node = new Node(val);
        node.next=null;
        tail=head;
        if (head==null){
            insertFirst(val);
            return;
        }
        while (tail.next!=null){
            tail=tail.next;
        }
        tail.next=node;
        node.prev=tail;

    }
    public void insert(int after , int val){
        Node p = find(after);
        if (p==null){
            System.out.println("Value not exist");
            return;
        }
        Node node = new Node(val);
        node.next=p.next;
        p.next=node;
        node.prev=p;
        if (node.next!=null) {
            node.next.prev = node;
        }
    }
    public Node find(int val){
        Node node = head;
        while(node.next!=null){
            if (node.value==val){
                return node;
            }
            node=node.next;
        }
        return null;
    }
    public int deleteFirst(){
        if (head==null){
            System.out.println("No Elements");
        }
        int val= head.value;
        head=head.next;
        head.prev=null;
        return val;
    }
    public int deleteLast(){
        Node temp=head;
        while (temp.next!=null){
            temp=temp.next;
        }
        int val=temp.value;
        temp.prev.next=null;
        return val;
    }
    public int delete(int val){
        Node p = find(val);
        if(p.next==null){
            p.next=null;
        }
        if (p.prev==null){
            p.prev=null;
        }
        p.prev.next=p.next;
        p.next.prev=p.prev;
        return p.value;
    }
    public void display(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.value+"->");
            tail=temp;
            temp=temp.next;
        }
        System.out.println("End");
            while (tail != null) {
                System.out.print(tail.value + "->");
                tail = tail.prev;
            }
            System.out.println("Start");
    }
    public static void main(String[] args) {
        Double list = new Double();
        list.insertFirst(2);
        list.insertFirst(3);
        list.insertFirst(5);
        list.insertLast(6);
        list.display();
        list.insert(2,10);
        list.display();
        System.out.println("First Deleted Node:"+list.deleteFirst());
        list.display();
        System.out.println("Last Deleted Node:"+list.deleteLast());
        list.display();
        System.out.println("Deleted Value:"+list.delete(2));
        list.display();
    }
}
