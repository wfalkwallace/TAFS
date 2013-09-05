import java.util.ArrayList;

/**
 * 
 */

/**
 * @author wgf2104
 *
 */
public class Drive implements Element, Container {

	private String name;
	private ArrayList<Element> children;

	public Drive(String name) {
		this.name = name;
		this.children = new ArrayList<Element>();
	}
	
	public Drive(String name, ArrayList<Element> children) {
		this.name = name;
		this.children = children;
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
