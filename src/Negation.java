public class Negation extends Function {

    public Function function;

    public Negation(Function function) {
        this.function = function;
    }


    @Override
    public double valueAt(double x) {
        double value = -1.0;
        return value * function.valueAt(x);
    }


    @Override
    public String toString() {
        return "(-" + function.toString() + ")";
    }


    @Override
    public Function derivative() {
        return new Negation(function.derivative());
    }

}
