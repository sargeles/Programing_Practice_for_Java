package design_pattern.strategy;

public class Client {

    public static void main(String[] args) {
        //ѡ�񲢴�����Ҫʹ�õĲ��Զ���
        Strategy strategy = new ConcreteStrategyC();
        //��������
        Context price = new Context(strategy);
        //����۸�
        double quote = price.quote(300);
        System.out.println("ͼ������ռ۸�Ϊ��" + quote);
    }

}