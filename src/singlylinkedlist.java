public class singlylinkedlist {
    private ListNode head;

    private static class ListNode {
        private int data;
        private ListNode next;

        public ListNode (int data) {
            this.data = data;
            this.next = null;
        }
    }
   //display the items in a listnode
    public void display () {
        ListNode current = head;
        while (current != null){
            System.out.println(current.data + "-->");
            current = current.next;
        }
        System.out.println("null");
    }
    // insert an item into a listnode at any given position
    public void insert (int position, int value) {
        ListNode node = new ListNode(value);
        if( position == 1 ){
            node.next = head;
            head = node;
        } else {
            ListNode previous = head;
            int count = 1;
            while (count < position-1){
                previous = previous.next;
                count ++;
            }
            ListNode current = previous.next;
            previous.next = node;
            node.next = current;
        }
    }
    //delete the first item from a listnode.
    public ListNode deleteFirst () {
        if(head == null){
            return null;
        }
        ListNode temp = head;
        head = head.next;
        temp.next = null;
        return temp;
    }
    //delete the last item from a listnode.
    public ListNode deleteLast () {
        if(head == null || head.next == null){
            return head;
        }
        ListNode current = head;
        ListNode previous = null;
        while (current.next != null){
            previous = current;
            current = current.next;
        }
        previous.next = null;
        return current;
    }
    //insert into a sorted linkedlist
    public ListNode insertInSortedList (int value){
        ListNode newNode = new ListNode(value);
        if(head == null) {
            return newNode;
        }
        ListNode current = head;
        ListNode temp = null;
        while (current != null && current.data < newNode.data){
            temp = current;
            current = current.next;
        }
        newNode.next = current;
        temp.next = newNode;
        return head;
    }
    //search the linkedlist for an item
    public boolean find (ListNode head, int searchKey){
        if(head == null){
            return false;
        }
        ListNode current = head;
        while(current != null){
            if(current.data == searchKey){
                return true;
            }
            current = current.next;
        }
        return false;
    }
    // delete item from linkedlist at any given position
    public void delete (int position){
        if (position == 1){
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
    //show the length of a listnode.
    public int length () {
        if(head == null){
            return 0;
        }
        int count = 0;
        ListNode current = head;
        while (current != null){
            count++;
            current = current.next;
        }
        return count;
    }
    //reverse a linkedlist
    public ListNode reverse(ListNode head){
        if(head == null){
            return head;
        }
        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;

        while (current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }
    //get starting node of a linkedlist
    public ListNode startNodeInALoop(){
        ListNode fastPtr = head;
        ListNode slowPtr = head;
        while (fastPtr != null && fastPtr.next != null){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if(slowPtr == fastPtr){
                return getStartingNode(slowPtr);
            }
        }
        return null;
    }
    private ListNode getStartingNode(ListNode slowPtr){
        ListNode temp = head;
        while(temp != slowPtr){
           temp = temp.next;
           slowPtr = slowPtr.next;
        }
        return temp;
    }
    //check if a linked list contains a loop
    public boolean containsLoop(){
        ListNode fastPtr = head;
        ListNode slowPtr = head;
        while (fastPtr != null && fastPtr.next != null){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if(slowPtr == fastPtr){
                return true;
            }
        }
        return false;
    }

    // delete a node from a linkedlist
    public void deleteNode (int key){
        ListNode current = head;
        ListNode temp = null;
        if (current != null && current.data == key){
            head = current.next;
            return;
        }
        while (current != null && current.data != key){
             temp = current;
             current = current.next;
        }
        if(current == null){
            return;
        }
        temp.next = current.next;

    }
    //get nthnode from end of the linkedlist
    public ListNode getNthNodeFromEnd (int n) {
        if(head==null){
            return null;
        }
        if(n<=0){
            throw new IllegalArgumentException("Invalid value :" +n);
        }
        ListNode mainPtr = head;
        ListNode refPtr = head;

        int count = 0;
        while(count < n){
            refPtr = refPtr.next;
            count++;
        }
        while (refPtr != null){
            refPtr = refPtr.next;
            mainPtr = mainPtr.next;
        }
        return mainPtr;
    }
    //remove duplicates
    public void removeDuplicates () {
        if(head == null){
            return;
        }
        ListNode current = head;
        while (current != null && current.next != null){
            if(current.data == current.next.data){
                current.next = current.next.next;
            }else {
                current = current.next;
            }
        }
    }
    //get middlenode of a linkedlist
    public ListNode getMiddleNode (){
        if(head==null){
            return null;
        }

        ListNode slowPtr = head;
        ListNode fastPtr = head;
        while(fastPtr != null && fastPtr.next != null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        return slowPtr;
    }
    //insert at the first position of a linkedlist
    public void insertFirst (int value) {
        ListNode newNode = new ListNode(value);
        newNode.next = head;
        head = newNode;
    }
    //insert at the last position of a linkedlist
    public void insertLast (int value){
         ListNode newNode = new ListNode(value);
         if(head == null){
             head = newNode;
             return;
         }
         ListNode current = head;
         while (null != current.next){
             current = current.next;
         }
         current.next = newNode;
    }
    public static void main(String[] args) {
        singlylinkedlist sll = new singlylinkedlist();
        sll.head = new ListNode(10);
        ListNode second = new ListNode(1);
        ListNode third = new ListNode(8);
        ListNode fourth = new ListNode(11);

        sll.head.next = second;
        second.next = third;
        third.next = fourth;
        sll.insert(3, 3);

        sll.display();
        System.out.println("length is " + sll.length());
    }
}
