import java.util.concurrent.ThreadLocalRandom;
public class ModHash {
	private long a;
	private long b;
	private int m;
	private long p;
	
	public ModHash(int m, long p) {
	this.m = m;
	this.p= p;
	a = ThreadLocalRandom.current().nextLong(1, p);
	b = ThreadLocalRandom.current().nextLong(0, p);
	}
	public static ModHash GetFunc(int m, long p){
		ModHash func = new ModHash(m,p);
		return func;
	}
	public long getA() {
		return a;
	}
	public long getB() {
		return b;
	}
	public int Hash(long key) {
		int ret = (int) (((a*key+b) %p) %m);
		return ret;
	}
}
