package JavaFx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
	   /*Stage window =primaryStage;
	    
	    Label label = new Label("hello");
	    VBox layout = new VBox();
	    layout.getChildren().add(label);
	    Scene scene = new Scene(layout,300,300);
	    window.setScene(scene);
	    window.show();
	    
	    */
		try
		{
			Parent root1 = FXMLLoader.load(this.getClass().getResource("GUI.fxml"));
			Scene scene = new Scene(root1);
			primaryStage.setScene(scene);
			primaryStage.show();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}	
