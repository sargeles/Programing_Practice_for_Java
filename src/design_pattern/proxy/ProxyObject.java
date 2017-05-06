package design_pattern.proxy;

public class ProxyObject extends AbstractObject {
	RealObject realObject = new RealObject();

	@Override
	public void operation() {
		// ����Ŀ�����֮ǰ��������ز���
		System.out.println("before");
		realObject.operation();
		// ����Ŀ�����֮���������ز���
		System.out.println("after");
	}
}