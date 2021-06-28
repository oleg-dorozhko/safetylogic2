package pixeleditor;

public class Logger {
	
	public static boolean debug;
	
	public static void log(String s) {
		if(debug) System.out.println(s);
		
	}
	public static void lo(String s) {
		System.out.println(s);
		
	}
}
