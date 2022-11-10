package DatabaseWindows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Random;


public class Generation {
	

	public static String randomEmail() {
		
		final Random random = new Random();

		int length = 5;
		String name = "0123456789abcdefghijklmnopqrstuvwxyz";

		String email = new String();

		StringBuilder sb = new StringBuilder(length);
		for (int i = 0; i < length; i++)
			sb.append(name.charAt(random.nextInt(name.length())));
		email += sb + "@gmail.com";

	
		return email;
		}
	
	public static String randomLogin() {
		
		final Random random = new Random();

		int length = 8;
		String name = "0123456789abcdefghijklmnopqrstuvwxyz";

		String login = new String();

		StringBuilder sb = new StringBuilder(length);
		for (int i = 0; i < length; i++)
			sb.append(name.charAt(random.nextInt(name.length())));
		login += sb;

	
		return login;
		}
	
	public static String randomName() {
		
		String name = new String();
		String allNames = FileWork.read("names.txt");
		
		int amountNames = allNames.split(" ").length;
		String[] arrayNames = allNames.split(" ");
		
		final Random random = new Random();
		name = arrayNames[random.nextInt(amountNames)];
		
		if(name.trim().length() == 0)
			name = "John";
		
		return name;
		}
	
	public static String randomSurname() {
		
		String surname = new String();
		String allSurnames = FileWork.read("surnames.txt");
		
		int amountSurnames = allSurnames.split("\n").length;
		String[] arraySurnames = allSurnames.split("\n");
		
		final Random random = new Random();
		surname = arraySurnames[random.nextInt(amountSurnames)];

		return surname;
		}
	
	
	
	public static int randomAge() {
		
		final Random random = new Random();
		int age = random.nextInt(42) + 18;

		return age;
		}
	
	
	
	public static String randomNumber() {
		
		final Random random = new Random();

		int length = 10;
		String name = "0123456789";

		String number = new String();
		number = "8";

		StringBuilder sb = new StringBuilder(length);
		for (int i = 0; i < length; i++)
			sb.append(name.charAt(random.nextInt(name.length())));
		number += sb;

	
		return number;
		}
	
	
	public static String randomDate() {
		
		final Random random = new Random();
		String date = new String();
		date = "20";
		
		date += random.nextInt(2);
		date += random.nextInt(8);
		date += "-";
		date += random.nextInt(12) + 1;
		date += "-";
		date += random.nextInt(28) + 1;
		
		return date;
		}
	
	
	public static String randomRole() {
		
		final Random random = new Random();
		String role = new String();
		String[] roles = {"manager", "chief", "trainee"};
		
		role = roles[random.nextInt(3)];	
		
		return role;
	}
	
	public static int randomLevel() {
		
		final Random random = new Random();
		int level = random.nextInt(5) + 1;
		
		return level;
	}
	
	
	public static void generationDB(int amount) {
		
		  try {
		       
		        Class.forName("com.mysql.jdbc.Driver");
		        String url = "jdbc:mysql://localhost:3306/logpass";
		        String login = "root";
		        String password = "";
		        Connection con = DriverManager.getConnection(url, login, password);
		        try {
		        	
		            for(int i = 1; i <= amount; i++) {
		            	
		            	String loginDB = randomLogin();
		            	String emailDB = randomEmail();
		            	String nameDB = randomName();
		            	String surnameDB = randomSurname();
		            	String phonenumberDB = randomNumber();
		            	String dateOfRegistrationDB = randomDate();
		            	String roleDB = randomRole();
		            	int levelDB = randomLevel();
		            	int ageDB = randomAge();
		            	
		            	Statement stmt = con.createStatement();
		            	stmt.executeUpdate("INSERT INTO consumers (id, login, email, is_registered, name, surname, age, phone_number, date_of_registration, role, level) VALUES ('"+ i +"', '"+ loginDB +"', '"+ emailDB +"', '"+ 1 +"', '"+ nameDB +"', '"+ surnameDB +"', '"+ ageDB +"', '"+ phonenumberDB +"', '"+ dateOfRegistrationDB +"', '"+ roleDB +"', '"+ levelDB +"') ");            
		            	stmt.close();
		            }
		           
		        } finally {
		            con.close();
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		
	}

}
