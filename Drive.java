import java.util.ArrayList;

/**
 * 
 */

/**
 * @author wgf2104
 *
 */
public class Drive implements Container {

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

	public void addChild(Element child) {
		for(Element e:children) {
			if(e.getName() != child.getName())
				children.add(child);
			else
				System.out.println("\nFile path already exists.\n");
		}
	}

	public void removeChild(Element child) {
		children.remove(child);
	}
	
	public void print() {
		System.out.println(name);
		for(Element e:children) {
			e.print(1);
		}
	}
	
	// TODO search

}
