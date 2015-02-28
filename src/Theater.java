
public class Theater {
	
	
	private static Theater instance = null;
	   protected Theater() {
	      
	   }
	   public static Theater getInstance() {
	      if(instance == null) {
	         instance = new Theater();
	      }
	      return instance;
	   }
	}

