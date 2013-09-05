import java.util.ArrayList;

/**
 * 
 */

/**
 * @author wgf2104
 *
 */
public class TAFS {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("\n\nWelcome to the TellApart File System (TAFS)\n" +
				"Commands:\n" +
				"	ll - print file system hierarchy\n" +
				"	create <drive/folder/zip/text> <name> <path-of-parent> - create given entity\n" +
				"	delete <d/f/z/t> <name> - remove directory/folder/zip/text\n" +
				"	cd <path> - change to specified directory\n" +
				"	");
		// Using arraylists throughout - maybe better to use an array but it's doing the same
		// thing in the background for me, and sorting within a branch is a bit easier than a 
		// map/table/tree.
		ArrayList<Drive> root = new ArrayList<Drive>();
		for(Drive d:root)
			d.print();
	}
	
	//TODO illegal file system operation
	
	create(String type, String name, String path) {
		//TODO Exceptions: path not found; path already exists
	}
	
	delete(String path) {
		//TODO Exceptions: path not found
	}
	
	move(String source, String target) {
		//TODO Exceptions: path not found; path already exists

	}
	
	writeToFile(String path, String contents) {
		//TODO Exceptions: path not found; not a text file 
	}

}
