// Controller class for model-view interaction. 

package controller;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import story.Story;
import userinterface.Window;

public class StoryController {
	
	@SuppressWarnings("unused")
	private Story model;
	private Window view;
	
	public StoryController(Story model, Window view) {
		this.model = model;
		this.view = view;
		
		// Mess with the story model i.e. begin the story. 
		// Add whatever it returns to the view.
		displayWelcomeScreen();
	}
	
	private void displayWelcomeScreen() {
		view.changeTextSize(60);
		view.setText("Welcome to the game!");

		setTextTransition("Let's start the game!");
		beginStory();
	}
	
	private void beginStory() {
		
	}
	
	private void setTextTransition(String text) {
		view.getText().setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				view.setText(text);
			}
		});
	}
}
