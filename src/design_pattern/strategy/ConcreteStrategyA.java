package design_pattern.strategy;

public class ConcreteStrategyA implements Strategy{
	@Override
    public double calcPrice(double booksPrice) {
        
        System.out.println("���ڳ�����Ա��û���ۿ�");
        return booksPrice;
    }
}
