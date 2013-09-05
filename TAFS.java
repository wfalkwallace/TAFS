import java.util.ArrayList;

/**
 * 
 */

/**
 * @author wgf2104
 *
 */
public class TAFS {

	private ArrayList<Drive> root = new ArrayList<Drive>();
	
	//TODO illegal file system operation
	
	private void create(String type, String name, String path) {
		//TODO Exceptions: path not found; path already exists
		try {
			String[] pathlist = path.split("/");
			String pwd = "root";
			for(int i = 0; i < pathlist.length; i++){
				
			}
			root.get(root.indexOf(o))
			Element elem = (Element) Class.forName(type).newInstance();
			elem.setName(name);
			
		}
		
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
	
	//TODO search

}
