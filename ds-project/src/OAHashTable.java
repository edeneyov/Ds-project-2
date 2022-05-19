
public abstract class OAHashTable implements IHashTable {
	
	private HashTableElement [] table;
	
	public OAHashTable(int m) {
		this.table = new HashTableElement[m];
		// TODO add to constructor as needed
	}
	
	
	@Override
	public HashTableElement Find(long key) {
		for(int i=0;i<table.length;i++)
		{
			int j = Hash(key, i);
			if (table[j].equals(null)) {
				//table isn't full but key isn't in the hash seq. 
				return null;
			}
			else if (table[j].GetKey()==key) {
				return table[j];
			}
		}
		//table is full and key isn't there
		return null;
	}
	
	@Override
	public void Insert(HashTableElement hte) throws TableIsFullException,KeyAlreadyExistsException {
		for(int i=0;i<table.length;i++)
		{
			int j = Hash(hte.GetKey(), i);
			if (table[j].equals(null)) {
				table[j] = hte;
				return;
			}
			else if (table[j].GetKey()==hte.GetKey()) {
				throw new KeyAlreadyExistsException(hte);
			}
		}
		throw new TableIsFullException(hte);
			
	}
	
	@Override
	public void Delete(long key) throws KeyDoesntExistException {
		// TODO implement deletion
		for(int i=0;i<table.length;i++)
		{
			int j = Hash(key, i);
			if (table[j].equals(null)) {
				//table isn't full but key isn't in the hash seq. 
				throw new KeyDoesntExistException(key);
			}
			else if (table[j].GetKey()==key) {
				// TODO assign a default hash table element to table[j]
			}
		}


	}
	
	/**
	 * 
	 * @param x - the key to hash
	 * @param i - the index in the probing sequence
	 * @return the index into the hash table to place the key x
	 */
	public abstract int Hash(long x, int i);
}
