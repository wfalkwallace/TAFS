import java.util.ArrayList;

/**
 * 
 */

/**
 * @author wgf2104
 *
 */
public class TAFS {

	private ArrayList<Element> root = new ArrayList<Element>();

	//TODO illegal file system operation


	private void create(String type, String name, String path) {
		//TODO Exceptions: path not found
		String[] pathlist = path.split("/");
		try {
			if(pathlist.length > 1) {
				Element pwd;
				for(Element e:root)
					if(e.getName().equals(pathlist[0])) {
						pwd = e;
						break;
					}
				for(int i = 1; i < pathlist.length - 1; i++){
					for(Element e:pwd.getChildren())
						if(e.getName().equals(pathlist[i])) {
							pwd = e;
							break;
						}
				}
				pwd.addChild(new Element(name, type, pwd));
			}
			else
				if(type.equals("drive"))
					root.add(new Element(name));
				else
					throw new TAFSException("Illegal File System Operation");
		} catch (TAFSException e) {
			System.out.println(e.getMessage());
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
