import java.util.concurrent.ThreadLocalRandom;
public class ModHash {
	private int a;
	private int b;
	private int m;
	private long p;
	
	public ModHash(int m, long p) {
	this.m = m;
	this.p= p;
	a = ThreadLocalRandom.current().nextInt(1, (int)p);
	b = ThreadLocalRandom.current().nextInt(0, (int)p);
	}
	public static ModHash GetFunc(int m, long p){
		ModHash func = new ModHash(m,p);
		return func;
	}
	
	public int Hash(long key) {
		int ret = (int) (((a*key+b) %p) %m);
		return ret;
	}
}
