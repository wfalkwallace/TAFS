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

	public void create(String type, String name, String path) {
		try {
			//search 
			Element pwd = search(path.substring(0, path.lastIndexOf("/")));
			if(pwd != null)
				pwd.addChild(new Element(name, type, pwd));
		} catch (TAFSException e) {
			System.out.println(e.getMessage());
		}
	}

	public void print() {
		for(Element d:root)
			d.print(0);
	}

	public void delete(String path) {
		try {
			//search 
			Element pwd = search(path);
			if(pwd != null)
				pwd.getParent().removeChild(pwd);
		} catch (TAFSException e) {
			System.out.println(e.getMessage());
		}
	}

	public void move(String source, String target) {
		//TODO Exceptions: path not found; path already exists

	}

	public void writeToFile(String path, String contents) {
		//TODO Exceptions: path not found; not a text file 
	}


	public Element search(String path) {
		try {
			String[] pathlist = path.split("/");
			Element pwd = null;

			//is there a path to search for?
			if(root.size() > 0) {
				//get drive
				for(Element e:root)
					if(e.getName().equals(pathlist[0])) {
						pwd = e;
						break;
					}
			}
			//no path? no problem!
			else
				throw new TAFSException("Path not found");

			//found the drive?
			if(pwd != null) {
				//iterate over the rest of the path
				for(int i = 1; i < pathlist.length; i++){
					for(Element e:pwd.getChildren())
						if(e.getName().equals(pathlist[i])) {
							pwd = e;
							break;
						}
					//pwd didnt contain the next item in path?
					if(!pwd.getName().equals(pathlist[i]))
						throw new TAFSException("Path not found");
				}
				return pwd;
			}
			//didnt find the drive?
			else
				throw new TAFSException("Path not found");
		} catch (TAFSException e) {
			System.out.println(e.getMessage());
			return null;
		}

	}


}
