package design_pattern.strategy;

public class ConcreteStrategyC implements Strategy {

	@Override
    public double calcPrice(double booksPrice) {
        
        System.out.println("对于高级会员的折扣为20%");
        return booksPrice * 0.8;
    }

}