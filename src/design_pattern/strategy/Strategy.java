package design_pattern.strategy;

public interface Strategy {
	/**
     * ����ͼ��ļ۸�
     * @param booksPrice    ͼ���ԭ��
     * @return    ��������ۺ�ļ۸�
     */
    public double calcPrice(double booksPrice);
}