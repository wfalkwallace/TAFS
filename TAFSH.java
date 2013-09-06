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
				"	delete <d/f/z/t> <name> - remove directory/folder/zip/text\n" +
				"	move <source path> <target path> - move element\n" +
				"	write <path> <content> - (over)write to text file" +
				"	print - print system hierarchy\n\n");

		tafs.print();

		String cmd;
		String[] arg;
		while(true) {
			if(user.hasNextLine()){
				cmd = user.nextLine();
				arg = cmd.split(" ");
				switch(arg[0]) {
				case "create":
					tafs.create(arg[1], arg[2], arg[3]);
					break;
				case "delete":
					tafs.
					break;
				case "move":
					break;
				case "write":
					break;
				case "print":
					break;
				default:
					System.out.println("Illegal file system operation");
				}
			}
		}


		//TODO command handling/illegal fs op
	}

}
