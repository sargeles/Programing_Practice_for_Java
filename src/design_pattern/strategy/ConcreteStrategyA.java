package design_pattern.strategy;

public class ConcreteStrategyA implements Strategy{
	@Override
    public double calcPrice(double booksPrice) {
        
        System.out.println("对于初级会员的没有折扣");
        return booksPrice;
    }
}
