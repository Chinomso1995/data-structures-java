import java.util.NoSuchElementException;

public class doublylinkedlist {
    private ListNode head;
    private ListNode tail;
    private int length;


    private class ListNode{
        private int data;
        private ListNode next;
        private ListNode previous;

        public ListNode (int data){
            this.data = data;
        }
    }

    public doublylinkedlist(){
        this.head = null;
        this.tail = null;
        this.length = 0;
    }


    public boolean isEmpty (){
        return length == 0;
    }

    public int length () {
        return length;
    }
    //insert to a doubly linkedlist
    public void insertLast(int value){
        ListNode newNode = new ListNode(value);
        if(isEmpty()){
            head = newNode;
        }else{
            tail.next = newNode;
        }
        newNode.previous = tail;
        tail = newNode;
        length++;
    }
    //insert at the beginning of a linkedlist
    public void insertFirst (int value) {
        ListNode newNode = new ListNode(value);
        if(isEmpty()){
            tail = newNode;
        }else{
            head.previous = newNode;
        }
        newNode.next = head;
        newNode = head;
        length++;
    }

    //insert at the end of a linkedlist
    public void insertEnd(int value){
        ListNode newNode = new ListNode(value);
        if(isEmpty()){
            head = newNode;
        }else {
            tail.next = newNode;
            newNode.previous = tail;
        }
        tail = newNode;
        length++;
    }
    //delete first item from a doubly linkedlist
    public ListNode deleteFirst(){
      if(isEmpty()){
          throw new NoSuchElementException();
      }
      ListNode temp = head;
      if(head == tail){
          tail = null;
      }else{
          head.next.previous = null;
      }
      head = head.next;
      temp.next= null;
      return temp;
    }
     //delete last item from a doublylinkedlist
    public ListNode deleteLast(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        ListNode temp = tail;
        if(head == tail){
            head = null;
        }else{
            tail.previous.next = null;
        }
        tail = tail.previous;
        temp.previous =null;
        length--;
        return temp;
    }
    //print nodes forward
    public void displayForward(){
        if(head == null){
            return;
        }
        ListNode temp = head;
        while (temp != null ){
            System.out.println(temp.data + "-->");
            temp= temp.next;
        }
        System.out.println("null");
    }
    //print nodes backward
    public void displayBackward(){
        if(tail == null){
            return;
        }
        ListNode temp= tail;
        while (temp != null){
            System.out.println(temp.data + "-->");
            temp= temp.previous;
        }
        System.out.println("null");
    }
}
