package app;

public interface Loadable<T> {
	
	public T loadFromFile(String file);
	public void saveToFile(T saver, String file);

}
