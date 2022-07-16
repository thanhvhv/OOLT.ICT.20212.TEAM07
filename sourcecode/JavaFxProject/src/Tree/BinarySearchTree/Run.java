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
    bst.insertNode(8); 
    bst.deleteNode(45);
   // bst.update(12, 20);
    bst.traverse();
    
    
}
}
