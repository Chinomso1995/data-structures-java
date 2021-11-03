import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class binarytree {
    private Treenode root;

    private class Treenode{
        private Treenode left;
        private Treenode right;
        private int data;

        public Treenode(int data) {
            this.data = data;
        }
    }

    public void createBinaryTree(){
        Treenode first = new Treenode(1);
        Treenode second = new Treenode(2);
        Treenode third = new Treenode(3);
        Treenode fourth = new Treenode(4);
        Treenode fifth = new Treenode(5);

        root = first;
        first.left = second;
        first.right = third;

        second.left = fourth;
        second.right = fifth;
    }
     //recursive preorder traversal

    public void recursivePreorder (Treenode root){
        if(root == null){
            return;
        }

        System.out.println(root.data + "");
        recursivePreorder(root.right);
        recursivePreorder(root.left);

    }
    //recursive inorder traversal
    public void inOrder(Treenode root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.println(root.data + "");
        inOrder(root.right);
    }

    //recursive postorder tree traversal
    public void postOrder (Treenode root){
        if (root == null){
            return;
        }
        postOrder(root.right);
        postOrder(root.left);
        System.out.println(root.data + "");
    }
     //find max value of a binary tree

    public int findMax(Treenode root){
        if(root == null){
            return Integer.MIN_VALUE;
        }
        int result = root.data;
        int left = findMax(root.left);
        int right = findMax(root.right);

        if(left > result){
            result = left;
        }

        if(right > result){
            result = right;
        }

        return result;
    }
    //level order traversal

    public void levelOrder(){
        if (root == null){
            return;
        }
        Queue<Treenode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            Treenode temp = queue.poll();
            System.out.println(temp.data + "");
            if(temp.left != null){
                queue.offer(temp.left);
            }
            if(temp.right != null){
                queue.offer(temp.right);
            }
        }
    }

    //iterative inorder traversal

    public void inorder(){
        if(root==null){
            return;
        }
        Stack<Treenode> stack = new Stack<>();
        Treenode temp = root;
        while(!stack.isEmpty() || temp != null){
              if(temp != null){
                  stack.push(temp);
                  temp = temp.left;
              }else{
                  temp = stack.pop();
                  System.out.println(temp.data + "");
                  temp = temp.right;
              }
        }
    }
    //iterative preorder traversal

    public void preOrder(){
        if(root == null){
            return;
        }

        Stack<Treenode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Treenode temp = stack.pop();
            System.out.println(temp.data + " ");
            if(temp.right != null){
                stack.push(temp.right);
            }
            if(temp.left != null){
                stack.push(temp.left);
            }
        }
    }



    public static void main (String [] args){

    }
}
