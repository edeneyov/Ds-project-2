import java.util.Random;

public class QPHashTable extends OAHashTable {
	ModHash hash;
	public QPHashTable(int m, long p) {
		super(m);
		hash = new ModHash(m, p);
	}
	
	@Override
	public int Hash(long x, int i) {
		
		return (hash.Hash(x)+i^2)% this.m ;
	}
}
