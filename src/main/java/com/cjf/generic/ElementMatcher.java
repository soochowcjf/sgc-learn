package com.cjf.generic;

/**
 * created by cjf 2020/12/1 15:20
 */
public interface ElementMatcher<T> {

    boolean matches(T target);

    interface Junction<S> extends ElementMatcher<S> {

        <U extends S> Junction<U> and(ElementMatcher<? super U> other);

//        <U> Junction<U> or(ElementMatcher<U> other);
    }

    public static void main(String[] args) {
//        StringMatcher stringMatcher = new StringMatcher("123", StringMatcher.Mode.ENDS_WITH);
//        StringMatcher stringMatcher2 = new StringMatcher("123", StringMatcher.Mode.ENDS_WITH);
//        stringMatcher.and(RecordMatcher);
    }


    abstract class AbstractBase<V> implements Junction<V> {

        /**
         * {@inheritDoc}
         */
        @Override
        public <U extends V> Junction<U> and(ElementMatcher<? super U> other) {
            return new Conjunction<U>(this, other);
        }
    }

    /**
     * A conjunction matcher which only matches an element if both represented matchers constitute a match.
     *
     * @param <W> The type of the object that is being matched.
     */
    class Conjunction<W> extends AbstractBase<W> {

        /**
         * The element matchers that constitute this conjunction.
         */
        private final ElementMatcher<? super W> left, right;

        /**
         * Creates a new conjunction matcher.
         *
         * @param left  The first matcher to consult for a match.
         * @param right The second matcher to consult for a match. This matcher is only consulted
         *              if the {@code first} matcher constituted a match.
         */
        public Conjunction(ElementMatcher<? super W> left, ElementMatcher<? super W> right) {
            this.left = left;
            this.right = right;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean matches(W target) {
            return left.matches(target) && right.matches(target);
        }

        @Override
        public String toString() {
            return "(" + left + " and " + right + ')';
        }
    }
}
