public class circularsinglylinkedlist {
    private ListNode last;
    private int length;

    private class ListNode {
        private ListNode next;
        private int data;

        public ListNode (int data){
            this.data = data;

        }
    }

    public circularsinglylinkedlist () {
        last = null;
        length = 0;
    }

    public int length (){
        return length;
    }

    public boolean isEmpty(){
        return length == 0;
    }

    public static void main (String[] args){
         circularsinglylinkedlist csll = new circularsinglylinkedlist();
         csll.createcircularlinkedlist();
         csll.display();

    }
    //show the length of a linkedlist

    public void display(){
        if(last == null){
            return;
        }
        ListNode first = last.next;
        while (first != last){
            System.out.println(first.data + "");
            first = first.next;
        }
        System.out.println(first.data);
    }
    public void createcircularlinkedlist(){
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(5);
        ListNode third = new ListNode(10);
        ListNode fourth = new ListNode(11);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next =  first;

        last = fourth;
    }
}
