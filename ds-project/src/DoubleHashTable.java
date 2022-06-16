import java.util.Random;

public class DoubleHashTable extends OAHashTable {
	private ModHash hash1;
	private ModHash hash2;
	public DoubleHashTable(int m, long p) {
		super(m);
		hash1 = new ModHash(m, p);
		hash2 = new ModHash(m-1, p);
	}
	
	@Override
	public int Hash(long x, int i) {
		long newI = (long)i;
		int res = (int) ((hash1.Hash(x)+newI*(hash2.Hash(x)+1))%this.m);
		return res;
	}
	
}
