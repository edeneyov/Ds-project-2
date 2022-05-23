import java.util.Random;

public class AQPHashTable extends OAHashTable {
	ModHash hash;
	int m;
	public AQPHashTable(int m, long p) {
		super(m);
		this.m = m;
		hash = new ModHash(m, p);
	}
	
	@Override
	public int Hash(long x, int i) {
		if (i%2==0) {
			return (hash.Hash(x)+i^2)% m;
		}
		return (hash.Hash(x)-i^2)% m;
	}
}

