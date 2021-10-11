public class mylinkedlist {
    private ListNode head;
    private static class ListNode {
        private int data;
        private ListNode next;
        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void display () {
        ListNode current = head;
        while (current != null){
            System.out.println(current.data + "-->");
            current = current .next;
        }
        System.out.println("null");

    }

    public void insertFirst (int value){
        ListNode newNode = new ListNode(value);
        newNode.next = head;
        head = newNode;
    }

    public void insertLast (int value){
        ListNode current = head;
        ListNode newNode = new ListNode(value);
        while (current != null){
            current = current.next;
        }
        current.next = newNode;

    }

    public void insertAny (int value, int position){
        ListNode newNode = new ListNode(value);
        if (position == 1){
            newNode.next = head;
            head = newNode;
        }else{
            ListNode previous = head;
            int count = 1;
            while (count < position - 1){
                previous = previous.next;
                count++;
            }
            ListNode current = previous.next;
            newNode.next = current;
            previous.next = newNode;

        }
    }
   public ListNode deleteFirst (){
        ListNode temp =head;
        head = head.next;
        temp.next = null;
        return temp;
   }
   public ListNode reverse (ListNode head){
        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;
        while(current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
   }

   public ListNode getMiddleNode (){
        ListNode fastPtr = head;
        ListNode slowPtr = head;
        while (slowPtr != null){
            fastPtr= fastPtr.next.next;
            slowPtr = slowPtr.next;
        }
        return slowPtr;
   }


   public ListNode deleteLast (){
        if(head == null || head.next == null){
            return head;
        }
        ListNode current = head;
        ListNode previous = null;
        while(current.next !=null){
            previous = current;
            current = current.next;
        }
        previous.next = null;
        return current;
   }
   public void deleteAny(int position){
        if(position == 1){
            head = head.next;
        } else {
            ListNode previous = head;
            int count = 1;
            while (count < position - 1){
                previous = previous.next;
                count++;
            }
            ListNode current = previous.next;
            previous.next = current.next;
        }
   }
    public int length (){
        ListNode current = head;
        int count = 0;
        while (current != null){
            current = current.next;
            count++;
        }
        return count;
    }

    public static void main (String[] args){
        mylinkedlist sll = new mylinkedlist();
        sll.head = new ListNode(19);
        ListNode second = new ListNode(10);
        ListNode third = new ListNode(5);
        ListNode fourth = new ListNode(3);
        sll.head.next = second;
        second.next = third;
        third.next = fourth;
        sll.display();
        System.out.println("length is " + sll.length());
    }

}
