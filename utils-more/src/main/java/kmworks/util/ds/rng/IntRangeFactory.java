package kmworks.util.ds.rng;

import kmworks.util.ds.rng.impl.IntRangeFactoryImpl;

import javax.annotation.Nonnull;
import java.util.*;

import static com.google.common.base.Preconditions.checkNotNull;
import static kmworks.util.base.Preconditions.checkNotEmpty;

public class IntRangeFactory {

    private static final IntRangeFactoryImpl factory = new IntRangeFactoryImpl();

    public static IntRange createCompactIntRange(int first, int last) {
        return factory.createCompactIntRange(first, last);
    }

    public static IntRange createBitsetIntRange(@Nonnull final Set<Integer> set) {
        return createBitsetIntRange(new TreeSet(set));
    }

    public static IntRange createBitsetIntRange(@Nonnull final SortedSet<Integer> sortedSet) {
        return factory.createBitsetIntRange(sortedSet);
    }

   public static IntRange createSegmentedIntRange(@Nonnull final IntRange... pieces) {
        return createSegmentedIntRange(checkNotEmpty(Arrays.asList(checkNotNull(pieces))));
    }

    public static IntRange createSegmentedIntRange(@Nonnull final List<IntRange> pieces) {
        return factory.createSegmentedIntRange(pieces);
    }

    public static IntRange createSegmentedIntRange(@Nonnull final Set<Integer> set) {
        return createSegmentedIntRange(new TreeSet(set));
    }

    public static IntRange createSegmentedIntRange(@Nonnull final SortedSet<Integer> sortedSet) {
        return factory.createSegmentedIntRange(sortedSet);
    }

}
