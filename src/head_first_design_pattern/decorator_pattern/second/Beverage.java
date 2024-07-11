package head_first_design_pattern.decorator_pattern.second;

public class Beverage {

    private String description;
    private boolean milk;
    private boolean soy;
    private boolean mocha;
    private boolean whip;

    public String getDescription() {
        return this.description;
    }

    public int cost() {
        int result = 0;
        if (isMilk()) {
            result += 500;
        }
        if (isMocha()) {
            result += 700;
        }
        if (isSoy()) {
            result += 1_000;
        }
        if (isWhip()) {
            result += 1_500;
        }
        return result;
    }

    public boolean isMilk() {
        return milk;
    }

    public boolean isSoy() {
        return soy;
    }

    public boolean isMocha() {
        return mocha;
    }

    public boolean isWhip() {
        return whip;
    }

    public void setMilk() {
        this.milk = true;
    }

    public void setSoy() {
        this.soy = true;
    }

    public void setMocha() {
        this.mocha = true;
    }

    public void setWhip() {
        this.whip = true;
    }
}
