// GUI class using JavaFX.
package userinterface;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Window{
	
	private String title = "GameProject";
	private Stage primaryStage;
	private int screenWidth;
	private int screenHeight;
	
	private BorderPane root;
	private Text logoText;
	private Text timerAndPhoneNumber;
	private VBox vBox;
	
	public Window (Stage primaryStage) {
		this.primaryStage = primaryStage;
		root = new BorderPane();
		
		primaryStage.setTitle(title);
		
		intialiseWindowContent();
		addScreenElements();		
		setScreenDimensions();
		
		root.setStyle("-fx-background-color: #939393;");
		
		primaryStage.setScene(new Scene(root, screenWidth, screenHeight));
		primaryStage.setMaximized(true);
		primaryStage.show();
	}

	@SuppressWarnings("static-access")
	private void addScreenElements() {
		// Set top to logo.		
		root.setTop(logoText);
		root.setAlignment(logoText, Pos.CENTER);
		
		// Set bottom to timer and phone number.
		root.setBottom(timerAndPhoneNumber);
		root.setAlignment(timerAndPhoneNumber, Pos.CENTER);
		
		// Set center to 
		root.setCenter(vBox);
	}

	private void intialiseWindowContent() {
		// Game screen goes here.
		vBox = new VBox();
		vBox.setStyle("-fx-background-color: #ffffff;");
		vBox.setAlignment(Pos.CENTER);
		
		// Initialising text for logo. 
		logoText = new Text();
		logoText.setText("Game Title");
		logoText.setStyle("-fx-font: 75 arial;");
		
		// Initialising timer and phone number. 
		timerAndPhoneNumber = new Text();
		timerAndPhoneNumber.setText("Timer goes here." + "\n \n" + "Phone Number here.");
		timerAndPhoneNumber.setStyle("-fx-font: 60 arial;");		
	}
	
	private void setScreenDimensions() {
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		screenWidth = gd.getDisplayMode().getWidth() - 200;
		screenHeight = gd.getDisplayMode().getHeight() - 200;
	}
}
