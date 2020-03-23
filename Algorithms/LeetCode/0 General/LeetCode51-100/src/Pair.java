
public class Pair <T1, T2> {
	
	T1 key;
	T2 val;
	
	public Pair(T1 key, T2 val) {
		this.key = key;
		this.val = val;
	}
	
	public T1 getKey() {
		return this.key;
	}
	
	public T2 getValue() {
		return this.val;
	}
	
	@Override
	public String toString() {
		return this.key + " " + this.val;
	}
}
