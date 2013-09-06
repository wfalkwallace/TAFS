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


	//drives
	public Element(String name) {
		this.name = name;
		this.type = "drive";
		parent = null;
		contents = "";
		children = new ArrayList<Element>();
	}

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

	public String getPath() {
		//calculating dynamically is easier than updating on all changes, maybe a bit bloated.
		if(parent != null)
			return parent.getPath() + "/" + name;
		return name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSize() {
		int size = contents.length();
		if(size == 0) 
			for(Element e:children)
				size += e.getSize();
		if(type.equals("zip"))
			size /= 2;
		return size;
	}

	public ArrayList<Element> getChildren() throws TAFSException {
		if(children != null)
			return children;
		else
			throw new TAFSException("Illegal File System Operation");
	}

	public Element getParent() {
		return parent;
	}

	public void setParent(Element parent) throws TAFSException {
		if(type.equals("drive"))
			this.parent = parent;
		else
			throw new TAFSException("Illegal File System Operation");
	}

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

	public void removeChild(Element child) throws TAFSException {
		if(children.indexOf(child) > -1)
			children.remove(child);
		else
			throw new TAFSException("Path Not Found");
	}

	public void print(int depth) {
		for(int i = 0; i < depth; i++)
			System.out.print(" |_");
		System.out.println(name);
		for(Element e:children) {
			e.print(depth + 1);
		}
	}

	public String getType() {
		return type;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}
}
