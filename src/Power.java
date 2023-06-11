/**
 * Represents a power function
 */
public class Power extends Function {
    public Function function;
    public int exponent;

    public Power(Function function, int exponent) {
        this.function = function;
        this.exponent = exponent;
    }


    /**
     * Calculates the value of the function at the given x-coordinate
     *
     * @param x the x-coordinate at which to evaluate the function
     * @return the value of the function at the specified x-coordinate
     */
    @Override
    public double valueAt(double x) {
        return Math.pow(function.valueAt(x), exponent);
    }


    /**
     * Returns a string representation of the function in a specific format
     *
     * @return a string representation of the function
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("(");

        String functionString = function.toString();
        sb.append(functionString);
        sb.append("^");
        sb.append(exponent);
        sb.append(")");

        return sb.toString();
    }


    /**
     * calculates the derivative of the function
     *
     * @return the derivative of the function
     */
    @Override
    public Function derivative() {
        if (exponent == 1) {
            return function.derivative();
        } else {
            Function[] derivativeFunction = new Function[3];
            derivativeFunction[0] = new Constant(exponent);
            derivativeFunction[1] = new Power(function, exponent-1);
            derivativeFunction[2] = function.derivative();
            return new MultiProduct(derivativeFunction);
        }
    }
}
