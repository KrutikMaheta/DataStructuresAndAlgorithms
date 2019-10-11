/**
 * Custom HashMap implementation
 * Supporting Files: Employee.java & CustomHashMapClient.java
 */

package implementation;

public class CustomHashMap<K, V> {

	private Entry<K, V>[] table;
	private static final int CAPACITY = 4;

	static class Entry<K, V> {
		K key;
		V value;
		Entry<K, V> next;

		public Entry(K key, V value, Entry<K, V> next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}

	@SuppressWarnings("unchecked")
	public CustomHashMap() {
		table = new Entry[CAPACITY];
	}

	public boolean put(K newKey, V data) {
		if (newKey == null)
			return false; // does not allow to store null.

		int hash = hash(newKey);
		Entry<K, V> newEntry = new Entry<K, V>(newKey, data, null);

		if (table[hash] == null) {
			table[hash] = newEntry;
			return true;
		} else {
			Entry<K, V> previous = null;
			Entry<K, V> current = table[hash];
			while (current != null) {
				if (current.key.equals(newEntry.key)) {
					if (previous == null) {
						newEntry.next = current.next;
						table[hash] = newEntry;
						return true;
					} else {
						newEntry.next = current.next;
						previous.next = newEntry;
						return true;
					}
				} // if
				previous = current;
				current = current.next;
			} // while
			previous.next = newEntry;
		} // else
		return false;
	}

	public V get(K key) {
		int hash = hash(key);
		if (table[hash] == null) {
			return null;
		} else {
			Entry<K, V> temp = table[hash];
			while (temp != null) {
				if (temp.key.equals(key))
					return temp.value;
				temp = temp.next;
			}
			return null;
		}
	}

	public boolean remove(K deleteKey) {
		int hash = hash(deleteKey);

		if (table[hash] == null) {
			return false;
		} else {
			Entry<K, V> previous = null;
			Entry<K, V> current = table[hash];
			while (current != null) {
				if (current.key.equals(deleteKey)) {
					if (previous == null) { // delete first entry node.
						table[hash] = table[hash].next;
						return true;
					} else {
						previous.next = current.next;
						return true;
					}
				}
				previous = current;
				current = current.next;
			} // while
		} // else
		return false;
	}

	public void display() {

		for (int i = 0; i < CAPACITY; i++) {
			if (table[i] != null) {
				Entry<K, V> entry = table[i];
				while (entry != null) {
					System.out.print("{" + entry.key + "=" + entry.value + "}" + "   ");
					entry = entry.next;
				}
			}
		}

	}

	private int hash(K key) {
		return Math.abs(key.hashCode()) % CAPACITY;
	}

}
