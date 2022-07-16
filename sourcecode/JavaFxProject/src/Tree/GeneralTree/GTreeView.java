package Tree.GeneralTree;


import Tree.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class GTreeView extends Pane {

	public GTreeView() {
		// TODO Auto-generated constructor stub
	}
	  private GeneralTree tree = new GeneralTree();
	    private double radius = 15; // Tree node radius
	    private double vGap = 50; // Gap between two levels in a tree

	    public GTreeView(GeneralTree tree) {
	        this.tree = tree;
	        
	    }

	    public void setStatus(String msg) {
	        getChildren().add(new Text(20, 20, msg));
	    }

	    public void displayGTTree() {
	        this.getChildren().clear(); // Clear the pane
	        if (tree.getRoot() != null) {
	            // Display tree recursively
	            displayGTTree(tree.getRoot(), getWidth() / 2, vGap,
	                    getWidth()/12);
	        }
	    }

	    /**
	     * Display a subtree rooted at position (x, y)
	     */
	    private void displayGTTree(Node root,
	                                double x, double y, double hGap) {
	    	if(!root.getList().isEmpty())
	    	{
	    		for (int i=0;i<root.getList().size();i++)
	    		{
	    			Line line=new Line(x - hGap, y + vGap, x, y);
	    			//line.setVisible(false);
	    			getChildren().add(line);
	    			displayGTTree(root.getList().get(i), x + hGap, y + vGap, hGap / 2);
	    		}
	    	}
	        
	        // Display a node
	        Circle circle = new Circle(x, y, radius);
	        circle.setFill(Color.CYAN);
	        circle.setStroke(Color.BLACK);
	        if (root.getParent()!=null)
	        {
	        	 getChildren().addAll(circle,
	 	                new Text(x - 4, y + 4, root.getKey()+","+root.getParent().getKey() + ""));
	        }
	        else
	        	{getChildren().addAll(circle,
	                new Text(x - 4, y + 4, root.getKey()+" root"));
	        	}
	    }
	    
	    
}
