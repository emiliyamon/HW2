/**
 * Represents a multi-product function
 */
public class MultiProduct extends Function {
    public Function[] functions;

    public MultiProduct(Function... functions) {
        if (functions.length < 2) {
            throw new IllegalArgumentException("MultiProduct requires at least two functions");
        }
        this.functions = functions;
    }


    /**
     * Calculates the value of the function at the given x-coordinate
     *
     * @param x the x-coordinate at which to evaluate the function
     * @return the value of the function at the specified x-coordinate
     */
    @Override
    public double valueAt(double x) {
        double value = 1.0;
        for (Function function : functions) {
            value *= function.valueAt(x);
        }
        return value;
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
                sb.append(" * ");
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
        if (functions.length == 1) {
            return functions[0].derivative();
        }

        Function[] functionsDerivative = new Function[functions.length];
        Function[] derivativeMultiProductI = new Function[functions.length];


        for (int i = 0; i < functions.length; i++) {
            functionsDerivative[i] = functions[i].derivative();

            Function[] makeMultiProductI = new Function[functions.length - 1];
            int k = 0;
            for (int j = 0; j < functions.length; j++) {
                if (j != i) {
                    makeMultiProductI[k] = functions[j];
                    k++;
                }
            }

            Function multiProductI;

            if (makeMultiProductI.length > 2) {
                multiProductI = new MultiProduct(makeMultiProductI);
            } else if (makeMultiProductI.length == 2) {
                multiProductI = new Product(makeMultiProductI[0], makeMultiProductI[1]);
            } else {
                multiProductI = makeMultiProductI[0];
            }

            derivativeMultiProductI[i] = new Product(functionsDerivative[i], multiProductI);
        }

        if (derivativeMultiProductI.length > 2) {
            return new MultiSum(derivativeMultiProductI);
        } else if (derivativeMultiProductI.length == 2) {
            return new Sum(derivativeMultiProductI[0], derivativeMultiProductI[1]);
        } else {
            return derivativeMultiProductI[0];
        }
    }
}