package exception;

@SuppressWarnings("serial")
public class ElementNotAllowedException extends RuntimeException{
	
	public ElementNotAllowedException(String msg)  {
		super("[TU nOTaLLOWEDeXCEPTION]: " + msg);
	}
}
