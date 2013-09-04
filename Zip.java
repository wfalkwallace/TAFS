import java.util.ArrayList;

/**
 * 
 */

/**
 * @author wgf2104
 *
 */
public class Zip implements Container, Element {

	private String name;
	private ArrayList<Element> children;
	private Container parent;
	
	// TODO constructor/children handling

	public Container getParent() {
		return parent;
	}
	
	public String getPath() {
		return parent.getPath() + "/" + name;
	}
	
	public String getName() {
		return name;
	}
	@Override
	public int getSize() {
		int size = 0;
		for(Element e:children)
			size += e.getSize();
		return size/2;
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
