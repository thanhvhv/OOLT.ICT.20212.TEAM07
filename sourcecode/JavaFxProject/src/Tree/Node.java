package Tree;

import java.util.ArrayList;




public class Node {

        public Node() {
			// TODO Auto-generated constructor stub
		}

		int key;
		Node left;
		Node right;
		Node parent;
		int height;
        int color;
        public Node(int key,Node left,Node right,int height)
        {
        	this.key=key;
        	this.left=left;
        	this.right=right;
        	this.height=height;
        }
        public Node(int key,Node left,Node right,Node parent,int color)
        {
        	this.key=key;
        	this.left=left;
        	this.right=right;
        	this.parent=parent;
        	this.color = color;
        }
        public Node(int data) {
		    this.key = data;
		    list=new ArrayList<>();
		  }
	    ArrayList<Node> list;

	    public Node(int value, ArrayList<Node> list) {
	        this.key = value;
	        this.list = list;
	    }

		public ArrayList<Node> getList() {
			return list;
		}

		public void setList(ArrayList<Node> list) {
			this.list = list;
		}

		public int getKey() {
			return key;
		}

		public void setKey(int key) {
			this.key = key;
		}

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}

		public Node getParent() {
			return parent;
		}

		public void setParent(Node parent) {
			this.parent = parent;
		}

		public int getColor() {
			return color;
		}

		public void setColor(int color) {
			this.color = color;
		}

		public int getHeight() {
			return height;
		}

		public void setHeight(int height) {
			this.height = height;
		}
	    
	}

