package Tree.BalancedBinaryTree;

import Tree.Node;
import Tree.BinarySearchTree.BinarySearchTree;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class BBiTreeView extends Pane {

	public BBiTreeView() {
		// TODO Auto-generated constructor stub
	}
	  private BinarySearchTree tree = new BinarySearchTree();
	    private double radius = 15; // Tree node radius
	    private double vGap = 50; // Gap between two levels in a tree

	   public  BBiTreeView(BinarySearchTree tree) {
	        this.tree = tree;
	       
	    }

	    public void setStatus(String msg) {
	        getChildren().add(new Text(20, 20, msg));
	    }

	    public void displayBBiTree() {
	        this.getChildren().clear(); // Clear the pane
	        if (tree.getRoot() != null) {
	            // Display tree recursively
	        	
	            displayBBiTree(tree.getRoot(), getWidth() / 2, vGap,
	                    getWidth() / 4);
	        }
	    }

	    /**
	     * Display a subtree rooted at position (x, y)
	     */
	    private void displayBBiTree(Node root,
	                                double x, double y, double hGap) {
	        if (root.getLeft() != null) {
	            // Draw a line to the left node
	            getChildren().add(new Line(x - hGap, y + vGap, x, y));
	            // Draw the left subtree recursively
	            displayBBiTree(root.getLeft(), x - hGap, y + vGap, hGap / 2);
	        }

	        if (root.getRight() != null) {
	            // Draw a line to the right node
	            getChildren().add(new Line(x + hGap, y + vGap, x, y));
	            // Draw the right subtree recursively
	            displayBBiTree(root.getRight(), x + hGap, y + vGap, hGap / 2);
	        }

	        // Display a node
	        Circle circle = new Circle(x, y, radius);
	      if(root.getColor()==1)
	      {
	    	   circle.setFill(Color.RED);
	    	   circle.setStroke(Color.BLACK);
	      }
	      else
	      {
	    	  circle.setFill(Color.GREY);
	    	  circle.setStroke(Color.WHITE);
	    	  
	      }
	    	   
	     
	        getChildren().addAll(circle,
	                new Text(x - 4, y + 4, root.getKey() + ""));
	    }

}
