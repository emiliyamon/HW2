/**
 * Represents a Difference function
 */
public class Difference extends Function {
    Function[] functions;

    public Difference(Function function1, Function function2) {
        this.functions = new Function[2];
        this.functions[0] = function1;
        this.functions[1] = function2;
    }


    /**
     * Calculates the value of the function at the given x-coordinate
     *
     * @param x the x-coordinate at which to evaluate the function
     * @return the value of the function at the specified x-coordinate
     */
    @Override
    public double valueAt(double x) {
        double sum = functions[0].valueAt(x);
        sum -= functions[1].valueAt(x);

        return sum;
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

        for (int i = 0; i < functions.length; i++) {
            sb.append(functions[i].toString());
            if (i != functions.length - 1) {
                sb.append(" - ");
            }
        }
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
        Function[] functionsDerivative = new Function[functions.length];
        int i = 0;

        for (Function function : functions) {
            functionsDerivative[i] = function.derivative();
            i++;
        }
        return new Difference(functionsDerivative[0], functionsDerivative[1]);
    }

}
