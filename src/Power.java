public class Power extends Function {
    private Function function;
    private int exponent;

    public Power(Function function, int exponent) {
        this.function = function;
        this.exponent = exponent;
    }

    public Function getFunction() {
        return function;
    }

    public void setFunction(Function function) {
        this.function = function;
    }

    public int getExponent() {
        return exponent;
    }

    public void setExponent(int exponent) {
        this.exponent = exponent;
    }

    @Override
    public double valueAt(double x) {

        return Math.pow(function.valueAt(x), exponent);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        String functionString = function.toString();
        sb.append("(");
        sb.append(functionString);
        sb.append(")^");
        sb.append(exponent);

        return sb.toString();
    }


    @Override
    public Function derivative() {
        if (exponent == 1) {
            return function.derivative();
        } else {
            Function[] derivativeFunction = new Function[3];
            derivativeFunction[0] = new Constant(exponent);
            derivativeFunction[1] = new Power(function, exponent-1);
            derivativeFunction[2] = function.derivative();
            return new MultiProduct(derivativeFunction[0], derivativeFunction[1], derivativeFunction[2]);
        }
    }
}
