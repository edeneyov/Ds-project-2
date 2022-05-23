import java.util.Random;

public class DoubleHashTable extends OAHashTable {
	ModHash hash1;
	ModHash hash2;
	int m;
	public DoubleHashTable(int m, long p) {
		super(m);
		this.m = m;
		hash1 = new ModHash(m, p);
		hash2 = new ModHash(m, p);
	}
	
	@Override
	public int Hash(long x, int i) {
		return (hash1.Hash(x)+i*hash2.Hash(x)(x))%m;
	}
	
}
