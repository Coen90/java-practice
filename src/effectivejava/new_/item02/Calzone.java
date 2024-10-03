package effectivejava.new_.item02;

public class Calzone extends Pizza{
    private final boolean sauceInside;

    public static class Builder extends Pizza.Builder<Builder> {
        private final boolean sauceInside;

        public Builder(boolean sauceInside) {
            this.sauceInside = sauceInside;
        }

        @Override
        Calzone build() {
            return new Calzone(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    Calzone(Builder builder) {
        super(builder);
        sauceInside = builder.sauceInside;
    }

    public boolean isSauceInside() {
        return sauceInside;
    }
}
