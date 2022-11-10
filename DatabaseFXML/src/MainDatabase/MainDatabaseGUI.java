package MainDatabase;


import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainDatabaseGUI extends Application{
	 
	private Stage primaryStage;
	private Pane rootLayout;
	
	public static void main(String[] args) {
		launch(args);
	}
	

    public void initRootLayout() {
        try {
           
            FXMLLoader loader = new FXMLLoader();
           
            loader.setLocation(MainDatabaseGUI.class.getResource("DatabaseMainForm.fxml"));
            rootLayout = (Pane) loader.load();
                   
            DatabaseMainController controller = loader.getController();
           
            controller.setDatabaseGUI(this);
            controller.Init();
            
            controller.setDatabaseForm1Controller();
     
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("DATA BASE");
		
		initRootLayout();
		
	}
}