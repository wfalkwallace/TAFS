/**
 * 
 */

/**
 * @author wgf2104
 *
 */
public class Text implements Element {

	private String name;
	private Container parent;
	private String contents;
	
	public Text(String name, Container parent) {
		this.name = name;
		this.parent = parent;
		this.contents = "";
	}
	
	public Text(String name, Container parent, String contents) {
		this.name = name;
		this.parent = parent;
		this.contents = contents;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSize() {
		//compute dynamically - get content size for text file
		return contents.length();
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}

	public Container getParent() {
		return parent;
	}

	public void setParent(Container parent) {
		this.parent = parent;
	}
	
	public String getPath() {
		return parent.getPath() + "/" + name;
	}

}
