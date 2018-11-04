// GUI class using JavaFX.
package userinterface;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Window{
	
	private String title = "GameProject";
	@SuppressWarnings("unused")
	private Stage primaryStage;
	private Scene myScene;
	private int screenWidth;
	private int screenHeight;
	
	private BorderPane root;
	private Text logoText;
	private Text contentText;
	private VBox vBox;
	private Label timerLabel = new Label();
	private static final Integer STARTTIME = 30;
    private Timeline timeline;
    private Integer timeSeconds = STARTTIME;
	
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
		root.setBottom(timerLabel);
		root.setAlignment(timerLabel, Pos.CENTER);
		
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
		
		// Initialising timer. 
		timerLabel.setText("30");
        timerLabel.setTextFill(Color.RED);
        timerLabel.setStyle("-fx-font-size: 4em;");
	
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
			System.out.println("running");
			vBox.getChildren().remove(contentText);
			vBox.getChildren().add(contentText);
		}
	}
	
	@SuppressWarnings("unchecked")
	public void startTimer() {
		if (timeline != null) {
            timeline.stop();
        }
        timeSeconds = STARTTIME;
 
        // update timerLabel
        timerLabel.setText(timeSeconds.toString());
        timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(1),
        		new EventHandler() {
        			// KeyFrame event handler
					@Override
					public void handle(Event event) {
						timeSeconds--;
                        // update timerLabel
                        timerLabel.setText(
                              timeSeconds.toString());
                        if (timeSeconds <= 0) {
                            timeline.stop();
                        }
					}
                }));
        timeline.playFromStart();
	}
	
	public Text getText() {
		return contentText;
	}
	
	public void changeTextSize(int size) {
		contentText.setStyle("-fx-font: " + size + "\"Tw Cen MT\"");
	}
}
