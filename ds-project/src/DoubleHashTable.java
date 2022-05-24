import java.util.Random;

public class DoubleHashTable extends OAHashTable {
	private ModHash hash1;
	private ModHash hash2;
	public DoubleHashTable(int m, long p) {
		super(m);
		hash1 = new ModHash(m, p);
		hash2 = new ModHash(m, p);
		// TODO Complete hash table constructor.
	}
	
	@Override
	public int Hash(long x, int i) {
		return (int) ((hash1.Hash(x)+i*hash2.Hash(x))%this.m);
	}
	
}
