import java.util.List;
import java.util.Scanner;

public class Options {
	public static void handleWelcomeScreenInput() {
		boolean running = true;
		Scanner sc = new Scanner(System.in);
		do {
			try {
				Fileoperations.displayMenu();
				int input = sc.nextInt();

				switch (input) {
				case 1:
					Fileoperations.displayAllFiles("filedir");
					break;
				case 2:
					Options.handleFileMenuOptions();
					break;
				case 3:
					System.out.println("Program exited successfully.");
					running = false;
					sc.close();
					System.exit(0);
					break;
				default:
					System.out.println("Please select a valid option from above.");
				}
			} catch (Exception e) {
				System.out.println(e.getClass().getName());
				handleWelcomeScreenInput();
			} 
		} while (running == true);
	}
	
	public static void handleFileMenuOptions() {
		boolean running = true;
		Scanner sc = new Scanner(System.in);
		do {
			try {
				Fileoperations.displayFileMenuOptions();
				Fileoperations.createFolder("filedir");
				
				int input = sc.nextInt();
				switch (input) {
				case 1:
					// File Add
					System.out.println("Enter the name of the file to be added to the \"filedir\" folder");
					String fileToAdd = sc.next();
					
					Fileoperations.createFile(fileToAdd, sc);
					
					break;
				case 2:
					// File/Folder delete
					System.out.println("Enter the name of the file to be deleted from \"filedir\" folder");
					String fileToDelete = sc.next();
					
					Fileoperations.createFolder("filedir");
					List<String> filesToDelete = Fileoperations.displayFileLocations(fileToDelete, "filedir");
					
					String deletionPrompt = "\nSelect index of which file to delete?"
							+ "\n(Enter 0 if you want to delete all elements)";
					System.out.println(deletionPrompt);
				
					int idx = sc.nextInt();
					
					if (idx != 0) {
						Fileoperations.deleteFile(filesToDelete.get(idx - 1));
					} else {
						
						// If idx == 0, delete all files displayed for the name
						for (String path : filesToDelete) {
							Fileoperations.deleteFile(path);
						}
					}
					

					break;
				case 3:
					// File/Folder Search
					System.out.println("Enter the name of the file to be searched from \"filedir\" folder");
					String fileName = sc.next();
					
					Fileoperations.createFolder("filedir");
					Fileoperations.displayFileLocations(fileName, "filedir");

					
					break;
				case 4:
					// Go to Previous menu
					return;
				case 5:
					// Exit
					System.out.println("Program exited successfully.");
					running = false;
					sc.close();
					System.exit(0);
				default:
					System.out.println("Please select a valid option from above.");
				}
			} catch (Exception e) {
				System.out.println(e.getClass().getName());
				handleFileMenuOptions();
			}
		} while (running == true);
	}
}
