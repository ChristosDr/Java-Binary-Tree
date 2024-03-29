import java.util.Stack;

public class Main {

    private TreeNode root;

    public class TreeNode{
        private int data;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int data){
            this.data = data;
        }
    }

    public void createBinaryTree(){
        TreeNode first = new TreeNode(1);
        TreeNode second = new TreeNode(2);
        TreeNode third = new TreeNode(3);
        TreeNode fourth = new TreeNode(4);
        TreeNode five = new TreeNode(5);

        root = first;
        first.left = second;
        first.right = third;

        second.left = fourth;
        second.right = five;

//        third.left = new TreeNode(6);
//        third.right = new TreeNode(7);
    }

    public void preOrder(TreeNode root){
        if (root==null){
            return;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void preOrderIterative(){
        if (root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode temp = stack.pop();
            System.out.print(temp.data+" ");
            if (temp.right!= null){
                stack.push(temp.right);
            }
            if (temp.left!= null){
                stack.push(temp.left);
            }
        }
    }

    public void inOrder(TreeNode root){//Na to jana dw
        if (root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

    public void inOrderIterative(){
        if (root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while(!stack.isEmpty() || temp != null){
            if (temp!= null){
                stack.push(temp);
                temp = temp.left;
            }else{
                temp = stack.pop();
                System.out.print(temp.data+" ");
                temp = temp.right;
            }
        }
    }

    public void postOrder(TreeNode root){
        if (root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
    }

    public void postOrderIterative(){
        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<>();
        while (current != null || !stack.isEmpty()){
            if (current != null){
                stack.push(current);
                current = current.left;
            }else {
                TreeNode temp = stack.peek().right;
                if (temp == null){
                    temp = stack.pop();
                    System.out.println(temp.data+" ");
                    while (!stack.isEmpty() && temp == stack.peek().right){
                        temp = stack.pop();
                        System.out.println(temp.data+" ");
                    }
                }else {
                    current = temp;
                }
            }
        }
    }

    public int findMax(TreeNode root){
        if (root == null){
            return Integer.MIN_VALUE;
        }
        int result = root.data;
        int left = findMax(root.left);
        int right = findMax(root.right);
        if (left > result){
            result = left;
        }
        if (right > result){
            result = right;
        }
        return result;
    }

    public static void main(String[] args) {
        Main sll = new Main();
        sll.createBinaryTree();
        //sll.preOrder(sll.root);

        //sll.inOrder(sll.root);
        //sll.inOrderIterative();
        //sll.postOrder(sll.root);
        //sll.postOrderIterative();
        System.out.println(sll.findMax(sll.root));


    }
}