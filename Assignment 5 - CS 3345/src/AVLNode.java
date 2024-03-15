import java.util.Stack;

public class AVLNode {
	
    private int element;
    private int height;
    private AVLNode leftNode;
    private AVLNode rightNode;
    
    public AVLNode() {
    	this(0, null, null);
    }

    public AVLNode(int element) {
        this.element = element;
        this.height = 1;
    }

    public AVLNode(int element, AVLNode leftNode, AVLNode rightNode) {
        this.element = element;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
        this.height = 1 + Math.max(getHeight(leftNode), getHeight(rightNode));
    }

    public int getElement() {
        return this.element;
    }

    public void setElement(int element) {
        this.element = element;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public AVLNode getLeftNode() {
        return this.leftNode;
    }

    public void setLeftNode(AVLNode leftNode) {
        this.leftNode = leftNode;
    }

    public AVLNode getRightNode() {
        return this.rightNode;
    }

    public void setRightNode(AVLNode rightNode) {
        this.rightNode = rightNode;
    }

    public static int getHeight(AVLNode node) {
        return node == null ? 0 : node.getHeight();
    }
    
    public void replace(AVLNode node) {
    	this.element = node.element;
        this.leftNode = node.leftNode;
        this.rightNode = node.rightNode;
        this.height = node.height;
    }
    
    public void leftRotation() {
        AVLNode newRoot = rightNode;
        rightNode = newRoot.getLeftNode();
        newRoot.setLeftNode(this);
        this.setHeight(1 + Math.max(getHeight(this.getLeftNode()), getHeight(this.getRightNode())));
        newRoot.setHeight(1 + Math.max(getHeight(newRoot.getLeftNode()), getHeight(newRoot.getRightNode())));
        this.replace(newRoot);
    }
    
    public void leftRotation(AVLNode node) {
        AVLNode newRoot = node;
        rightNode = newRoot.getLeftNode();
        newRoot.setLeftNode(this);
        this.setHeight(1 + Math.max(getHeight(this.getLeftNode()), getHeight(this.getRightNode())));
        newRoot.setHeight(1 + Math.max(getHeight(newRoot.getLeftNode()), getHeight(newRoot.getRightNode())));
        this.replace(newRoot);
    }

    public void rightRotation() {
        AVLNode newRoot = leftNode;
        leftNode = newRoot.getRightNode();
        newRoot.setRightNode(this);
        this.setHeight(1 + Math.max(getHeight(this.getLeftNode()), getHeight(this.getRightNode())));
        newRoot.setHeight(1 + Math.max(getHeight(newRoot.getLeftNode()), getHeight(newRoot.getRightNode())));
        this.replace(newRoot);
    }
    
    public void rightRotation(AVLNode node) {
        AVLNode newRoot = node;
        leftNode = newRoot.getRightNode();
        newRoot.setRightNode(this);
        this.setHeight(1 + Math.max(getHeight(this.getLeftNode()), getHeight(this.getRightNode())));
        newRoot.setHeight(1 + Math.max(getHeight(newRoot.getLeftNode()), getHeight(newRoot.getRightNode())));
        this.replace(newRoot);
    }
    
    public void balance() {
        int balanceFactor = getBalanceFactor();

        if (balanceFactor > 1) { // Right-heavy case
            if (rightNode.getBalanceFactor() < 0) {
                rightNode.rightRotation(); // First do a right rotation on the right child
            }
            leftRotation(); // Then do a left rotation on the node itself
        } else if (balanceFactor < -1) { // Left-heavy case
            if (leftNode.getBalanceFactor() > 0) {
                leftNode.leftRotation(); // First do a left rotation on the left child
            }
            rightRotation(); // Then do a right rotation on the node itself
        }
    }
    
    private int getBalanceFactor() {
        return getHeight(rightNode) - getHeight(leftNode);
    }
    
    public void insertNode(int value) {
        AVLNode node = this;
        Stack<AVLNode> stack = new Stack<>();

        while (node != null) {
            stack.push(node);
            if (value < node.element) {
                node = node.leftNode;
            } else {
                node = node.rightNode;
            }
        }

        AVLNode parent = stack.pop();
        AVLNode newNode = new AVLNode(value);

        if (value < parent.element) {
            parent.leftNode = newNode;
        } else {
            parent.rightNode = newNode;
        }

        while (!stack.isEmpty()) {
            AVLNode current = stack.pop();
            current.balance();
        }

        this.balance();
        height = 1 + Math.max(getHeight(leftNode), getHeight(rightNode));
    }
}