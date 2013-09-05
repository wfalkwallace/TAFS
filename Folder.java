import java.util.ArrayList;

/**
 * 
 */

/**
 * @author wgf2104
 *
 */
public class Folder implements Container, Element {

	private String name;
	private ArrayList<Element> children;
	private Container parent;
	
	public Folder(String name, Container parent) {
		this.name = name;
		this.parent = parent;
		this.children = new ArrayList<Element>();
	}
	
	public Folder(String name, Container parent, ArrayList<Element> children) {
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
	
	// TODO search
	
}
