// Application launcher. Will instantiate all necessary features and import them into the window. 

package userinterface;

import javafx.application.Application;
import javafx.stage.Stage;

public class Launcher extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Window window = new Window (primaryStage);
	}
}

//
// _______                 _______
// I       I     I I\    I    I
// I       I     I I \   I    I
// I       I     I I  \  I    I
// I       I     I I   \ I    I
// L______ L_____I I    \I    I
//
//

