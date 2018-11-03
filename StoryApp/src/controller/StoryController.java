// Controller class for model-view interaction. 

package controller;

import story.Story;
import userinterface.Window;

public class StoryController {
	
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
						
	}
}
