package DatabaseWindows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseSQL {
	

	
	public static Object connectDB() {   // не используется
		Connection con = null;
		try {
		
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/logpass";
			String login = "root";
			String password = "";
			con = DriverManager.getConnection(url, login, password);
			} catch (Exception e) {
				e.printStackTrace();
			}
		return con;
	}
	
	public static void addConsumersDB(String[] consumers) {  // метод записывающий в базу данных информацию
		   
	    try {
	       
	        Class.forName("com.mysql.jdbc.Driver");
	        String url = "jdbc:mysql://localhost:3306/logpass";
	        String login = "root";
	        String password = "";
	        Connection con = DriverManager.getConnection(url, login, password);
	        try {
	           
	            Statement stmt = con.createStatement();
	            stmt.executeUpdate("INSERT INTO consumers (id, login, email, is_registered, name, surname, age, phone_number, date_of_registration, role, level) VALUES ('"+ consumers[0] +"', '"+ consumers[1] +"', '"+ consumers[2] +"', '"+ consumers[3] +"', '"+ consumers[4] +"', '"+ consumers[5] +"', '"+ consumers[6] +"', '"+ consumers[7] +"', '"+ consumers[8] +"', '"+ consumers[9] +"', '"+ consumers[10] +"' ) ");      // Принимаем наш массив строковый в метод, и записываем логин и пароль в соответствующие ячейки      
	            stmt.close();
	           
	        } finally {
	            con.close();
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	   
	}
	 
	public static String readConsumersDB() {    // метод чтения базы данных покупателей
	       
	        String allstr = "";        // строка, в которую помещается вся база данных
	        String str;
	        int length = 0;
	       
	    try {
	       
	        Class.forName("com.mysql.jdbc.Driver");
	        String url = "jdbc:mysql://localhost:3306/logpass";        // 3306 - порт вашего сервера   logpass - имя базы данных
	        String login = "root";
	        String password = "";
	        Connection con = DriverManager.getConnection(url, login, password);
	       
	        try {
	           
	            Statement stmt = con.createStatement();                 // начало работы с таблицей базы данных
	            ResultSet rs = stmt.executeQuery("SELECT * FROM consumers");  // вытаскиваем данные. SELECT FROM - SQL запросы
	            while (rs.next()) {
	 
	                for(int i = 1; i < 12; i++)
	                {
	                    str = rs.getString(i);             
	                    length = str.length();
	                    allstr += str;
	                   
	                    for(int j = 0; j < (25 - length); j++)
	                        allstr += " ";
	                   
	                    if(i == 11)
	                        allstr += "\n";
	                    str = "";
	                }
	            }
	            rs.close();
	            stmt.close();
	        } finally {
	            con.close();
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	   
	    return allstr;
	}
	
	public static void addLogpassDB(String[] logPass) {  // метод записывающий в базу данных информацию
		
		try {
			
	        Class.forName("com.mysql.jdbc.Driver");
	        String url = "jdbc:mysql://localhost:3306/logpass";
	        String login = "root";
	        String password = "";
	        Connection con = DriverManager.getConnection(url, login, password);
	        try {
	        	
	            Statement stmt = con.createStatement();
	            stmt.executeUpdate("INSERT INTO logpass (login,password) VALUES ('"+ logPass[0] +"', '"+ logPass[1] +"') ");      // Принимаем наш массив строковый в метод, и записываем логин и пароль в соответствующие ячейки       
	            stmt.close();
	            
	        } finally {
	            con.close();
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		
	}
	
	public static void addEmployeesDB(String[] employees) {  // метод записывающий в базу данных информацию
		
		try {
			
	        Class.forName("com.mysql.jdbc.Driver");
	        String url = "jdbc:mysql://localhost:3306/logpass";
	        String login = "root";
	        String password = "";
	        Connection con = DriverManager.getConnection(url, login, password);
	        try {
	        	
	            Statement stmt = con.createStatement();
	            stmt.executeUpdate("INSERT INTO employees (id, name, surname, patronymic, email, position, phonenumber, level) VALUES ('"+ employees[0] +"', '"+ employees[1] +"', '"+ employees[2] +"', '"+ employees[3] +"', '"+ employees[4] +"', '"+ employees[5] +"', '"+ employees[6] +"', '"+ employees[7] +"') ");      // Принимаем наш массив строковый в метод, и записываем данные в соответствующие ячейки       
	            stmt.close();
	            
	        } finally {
	            con.close();
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		
	}
	
	public static void runSQL(String query) {  // метод, который выполняет введенный пользовталаем SQL запрос (например на удаление или добавление информации)
		
		try {
			
	        Class.forName("com.mysql.jdbc.Driver");
	        String url = "jdbc:mysql://localhost:3306/logpass";
	        String login = "root";
	        String password = "";
	        Connection con = DriverManager.getConnection(url, login, password);
	        try {
	        	
	            Statement stmt = con.createStatement();
	            stmt.executeUpdate(""+ query +"");      // передаем объекту stmt.executeUpdate наш SQL запрос    
	            stmt.close();
	            
	        } finally {
	            con.close();
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		
	}
	
	
	public static String readLogpassDB() {    // метод чтения таблицы логинов и паролей
		
		String allstr = "";        // строка, в которую помещается вся таблица
		String str;
		int length = 0;
	try {
		
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/logpass";        // 3306 - порт вашего сервера   logpass - имя базы данных
        String login = "root";
        String password = "";
        Connection con = DriverManager.getConnection(url, login, password);
        try {
        	
            Statement stmt = con.createStatement();                 // начало работы с таблицей базы данных
            ResultSet rs = stmt.executeQuery("SELECT * FROM logpass");  // вытаскиваем данные. SELECT FROM - SQL запросы (Здесь logpass - название таблицы)
            while (rs.next()) {         // rs.next() перебирает все строки таблицы
            	
            	for(int i = 1; i < 3; i++)
            	{
            		str = rs.getString(i);         //rs.getString(i) обращение к определенному столбцу строки   	
            		length = str.length();
            		allstr += str;
            		
            		for(int j = 0; j < (25 - length); j++)  // форматирование таблицы (создание отступов между словами)
            			allstr += " ";
            		
            		if(i == 2)
            			allstr += "\n";        // отделяем строки друг от друга, чтобы сформировать таблицу
            		str = "";
            	}
            
            }
            rs.close();
            stmt.close();
        } finally {
            con.close();
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
	
	return allstr;    // возвращаем полученную таблицу
}
	
	
	public static String readEmployeesDB() {    // метод чтения базы данных сотрудников
		
		String allstr = "";        // строка, в которую помещается вся база данных
		String str;
		int length = 0;
		
	try {
		
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/logpass";        // 3306 - порт вашего сервера   logpass - имя базы данных
        String login = "root";
        String password = "";
        Connection con = DriverManager.getConnection(url, login, password);
        
        try {
        	
            Statement stmt = con.createStatement();                 // начало работы с таблицей базы данных
            ResultSet rs = stmt.executeQuery("SELECT * FROM employees");  // вытаскиваем данные. SELECT FROM - SQL запросы
            while (rs.next()) {

            	for(int i = 1; i < 9; i++)
            	{
            		str = rs.getString(i);            	
            		length = str.length();
            		allstr += str;
            		
            		for(int j = 0; j < (25 - length); j++)
            			allstr += " ";
            		
            		if(i == 8)
            			allstr += "\n";
            		str = "";
            	}
            }
            rs.close();
            stmt.close();
        } finally {
            con.close();
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
	
	return allstr; 
}
	
public static String readEmailDB() {    // метод чтения емейлов из базы данных сотрудников
		
		String emailstr = "";        
		
	try {
		
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/logpass";        // 3306 - порт вашего сервера   logpass - имя базы данных
        String login = "root";
        String password = "";
        Connection con = DriverManager.getConnection(url, login, password);
        try {
        	
            Statement stmt = con.createStatement();                 // начало работы с таблицей БД
            ResultSet rs = stmt.executeQuery("SELECT * FROM employees");  // вытаскиваем данные. SELECT FROM - SQL запросы
            while (rs.next()) {
            	
                String str1 = new String(rs.getString(5));         
                emailstr += str1 + " ";
                
            }
            rs.close();
            stmt.close();
        } finally {
            con.close();
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
	
	return emailstr; 
}

	public static String readLastAddedDB(String nameDB) {    // метод чтения емейлов из базы данных сотрудников
	
		String laststr = ""; 
		String str;
		
	
		try {
	
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/logpass";        // 3306 - порт вашего сервера   logpass - имя базы данных
			String login = "root";
			String password = "";
			Connection con = DriverManager.getConnection(url, login, password);
			try {
    	
				Statement stmt = con.createStatement();                 // начало работы с таблицей БД
				ResultSet rs = stmt.executeQuery("SELECT * FROM "+ nameDB +"");  // вытаскиваем данные. SELECT FROM - SQL запросы
            
				while (rs.next()) {
					if(rs.isLast()) 
					{
						for(int i = 1; i < 9; i++)
		            	{
		            		str = (rs.getString(i));
		            		laststr += str + " ";
		            		if(i == 8)
		            			laststr += "\n";
		            		str = "";
		            	}
					}
				}
				rs.close();
				stmt.close();
			} finally {
				con.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
	}

		return laststr; 
	}
}

