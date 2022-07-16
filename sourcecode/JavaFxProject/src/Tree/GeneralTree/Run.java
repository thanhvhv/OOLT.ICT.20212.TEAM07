package Tree.GeneralTree;



public class Run {

	public Run() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    GeneralTree bst= new GeneralTree();
    bst.insertNode(45); 
    bst.insertNode(10); 
    bst.insertNode(7); 
    bst.insertNode(10,12); 
    bst.insertNode(10,90); 
    bst.insertNode(7,50); 
    bst.traverse();
    
    
}
}
