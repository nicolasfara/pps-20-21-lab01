package lab01.tdd;

public class SelectStrategyFactory extends AbstractSelectStrategy {

    private SelectStrategyFactory() { }

    @Override
    public SelectStrategy getStrategy(SelectionType type) {
        if (type == SelectionType.EVEN) {
            return e -> e % 2 == 0;
        }
        throw new IllegalArgumentException("The given strategy type is invalid");
    }

    @Override
    public SelectStrategy getStrategyWithArgs(SelectionType type, int value) {
        switch (type) {
            case EQUALS:
                return e -> e == value;
            case MULTIPLE_OF:
                return e -> e % value == 0;
            default:
                throw new IllegalArgumentException("Invalid strategy type");
        }
    }

    public static SelectStrategyFactory getFactory() {
        return new SelectStrategyFactory();
    }
}
