package Tree.AVLTree;

import Tree.Node;
import Tree.BinarySearchTree.BinarySearchTree;

public class AVLTree extends BinarySearchTree {
	private Node root;
	private Node root2;
	private Node root3;
	private Node root4;
	private int check =0;

	public AVLTree() {
		// TODO Auto-generated constructor stub
		root=null;
	}
	public AVLTree(Node key)
	{
		this.root=key;
	}
   
	 public void insertNode(int value)
	 {
		 root=Insert(root,value);
		 traverseParent(root,root);
	 }
	 public void insertNode(int[] a)
	    {
	    	for(int i=0;i<a.length;i++)
	    	{
	    		root=Insert(root,a[i]);
	    	}
	    	traverseParent(root,root);
	    }
	 
	public int getHeight(Node root) {
	    if (root == null)
	        return 0;
	    return root.getHeight();
	}
	 
	public Node rightRotate(Node root)
	{
	    Node x = root.getLeft();
	 
	    root.setLeft(x.getRight());
	    x.setRight(root); 
	 
	    root.setHeight(1 + Math.max(getHeight(root.getLeft()), getHeight(root.getRight())));
	    x.setHeight(1 + Math.max(getHeight(x.getLeft()), getHeight(x.getRight())));
	 
	    return x;
	}
	 
	public Node leftRotate(Node root) 
	{
	    Node y = root.getRight();
	 
	    root.setRight(y.getLeft());
	    y.setLeft(root);
	
	    root.setHeight(1 + Math.max(getHeight(root.getLeft()), getHeight(root.getRight()))) ;
	    y.setHeight(1 + Math.max(getHeight(y.getLeft()), getHeight(y.getRight())));
	 
	    return y;
	}

	public Node Insert(Node root, int value) 
	{
	   
	    if (root == null)
	    {
	    	root2=new Node( value, null, null, 1 );
	        return root2 ; 
	    }
	    if (value > root.getKey())
	    {
	        root.setRight(Insert(root.getRight(), value)); 
	    }
	    else if (value < root.getKey())
	    {
	        root.setLeft(Insert(root.getLeft(), value));
	    }
	    else
	        return root; 
	 
	    
	    root.setHeight(1 + Math.max(getHeight(root.getLeft()), getHeight(root.getRight())));
	 
	
	    int valBalance = getHeight(root.getLeft()) - getHeight(root.getRight());
	    
	 
	    if (valBalance > 1 && value < root.getLeft().getKey())
	        return rightRotate(root);
	
	    if (valBalance < -1 && value > root.getRight().getKey())
	        return leftRotate(root);
	
	    if (valBalance > 1 && value > root.getLeft().getKey()) 
	    {
	        root.setLeft(leftRotate(root.getLeft())); 
	        return rightRotate(root);
	    }
	 
	    if (valBalance < -1 && value < root.getRight().getKey()) 
	    {
	        root.setRight(rightRotate(root.getRight()));
	        return leftRotate(root);
	    }
	 
	    return root;
	}
	public void traverseParent(Node key,Node parent)
	{
		if(key!=null)
		{
			
			traverseParent(key.getLeft(),key);
			key.setParent(parent);
			traverseParent(key.getRight(),key);
		}
	}
    public void traverse()
	{
		traverse(root);
		
	}
	public void traverse(Node key)
	{
		
		if(key!=null)
		{
			traverse(key.getLeft());
			System.out.println(key.getKey()+" "+key.getParent().getKey());
			traverse(key.getRight());
		}
		
	
	}
	public boolean traverse(int value)
	{
		check=-1;
		traverse(root,value);
		if (check!=-1)
		{
			return true;
		}
		return false;
	}
	public void traverse(Node key,int value)
	{
		
		
		if(key!=null)
		{
			if(value==key.getKey())
			{
				check=1;
				root3=key;
			}
			if(value<=key.getKey()) traverse(key.getLeft(),value);
			else
				traverse(key.getRight(),value);
		}
		
		
	}
	
	public int valueBalance(Node root) {
	    if (root == null)
	        return 0;
	    return getHeight(root.getLeft()) - getHeight(root.getRight());
	}
	 
