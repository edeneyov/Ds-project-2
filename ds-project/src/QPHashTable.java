import java.util.Random;

public class QPHashTable extends OAHashTable {
	ModHash hash;
	int m;
	public QPHashTable(int m, long p) {
		super(m);
		this.m = m;
		hash = new ModHash(m, p);
	}
	
	@Override
	public int Hash(long x, int i) {
		
		return (hash.Hash(x)+i^2)% m ;
	}
}
