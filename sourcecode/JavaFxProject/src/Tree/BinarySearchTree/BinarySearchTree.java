package Tree.BinarySearchTree;


import java.util.LinkedList;

import Tree.Node;
import Tree.Tree;
import Tree.GeneralTree.GeneralTree;

public class BinarySearchTree extends GeneralTree{

	private Node root;
	private Node root2;
	private Node root3;
	private Node root4;
	private int check =0;
	public BinarySearchTree() {
		// TODO Auto-generated constructor stub
		root=null;
	}
	public BinarySearchTree(Node root)
	{
		this.root=root;
	}
	public void insertNode(int[] a)
	{
		for(int i=0;i<a.length;i++)
		{
			insertNode(a[i]);
		}
		traverseParent(root,root);
	}
	public Node getRoot()
	{
		return this.root;
	}
	@Override
	public void insertNode(int parent)
	{
		
			root =Insert(root,parent);
			traverseParent(root,root);
			
			
		
	}
	 public void clear() {
	        root = null;
	       // size = 0;
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
	    return root;
	}
	public void insertNode(Node key,int value)
	{
		if(value<=key.getKey())
		{
			if(key.getLeft()!=null) insertNode(key.getLeft(),value);
			else
			{
				root2=new Node(value);
				key.setLeft(root2);
				root2.setParent(key);
			}
		}
		if(value>key.getKey())
		{
			if(key.getRight()!=null) insertNode(key.getRight(),value);
			else
			{
				root2=new Node(value);
				key.setRight(root2);
				root2.setParent(key);
			}
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
	public int deleteNode(int value)
	{
		root=delete(root,value);
		traverseParent(root,root);
		return 1;
	}
	@Override
	public void traverse()
	{
		traverse(root);
		
	}
	public void traverse(Node key)
	{
		
		if(key!=null)
		{
			traverse(key.getLeft());
			System.out.println(key.getKey());
			traverse(key.getRight());
		}
		
		
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
	 return root;
	}
	public Node maxValueNode(Node root)
	{
	    Node current = root;
	 
	    while (current.getRight() != null)
	        current = current.getRight();
	 
	    return current;
	}
	 
	public int deleteNode(Node key,int value)
	{
		check=-1;
		traverse(key,value);
		if(check==1)
			{
			if(root3.getLeft()==null)
			{
				if(root3.getRight()==null)
				{
					if (root3.getParent().getLeft()!=null&&root3.getParent().getLeft().getKey()==value)
					{
						root3.getParent().setLeft(null);
					}
					if (root3.getParent().getRight()!=null&&root3.getParent().getRight().getKey()==value)
					{
						root3.getParent().setRight(null);
					}
					root3=null;
					return 1;
				}
				else
				{
					if (root3.getParent().getLeft()!=null&&root3.getParent().getLeft().getKey()==value)
					{
						root3.getParent().setLeft(root3.getRight());
					}
					if (root3.getParent().getRight()!=null&&root3.getParent().getRight().getKey()==value)
					{
						root3.getParent().setRight(root3.getRight());
					}
					root3=null;
					return 1;
				}
			}
		  if(root3.getRight()==null)
			{
				if(root3.getLeft()==null)
				{
					if (root3.getParent().getLeft()!=null&&root3.getParent().getLeft().getKey()==value)
					{
						root3.getParent().setLeft(null);
					}
					if (root3.getParent().getRight()!=null&&root3.getParent().getRight().getKey()==value)
					{
						root3.getParent().setRight(null);
					}
					root3=null;
					return 1;
				}
				else
				{
					if (root3.getParent().getLeft()!=null&&root3.getParent().getLeft().getKey()==value)
					{
						root3.getParent().setLeft(root3.getLeft());
					}
					if (root3.getParent().getRight()!=null&&root3.getParent().getRight().getKey()==value)
					{
						root3.getParent().setRight(root3.getLeft());
					}
					root3=null;
					return 1;
				}
			}
		  if(root3.getLeft()!=null&&root3.getRight()!=null)
		  {
			  check=findMin(root3.getRight());
			  root3.setKey(check);
			  deleteNode(root3.getRight(),check);
			  return 1;
		  }
			
			
			}else
			{
				System.out.println("The node isn't exist");
				return 1;
			}
			return 1;	
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
	@Override
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
	@Override
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
