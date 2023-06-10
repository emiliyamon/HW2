public class Negation extends Function {
    private Function[] functions;
    private Function function;

    public Negation(Function function) {
        this.functions = new Function[2];
        this.functions[0] = function;
        this.functions[1] = new Constant(-1);
        this.function = new Product(this.functions[0], this.functions[1]);
    }


    public Function getFunction() {
        return function;
    }

    public void setFunction(Function function) {
        this.function = function;
    }


    @Override
    public double valueAt(double x) {
        double value = 1.0;
        for (Function function : functions) {
            value *= function.valueAt(x);
        }
        return value;
    }


    @Override
    public String toString() {
        return "-(" + functions[0].toString() + ")";
    }


    @Override
    public Function derivative() {
        return function.derivative();
    }
}
