package Tree.BalancedBinaryTree;


public class Run {

	public Run() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    BalancedBinaryTree bst= new BalancedBinaryTree();
    int[] a= {1,4,6,3,5,7,8,2,9};
    bst.insertNode(a); 
    
    //bst.traverse();
    //bst.update();
   bst.deleteNode(6);
    //bst.update(4, 20);
    bst.traverse();
    //bst.test();
   // System.out.println(bst.search(2));
	} 

}
