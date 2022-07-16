package Tree.AVLTree;

import Tree.Node;
import Tree.BinarySearchTree.BinarySearchTree;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class AVLTreeView extends Pane {

	public AVLTreeView() {
		// TODO Auto-generated constructor stub
	}
	  private BinarySearchTree tree = new BinarySearchTree();
	    private double radius = 15; // Tree node radius
	    private double vGap = 50; // Gap between two levels in a tree

	    public AVLTreeView(BinarySearchTree tree) {
	        this.tree = tree;
	     
	    }

	    public void setStatus(String msg) {
	        getChildren().add(new Text(20, 20, msg));
	    }

	    public void displayAVLTree() {
	        this.getChildren().clear(); // Clear the pane
	        if (tree.getRoot() != null) {
	            // Display tree recursively
	            displayAVLTree(tree.getRoot(), getWidth() / 2, vGap,
	                    getWidth() / 4);
	        }
	    }

	    /**
	     * Display a subtree rooted at position (x, y)
	     */
	    private void displayAVLTree(Node root,
	                                double x, double y, double hGap) {
	        if (root.getLeft() != null) {
	            // Draw a line to the left node
	            getChildren().add(new Line(x - hGap, y + vGap, x, y));
	            // Draw the left subtree recursively
	            displayAVLTree(root.getLeft(), x - hGap, y + vGap, hGap / 2);
	        }

	        if (root.getRight() != null) {
	            // Draw a line to the right node
	            getChildren().add(new Line(x + hGap, y + vGap, x, y));
	            // Draw the right subtree recursively
	            displayAVLTree(root.getRight(), x + hGap, y + vGap, hGap / 2);
	        }

	        // Display a node
	        Circle circle = new Circle(x, y, radius);
	        circle.setFill(Color.CYAN);
	        circle.setStroke(Color.BLACK);
	        getChildren().addAll(circle,
	                new Text(x - 4, y + 4, root.getKey() + ""));
	    }

}
