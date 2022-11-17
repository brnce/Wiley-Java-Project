class GenericInput<T> {
    private T value;

    GenericInput() {
    }

    public T getValue() {
        return this.value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}