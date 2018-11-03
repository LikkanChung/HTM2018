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
	@SuppressWarnings("unused")
	private Stage primaryStage;
	private Scene myScene;
	private int screenWidth;
	private int screenHeight;
	
	private BorderPane root;
	private Text logoText;
	private Text timerAndPhoneNumber;
	private Text contentText;
	private VBox vBox;
	
	public Window (Stage primaryStage) {
		this.primaryStage = primaryStage;
		root = new BorderPane();
		
		primaryStage.setTitle(title);
		
		intialiseWindowContent();
		addScreenElements();		
		setScreenDimensions();
		
		
		contentText = new Text();
		
		myScene = new Scene(root, screenWidth, screenHeight);
		myScene.getStylesheets().add("styles.css");
		
		primaryStage.setScene(myScene);
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
		vBox.setMaxHeight(screenHeight + 900);
		vBox.setMaxWidth(screenWidth + 1800);
		vBox.setAlignment(Pos.CENTER);
		vBox.getStyleClass().add("vbox");
		
		// Initialising text for logo. 
		logoText = new Text();
		logoText.setText("Game Title");
		logoText.getStyleClass().add("logoText");
		
		// Initialising timer and phone number. 
		timerAndPhoneNumber = new Text();
		timerAndPhoneNumber.setText("Timer goes here." + "\n \n" + "Phone Number here.");
		timerAndPhoneNumber.getStyleClass().add("bottomText");		
	}
	
	private void setScreenDimensions() {
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		screenWidth = gd.getDisplayMode().getWidth() - 200;
		screenHeight = gd.getDisplayMode().getHeight() - 200;
	}
	
	public void setText(String text) {		
		contentText.setText(text);
		if(vBox.getChildren() == null) { // If component contains no text. 
			vBox.getChildren().add(contentText);
		}else {
			vBox.getChildren().remove(contentText);
			vBox.getChildren().add(contentText);
		}
	}
	
	public void changeTextSize(int size) {
		contentText.setStyle("-fx-font: " + size + "\"Tw Cen MT\"");
	}
}
