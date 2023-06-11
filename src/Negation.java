/**
 * Represents the negation function to a given function
 */
public class Negation extends Function {

    public Function function;

    public Negation(Function function) {
        this.function = function;
    }


    /**
     * Calculates the value of the function at the given x-coordinate
     *
     * @param x the x-coordinate at which to evaluate the function
     * @return the value of the function at the specified x-coordinate
     */
    @Override
    public double valueAt(double x) {
        double value = -1.0;
        return value * function.valueAt(x);
    }


    /**
     * Returns a string representation of the function in a specific format
     *
     * @return a string representation of the function
     */
    @Override
    public String toString() {
        return "(-" + function.toString() + ")";
    }


    /**
     * calculates the derivative of the function
     *
     * @return the derivative of the function
     */
    @Override
    public Function derivative() {
        return new Negation(function.derivative());
    }

}
