package exception;

@SuppressWarnings("serial")
public class ListSizeOverflownException extends RuntimeException {

	public ListSizeOverflownException(String msg)  {
		super("[TU oVERfLOWeXCEPTION]: " + msg);
	}
}
