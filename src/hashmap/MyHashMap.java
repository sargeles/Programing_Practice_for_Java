package hashmap;

//��֤key��value��Ϊ��
public class MyHashMap<K, V> {
  private Entry[] table;//Entry�����
  static final int DEFAULT_INITIAL_CAPACITY = 16;//Ĭ�����鳤��
  private int size;

  // ���캯��
  public MyHashMap() {
      table = new Entry[DEFAULT_INITIAL_CAPACITY];
      size = DEFAULT_INITIAL_CAPACITY;
  }

  //��ȡ���鳤��
  public int getSize() {
      return size;
  }
  
  // ��index
  static int indexFor(int h, int length) {
      return h % (length - 1);
  }

  //��ȡԪ��
  public V get(Object key) {
      if (key == null)
          return null;
      int hash = key.hashCode();// key�Ĺ�ϣֵ
      int index = indexFor(hash, table.length);// ��key�������е��±�
      for (Entry<K, V> e = table[index]; e != null; e = e.next) {
          Object k = e.key;
          if (e.key.hashCode() == hash && (k == key || key.equals(k)))
              return e.value;
      }
      return null;
  }

  // ���Ԫ��
  public V put(K key, V value) {
      if (key == null)
          return null;
      int hash = key.hashCode();
      int index = indexFor(hash, table.length);
      /*System.out.println(index);*/

      // �����ӵ�key�Ѿ����ڣ���ôֻ��Ҫ�޸�valueֵ����
      for (Entry<K, V> e = table[index]; e != null; e = e.next) {
          Object k = e.key;
          if (e.key.hashCode() == hash && (k == key || key.equals(k))) {
              V oldValue = e.value;
              e.value = value;
              return oldValue;// ԭ����valueֵ
          }
      }
      // ���keyֵ�����ڣ���ô��Ҫ���
      Entry<K, V> e = table[index];// ��ȡ��ǰ�����е�e
      table[index] = new Entry<K, V>(key, value, e);// �½�һ��Entry��������ָ��ԭ�ȵ�e
      return null;
  }

}