package design_pattern.strategy;

public class Context {
	private Strategy strategy;
    /**
     * ���캯��������һ��������Զ���
     * @param strategy    ������Զ���
     */
    public Context(Strategy strategy){
        this.strategy = strategy;
    }
    /**
     * ����ͼ��ļ۸�
     * @param booksPrice    ͼ���ԭ��
     * @return    ��������ۺ�ļ۸�
     */
    public double quote(double booksPrice){
        return this.strategy.calcPrice(booksPrice);
    }
}
