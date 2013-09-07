import java.util.Scanner;

/**
 * 
 */

/**
 * @author wgf2104
 *
 */
public class TAFSH {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TAFS tafs = new TAFS();
		Scanner user = new Scanner(System.in);

		System.out.println("\n\nWelcome to the TellApart File System (TAFS)\n" +
				"===========================================\n" +
				"Commands:\n" +
				"	ll - print file system hierarchy\n" +
				"	create <drive/folder/zip/text> <name> <path-of-parent> - create given entity\n" +
				"	delete <path> - remove element\n" +
				"	move <source path> <target path> - move element\n" +
				"	write <path> <content> - (over)write to text file\n" +
				"	print - print system hierarchy\n" +
				"	quit - exit the system\n\n");

		String cmd;
		String[] arg;
		//iterate until quit
		while(true) {
			if(user.hasNextLine()){
				//get and break down command
				cmd = user.nextLine();
				arg = cmd.split(" ");
				//switch over input command
				switch(arg[0]) {
				case "create":
					tafs.create(arg[1], arg[2], arg[3]);
					break;
				case "delete":
					tafs.delete(arg[1]);
					break;
				case "move":
					tafs.move(arg[1], arg[2]);
					break;
				case "write":
					tafs.writeToFile(arg[1], cmd.substring(cmd.indexOf(" ")));
					break;
				case "print":
					tafs.print();
					break;
				case "quit":
					user.close();
					System.exit(0);
				default:
					System.out.println("Illegal file system operation");
				}
			}
		}
	}
}
