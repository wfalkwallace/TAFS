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
	private Element parent;
	private ArrayList<Element> children;

	public Element(String name, String type) {
		this.name = name;
		this.type = type;
		this.parent = null;
		this.children = new ArrayList<Element>();
	}
	
	public Element(String name, String type, Element parent) {
		this.name = name;
		this.type = type;
		this.parent = parent;
		this.children = new ArrayList<Element>();
	}
	
	public Element(String name, String type, ArrayList<Element> children) {
		this.name = name;
		this.type = type;
		this.parent = null;
		this.children = children;
	}
	
	//sub-folders and zips
	public Element(String name, String type, Element parent, ArrayList<Element> children) {
		this.name = name;
		this.type = type;
		this.parent = parent;
		this.children = new ArrayList<Element>();
	}
	
	
	public String getPath() {
		return "/" + name;
	}

	public String getName() {
		return name;
	}

	public int getSize() {
		int size = 0;
		for(Element e:children)
			size += e.getSize();
		return size;
	}

	public ArrayList<Element> getChildren() {
		return children;
	}

	public void addChild(Element child) throws TAFSException {
		for(Element e:children) {
			if(e.getName() != child.getName())
				children.add(child);
			else
				throw new TAFSException("Path already exists");
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

	public Container getParent() {
		return null;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	// TODO search

}
