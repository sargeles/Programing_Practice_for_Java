package reflect;


/*public class Test {
	public static void main(String[] args) throws ClassNotFoundException {
		String st = new String();
		Class c = String.class;
		Integer i = new Integer(5);
		ClassUtil.printClassMessage(st);
		ClassUtil.printFieldMessage(st);
		ClassUtil.printConstructorMessage(st);
		ClassUtil.printInterfacesMessage(st);
		ClassUtil.printSuperclassMessage(st);
	}
}*/
//�ⲿ��
public class Test {
  
  private String name = "��Ľ��";
  
  // �ⲿ���е�show����
  public void show() { 
		// ���巽���ڲ���
		class MInner {
			int score = 83;
			public int getScore() {
				return score + 10;
			}
		}
      
		// ���������ڲ���Ķ���
      MInner mi = new MInner();
      
      // �����ڲ���ķ���
		int newScore=mi.getScore();
      
		System.out.println("������" + name + "\n�ӷֺ�ĳɼ���" + newScore);
	}
  
	// ���Է����ڲ���
	public static void main(String[] args) {
      
		// �����ⲿ��Ķ���
      Test mo = new Test();
      
      // �����ⲿ��ķ���
		mo.show();
	}
}