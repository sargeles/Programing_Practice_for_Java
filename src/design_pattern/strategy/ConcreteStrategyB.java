package design_pattern.strategy;

public class ConcreteStrategyB implements Strategy{
	@Override
    public double calcPrice(double booksPrice) {

        System.out.println("对于中级会员的折扣为10%");
        return booksPrice * 0.9;
    }
}
