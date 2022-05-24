
public abstract class OAHashTable implements IHashTable {

	private HashTableElement [] table;
	int m;

	public OAHashTable(int m) {
		this.table = new HashTableElement[m];
		this.m = m;
		// TODO add to constructor as needed
	}


	@Override
	public HashTableElement Find(long key) {
		for(int i=0;i<table.length;i++)
		{
			int j = Hash(key, i);
			if (table[j] == null) {
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
		int place = -1;
		for(int i=0;i<table.length;i++)
		{
			int j = Hash(hte.GetKey(), i);
			if ((table[j] == null || table[j].GetKey() < 0)){
				//table[j].equals(null)) or table[j].equals(deleted)
				if (place == -1) {
					place = j;
				}
				if(table[j] == null)
					break;
				
			}
			else if (table[j].GetKey() == hte.GetKey()) {
				throw new KeyAlreadyExistsException(hte);
			}
		}
		if (place != -1) {
			table[place]= hte;
		}
		else {
			throw new TableIsFullException(hte);
		}

	}

	@Override
	public void Delete(long key) throws KeyDoesntExistException {
		for(int i=0;i<table.length;i++)
		{
			int j = Hash(key, i);
			if (table[j] == null) {
				//table isn't full but key isn't in the hash seq. 
				throw new KeyDoesntExistException(key);
			}
			if (table[j].GetKey()==key) {
				// TODO assign a default hash table element to table[j]
				table[j] = new HashTableElement(-1, 0);
				return;
			}
		}
		throw new KeyDoesntExistException(key);


	}

	/**
	 * 
	 * @param x - the key to hash
	 * @param i - the index in the probing sequence
	 * @return the index into the hash table to place the key x
	 */
	public abstract int Hash(long x, int i);
}
