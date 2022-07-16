package Tree.BalancedBinaryTree;

import Tree.Node;
import Tree.AVLTree.AVLTree;
import Tree.BinarySearchTree.BinarySearchTree;

public class BalancedBinaryTree extends BinarySearchTree {

	private Node root;
	private Node root13;
	private Node root14;
	private int check =0;

	boolean ll = false;
    boolean rr = false;
    boolean lr = false;
    boolean rl = false;
	public BalancedBinaryTree() {
		// TODO Auto-generated constructor stub
		root=null;
	}
	public BalancedBinaryTree(Node key) {
		this.root=key;
	}

	public Node rotateRight(Node root1) {
        Node x = root1.getLeft();
        root1.setLeft(x.getRight());
        if (x.getRight() != null)
            x.getRight().setParent(root1);
 
        x.setParent(root1.getParent());
        if (root1.getParent() == null)
            root = x;
        else if (root1.getParent().getLeft() == root1)
            root1.getParent().setLeft(x);
        else
            root1.getParent().setRight(x);
        x.setRight(root1);
        root1.setParent(x);
        return x;
    }
 
    public Node rotateLeft(Node root1) {
        Node y = root1.getRight();
        root1.setRight(y.getLeft());
        if (y.getLeft() != null)
            y.getLeft().setParent(root1);
 
        y.setParent(root1.getParent());
        if (root1.getParent() == null)
            root = y;
        else if (root1.getParent().getLeft() == root1)
            root1.getParent().setLeft(y);
        else
            root1.getParent().setRight(y);
        y.setLeft(root1);
        root1.setParent(y);
        return y;
    }
	public Node insertHelp(Node root1, int key) 
	{
        boolean f = false;
 
        if (root1 == null) 
        {
            return new Node( key, null, null, null, 1 ); 
        }
        else if (key < root1.getKey()) 
        {
            root1.setLeft(insertHelp(root1.getLeft(), key));
            root1.getLeft().setParent(root1); 
            if (root != root1) 
            {
                if (root1.getColor()==1&&root1.getColor() == root1.getLeft().getColor())
                    f = true;
            }
        }
        else 
        {
            root1.setRight(insertHelp(root1.getRight(), key));
            root1.getRight().setParent(root1);
            if (root != root1) 
            {
                if (root1.getColor()== 1&& root1.getRight().getColor()==root1.getColor() )
                    f = true;
            }
        }
        if (ll) 
        {
            root1 = rotateRight(root1);
            root1.setColor(0);
            root1.getRight().setColor(1);
            ll = false;
        }
        else if (rr) 
        {
            root1 = rotateLeft(root1);
            root1.setColor(0);
            root1.getLeft().setColor(1);
            rr = false;
        }
        else if (lr) 
        {
            root1.setLeft(rotateLeft(root1.getLeft()));
            root1.getLeft().setParent(root1); 
            root1 = rotateRight(root1);
            root1.setColor(0);
            root1.getRight().setColor(1);
            lr = false;
        }
        else if (rl) 
        {
            root1.setRight(rotateRight(root1.getRight()));
            root1.getRight().setParent(root1);
 
            root1 = rotateLeft(root1);
            root1.setColor(0);
            root1.getLeft().setColor(1);
            rl = false;
        }
 
        if (f) 
        {
            if (root1.getParent().getRight() == root1) 
            {
                if (root1.getParent().getLeft() == null || root1.getParent().getLeft().getColor() == 0) 
                {
     
                    if (root1.getLeft() != null && root1.getLeft().getColor() == 1)
                        rl = true;
                    if (root1.getRight() != null && root1.getRight().getColor() == 1)
                        rr = true;
                }
                else 
                {
                 
                    root1.setColor(0);root1.getParent().getLeft().setColor(0);
                    if (root1 != root)
                        root1.getParent().setColor(1);
                }
            }
            else 
            {
                if (root1.getParent().getRight() == null || root1.getParent().getRight().getColor() == 0) 
                {
                    
                    if (root1.getLeft() != null && root1.getLeft().getColor() == 1)
                        ll = true;
                    if (root1.getRight() != null && root1.getRight().getColor() == 1)
                        lr = true;
                }
                else 
                {
                   
                    root1.setColor(0);  root1.getParent().getRight().setColor(0);
                    if (root1 != root)
                        root1.getParent().setColor(1);
                }
            }
            f = false;
        }
        return root1;
    }
 
	public Node getRoot()
	{
		return this.root;
	}
	public void insertNode(int[] a)
	{
		for(int i=0;i<a.length;i++)
		{
			Insert(a[i]);
		}
	}
	public void insertNode(int a)
	{
			Insert(a);
		
	}
    public void Insert(int key) 
    {
        if (root == null) 
        {
            root = new Node( key, null, null, null, 0 );
        }
        else 
        {
            root = insertHelp(root, key);
            if (root.getColor() == 1)
                root.setColor(0);
        }
    }
    public Node maxValueNode(Node root1)
    {
        Node current = root1;
        while (current.getRight() != null)
            current = current.getRight();
        return current;
    }
     
