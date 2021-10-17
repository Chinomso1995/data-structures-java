public class mydoublylinkedlist {
   private ListNode head;
   private ListNode tail;
   private int length;

   private class ListNode {
       private ListNode next;
       private ListNode previous;
       private int data;

       public ListNode(int data){
           this.data = data;
       }
   }

   public boolean isEmpty () {
       return length == 0;
   }

   public int length () {
       return length;
   }

   public void insertLast (int value) {
       ListNode newNode = new ListNode (value);
       if(isEmpty()){
           head = newNode;
       }else{
           tail.next = newNode;
       }
       newNode.previous = tail;
       tail = newNode;
       length++;
   }
}
