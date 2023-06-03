public class Constant extends Function {
    final double constant;

    public Constant(double x) {
        this.constant = x;
    }


    @Override
    public double valueAt(double x) {
        return constant;
    }


    @Override
    public String toString() {
        return String.valueOf(constant);
    }


    @Override
    public String derivative() {
        return "0" ;
    }

}
