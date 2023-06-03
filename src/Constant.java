public class Constant extends Function {
    final double constant;

    public Constant(double x) {
        this.constant = x;
    }

    public double valueAt(double x) {
        return constant;
    }


    @Override
    public String toString() {
        return String.valueOf(constant);
    }


    public Function derivative() {
        return new Function("0");
    }

}
