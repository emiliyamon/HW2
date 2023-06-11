/**
 * Represents a constant function
 */
public class Constant extends Function {
    final double constant;

    public Constant(double x) {
        this.constant = x;
    }


    /**
     * Calculates the value of the function at the given x-coordinate
     *
     * @param x the x-coordinate at which to evaluate the function
     * @return the value of the function at the specified x-coordinate
     */
    @Override
    public double valueAt(double x) {
        return constant;
    }


    /**
     * Returns a string representation of the function in a specific format
     *
     * @return a string representation of the function
     */
    @Override
    public String toString() {
        if (constant == (int) constant) {
            return "(" + (int) constant + ")";
        } else {
            return "(" + constant + ")";
        }
    }


    /**
     * calculates the derivative of the function
     * @return the derivative of the function
     */
    @Override
    public Function derivative() {
        return new Constant(0);
    }
}
