/**
 *Lorcan Murray
 */
package ie.atu.serialize;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import ie.atu.hotel.Employee;
import ie.atu.hotel.Name;

public class EmployeeSerializer {
	private ArrayList<Employee> employees;
	private File employeesFile;
	private final String FILENAME = "employees.bin";	
	private Name name1;
	
	// Default Constructor
	public EmployeeSerializer(){
		// Construct EmployeeList ArrayList
		employees = new ArrayList<Employee>();
		try {
		employeesFile = new File(FILENAME);
		
			if(employeesFile.createNewFile())
			{
				System.out.println("File Created");
			}
			else {
				System.out.println("File already exists");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
;
		// TODO Construct employeesFile and physically create the File

	}	

	/////////////////////////////////////////////////////////////
	// Method Name : add()								              //
	// Return Type : void								              //
	// Parameters : None								                 //
	// Purpose : Reads one Employee record from the user       //
	//           and adds it to the ArrayList called employees //
	/////////////////////////////////////////////////////////////
	public void add(){ 
	    // Create an Employee object
		
		 Employee employee = new Employee();
 
       // TODO - Update add() so it checks if Cancel was clicked when reading Employee
       
		 // Read its details
		
		 employee.read();
		 if(employee.read()==true){//if true add the employee if clicked ok
		 // And add it to the employees ArrayList
		 employees.add(employee);
				 }
		 else {
			 System.out.println("Canceled");//hit cancel
			 
		 }
		 
	}

	///////////////////////////////////////////////////////
	// Method Name : list()						              //
	// Return Type : void					   	           //
	// Parameters : None						                 //
	// Purpose : Lists all Employee records in employees //
	///////////////////////////////////////////////////////		
	public void list(){
		String employeesToList="";

		if(!employees.isEmpty()) {
			// for every Employee object in employees
			for(Employee tmpEmployee : employees) {
				// add it to employeesToList and
				employeesToList+=tmpEmployee;
				// add a newline
				employeesToList+="\n";
			}
			
			// Display employeesToList in a messageDialog
		   JOptionPane.showMessageDialog(null, employeesToList, "EMPLOYEE LIST", JOptionPane.INFORMATION_MESSAGE);	
		}
		else
			// Display "No Employees stored..." in messageDialog
		   JOptionPane.showMessageDialog(null, "No Employees to list.", "EMPLOYEE LIST", JOptionPane.INFORMATION_MESSAGE);	
	}	

	////////////////////////////////////////////////////////////////
	// Method Name : view()									              //
	// Return Type : Employee								              //
	// Parameters : None								                    //
	// Purpose : Displays the required Employee record on screen  //
	//         : And returns it, or null if not found             //   
	////////////////////////////////////////////////////////////////	
	public Employee view(){
		 // TODO - Write the code for view()
		String employeesToList="";
		JTextField txtEmployeeNumber = new JTextField();
Object[] message = {
				
				"Employee Number:", txtEmployeeNumber ,
};
JDialog dialog = new JDialog();
dialog.setAlwaysOnTop(true);
int option = JOptionPane.showConfirmDialog(dialog, message,
"ENTER EMPLOYEE DETAILS", JOptionPane.OK_CANCEL_OPTION);
if (option == JOptionPane.OK_OPTION){
	
}
		if(!employees.isEmpty()) {
			// for every Employee object in employees
			for(Employee tmpEmployee : employees) {
				// add it to employeesToList and
				if(Integer.parseInt(txtEmployeeNumber.getText())==tmpEmployee.getNumber())//compare the numbers and find the match
				{JOptionPane.showMessageDialog(null, tmpEmployee, "EMPLOYEE FOUND", JOptionPane.INFORMATION_MESSAGE);
					return tmpEmployee;	}
			}
			
		}
		else if(employees.isEmpty())
			// Display "No Employees stored..." in messageDialog
		   JOptionPane.showMessageDialog(null, "No Employees to view.", "EMPLOYEE VIEW", JOptionPane.INFORMATION_MESSAGE);	
		return null;
	}	

	
	///////////////////////////////////////////////////////////////////
	// Method Name : delete()							        	           //
	// Return Type : void								        	           //
	// Parameters : None									                    //
	// Purpose : Deletes the required Employee record from employees //
	///////////////////////////////////////////////////////////////////	
	public void delete(){
		String employeesToList="";
		JTextField txtEmployeeNumber = new JTextField();
Object[] message = {
				
				"Employee Number:", txtEmployeeNumber ,
};
JDialog dialog = new JDialog();
dialog.setAlwaysOnTop(true);
int option = JOptionPane.showConfirmDialog(dialog, message,
"ENTER EMPLOYEE DETAILS", JOptionPane.OK_CANCEL_OPTION);
if (option == JOptionPane.OK_OPTION){//for the cancel and ok buttons and options in general
	
}
		 // TODO - Write the code for delete()
		if(!employees.isEmpty()) {//if not empty
			// for every Employee object in employees
			for(Employee tmpEmployee : employees) {
				// add it to employeesToList and
				if(Integer.parseInt(txtEmployeeNumber.getText())==tmpEmployee.getNumber())
				{JOptionPane.showMessageDialog(null, tmpEmployee, "EMPLOYEE LIST MEMBER REMOVED", JOptionPane.INFORMATION_MESSAGE);
					employees.remove(tmpEmployee);}//find the appropriate employee from the number then remove them
			}
			
		}
		else if(employees.isEmpty())
			// Display "No Employees stored..." in messageDialog
		   JOptionPane.showMessageDialog(null, "No Employees to remove.", "EMPLOYEE LIST", JOptionPane.INFORMATION_MESSAGE);	
		
		}

	///////////////////////////////////////////////////////////////
	// Method Name : edit()			  					                //
	// Return Type : void								    	          //
	// Parameters : None								     	             //
	// Purpose : Edits the required Employee record in employees //
	///////////////////////////////////////////////////////////////	
	public void edit(){
		 // TODO - Write the code for edit()
		 // TODO - Write the code for view()
		String employeesToList="";
		JTextField txtEmployeeNumber = new JTextField();
		String[] Title = {"Mr","Ms","Mrs"};
		 JComboBox title=new JComboBox(Title);
			JTextField txtFirstName = new JTextField();
			JTextField txtSurname = new JTextField();
			JTextField txtPhoneNumber = new JTextField();
			JTextField txtSalary = new JTextField();
Object[] message = {
				
				"Employee Number:", txtEmployeeNumber ,
			
};
JDialog dialog = new JDialog();
dialog.setAlwaysOnTop(true);
int option = JOptionPane.showConfirmDialog(dialog, message,
"ENTER EMPLOYEE DETAILS", JOptionPane.OK_CANCEL_OPTION);
if (option == JOptionPane.OK_OPTION){
	
}
		if(!employees.isEmpty()) {
		
			// for every Employee object in employees
			for(Employee tmpEmployee : employees) {
		
				// add it to employeesToList and
				if(Integer.parseInt(txtEmployeeNumber.getText())==tmpEmployee.getNumber())
				{JOptionPane.showMessageDialog(null, tmpEmployee, "EMPLOYEE SEARCH", JOptionPane.INFORMATION_MESSAGE);
		Object[] messages = {
						
						"Employee Number:", txtEmployeeNumber ,
						"Title:", title,
						"First Name:", txtFirstName,
						"Surname", txtSurname,
						"Phone Number:", txtPhoneNumber,
						"Salary:", txtSalary,
		};
		JDialog dialogs = new JDialog();
		dialog.setAlwaysOnTop(true);
		int options = JOptionPane.showConfirmDialog(dialogs, messages,
		"ENTER EMPLOYEE DETAILS", JOptionPane.OK_CANCEL_OPTION);
		if (options == JOptionPane.OK_OPTION){
			
		}
				
				tmpEmployee.getNumber();
				Name name =new Name(title.getSelectedItem().toString(),txtFirstName.getText(),txtSurname.getText());
				tmpEmployee.setName(name);
			
				tmpEmployee.setPhoneNumber(txtPhoneNumber.getText());
				tmpEmployee.setSalary(Double.parseDouble(txtSalary.getText()));//edit the chosen employee by typing in the employee number
					}
			}
			
		}
		
		

		
		
		else if(employees.isEmpty())
			// Display "No Employees stored..." in messageDialog
		   JOptionPane.showMessageDialog(null, "No Employees to edit.", "EMPLOYEE LIST", JOptionPane.INFORMATION_MESSAGE);	
	
	}
	
	// This method will serialize the employees ArrayList when called, 
	// i.e. it will write employees to a file called employees.bin
	public void serializeEmployees(){
		 // TODO - Write the code for serializeEmployees()
		try {
			// Serialize the ArrayList...
			FileOutputStream fileStream = new FileOutputStream(employeesFile);
		
			ObjectOutputStream os = new ObjectOutputStream(fileStream);
				
			os.writeObject(employees);
			
			os.close();
		}
		catch(FileNotFoundException fNFE){
			System.out.println("Cannot create file to store employees.");
		}
		catch(IOException ioE){
			 System.out.println("Cannot write to " + FILENAME + ".");
		}	}

	// This method will deserialize the Employees ArrayList when called, 
	// i.e. it will restore the employees ArrayList from the file employees.bin
	public void deserializeEmployees(){
		 ObjectInputStream is=null;
		
		 try {
			 // Deserialize the ArrayList...
			 FileInputStream fileStream = new FileInputStream(employeesFile);
				
			 is = new ObjectInputStream(fileStream);
						
			 employees = (ArrayList<Employee>)is.readObject();
          
          is.close();
		}
		catch(FileNotFoundException fNFE){
			 System.out.println("Cannot open file " + employeesFile.getName() + ".");
		}
		catch(IOException ioE){
			 System.out.println("Cannot read from " + employeesFile.getName() + ".");
		}
		catch(Exception e){
			 System.out.println("Cannot read from " + employeesFile.getName() + ".");
		}
	}
}