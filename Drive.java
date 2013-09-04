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
	
	// TODO constructor/children handling
	
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
		children.add(child);
	}

	// TODO remove child
	// TODO search

}
