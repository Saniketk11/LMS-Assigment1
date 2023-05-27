package MainScreens;

import java.io.File;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import ScreenServises.ChooseScreen;

public class HomeScreen implements Screen{
	private String welcomeText = "Welcome to My First Assigment!";
    
    private ArrayList<String> options = new ArrayList<>();


    public HomeScreen() {
        options.add("1. Show Files");
        options.add("2. Show File Options Menu");
        options.add("3. Quit");

    }

    public void introduction() {
    	System.out.println(welcomeText);
        System.out.println("\n");
        Show();
    }
	@Override
	public void Show() {
		System.out.println("Main Menu");
        for (String s : options)  {
            System.out.println(s);
        }
	}


	@Override
	public void NavigateOption(int option) {
		switch(option) {

        case 1: // Show Files in Directory
        	this.DisplayFiles();
            
            this.Show();
            
            break;
            
        case 2: // Show File Options menu
        	ChooseScreen.setCurrentScreen(ChooseScreen.FileOptionsScreen);
            ChooseScreen.getCurrentScreen().Show();
            ChooseScreen.getCurrentScreen().GetUserInput();
            this.Show();
            
            break;
            
        default:
            System.out.println("Invalid Option");
            break;
    }
	}


	private void DisplayFiles() {
		System.out.println("List of Files Under Files Folder: ");
		
		File dir = new File("src/Files");
	      String[] children = dir.list();
	      
	      if (children == null) {
	         System.out.println( "Either dir does not exist or is not a directory");
	      } else { 
	         for (int i = 0; i< children.length; i++) {
	            String filename = children[i];
	            System.out.println(filename);
	         }
	      }
	}

	@Override
	public void GetUserInput() {
		 int selectedOption  = 0;
	        while ((selectedOption = this.getOption()) != 3) {
	            this.NavigateOption(selectedOption);
	        }
	}

	private int getOption() {
		Scanner in = new Scanner(System.in);

        int returnOption = 0;
        try {
            returnOption = in.nextInt();
        }
        catch (InputMismatchException ex) {

        }
        return returnOption;
	}
}
