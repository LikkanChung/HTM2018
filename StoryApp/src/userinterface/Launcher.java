// Application launcher. Will instantiate all necessary features and import them into the window. 

package userinterface;

import controller.StoryController;
import javafx.application.Application;
import javafx.stage.Stage;
import story.Story;
import story.StoryFactory;

public class Launcher extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Story story = StoryFactory.sampleStory(); // Generates sample story. 
		Window window = new Window (primaryStage);
		StoryController controller = new StoryController(story, window);
	}
}

/************************************
// _______                 _______
// I       I     I I\    I    I
// I       I     I I \   I    I
// I       I     I I  \  I    I
// I       I     I I   \ I    I
// L______ L_____I I    \I    I
//
 ***********************************/

