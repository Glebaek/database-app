package MainDatabase;


import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import DatabaseWindows.DatabaseForm1Controller;

public class DatabaseMainController {
		
	 @FXML
	 private Button ButtonName1;

			private MainDatabaseGUI mainDatabaseGUI; 

			//Личный кабинет
			public DatabaseForm1Controller DatabaseForm1Controller;
			
			Stage StageDatabaseForm1Controller = new Stage();
			public void ShowDatabaseForm1()
			{
				StageDatabaseForm1Controller.show();
			}
			
			public void CloseDatabaseForm1()
			{
				StageDatabaseForm1Controller.close();
			}
			

	public void setDatabaseForm1Controller()
	{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(DatabaseMainController.class.getResource("/DatabaseWindows/DatabaseForm1.fxml"));
		try {
			Pane pane = (Pane) loader.load();
			Scene scene = new Scene(pane);
			StageDatabaseForm1Controller.setScene(scene);
			StageDatabaseForm1Controller.initModality(Modality.APPLICATION_MODAL);
			DatabaseForm1Controller = loader.getController();
			DatabaseForm1Controller.Init();
			
		} catch (IOException e) {
			// TODO Автоматически созданный блок catch
			e.printStackTrace();
		}
		
	}
	
	public void setDatabaseGUI(MainDatabaseGUI mainDatabaseGUI)
	{
		this.mainDatabaseGUI = mainDatabaseGUI;
	}		
	


	public void Init() {
		
		//Кнопка
		ButtonName1.setOnAction(new EventHandler<ActionEvent>() {
		      @Override
		      public void handle(ActionEvent event) {
		    	  System.out.println("Открыта вторая форма");
		    	  ShowDatabaseForm1();
		      }
		  
	  });
	
		
		
	}}
