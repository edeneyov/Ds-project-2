import java.util.Random;

public class LPHashTable extends OAHashTable {
	ModHash hash;
	public LPHashTable(int m, long p) {
		super(m);
		hash = new ModHash(m, p);
	}
	
	@Override
	public int Hash(long x, int i) {
		return (hash.Hash(x)+i)% this.m ;
	}
	
}
