import java.util.ArrayList;

/**
 * 
 */

/**
 * @author wgf2104
 *
 */
public interface Container {

	public String getPath();
	public String getName();
	public int getSize();
	public ArrayList<Element> getChildren();
	public void addChild(Element child);
	
}
