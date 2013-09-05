/**
 * 
 */

/**
 * @author wgf2104
 *
 */
public interface Element {
	
	public String getPath();
	public String getName();
	public void setName(String name);
	public int getSize();
	public Container getParent();
	public void print(int depth);
	
}
