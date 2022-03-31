
public class Main {
public static void main(String[] args) {
		
		// Create "main" folder if not present in current folder structure
		Fileoperations.createFolder("filedir");
		System.out.println("_______________________________________________");
		System.out.println("LockedMe.com ");
        System.out.println("This application was developed by kalyani");


        System.out.println("_______________________________________________");
        
        System.out.println( "You can use this application to :-\n"
				+ "• Retrieve all file names in the Filedir folder\n"
				+ "• Search, add, or delete files in Filedir folder.\n"
				+ "\n**Please be careful to ensure the correct filename is provided for searching or deleting files.**\n");
		
		
		Options.handleWelcomeScreenInput();
	}
}
