package MainScreens;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import ScreenServises.ChooseScreen;

public class FileOperations implements Screen {

	
	private ArrayList<String> options = new ArrayList<>();

    public FileOperations() {
    	
    	options.add("1. Add a File");
        options.add("2. Delete A File");
        options.add("3. Search A File");
        options.add("4. Return to Menu");
        
    }

	 @Override
	    public void Show() {
	    	System.out.println("File Options Menu");
	        for (String s : options) {
	            System.out.println(s);
	        }

	    }

	    public void GetUserInput() {
	        int selectedOption;
	        while ((selectedOption = this.getOption()) != 4) {
	            this.NavigateOption(selectedOption);
	        }
	    }

	    @Override
	    public void NavigateOption(int option) {
	        
	    	switch(option) {

	            case 1: // Add File
	            	this.AddFile();
	                
	                this.Show();
	                break;
	            case 2: // Delete File
	            	this.DeleteFile();
	                this.Show();
	                break;
	            case 3: // Search File
	            	this.SearchFile();
	                this.Show();
	                break;
	            
	                
	            case 4: // Return to Menu
	            	
	            	ChooseScreen.setCurrentScreen(ChooseScreen.WelcomeScreen);
	                ChooseScreen.getCurrentScreen().Show();
	                ChooseScreen.getCurrentScreen().GetUserInput();
	                
	                break;
	                
	            default:
	                System.out.println("Invalid Option");
	                break;
	                
	                
	        }

	    }
	    
	    private void AddFile() {
			 System.out.println("Please Enter the Filename:");

		        String fileName = this.getInputString();

		        System.out.println("You are adding a file named: " + fileName);
		        
		        try {
		            File file = new File("src/Files/"+fileName+".txt");
		            if (file.createNewFile()) {
		                System.out.println("File created successfully.");
		            } else {
		                System.out.println("File already exists.");
		            }
		        } catch (IOException e) {
		            System.out.println("An error occurred: " + e.getMessage());
		            e.printStackTrace();
		        }
			}
	 

	private void DeleteFile() {
		 System.out.println("Please Enter the Filename:");

	        String fileName = this.getInputString();

	        System.out.println("You are Deleting a file named: " + fileName);
	        
	        
	        	File file = new File("src/Files/"+fileName+".txt");
	            
	            if (file.delete()) {
	                System.out.println("File deleted successfully.");
	            } else {
	                System.out.println("Given File Does Not Exists.");
	            }
	         
		}

	private void SearchFile() {
		 
		 System.out.println("Please Enter the Filename:");

	        String rowName = this.getInputString();	
	        String fileName = rowName+".txt";
	        String folderPath = "src/Files";
	        File file = new File(folderPath, fileName);

	        if (file.exists()) {
	            System.out.println("File exists.");
	        } else {
	            System.out.println("File does not exist.");
	        }
		}

	private String getInputString() {
		 Scanner in = new Scanner(System.in);
	        return(in.nextLine());
	}

	private int getOption() {
	        Scanner in = new Scanner(System.in);

	        int returnOption = 0;
	        try {
	            returnOption = in.nextInt();
	        }
	        catch (InputMismatchException ex) {
	        	System.out.println("Invalid input");
	        }
	        return returnOption;

	    }
}
