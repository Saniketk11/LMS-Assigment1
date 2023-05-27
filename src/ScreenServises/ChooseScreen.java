package ScreenServises;

import AssigmentOne.Welcome;
import MainScreens.FileOperations;
import MainScreens.HomeScreen;
import MainScreens.Screen;

public class ChooseScreen {

	public static HomeScreen WelcomeScreen = new HomeScreen();
    public static FileOperations FileOptionsScreen = new FileOperations();
    
    

    public static Screen CurrentScreen = WelcomeScreen;

    
    public static Screen getCurrentScreen() {
        return CurrentScreen;
    }

    
    public static void setCurrentScreen(Screen currentScreen) {
        CurrentScreen = currentScreen;
    }
}
