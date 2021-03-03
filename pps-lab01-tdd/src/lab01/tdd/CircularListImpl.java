package lab01.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CircularListImpl implements CircularList {
    private final List<Integer> list = new ArrayList<>();
    private int currentIndex = 0;

    @Override
    public void add(int element) {
        list.add(element);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public Optional<Integer> next() {
        if (this.isEmpty()) {
            return Optional.empty();
        }

        Optional<Integer> value = Optional.of(list.get(currentIndex));
        currentIndex = ++currentIndex % list.size();
        return value;
    }

    @Override
    public Optional<Integer> previous() {
        if (this.isEmpty()) {
            return Optional.empty();
        }

        Optional<Integer> value = Optional.of(list.get(currentIndex));
        if (currentIndex == 0) {
            currentIndex = list.size() - 1;
        } else {
            currentIndex--;
        }
        return value;
    }

    @Override
    public void reset() {
        currentIndex = 0;
    }

    @Override
    public Optional<Integer> next(SelectStrategy strategy) {
        if (this.isEmpty()) {
            return Optional.empty();
        }

        Optional<Integer> currentValue;
        int counter = 0; // Used to not iterate the list indefinitely if no match is found

        do {
            currentValue = this.next();
            if (currentValue.isEmpty()) {
                return Optional.empty();
            }
        } while (!strategy.apply(currentValue.get()) && ++counter != list.size());

        if (counter == list.size()) {
            return Optional.empty();
        }
        return currentValue;
    }
}