    public Node sibling(Node current) 
    {
        if (current.getParent() == null)
            return null;
        if (current.getParent().getLeft() == current)
            return current.getParent().getRight();
        return current.getParent().getLeft();
    }
     
    public void swapColors(Node x1, Node x2) 
    {
        int temp;
        temp = x1.getColor();
        x1.setColor(x2.getColor()); 
        x2.setColor(temp); 
    }
     
    public void swapValues(Node u, Node v) 
    {
        int temp;
        temp = u.getKey();
        u.setKey(v.getKey()); 
        v.setKey(temp); 
    }
     
    boolean hasRedChild(Node x) 
    {
        if (x.getRight() != null)
            if (x.getRight().getColor() == 1)
                return true;
        if (x.getLeft() != null)
            if (x.getLeft().getColor() == 1)
                return true;
        return false;
    }
    public void fixDoubleBlack(Node root1) 
    {
        if (root1 == root)
           return;
        Node sib = sibling(root1);
        Node par = root1.getParent();
 
        if (sib == null)
            fixDoubleBlack(par);
        else {
            if (sib.getColor() == 1) 
            {
                par.setColor(1); 
                sib.setColor(0);
 
                if (sib.getParent().getLeft() == sib) 
                    par = rotateRight(par);
                else 
                    par = rotateLeft(par);
        
                fixDoubleBlack(root1);
            }
            else 
            {
                if (hasRedChild(sib)) 
                {
                    if (sib.getParent().getLeft() == sib) 
                    {
                        if (sib.getLeft() != null && sib.getLeft().getColor()==1) {
                            sib.getLeft().setColor(sib.getColor()); 
                            sib.setColor(par.getColor()); 
                              par.setColor(0);
                              par = rotateRight(par);
                        }
                        else 
                        {
                            sib.getRight().setColor(par.getColor()); 
                              par.setColor(0);
                            sib = rotateLeft(sib);
                            par = rotateRight(par);
                        }
                    }
                    else 
                    {
                        if (sib.getRight() != null && sib.getRight().getColor()==1) 
                        {
                            sib.getRight().setColor(sib.getColor()); 
                            sib.setColor(par.getColor()); 
                            par.setColor(0);
                            par = rotateLeft(par);
                        }
                        else 
                        {
                            sib.getLeft().setColor(par.getColor());
                            par.setColor(0);
                            sib = rotateRight(sib);
                            par = rotateLeft(par);
                        }
                    }
                }
                else 
                {
                    sib.setColor(1); 
                    if (par.getColor()==0)
                        fixDoubleBlack(par);
                    else
                        par.setColor(0); 
                }
            }
        }
             
    }
    public void deleteNode(Node vDelete) 
    {
        Node uReplace;
 
        if ((vDelete.getLeft() != null) && (vDelete.getRight() != null))
            uReplace = maxValueNode(vDelete.getLeft());
        else if (vDelete.getLeft() != null) 
            uReplace = vDelete.getLeft();
        else if (vDelete.getRight() != null) 
            uReplace = vDelete.getRight();
        else 
            uReplace = null;
 
        boolean uvBlack = ((uReplace == null) || (uReplace.getColor() == 0)) && (vDelete.getColor() == 0);
        Node par = vDelete.getParent();
        Node sib = sibling(vDelete);
        if (uReplace == null) 
        {
            if (vDelete == root) 
            {
                root = null;
            }
            else
            {
                if (uvBlack)
                    fixDoubleBlack(vDelete);
                else if(sib != null)
                    sib.setColor(1);
 
                if (vDelete.getParent().getLeft() == vDelete)
                    par.setLeft(null); 
                else
                    par.setRight(null); 
            }
            return;
        }
 
        if (vDelete.getLeft() == null || vDelete.getRight() == null) 
        {
            if (vDelete == root) 
            {
                vDelete.setKey(uReplace.getKey());
                vDelete.setLeft(null);
                vDelete.setRight(null);
                       
            }
            else 
            {
                if (vDelete.getParent().getLeft() == vDelete)
                    par.setLeft(uReplace);
                else
                    par.setRight(uReplace);
                
 
                uReplace.setParent(par);
                if (uvBlack)
                    fixDoubleBlack(uReplace);
                else
                    uReplace.setColor(0); 
            }
            return;
        }
        swapValues(uReplace, vDelete);
        deleteNode(uReplace);
    }
    public Node searchNode(int val) 
    {
        Node temp = root;
        while (temp != null) {
            if (val < temp.getKey()) {
                if (temp.getLeft() == null)
                    return null;
                else
                    temp = temp.getLeft();
            }
            else if (val == temp.getKey()) {
                break;
            }
            else {
                if (temp.getRight() == null)
                    return null;
                else
                    temp = temp.getRight();
            }
        }
        return temp;
    }
    public int deleteNode(int value)
    {
    	Delete(value);
    	return 1;
    }
    public void Delete(int val) 
    {
        Node vDelete = searchNode(val);
        if (vDelete == null) 
        {
            System.out.println( "\n ** Khong tim thay Node can xoa **\n");
            return;
        }
        else 
        {
            deleteNode(vDelete);
        }
        return;
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
   			System.out.println(!(key.getParent()==null)?key.getKey()+" "+getColor(key)+" "+key.getParent().getKey():key.getKey()+" "+getColor(key));
   			traverse(key.getRight());
   		}
   		
   	
   	}
    public void clear() {
        root = null;
       // size = 0;
    }
   	public boolean search(int value)
	{
		if(traverse(value))
		{
			System.out.println(root13);
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
				if(root13.getParent()!=root13)
				{
					root14=root13.getParent();
					if(root14.getLeft()==root13)
					{
						if(value<root14.getKey())
						{
							if(root13.getLeft()==null&&root13.getRight()==null)
							{
								root13.setKey(value);
								return;
							}
							if(root13.getLeft()!=null&&root13.getRight()==null)
							{
								if(value>root13.getLeft().getKey())
								{
									root13.setKey(value);
									return;
								}
								else
								{
									deleteNode(root13.getKey());
									insertNode(value);
									return;
									
								}
							}

							if(root13.getLeft()==null&&root13.getRight()!=null)
							{
								if(value<root13.getRight().getKey())
								{
									root13.setKey(value);
									return;
								}
								else
								{
									deleteNode(root13.getKey());
									insertNode(value);
									return;
									
								}
							}
							if(root13.getLeft()!=null&&root13.getRight()!=null)
							{
								if(value>root13.getLeft().getKey()&&value<root13.getRight().getKey())
								{
									root13.setKey(value);
									return;
								}
								else
								{
									deleteNode(root13.getKey());
									insertNode(value);
									return;
								}
							}
						}
						else
						{
							deleteNode(root13.getKey());
							insertNode(value);
							return;
						}
					}
					else
					{
						if(root14.getRight()==root13)
						{
							if(value>root14.getKey())
							{
								if(root13.getLeft()==null&&root13.getRight()==null)
								{
									root13.setKey(value);
									return;
								}
								if(root13.getLeft()!=null&&root13.getRight()==null)
								{
									if(value>root13.getLeft().getKey())
									{
										root13.setKey(value);
										return;
									}
									else
									{
										deleteNode(root13.getKey());
										insertNode(value);
										return;
										
									}
								}

								if(root13.getLeft()==null&&root13.getRight()!=null)
								{
									if(value<root13.getRight().getKey())
									{
										root13.setKey(value);
										return;
									}
									else
									{
										deleteNode(root13.getKey());
										insertNode(value);
										return;
										
									}
								}
								if(root13.getLeft()!=null&&root13.getRight()!=null)
								{
									if(value>root13.getLeft().getKey()&&value<root13.getRight().getKey())
									{
										root13.setKey(value);
										return;
									}
									else
									{
										deleteNode(root13.getKey());
										insertNode(value);
										return;
									}
								}
							}
							else
							{
								deleteNode(root13.getKey());
								insertNode(value);
								return;
							}
						}
					}
				}
				else
				{
					if(root13.getLeft()==null&&root13.getRight()==null)
					{
						root13.setKey(value);
						return;
					}
					if(root13.getLeft()!=null&&root13.getRight()==null)
					{
						if(value>root13.getLeft().getKey())
						{
							root13.setKey(value);
							return;
						}
						else
						{
							deleteNode(root13.getKey());
							insertNode(value);
							return;
							
						}
					}

					if(root13.getLeft()==null&&root13.getRight()!=null)
					{
						if(value<root13.getRight().getKey())
						{
							root13.setKey(value);
							return;
						}
						else
						{
							deleteNode(root13.getKey());
							insertNode(value);
							return;
							
						}
					}
					if(root13.getLeft()!=null&&root13.getRight()!=null)
					{
						if(value>root13.getLeft().getKey()&&value<root13.getRight().getKey())
						{
							root13.setKey(value);
							return;
						}
						else
						{
							deleteNode(root13.getKey());
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
				root13=key;
			}
			if(value<=key.getKey()) traverse(key.getLeft(),value);
			else
				traverse(key.getRight(),value);
		}
		
		
	}
 public String getColor(Node root1) 
{
    if (root1.getColor() == 1)
        return "RED";
    return "BLACK";
}
}
