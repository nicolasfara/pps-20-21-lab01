package lab01.tdd;

public abstract class AbstractSelectStrategy {
    public abstract SelectStrategy getStrategy(SelectionType type);
    public abstract SelectStrategy getStrategyWithArgs(SelectionType type, int value);
}
