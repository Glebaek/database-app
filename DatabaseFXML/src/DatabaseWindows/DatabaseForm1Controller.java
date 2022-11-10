package DatabaseWindows;

import java.io.IOException;

import MainDatabase.DatabaseMainController;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class DatabaseForm1Controller {
	
	static String config = FileWork.read("setting.config.txt");
	String nameDB = "";
	
	
	@FXML
	private Button Button1Clear;
	
	@FXML
    private Button Button2SendEmail;
	
	@FXML
    private Button Button3Show;
	
	@FXML
	private Button Button4AddAccount;
	
	@FXML
    private Button Button5RunSQL;
	
	@FXML
	private Button Button6Generate;
	
	

    
    @FXML
    private CheckBox CheckBox1Greetings;
    
    @FXML
    private void handleCheckBox1Greetings() {
    	
    	if(CheckBox1Greetings.isSelected()) 
    		FileWork.write("setting.config.txt", "1 - show the number of characters");
    	else
    		FileWork.write("setting.config.txt", "0 - show the number of characters");
    
    }
    
    @FXML
    private ChoiceBox<Object> ChoiceBox1SelectDB;
    
    
    @FXML
    private TextArea TextArea1Output;
    
    
    
    @FXML
    private TextField TextField1AddAccount;
    
    @FXML
    private TextField TextField2SendEmail;
    
    @FXML
    private TextField TextField3RunSQL;
    
    @FXML
    private TextField TextField4Generate;
    
    
    
	DatabaseMainController DatabaseMainController;
	
	public void setDatabaseMainController(DatabaseMainController DatabaseMainController)
	{
		this.DatabaseMainController = DatabaseMainController;
	}
	
	
	public void Init() throws IOException
	{
		
		
		if( config.charAt(0) == '1') 
		{
    		CheckBox1Greetings.setSelected(true);
    		TextArea1Output.appendText("                                                                          WELCOME TO THE DATABASE \n");
		}
    	else
    		CheckBox1Greetings.setSelected(false);
		
		
		ChoiceBox1SelectDB.setItems(FXCollections.observableArrayList("logpass", "employees", "consumers"));
		
		ChoiceBox1SelectDB.getSelectionModel().selectedIndexProperty().addListener(
				(ObservableValue<? extends Number> ov, Number old_val, Number new_val)->{
					int choice = new_val.intValue();
					switch(choice)
					{
					case 0: nameDB = "logpass"; break;
					case 1: nameDB = "employees"; break;
					case 2: nameDB = "consumers"; break;
					}
				}
			);
		
		
		

		Button1Clear.setOnAction(new EventHandler<ActionEvent>() {
				      @Override
				      public void handle(ActionEvent event) {			    	 
				    	  TextArea1Output.clear();
				    	  }
				  
			  });
		
			
		Button2SendEmail.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					String message = TextField2SendEmail.getText(); 
					if( message.trim().length() != 0 ) {
						TextField2SendEmail.clear();
						SendEmail.send("Java", message, "WorkMailGorodkov@gmail.com");
					}
				}
						  
			});
				
			
		Button3Show.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					switch(nameDB)
					{
					case "logpass":   TextArea1Output.appendText(DatabaseSQL.readLogpassDB()); break;
					case "employees": TextArea1Output.appendText(DatabaseSQL.readEmployeesDB()); break;
					case "consumers": TextArea1Output.appendText(DatabaseSQL.readConsumersDB()); break;
					case "": TextArea1Output.appendText("Please, choose database!");						    	  
					}
				}
						  
			});
		
		Button4AddAccount.setOnAction(new EventHandler<ActionEvent>() {
		      @Override
		      public void handle(ActionEvent event) {
		    	  String newAcc = TextField1AddAccount.getText();       //при нажатии на кнопку 4 в строку text помещается текст, введеный пользователем
		    	  if( newAcc.trim().length() != 0 ) 
		    	  {
		    		  TextField1AddAccount.clear();
		    		  int columns = newAcc.split(" ").length;
		    		  String[] newAccArray = newAcc.split(" ");           //инициализируем строковый массив. затем с помощью метода split (системный метод), разделяем нашу строку text на строковый массив, разделение происходит по пробелам. (строка grisha21 pepech - станет уже не единой строкой, а массивом состоящим из первого элемента grisha21 и второго элемента pepech)
		    		  switch(columns)
		    		  {
		    		  case 2: DatabaseSQL.addLogpassDB(newAccArray); break;
		    		  case 8: DatabaseSQL.addEmployeesDB(newAccArray); break;
		    		  case 11: DatabaseSQL.addConsumersDB(newAccArray); break;
		    		  }
		    		  
		    	  }
		    }
		  
	  });
		
		Button5RunSQL.setOnAction(new EventHandler<ActionEvent>() {
		      @Override
		      public void handle(ActionEvent event) {
		    	  String query = TextField3RunSQL.getText();
		    	  if( query.trim().length() != 0 ) 
		    	  {
		    		  TextField3RunSQL.clear();   		  
		    		  DatabaseSQL.runSQL(query);
	    			  TextArea1Output.appendText("Request Completed! \n");
		    	  }
		    	  
		      }
		  });
		
		Button6Generate.setOnAction(new EventHandler<ActionEvent>() {
		      @Override
		      public void handle(ActionEvent event) {
		    	  int numberOfLines = -1;
		    	  numberOfLines = Integer.parseInt(TextField4Generate.getText());
		    	  if((numberOfLines > 0) && (numberOfLines < 10001))		    	  
		    	  {
		    		  TextField4Generate.clear();   		  
		    		  Generation.generationDB(numberOfLines);
	    			  TextArea1Output.appendText("The lines are generated! \n");
		    	  }
		    	  
		      }
		  });
	}
	
}
