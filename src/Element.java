import java.util.ArrayList;

/**
 * 
 */

/**
 * @author wgf2104
 *
 */
public class Element {

	private String name;
	private String type;
	private String contents;
	private Element parent;
	private ArrayList<Element> children;


	/**
	 * Drive constructor
	 * @param name drive name
	 */
	public Element(String name) {
		this.name = name;
		this.type = "drive";
		parent = null;
		contents = "";
		children = new ArrayList<Element>();
	}

	/**
	 * Folder, Zip, and Text File constructor
	 * @param name element name
	 * @param type element type
	 * @param parent file system hierarchy parent
	 */
	//folders, zips, and apparently text files? guidelines are a bit 
	//ambiguous here - are drives supposed to be created with a null-parent/path?
	public Element(String name, String type, Element parent) {
		this.name = name;
		this.type = type.toLowerCase();
		this.parent = parent;
		contents = "";
		if(type.equals("text"))
			children = null;
		else
			children = new ArrayList<Element>();
	}

	/**
	 * Populated text file constructor
	 * @param name text file name
	 * @param parent hierarchy parent
	 * @param contents initial text file contents
	 */
	//text files
	public Element(String name, Element parent, String contents) {
		type = "text";
		this.name = name;
		this.parent = parent;
		this.contents = contents;

		//maybe a little bloated for text files to all have children at all, but so
		//much simpler to just check type in addChild instead of both here and there.
		children = null;
	}

	/**
	 * Get Element path as a string
	 * @return path from root
	 */
	public String getPath() {
		//calculating dynamically is easier than updating on all changes, maybe a bit bloated.
		if(parent != null)
			return parent.getPath() + "/" + name;
		return name;
	}

	/**
	 * Element Name
	 * @return name string
	 */
	public String getName() {
		return name;
	}

	/**
	 * modify element name
	 * @param name new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * element size calculator
	 * @return element size (sum of size of all children, recursively; content string length for text files; and half calculated size for zip files)
	 */
	public int getSize() {
		int size = contents.length();
		if(size == 0) 
			for(Element e:children)
				size += e.getSize();
		if(type.equals("zip"))
			size /= 2;
		return size;
	}

	/**
	 * Get's an elements children
	 * @return set of element's children
	 * @throws TAFSException if textfile, operation is illegal
	 */
	public ArrayList<Element> getChildren() throws TAFSException {
		if(children != null)
			return children;
		else
			throw new TAFSException("Illegal File System Operation");
	}

	/**
	 * Get element container - only valid for non-drive elements
	 * @return element's container
	 */
	public Element getParent() {
		return parent;
	}

	/**
	 * Modify element parent
	 * @param parent new parent
	 * @throws TAFSException nonvalid operation for drive entities
	 */
	public void setParent(Element parent) throws TAFSException {
		if(type.equals("drive"))
			this.parent = parent;
		else
			throw new TAFSException("Illegal File System Operation");
	}

	/**
	 * Add a child element to a container element
	 * @param child child to add
	 * @throws TAFSException preexisting path/duplicate element name; illegal operation
	 */
	public void addChild(Element child) throws TAFSException {
		if(!type.equals("text"))
			for(Element e:children) {
				if(!e.getName().equals(child.getName()))
					children.add(child);
				else
					throw new TAFSException("Path already exists");
			}
		else
			throw new TAFSException("Illegal File System Operation");
	}

	/**
	 * Remove an element from its container
	 * @param child element to remove
	 * @throws TAFSException non-existing child
	 */
	public void removeChild(Element child) throws TAFSException {
		if(children.indexOf(child) > -1)
			children.remove(child);
		else
			throw new TAFSException("Path Not Found");
	}

	/**
	 *Recursively print subsequent file system hierarchy
	 * @param depth indentation guideline
	 */
	public void print(int depth) {
		for(int i = 0; i < depth; i++)
			System.out.print(" |_");
		System.out.println(name);
		for(Element e:children) {
			e.print(depth + 1);
		}
	}

	/**
	 * Element Type accessor
	 * @return Element Type
	 */
	public String getType() {
		return type;
	}

	/**
	 * text file content accessor
	 * @return Text file content string
	 * @throws TAFSException not a text file
	 */
	public String getContents() throws TAFSException {
		if(type.equals("text"))
			return contents;
		else 
			throw new TAFSException("Illegal File System Operation");

	}

	/**
	 * Modify text file contents
	 * @param contents new content string (overwrites old)
	 * @throws TAFSException not a text file
	 */
	public void setContents(String contents) throws TAFSException {
		if(type.equals("text"))
			this.contents = contents;
		else 
			throw new TAFSException("Not a text File");
	}
}
