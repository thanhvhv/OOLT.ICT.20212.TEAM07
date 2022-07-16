package Tree.GeneralTree;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import Tree.Node;
import Tree.Tree;

public class GeneralTree implements Tree {

	private Node root;
	
	private Node root2;
	private Node root3;
	private ArrayList<Node> parentList;
	private LinkedList<Tree> children;
	private int check =0;
	public GeneralTree() {
		// TODO Auto-generated constructor stub
		root = null;
	}
	public GeneralTree(Node root){
	        this.root = root;
	        
	    }
	public void insertNode(int[] a)
	{
		for(int i=0;i<a.length;i++)
		{
			insertNode(a[i]);
		}
	}
	public Node getRoot()
	{
		return this.root;
	}
	@Override
	public void insertNode(int parent,int child)
	{
		if (traverse(child)) System.out.println("This child value has exist");
		if (traverse(parent)) 
		{
			root2=new Node(child);
			parentList=root3.getList();
			parentList.add(root2);
			root2.setParent(root3);
			root3.setList(parentList);
		}else
		{
			System.out.println("The parent value hasn't exist");
		}
	}
	public void insertNode(int parent)
	{
		if(root==null)
		{
		root=new Node(parent);
		//root.setParent(root);
		
		}else
		{
			
			root2=new Node(parent);
			parentList=root.getList();
			parentList.add(root2);
			root2.setParent(root);
			root.setList(parentList);
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
		
		if(!key.getList().isEmpty())
		{
			for(int i=0;i<key.getList().size();i++)
			{
				traverse(key.getList().get(i),value);
			}
		    
		}
		if(key.getKey()==value)
		{
			check=1;
			root3=key;
		}
		
	}
	@Override
	public void traverse()
	{
		traverse(root);
		
	}
	public void traverse(Node key)
	{
		
		if(!key.getList().isEmpty())
		{
			for(int i=0;i<key.getList().size();i++)
			{
				traverse(key.getList().get(i));
			}
		    
		}
		System.out.println(!(key.getParent()==null)?key.getKey()+" "+key.getParent().getKey():key.getKey());
		
	}
	@Override
	public int deleteNode(int value)
	{
		parentList=new ArrayList<>();
		if(traverse(value))
			{
			if(root3==root)
			{
				if(!root.getList().isEmpty())
				{
				parentList.addAll(root.getList().get(0).getList());
				for(int i=1;i<root.getList().size();i++)
				{
					parentList.add(root.getList().get(i));
					root.getList().get(i).setParent(root.getList().get(0));
				}
				root.getList().get(0).setList(parentList);
				root=root.getList().get(0);
				}
				else
				{
					root=null;
				}
				return 1;
			}
			if (root3.getList().isEmpty())
			{
				parentList=root3.getParent().getList();
				parentList.remove(parentList.indexOf(root3));
				root3.getParent().setList(parentList);
				return 1;
			}
			else
			{
				int k=root3.getParent().getList().indexOf(root3);
				for(int i=0;i<k;i++)
				{
					parentList.add(root3.getParent().getList().get(i));
				}
				parentList.addAll(root3.getList());
				for(int i=k+1;i<root3.getParent().getList().size();i++)
				{
					parentList.add(root3.getParent().getList().get(i));
				}
				root3.getParent().setList(parentList);
				return 1;
			}
		    }else
		    {
		    	System.out.println("The value is not exist");
		    	return 1;
		    }
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
				root3.setKey(value);
			}else
			{
				System.out.println("The current value is not exist");
			}
		}else
		{
			System.out.println("The updated value has exist");
		}
	}
	 public void clear() {
	        root = null;
	       // size = 0;
	    }
	   
		
	}


