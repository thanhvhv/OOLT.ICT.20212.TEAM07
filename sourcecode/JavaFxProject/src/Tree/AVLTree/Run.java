package Tree.AVLTree;



public class Run {

	public Run() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    AVLTree bst= new AVLTree();
    int[] a= {10,5,15,3,12,17,11};
    bst.insertNode(a); 
    
   
    bst.update(15,20);
    bst.traverse();
  // bst.deleteNode(15);
  //System.out.println(bst.traverse(10));
    //bst.test();
	} 
}
