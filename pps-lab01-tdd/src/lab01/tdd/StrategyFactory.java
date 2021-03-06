package lab01.tdd;

public interface StrategyFactory {
    SelectStrategy getEvenStrategy();
    SelectStrategy getMultipleOfStrategy(int value);
    SelectStrategy getEqualStrategy(int value);
}
