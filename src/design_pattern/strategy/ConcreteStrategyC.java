package design_pattern.strategy;

public class ConcreteStrategyC implements Strategy {

	@Override
    public double calcPrice(double booksPrice) {
        
        System.out.println("���ڸ߼���Ա���ۿ�Ϊ20%");
        return booksPrice * 0.8;
    }

}