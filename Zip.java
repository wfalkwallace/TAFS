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
	private Container parent;
	private ArrayList<Element> children;
	
	public Zip(String name, Container parent) {
		this.name = name;
		this.parent = parent;
		this.children = new ArrayList<Element>();
	}
	
	public Zip(String name, Container parent, ArrayList<Element> children) {
		this.name = name;
		this.parent = parent;
		this.children = children;
	}
	
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
		for(int i = 1; i < depth; i++){
			System.out.print("  ");
		}
		System.out.print("|_");
		System.out.println(name);
		for(Element e:children) {
			e.print(depth+1);
		}
	}

	public void setName(String name) {
		this.name = name;
	}
	
	// TODO search

}
