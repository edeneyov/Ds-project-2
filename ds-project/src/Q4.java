import java.util.concurrent.ThreadLocalRandom;

public class Q4 {

	public static void main(String[] args) {
		IHashTable Lp = new LPHashTable(10000019, 1000000007);
		IHashTable AQp = new AQPHashTable(10000019, 1000000007);
		IHashTable Qp = new QPHashTable(10000019, 1000000007);
		IHashTable Dh = new DoubleHashTable(10000019, 1000000007);
		System.out.println("--------------------4_1----------------------");
		q4_Compute(Lp, "LP", 5000009);
		q4_Compute(AQp, "AQP", 5000009);
		q4_Compute(Qp, "QP", 5000009);
		q4_Compute(Dh, "Double hash", 5000009);
		System.out.println("--------------------4_2----------------------");
		IHashTable Lp_2 = new LPHashTable(10000019, 1000000007);
		IHashTable AQp_2 = new AQPHashTable(10000019, 1000000007);
		IHashTable Dh_2 = new DoubleHashTable(10000019, 1000000007);
		q4_Compute(Lp_2, "LP", 9500018);
		q4_Compute(AQp_2, "AQP", 9500018);
		q4_Compute(Dh_2, "Double Hash", 9500018);
//		System.out.println("---------------------5----------------------");
//		printTime_5();
		System.out.println("out");


	}
	private static void printTime_5() {
		int [] a_1 = generate_A_i();
		int [] a_2 = generate_A_i();
		int [] a_3 = generate_A_i();
		int [] a_4 = generate_A_i();
		int [] a_5 = generate_A_i();
		int [] a_6 = generate_A_i();
		int [][] A = {a_1 , a_2 , a_3, a_4, a_5, a_6};
		long startTime = System.nanoTime();
		IHashTable Dh_5 = new DoubleHashTable(10000019, 1000000007);
		for (int i=0; i<3;i++) {
			insert_A(Dh_5,A[i]);
			remove_A(Dh_5, A[i]);
		}
		long midTime= System.nanoTime();
		
		for (int i=3; i<6;i++) {
			insert_A(Dh_5,A[i]);
			remove_A(Dh_5, A[i]);
		}
		long endTime= System.nanoTime();
		long total_first_Three = midTime - startTime;
		long total_last_Three = endTime- midTime;
		System.out.println("first 3 = "+ total_first_Three);
		System.out.println("last 3 = "+ total_last_Three);
	}
	private static void remove_A(IHashTable dh, int[] a_i) {
		HashTableElement hte;
		int n = 5000009;
		for (int i=0; i<n;i++) {
			hte = new HashTableElement(a_i[i], i);
			try {
				dh.Delete(a_i[i]);
			} catch (IHashTable.KeyDoesntExistException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	private static void insert_A(IHashTable dh, int[] a_i) {
		HashTableElement hte;
		int n = 5000009;
		for (int i=0; i<n;i++) {
			hte = new HashTableElement(a_i[i], i);
			try {
				dh.Insert(hte);
			} catch (IHashTable.TableIsFullException e) {
				e.printStackTrace();
			} catch (IHashTable.KeyAlreadyExistsException e) {
				e.printStackTrace();
			}
		}
	}
	private static int[] generate_A_i() {
		int n = 5000009;
		int b_i;
		int [] a  = new int [n];
		for(int i= 0; i<n;i++) {
			b_i = ThreadLocalRandom.current().nextInt(0,100);
			a[i] = 100*i + b_i;
		}
		return a;
	}
	public static void q4_Compute(IHashTable ht , String st, int n) {
		long startTime = System.nanoTime();
		q4(ht,n);
		long endTime= System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.println(st+" total time is == "+totalTime);
	}
	public static void q4(IHashTable ht, int n) {
		int b_i;
		int a_i;
		HashTableElement hte;
		for(int i= 0; i<n;i++) {
			b_i = ThreadLocalRandom.current().nextInt(0,100);
			a_i = 100*i + b_i;
			hte = new HashTableElement(a_i, i);
			try {
				ht.Insert(hte);
			}
			catch (Exception e) {

				System.out.println("not supposed to get here - "+ e.getLocalizedMessage());
			}
		}
	}

}
