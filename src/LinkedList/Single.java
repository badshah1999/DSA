package LinkedList;

public class Single {
    private Node head;
    private Node tail;
    private int size=0;
    private class Node{
        private int value;
        private Node next;
        public Node(int value){
            this.value=value;
        }
        public Node(int value,Node next){
            this.value=value;
            this.next=next;
        }
    }
    public void insertFirst(int val){
        Node node = new Node(val);
        node.next=head;
        head=node;
        if(tail==null){
            tail=head;
        }
        size++;
    }
    public void insertLast(int val){
        if(tail==null){
            insertFirst(val);
        }
        Node node = new Node(val);
        tail.next=node;
        tail=node;
        size++;
    }
    public void insert(int val,int index){
        if(index==0){
            insertFirst(val);
            return;
        }
        if(index==size){
            insertLast(val);
            return;
        }
        Node temp=head;
        for(int i=0;i<index-1;i++){
            temp=temp.next;
        }
        Node node = new Node(val,temp.next);
        temp.next=node;
        node=node.next;
        size++;
    }
    public int deleteFirst(){
        int val=head.value;
        head=head.next;
        if(head==null){
            tail=null;
        }
        size--;
        return val;
    }
    public int deleteLast(){
        if(size<=1){
            return deleteFirst();
        }
        int val=tail.value;
        Node secondLast = get(size-2);
        tail=secondLast;
        tail.next=null;
        return val;
    }
    public int delete(int index){
        if(index==0){
            return deleteFirst();
        }
        if(index==size-1){
            return deleteLast();
        }
        Node delete = get(index-1);
        int val=delete.next.value;
        delete.next=delete.next.next;
        return val;
    }
    public Node get(int index){
        Node temp=head;
        for(int i=0;i<index;i++){
            temp=temp.next;
        }
        return temp;
    }
    public void display(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.value+"->");
            temp=temp.next;
        }
        System.out.println("END");
    }
    public static void main(String[] args) {
        Single list = new Single();
        list.insertFirst(3);
        list.insertFirst(4);
        list.insertFirst(5);
        list.insertLast(6);
        list.insertLast(7);
        list.insert(100,3);
        list.display();
        System.out.println("Deleted Node:"+list.deleteFirst());
        list.display();
        System.out.println(list.deleteLast());
        list.display();
        System.out.println(list.delete(2));
        list.display();
    }
}
