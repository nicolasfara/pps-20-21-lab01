package lab01.tdd;

public class StrategyFactoryImpl implements StrategyFactory {

    @Override
    public SelectStrategy getEvenStrategy() {
        return this.getMultipleOfStrategy(2);
    }

    @Override
    public SelectStrategy getMultipleOfStrategy(int value) {
        return e -> e % value == 0;
    }

    @Override
    public SelectStrategy getEqualStrategy(int value) {
        return e -> e == value;
    }
}
