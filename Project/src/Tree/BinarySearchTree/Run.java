package Tree.BinarySearchTree;

public class Run {

	public Run() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    BinarySearchTree bst= new BinarySearchTree();
    bst.insertNode(45); 
    bst.insertNode(10); 
    bst.insertNode(7); 
    bst.insertNode(12); 
    bst.insertNode(90); 
    bst.insertNode(50); 
    //print the BST
    System.out.println("The BST Created with input data(Left-root-right):"); 
    bst.inOrderTraverseNode(); 
    
    //delete leaf node 
    System.out.println("\nThe BST after Delete 12(leaf node):"); 
    bst.deleteNode(12); 
    bst.inOrderTraverseNode(); 
    //delete the node with one child
    System.out.println("\nThe BST after Delete 90 (node with 1 child):"); 
    bst.deleteNode(90); 
    bst.inOrderTraverseNode(); 
             
    //delete node with two children  
    System.out.println("\nThe BST after Delete 45 (Node with two children):"); 
    bst.deleteNode(45); 
    bst.inOrderTraverseNode(); 
    //search a key in the BST
    boolean ret_val = bst.searchNode (14);
    System.out.println("\nKey 50 found in BST:" + ret_val );
    boolean ret_val1 = bst.searchNode (50);
    System.out.println("\nKey 12 found in BST:" + ret_val1 );
    ret_val= bst.searchNode(50);
    System.out.println(ret_val);
    ret_val= bst.updateNode(12);
    System.out.println(ret_val);
    
    
 } 
}


