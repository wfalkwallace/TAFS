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
	public Element(String name, String type) {
		this.name = name;
		this.type = "drive";
		parent = null;
		contents = "";
		children = new ArrayList<Element>();
	}

	//folders, zips
	public Element(String name, String type, Element parent) {
		this.name = name;
		this.type = type.toLowerCase();
		this.parent = parent;
		contents = "";
		this.children = new ArrayList<Element>();
	}

	//text files
	public Element(String name, Element parent, String contents) {
		type = "text";
		this.name = name;
		this.parent = parent;
		this.contents = contents;

		//maybe a little bloated for text files to all have children at all, but so
		//much simpler to just check type in addChild instead of both here and there.
		this.children = null;
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
		if(type == "zip")
			size /= 2;
		return size;
	}

	public ArrayList<Element> getChildren() {
		return children;
	}
	
	public Element getParent() {
		return parent;
	}

	public void setParent(Element parent) {
		this.parent = parent;
	}
	
	public void addChild(Element child) {
		if(type !=)
		for(Element e:children) {
			if(e.getName() != child.getName())
				children.add(child);
		}
	}

	public void removeChild(Element child) {
		children.remove(child);
	}

	public void print(int depth) {
		System.out.println(name);
		for(Element e:children) {
			e.print(depth + 1);
		}
	}


	// TODO search

}
