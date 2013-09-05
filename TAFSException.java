/**
 * 
 */

/**
 * @author wgf2104
 *
 */
public class TAFSException extends Exception {
	 public TAFSException() {
		 super();
	 }

     public TAFSException(String message) {
        super(message);
     }
     
     public TAFSException(String message, Throwable cause) {
         super(message, cause);
     }
     
     public TAFSException(Throwable cause) {
         super(cause);
     }
}