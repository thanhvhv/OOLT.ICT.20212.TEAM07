package Tree.BinarySearchTree;

public class BinarySearchTree {

	public BinarySearchTree() {
		// TODO Auto-generated constructor stub
		root = null;
	}
    public void Create()
    {
       
    }
	Node root,root1;
	
	//delete a node from BST
    void deleteNode(int key) { 
        root = delete(root, key); 
    } 
   
    //recursive delete function
    Node delete(Node root, int key)  { 
        //tree is empty
        if (root == null)  return root; 
   
        //traverse the tree
        if (key < root.key)     //traverse left subtree 
            root.left = delete(root.left, key); 
        else if (key > root.key)  //traverse right subtree
            root.right = delete(root.right, key); 
        else  { 
            // node contains only one child
            if (root.left == null) 
                return root.right; 
            else if (root.right == null) 
                return root.left; 
   
 
            root.key = findMin(root.right); 
   
            // Delete the inOrderTraverse successor 
            root.right = delete(root.right, root.key); 
        } 
        return root; 
    } 
   
    int findMin(Node root)  { 
        //initially min = root
        int min = root.key; 
        //find min
        while (root.left != null)  { 
            min = root.left.key; 
            root = root.left; 
        } 
        return min; 
    } 
   
    // insertNode a node in BST 
    void insertNode(int key)  { 
        root = insert(root, key); 
    } 
   
    //recursive insertNode function
    Node insert(Node root, int key) { 
          //tree is empty
        if (root == null) { 
            root = new Node(key); 
            root1=root;
            return root; 
        } 
        //traverse the tree
        if (key < root.key)     //insertNode in the left subtree
            root.left = insert(root.left, key); 
        else if (key > root.key)    //insertNode in the right subtree
            root.right = insert(root.right, key); 
          // return pointer
        return root; 
    } 
 
// method for inOrderTraverse traversal of BST 
    void inOrderTraverseNode() { 
        inOrderTraverse(root); 
    } 
   
    // recursively traverse the BST  
    void inOrderTraverse(Node root) { 
        if (root != null) { 
            inOrderTraverse(root.left); 
            System.out.print(root.key + " "); 
            inOrderTraverse(root.right); 
        } 
    } 
    
    boolean searchNode(int key)  { 
    	root=root1;
        root = search(root, key); 
        if (root!= null)
            return true;
        else
            return false;
    } 
   
    //recursive insertNode function
    Node search(Node root, int key)  { 
        // Base Cases: root is null or key is present at root 
        if (root==null||root.key==key) 
            return root; 
        // val is greater than root's key 
        if (root.key > key) 
            return search(root.left, key); 
        // val is less than root's key 
        return search(root.right, key); 
    }
    boolean updateNode(int key)
    {
    	if(searchNode(key)==true)
    		{
    		return true;
    		}
    	return false;
    	
    }
    
}



