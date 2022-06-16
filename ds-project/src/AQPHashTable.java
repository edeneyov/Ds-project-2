import java.util.Random;

public class AQPHashTable extends OAHashTable {
	private ModHash hash;
	public AQPHashTable(int m, long p) {
		super(m);
		hash = new ModHash(m, p);
	}
	
	@Override
	public int Hash(long x, int i) {
		int ret;
		if (i%2==0) {
			ret = (int)((hash.Hash(x)+i^2));
		}
		else {
			ret = (int)((hash.Hash(x)-(i^2)));	
		}
		
		return Math.floorMod(ret, this.m);
	}
}