	public Node maxValueNode(Node root)
	{
	    Node current = root;
	 
	    while (current.getRight() != null)
	        current = current.getRight();
	 
	    return current;
	}
	public Node getRoot()
	{
		return this.root;
	} 
	public int deleteNode(int value)
	{
		root=delete(root,value);
		traverseParent(root,root);
		return 1;
	}
	public Node delete(Node root, int key) 
	{
	  
	    if (root == null)
	        return root;
	 
	    if (key > root.getKey())
	        root.setRight(delete(root.getRight(), key));
	    else if (key < root.getKey())
	        root.setLeft(delete(root.getLeft(), key));
	 
	    else 
	    {
	      if (root.getLeft() == null || root.getRight() == null) 
	        {
	           Node temp = root.getLeft();
	            if (root.getRight() != null)
	                temp = root.getRight();

	            if (temp == null) 
	            {
	                temp = root;
	                root = null;
	              
	            }
	            else 
	            {
	                root = temp;
	               
	            }
	        }
	        
	        else 
	        {
	            
	            Node temp = maxValueNode(root.getLeft());
	 
	         
	            root.setKey(temp.getKey());
	 
	            
	            root.setLeft(delete(root.getLeft(), temp.getKey()));
	        }
	      
	    }
	 
	    
	    if (root == null)
	        return root;
	 
	    
	    root.setHeight(1 + Math.max(getHeight (root.getLeft()), getHeight (root.getRight())));
	 
	    int valBalance = valueBalance(root);
	 
	    if (valBalance > 1 && valueBalance(root.getLeft()) >= 0)
	        return rightRotate(root);
	 
	   if (valBalance < -1 && valueBalance(root.getRight()) <= 0)
	        return leftRotate(root);
	   
	    if (valBalance > 1 && valueBalance(root.getLeft()) < 0){
	        root.setLeft(leftRotate(root.getLeft())) ;
	        return rightRotate(root);
	    }
	 
	    if (valBalance < -1 && valueBalance(root.getRight()) > 0){
	        root.setRight(rightRotate(root.getRight()));
	        return leftRotate(root);
	    }
	 
	    return root;
	}
	 public void clear() {
	        root = null;
	       // size = 0;
	    }
	int min;
	public int findMin(Node key)
	{
		if(key!=null)
		{
			min=key.getKey();
			findMin(key.getLeft());
		}
		return min;
		
	}
	public boolean search(int value)
	{
		if(traverse(value))
		{
			System.out.println(root3);
			return true;
		}else
		{
			System.out.println("the value isn't exist");
			return false;
		}
	}
	public void update(int current,int value)
	{
		if (!traverse(value))
		{
			if(traverse(current))
			{
				if(root3.getParent()!=root3)
				{
					root4=root3.getParent();
					if(root4.getLeft()==root3)
					{
						if(value<root4.getKey())
						{
							if(root3.getLeft()==null&&root3.getRight()==null)
							{
								root3.setKey(value);
								return;
							}
							if(root3.getLeft()!=null&&root3.getRight()==null)
							{
								if(value>root3.getLeft().getKey())
								{
									root3.setKey(value);
									return;
								}
								else
								{
									deleteNode(root3.getKey());
									insertNode(value);
									return;
									
								}
							}

							if(root3.getLeft()==null&&root3.getRight()!=null)
							{
								if(value<root3.getRight().getKey())
								{
									root3.setKey(value);
									return;
								}
								else
								{
									deleteNode(root3.getKey());
									insertNode(value);
									return;
									
								}
							}
							if(root3.getLeft()!=null&&root3.getRight()!=null)
							{
								if(value>root3.getLeft().getKey()&&value<root3.getRight().getKey())
								{
									root3.setKey(value);
									return;
								}
								else
								{
									deleteNode(root3.getKey());
									insertNode(value);
									return;
								}
							}
						}
						else
						{
							deleteNode(root3.getKey());
							insertNode(value);
							return;
						}
					}
					else
					{
						if(root4.getRight()==root3)
						{
							if(value>root4.getKey())
							{
								if(root3.getLeft()==null&&root3.getRight()==null)
								{
									root3.setKey(value);
									return;
								}
								if(root3.getLeft()!=null&&root3.getRight()==null)
								{
									if(value>root3.getLeft().getKey())
									{
										root3.setKey(value);
										return;
									}
									else
									{
										deleteNode(root3.getKey());
										insertNode(value);
										return;
										
									}
								}

								if(root3.getLeft()==null&&root3.getRight()!=null)
								{
									if(value<root3.getRight().getKey())
									{
										root3.setKey(value);
										return;
									}
									else
									{
										deleteNode(root3.getKey());
										insertNode(value);
										return;
										
									}
								}
								if(root3.getLeft()!=null&&root3.getRight()!=null)
								{
									if(value>root3.getLeft().getKey()&&value<root3.getRight().getKey())
									{
										root3.setKey(value);
										return;
									}
									else
									{
										deleteNode(root3.getKey());
										insertNode(value);
										traverseParent(root,root);
										return;
									}
								}
							}
							else
							{
								deleteNode(root3.getKey());
								insertNode(value);
								return;
							}
						}
					}
				}
				else
				{
					if(root3.getLeft()==null&&root3.getRight()==null)
					{
						root3.setKey(value);
						return;
					}
					if(root3.getLeft()!=null&&root3.getRight()==null)
					{
						if(value>root3.getLeft().getKey())
						{
							root3.setKey(value);
							return;
						}
						else
						{
							deleteNode(root3.getKey());
							insertNode(value);
							return;
							
						}
					}

					if(root3.getLeft()==null&&root3.getRight()!=null)
					{
						if(value<root3.getRight().getKey())
						{
							root3.setKey(value);
							return;
						}
						else
						{
							deleteNode(root3.getKey());
							insertNode(value);
							return;
							
						}
					}
					if(root3.getLeft()!=null&&root3.getRight()!=null)
					{
						if(value>root3.getLeft().getKey()&&value<root3.getRight().getKey())
						{
							root3.setKey(value);
							return;
						}
						else
						{
							deleteNode(root3.getKey());
							insertNode(value);
							return;
						}
					}
				}
				
			}else
			{
				System.out.println("The current value is not exist");
			}
		}else
		{
			System.out.println("The updated value has exist");
		}
	}

}
