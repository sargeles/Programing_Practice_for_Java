package design_pattern.strategy;

public class ConcreteStrategyB implements Strategy{
	@Override
    public double calcPrice(double booksPrice) {

        System.out.println("�����м���Ա���ۿ�Ϊ10%");
        return booksPrice * 0.9;
    }
}
