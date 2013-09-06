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
		
		//TODO command handling/illegal fs op
	}

}
