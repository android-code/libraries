public class SimpleDependency {

    private String color;
    private String shape;

    private SimpleDependency(Builder builder) {
        this.color = builder.color;
        this.shape = builder.shape;
    }

    public String getInfo() {
        return "SimpleDependency is " + color + " " + shape;
    }

    public static class Builder {

        private String color;
        private String shape;

        public Builder setColor(String color) {
            this.color = color;
            return this;
        }

        public Builder setShape(String shape) {
            this.shape = shape;
            return this;
        }

        public SimpleDependency build() {
            return new SimpleDependency(this);
        }
    }
}