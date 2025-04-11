package io.seats.utils;

import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.function.Function;

public abstract class Either<L, R> {

    public abstract boolean isLeft();

    public abstract boolean isRight();

    public abstract R get();

    public abstract L getLeft();

    public R getOrNull() {
        return this.isRight() ? this.get() : null;
    }

    public static <L, R> Either<L, R> left(L value) {
        return new Left<>(value);
    }

    public static <L, R> Either<L, R> right(R value) {
        return new Right<>(value);
    }

    public <U> U fold(Function<? super L, ? extends U> leftFn, Function<? super R, ? extends U> rightFn) {
        if (this.isLeft()) {
            return leftFn.apply(this.getLeft());
        }
        return rightFn.apply(this.get());
    }

    public void forEach(Consumer<L> leftConsumer, Consumer<R> rightConsumer) {
        if (this.isLeft()) {
            leftConsumer.accept(this.getLeft());
        } else {
            rightConsumer.accept(this.get());
        }
    }

    public static class Left<L, R> extends Either<L, R> {

        private final L value;

        public Left(L value) {
            this.value = value;
        }

        @Override
        public boolean isLeft() {
            return true;
        }

        @Override
        public boolean isRight() {
            return false;
        }

        @Override
        public R get() {
            throw new NoSuchElementException("Can not get() on a Left");
        }

        @Override
        public L getLeft() {
            return value;
        }
    }

    public static class Right<L, R> extends Either<L, R> {

        private final R value;

        public Right(R value) {
            this.value = value;
        }

        @Override
        public boolean isLeft() {
            return false;
        }

        @Override
        public boolean isRight() {
            return true;
        }

        @Override
        public R get() {
            return value;
        }

        @Override
        public L getLeft() {
            throw new NoSuchElementException("Can not getLeft() on a Right");
        }
    }
}
