package design_pattern.strategy;

public class Client {

    public static void main(String[] args) {
        //选择并创建需要使用的策略对象
        Strategy strategy = new ConcreteStrategyC();
        //创建环境
        Context price = new Context(strategy);
        //计算价格
        double quote = price.quote(300);
        System.out.println("图书的最终价格为：" + quote);
    }

}