package JavaFx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.ResourceBundle;


import Tree.AVLTree.AVLTree;
import Tree.AVLTree.AVLTreeView;
import Tree.BalancedBinaryTree.BBiTreeView;
import Tree.BalancedBinaryTree.BalancedBinaryTree;
import Tree.BinarySearchTree.BSTreeView;
import Tree.BinarySearchTree.BinarySearchTree;
import Tree.GeneralTree.GTreeView;
import Tree.GeneralTree.GeneralTree;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class Controller  {

	public Controller() {
		// TODO Auto-generated constructor stub
	}
	GeneralTree tree1= new GeneralTree();
	BinarySearchTree tree2= new BinarySearchTree();
	AVLTree tree3= new AVLTree();
	BalancedBinaryTree tree4= new BalancedBinaryTree();
	
	@FXML
	Button generalTree = new Button("General Tree");
	@FXML
	Button binarySearchTree = new Button("binarySearchTree");
	@FXML
	Button aVLTree = new Button("AVL Tree");
    @FXML
	Button balancedBinaryTree = new Button("Balanced Binary Tree");
    @FXML
	Button create = new Button("Create");
    @FXML
	Button insert = new Button("Insert");
    @FXML
	Button delete = new Button("Delete");
    @FXML
	Button search = new Button("Search");
    @FXML
	Button update = new Button("Update");
    @FXML
	Button traverse = new Button("Traverse");
    @FXML 
    Button ok=new Button("ok");
    @FXML
    BorderPane myView = new BorderPane();
    BSTreeView view = new BSTreeView(tree2); 
    AVLTreeView view1 = new AVLTreeView(tree3);
    BBiTreeView view2=new BBiTreeView(tree4);
    GTreeView view3= new GTreeView(tree1);
    int t=0;
    String s,s1;
    int[] insertVal;
    ArrayList<Integer> treeVal = new ArrayList<>();
    String[] a = {"GeneralTree","BinarySearchTree","AVLTree","BalancedBinaryTree"};
   @FXML
    TextField tfKey = new TextField();
   @FXML
   TextField tfKey2=new TextField();
   Validation v = new Validation();
   public void invalidKey(TextField key, String alertHeader) {
       Alert alert = new Alert(Alert.AlertType.WARNING);
       alert.setTitle("Warning");
       alert.setHeaderText(alertHeader);
       alert.setContentText("Please enter an integer in the key box and try again");
       key.requestFocus();
       alert.showAndWait();
   }

    public void set1()
    {
    	
    	generalTree.setStyle("-fx-text-fill: #000000; ");
    	binarySearchTree.setStyle("-fx-text-fill: #000000; ");
    	aVLTree.setStyle("-fx-text-fill: #000000; ");
    	balancedBinaryTree.setStyle("-fx-text-fill: #000000; ");
    	generalTree.setUnderline(false);
    	binarySearchTree.setUnderline(false);
    	aVLTree.setUnderline(false);
    	balancedBinaryTree.setUnderline(false);
    }
    public void set2() 
    {
    	
    	create.setStyle("-fx-text-fill: #000000; ");
    	insert.setStyle("-fx-text-fill: #000000; ");
    	delete.setStyle("-fx-text-fill: #000000; ");
    	search.setStyle("-fx-text-fill: #000000; ");
    	update.setStyle("-fx-text-fill: #000000; ");
    	traverse.setStyle("-fx-text-fill: #000000; ");
    	 create.setUnderline(false);
    	 insert.setUnderline(false);
    	 delete.setUnderline(false);
    	 search.setUnderline(false);
    	update.setUnderline(false);
    	traverse.setUnderline(false);
    	 
    }
	public void pok()
	{
		
	}
	
    public void set()
    {
    	generalTree.setOnAction(e->
    	{
    		t=1;
    		s="GeneralTree";
    		set1();
    		generalTree.setUnderline(true);
    		generalTree.setStyle("-fx-text-fill: #ff0000; ");
    		
    	});
    	binarySearchTree.setOnAction(e->
    	{
    		t=1;
    		s="BinarySearchTree";
    		set1();
    		binarySearchTree.setUnderline(true);
    		binarySearchTree.setStyle("-fx-text-fill: #ff0000; ");
    	});
    	aVLTree.setOnAction(e->
    	{
    		t=1;
    		s="AVLTree";
    		set1();
    		aVLTree.setUnderline(true);
    		aVLTree.setStyle("-fx-text-fill: #ff0000; ");
    	});
    	balancedBinaryTree.setOnAction(e->
    	{
    		t=1;
    		s="BalancedBinaryTree";
    		set1();
    		balancedBinaryTree.setUnderline(true);
    		balancedBinaryTree.setStyle("-fx-text-fill: #ff0000; ");
    	});
    	create.setOnAction(e->
    	{
    		if(t==1||t==2)
    		{
    			t=2;
    			s1="Create";
    		set2();
            create.setUnderline(true);
    		create.setStyle("-fx-text-fill: #ff0000; ");
    		ok.setText(s1);
    		}
    	});
    	insert.setOnAction(e->
    	{if(t==1||t==2)
    	{
    		t=2;
			s1="Insert";
    		set2();
    		insert.setUnderline(true);
    		insert.setStyle("-fx-text-fill: #ff0000; ");
    		ok.setText(s1);
    	}
    	});
    	delete.setOnAction(e->
    	{
    		if(t==1||t==2)
    		{
    			t=2;
    			s1="Delete";
    		set2();
    		delete.setUnderline(true);
    		delete.setStyle("-fx-text-fill: #ff0000; ");
    		ok.setText(s1);
    		}
    	});
    	search.setOnAction(e->
    	{
    		if(t==1||t==2)
    		{
    			t=2;
    			s1="Search";
    		
    		set2();
    		search.setUnderline(true);
    		search.setStyle("-fx-text-fill: #ff0000; ");
    		ok.setText(s1);
    		}
    	});
    	update.setOnAction(e->
    	{
    		if(t==1||t==2)
    			{
    			t=2;
    			
			s1="Update";
    		set2();
    		update.setUnderline(true);
    		update.setStyle("-fx-text-fill: #ff0000; ");
    		ok.setText(s1);
    	}
    	});
    	traverse.setOnAction(e->
    	{
    		if(t==1||t==2)
    		{
    		t=2;
			s1="Traverse";
    		set2();
    		traverse.setUnderline(true);
    		traverse.setStyle("-fx-text-fill: #ff0000; ");
    		ok.setText(s1);
    		}
    	});
    	ok.setOnAction(e->
    	{
    		
    		if(t==2)
    		{
    			if(s=="GeneralTree")
    			{
    				myView.setCenter(view3);
    				if(s1=="Create")
    				{
    					tree2.clear();
    					tree3.clear();
    					tree4.clear();
    					tree1=new GeneralTree();
    					view3.setStatus("A new General Tree has been created");
    				}
    				if(s1=="Insert")
    				{
    					if(tree1.getRoot()==null)
    					{
    						if (v.emptyTextField(tfKey)) {
    			                invalidKey(tfKey, "No key entered!");
    			            } else {
    			            	try
    			            	{
    			            		int key = Integer.parseInt(tfKey.getText());
    			            		
    			            		tree1.insertNode(key);
    			            		view3.displayGTTree();
    			            		view3.setStatus(key+"is added in tree");
    			            		treeVal.add(key);
    			            		
    			            		tfKey.setText("");
					                tfKey.requestFocus();
    			            		
    			            	}catch (NumberFormatException ex) {
				                    invalidKey(tfKey, "Key must be an integer!");
				                }
    			            }
    					}
    					else
    					{
    						
    					if (v.emptyTextField(tfKey2)) {
    						if (v.emptyTextField(tfKey)) {
				                invalidKey(tfKey, "No inserted key entered!");}
				                else
				                {
				                	try
				                	{
				                		
				                		int key1 = Integer.parseInt(tfKey.getText());
				                		
				                			tree1.insertNode(key1);
		    			            		view3.displayGTTree();
		    			            		view3.setStatus(key1+"is added in tree");
		    			            		treeVal.add(key1);
				                		
				                		
				                		tfKey2.setText("");
						                tfKey2.requestFocus();
				                		
				                	}
				                	 catch (NumberFormatException ex) {
						                    invalidKey(tfKey, "Key must be an integer!");
						                }
				                }
			            } else {
			                try {
			                    int key = Integer.parseInt(tfKey2.getText());
			                    if (tree2.search(key)) { // key is in the tree already
			                    	if (v.emptyTextField(tfKey)) {
						                invalidKey(tfKey, "No inserted key entered!");}
						                else
						                {
						                	try
						                	{
						                		
						                		int key1 = Integer.parseInt(tfKey.getText());
						                		if(!tree2.search(key1))
						                		{
						                			tree1.insertNode(key,key1);
				    			            		view3.displayGTTree();
				    			            		view3.setStatus(key+"is added in tree");
				    			            		treeVal.add(key);
						                		}
						                		else
						                		{
						                			view3.displayGTTree();
						                			view3.setStatus(key1+"is alrealdy exist");
						                		}
						                		tfKey2.setText("");
								                tfKey2.requestFocus();
						                		
						                	}
						                	 catch (NumberFormatException ex) {
								                    invalidKey(tfKey, "Key must be an integer!");
								                }
						                }
			                    }
			                    else
			                    {
			                    	view3.displayGTTree();
			                    	view3.setStatus(key+"is alrealdy exist");
			                    }
			                    tfKey.setText("");
			                    tfKey.requestFocus();
			                } catch (NumberFormatException ex) {
			                    invalidKey(tfKey, "Key must be an integer!");
			                }
			            }
    					
    				}
    				if(s1=="Delete")
    				{

    					 if (v.emptyTextField(tfKey)) {
    			                invalidKey(tfKey, "No key entered!");
    			            } else {
    			                try {
    			                    int key = Integer.parseInt(tfKey.getText());
    			                    if (!tree1.search(key)) { // key is not in the tree
    			                        view3.displayGTTree();
    			                        view3.setStatus(key + " is not in the tree");
    			                    } else {
    			                        tree1.deleteNode(key); // Delete a key
    			                        view3.displayGTTree();
    			                        view3.setStatus(key + " is deleted from the tree");
    			                        treeVal.remove(treeVal.indexOf(key)); // 
    			                    
    			                    }
    			                    tfKey.setText("");
    			                    tfKey.requestFocus();
    			                } catch (NumberFormatException ex) {
    			                    invalidKey(tfKey, "Key must be an integer!");
    			                }
    			            }
    				}
    				}
    				if(s1=="Search")
    				{
    					if (v.emptyTextField(tfKey)) {
			                invalidKey(tfKey, "No key entered!");
			            } else {
			            	
			                try {
			                	
			                int key = Integer.parseInt(tfKey.getText());
			                   view3.displayGTTree();
			                   tree1.search(key);
			                    tfKey.setText("");
			                    tfKey.requestFocus();
			                } catch (NumberFormatException ex) {
			                    invalidKey(tfKey, "Key must be an integer!");
			                }
			            }
    				}
    				if(s1=="Update")
    				{
    					
    					if (v.emptyTextField(tfKey2)) {
			                invalidKey(tfKey2, "No current key entered!");
			            } else {
			                try {
			                    int key = Integer.parseInt(tfKey2.getText());
			                    if (tree1.search(key)) { // key is in the tree already
			                    	if (v.emptyTextField(tfKey)) {
						                invalidKey(tfKey, "No new key entered!");}
						                else
						                {
						                	try
						                	{
						                		
						                		int key1 = Integer.parseInt(tfKey.getText());
						                		if(!tree1.search(key1))
						                		{
						                		view3.displayGTTree();
						                		tree1.update(key,key1);
						                		view3.displayGTTree();
						                		view3.setStatus(key+"is updated with new value"+key1);
						                		treeVal.set(treeVal.indexOf(key),key1);
						                		}
						                		else
						                		{
						                			view3.displayGTTree();
						                			view3.setStatus(key1+"is alrealdy exist");
						                		}
						                		tfKey2.setText("");
								                tfKey2.requestFocus();
						                		
						                	}
						                	 catch (NumberFormatException ex) {
								                    invalidKey(tfKey, "Key must be an integer!");
								                }
						                }
			                    }
			                    else
			                    {
			                    	view3.displayGTTree();
			                    	view3.setStatus(key+"is alrealdy exist");
			                    }
			                    tfKey.setText("");
			                    tfKey.requestFocus();
			                } catch (NumberFormatException ex) {
			                    invalidKey(tfKey, "Key must be an integer!");
			                }
			            }
    					
    	                
    				}
    				if(s1=="Traverse")
    				{
    					view3.displayGTTree();
    					view3.setStatus("Traverse");
    				}
    				
    			}
    			if(s=="BinarySearchTree")
    			{
    				myView.setCenter(view);
    				if(s1=="Create")
    				{
    					tree1.clear();
    					tree3.clear();
    					tree4.clear();
    					tree2=new BinarySearchTree();
    					view.setStatus("A new Binary Search Tree has been created");
    				}
    				if(s1=="Insert")
    				{
    					 if (v.emptyTextField(tfKey)) {
    			                invalidKey(tfKey, "No key entered!");
    			            } else {
    			                try {
    			                    int key = Integer.parseInt(tfKey.getText());
    			                    if (tree2.search(key)) { // key is in the tree already
    			                        view.displayBSTTree();
    			                        view.setStatus(key + " is already in the tree");
    			                    } else {
    			                        tree2.insertNode(key); // Insert a new key
    			                        view.displayBSTTree();
    			                        view.setStatus(key + " is inserted in the tree");
    			                        treeVal.add(key); // Adds value to HashSet for building AVL tree
    			                    }
    			                    tfKey.setText("");
    			                    tfKey.requestFocus();
    			                } catch (NumberFormatException ex) {
    			                    invalidKey(tfKey, "Key must be an integer!");
    			                }
    			            }
    				}
    				if(s1=="Delete")
    				{

    					 if (v.emptyTextField(tfKey)) {
    			                invalidKey(tfKey, "No key entered!");
    			            } else {
    			                try {
    			                    int key = Integer.parseInt(tfKey.getText());
    			                    if (!tree2.search(key)) { // key is not in the tree
    			                        view.displayBSTTree();
    			                        view.setStatus(key + " is not in the tree");
    			                    } else {
    			                        tree2.deleteNode(key); // Delete a key
    			                        view.displayBSTTree();
    			                        view.setStatus(key + " is deleted from the tree");
    			                        treeVal.remove(treeVal.indexOf(key)); // 
    			                    
    			                    }
    			                    tfKey.setText("");
    			                    tfKey.requestFocus();
    			                } catch (NumberFormatException ex) {
    			                    invalidKey(tfKey, "Key must be an integer!");
    			                }
    			            }
    				}
    				if(s1=="Search")
    				{
    					if (v.emptyTextField(tfKey)) {
			                invalidKey(tfKey, "No key entered!");
			            } else {
			            	int checkSearch=0;
			            	int index=0;
			                try {
			                    int key = Integer.parseInt(tfKey.getText());
			                    if (tree2.search(key)) { 
			                    	checkSearch=1;
			                    	index=treeVal.indexOf(key);
			                    	tree2=new BinarySearchTree();
			                    	for(int i=0;i<=index;i++)
			                    	{
			                    		
			                    		tree2.insertNode(treeVal.get(i));
			                    		view.displayBSTTree();
			                    	}
			                    	view.setStatus(key+" is in tree");
			                        
			                       
			                    } else {
			                        
			                        view.displayBSTTree();
			                        view.setStatus(key + " is not in tree");
			                    }
			                    if(checkSearch==1)
			                    {
			                    	for(int i=index+1;i<treeVal.size();i++)
			                    	{
			                    		tree2.insertNode(treeVal.get(i));
			                    	}
			                    	checkSearch=0;
			                    }
			                    tfKey.setText("");
			                    tfKey.requestFocus();
			                } catch (NumberFormatException ex) {
			                    invalidKey(tfKey, "Key must be an integer!");
			                }
			            }
    				}
    				if(s1=="Update")
    				{
    					
    					if (v.emptyTextField(tfKey2)) {
			                invalidKey(tfKey2, "No current key entered!");
			            } else {
			                try {
			                    int key = Integer.parseInt(tfKey2.getText());
			                    if (tree2.search(key)) { // key is in the tree already
			                    	if (v.emptyTextField(tfKey)) {
						                invalidKey(tfKey, "No new key entered!");}
						                else
						                {
						                	try
						                	{
						                		
						                		int key1 = Integer.parseInt(tfKey.getText());
						                		if(!tree2.search(key1))
						                		{
						                		view.displayBSTTree();
						                		tree2.update(key,key1);
						                		view.displayBSTTree();
						                		view.setStatus(key+"is updated with new value"+key1);
						                		treeVal.set(treeVal.indexOf(key),key1);
						                		}
						                		else
						                		{
						                			view.displayBSTTree();
						                			view.setStatus(key1+"is alrealdy exist");
						                		}
						                		tfKey2.setText("");
								                tfKey2.requestFocus();
						                		
						                	}
						                	 catch (NumberFormatException ex) {
								                    invalidKey(tfKey, "Key must be an integer!");
								                }
						                }
			                    }
			                    else
			                    {
			                    	view.displayBSTTree();
			                    	view.setStatus(key+"is alrealdy exist");
			                    }
			                    tfKey.setText("");
			                    tfKey.requestFocus();
			                } catch (NumberFormatException ex) {
			                    invalidKey(tfKey, "Key must be an integer!");
			                }
			            }
    					
    	                
    				}
    				if(s1=="Traverse")
    				{
    					tree2=new BinarySearchTree();
    					for(int i=0;i<treeVal.size();i++)
    					{
    						tree2.insertNode(treeVal.get(i));
    						view.displayBSTTree();
    					}
    					view.setStatus("Traverse");
    				}
    			}
    			if(s=="AVLTree")
    			{
    				

    				myView.setCenter(view1);
    				    				if(s1=="Create")
    				    				{
    				    					tree2.clear();
    				    					tree1.clear();
    				    					tree4.clear();
    				    					tree3=new AVLTree();
    				    					
    				    					view1.setStatus("A new AVL Tree has been created");
    				    				}
    				    				if(s1=="Insert")
    				    				{
    				    					 if (v.emptyTextField(tfKey)) {
    				    			                invalidKey(tfKey, "No key entered!");
    				    			            } else {
    				    			                try {
    				    			                    int key = Integer.parseInt(tfKey.getText());
    				    			                    if (tree3.search(key)) { // key is in the tree already
    				    			                        view1.displayAVLTree();
    				    			                        view1.setStatus(key + " is already in the tree");
    				    			                    } else {
    				    			                        tree3.insertNode(key); // Insert a new key
    				    			                        view1.displayAVLTree();
    				    			                        view1.setStatus(key + " is inserted in the tree");
    				    			                        treeVal.add(key); // Adds value to HashSet for building AVL tree
    				    			                    }
    				    			                    tfKey.setText("");
    				    			                    tfKey.requestFocus();
    				    			                } catch (NumberFormatException ex) {
    				    			                    invalidKey(tfKey, "Key must be an integer!");
    				    			                }
    				    			            }
    				    				}
    				    				if(s1=="Delete")
    				    				{

    				    					 if (v.emptyTextField(tfKey)) {
    				    			                invalidKey(tfKey, "No key entered!");
    				    			            } else {
    				    			                try {
    				    			                    int key = Integer.parseInt(tfKey.getText());
    				    			                    if (!tree3.search(key)) { // key is not in the tree
    				    			                        view1.displayAVLTree();
    				    			                        view1.setStatus(key + " is not in the tree");
    				    			                    } else {
    				    			                        tree3.deleteNode(key); // Delete a key
    				    			                        view1.displayAVLTree();
    				    			                        view1.setStatus(key + " is deleted from the tree");
    				    			                        treeVal.remove(treeVal.indexOf(key)); // 
    				    			                    
    				    			                    }
    				    			                    tfKey.setText("");
    				    			                    tfKey.requestFocus();
    				    			                } catch (NumberFormatException ex) {
    				    			                    invalidKey(tfKey, "Key must be an integer!");
    				    			                }
    				    			            }
    				    				}
    				    				if(s1=="Search")
    				    				{
    				    					if (v.emptyTextField(tfKey)) {
    							                invalidKey(tfKey, "No key entered!");
    							            } else {
    							            	int checkSearch=0;
    							            	int index=0;
    							                try {
    							                    int key = Integer.parseInt(tfKey.getText());
    							                    if (tree3.search(key)) { 
    							                    	checkSearch=1;
    							                    	index=treeVal.indexOf(key);
    							                    	tree3=new AVLTree();
    							                    	for(int i=0;i<=index;i++)
    							                    	{
    							                    		
    							                    		tree3.insertNode(treeVal.get(i));
    							                    		view1.displayAVLTree();
    							                    	}
    							                    	view1.setStatus(key+" is in tree");
    							                        
    							                       
    							                    } else {
    							                        
    							                        view1.displayAVLTree();
    							                        view1.setStatus(key + " is not in tree");
    							                    }
    							                    if(checkSearch==1)
    							                    {
    							                    	for(int i=index+1;i<treeVal.size();i++)
    							                    	{
    							                    		tree3.insertNode(treeVal.get(i));
    							                    	}
    							                    	checkSearch=0;
    							                    }
    							                    tfKey.setText("");
    							                    tfKey.requestFocus();
    							                } catch (NumberFormatException ex) {
    							                    invalidKey(tfKey, "Key must be an integer!");
    							                }
    							            }
    				    				}
    				    				if(s1=="Update")
    				    				{
    				    					
    				    					if (v.emptyTextField(tfKey2)) {
    							                invalidKey(tfKey2, "No current key entered!");
    							            } else {
    							                try {
    							                    int key = Integer.parseInt(tfKey2.getText());
    							                    if (tree3.search(key)) { // key is in the tree already
    							                    	if (v.emptyTextField(tfKey)) {
    										                invalidKey(tfKey, "No new key entered!");}
    										                else
    										                {
    										                	try
    										                	{
    										                		
    										                		int key1 = Integer.parseInt(tfKey.getText());
    										                		if(!tree3.search(key1))
    										                		{
    										                		view1.displayAVLTree();
    										                		tree3.update(key,key1);
    										                		view1.displayAVLTree();
    										                		view1.setStatus(key+"is updated with new value"+key1);
    										                		treeVal.set(treeVal.indexOf(key),key1);
    										                		}
    										                		else
    										                		{
    										                			view1.displayAVLTree();
    										                			view1.setStatus(key1+"is alrealdy exist");
    										                		}
    										                		tfKey2.setText("");
    												                tfKey2.requestFocus();
    										                		
    										                	}
    										                	 catch (NumberFormatException ex) {
    												                    invalidKey(tfKey, "Key must be an integer!");
    												                }
    										                }
    							                    }
    							                    else
    							                    {
    							                    	view1.displayAVLTree();
    							                    	view1.setStatus(key+"is alrealdy exist");
    							                    }
    							                    tfKey.setText("");
    							                    tfKey.requestFocus();
    							                } catch (NumberFormatException ex) {
    							                    invalidKey(tfKey, "Key must be an integer!");
    							                }
    							            }
    				    					
    				    	                
    				    				}
    				    				if(s1=="Traverse")
    				    				{
    				    					tree3=new AVLTree();
    				    					for(int i=0;i<treeVal.size();i++)
    				    					{
    				    						tree3.insertNode(treeVal.get(i));
    				    						view1.displayAVLTree();
    				    					}
    				    					view1.setStatus("Traverse");
    				    				}
    			}
    			if(s=="BalancedBinaryTree")
    			{
    				myView.setCenter(view2);
    				if(s1=="Create")
    				{
    					tree2.clear();
    					tree3.clear();
    					tree1.clear();
    					tree4=new BalancedBinaryTree();
    					view2.setStatus("A new Balanced Binary Tree has been created");
    				}
    				if(s1=="Insert")
    				{
    					 if (v.emptyTextField(tfKey)) {
    			                invalidKey(tfKey, "No key entered!");
    			            } else {
    			                try {
    			                    int key = Integer.parseInt(tfKey.getText());
    			                    if (tree4.search(key)) { // key is in the tree already
    			                        view2.displayBBiTree();
    			                        view2.setStatus(key + " is already in the tree");
    			                    } else {
    			                        tree4.insertNode(key); // Insert a new key
    			                        view2.displayBBiTree();
    			                        view2.setStatus(key + " is inserted in the tree");
    			                        treeVal.add(key); // Adds value to HashSet for building AVL tree
    			                    }
    			                    tfKey.setText("");
    			                    tfKey.requestFocus();
    			                } catch (NumberFormatException ex) {
    			                    invalidKey(tfKey, "Key must be an integer!");
    			                }
    			            }
    				}
    				if(s1=="Delete")
    				{

    					 if (v.emptyTextField(tfKey)) {
    			                invalidKey(tfKey, "No key entered!");
    			            } else {
    			                try {
    			                    int key = Integer.parseInt(tfKey.getText());
    			                    if (!tree4.search(key)) { // key is not in the tree
    			                        view2.displayBBiTree();
    			                        view2.setStatus(key + " is not in the tree");
    			                    } else {
    			                        tree4.deleteNode(key); // Delete a key
    			                        view2.displayBBiTree();
    			                        view2.setStatus(key + " is deleted from the tree");
    			                        treeVal.remove(treeVal.indexOf(key)); // 
    			                    
    			                    }
    			                    tfKey.setText("");
    			                    tfKey.requestFocus();
    			                } catch (NumberFormatException ex) {
    			                    invalidKey(tfKey, "Key must be an integer!");
    			                }
    			            }
    				}
    				if(s1=="Search")
    				{
    					if (v.emptyTextField(tfKey)) {
			                invalidKey(tfKey, "No key entered!");
			            } else {
			            	int checkSearch=0;
			            	int index=0;
			                try {
			                    int key = Integer.parseInt(tfKey.getText());
			                    if (tree4.search(key)) { 
			                    	checkSearch=1;
			                    	index=treeVal.indexOf(key);
			                    	tree4=new BalancedBinaryTree();
			                    	for(int i=0;i<=index;i++)
			                    	{
			                    		
			                    		tree4.insertNode(treeVal.get(i));
			                    		view2.displayBBiTree();
			                    	}
			                    	view2.setStatus(key+" is in tree");
			                        
			                       
			                    } else {
			                        
			                        view2.displayBBiTree();
			                        view2.setStatus(key + " is not in tree");
			                    }
			                    if(checkSearch==1)
			                    {
			                    	for(int i=index+1;i<treeVal.size();i++)
			                    	{
			                    		tree4.insertNode(treeVal.get(i));
			                    	}
			                    	checkSearch=0;
			                    }
			                    tfKey.setText("");
			                    tfKey.requestFocus();
			                } catch (NumberFormatException ex) {
			                    invalidKey(tfKey, "Key must be an integer!");
			                }
			            }
    				}
    				if(s1=="Update")
    				{
    					
    					if (v.emptyTextField(tfKey2)) {
			                invalidKey(tfKey2, "No current key entered!");
			            } else {
			                try {
			                    int key = Integer.parseInt(tfKey2.getText());
			                    if (tree4.search(key)) { // key is in the tree already
			                    	if (v.emptyTextField(tfKey)) {
						                invalidKey(tfKey, "No new key entered!");}
						                else
						                {
						                	try
						                	{
						                		
						                		int key1 = Integer.parseInt(tfKey.getText());
						                		if(!tree4.search(key1))
						                		{
						                		view2.displayBBiTree();
						                		tree4.update(key,key1);
						                		view2.displayBBiTree();
						                		view2.setStatus(key+"is updated with new value"+key1);
						                		treeVal.set(treeVal.indexOf(key),key1);
						                		}
						                		else
						                		{
						                			view2.displayBBiTree();
						                			view2.setStatus(key1+"is alrealdy exist");
						                		}
						                		tfKey2.setText("");
								                tfKey2.requestFocus();
						                		
						                	}
						                	 catch (NumberFormatException ex) {
								                    invalidKey(tfKey, "Key must be an integer!");
								                }
						                }
			                    }
			                    else
			                    {
			                    	view2.displayBBiTree();
			                    	view2.setStatus(key+"is alrealdy exist");
			                    }
			                    tfKey.setText("");
			                    tfKey.requestFocus();
			                } catch (NumberFormatException ex) {
			                    invalidKey(tfKey, "Key must be an integer!");
			                }
			            }
    					
    	                
    				}
    				if(s1=="Traverse")
    				{
    					tree4=new BalancedBinaryTree();
    					for(int i=0;i<treeVal.size();i++)
    					{
    						tree4.insertNode(treeVal.get(i));
    						view2.displayBBiTree();
    					}
    					view2.setStatus("Traverse");
    				}
    			}
    		}
    	});
    	
    }
	
	
}
