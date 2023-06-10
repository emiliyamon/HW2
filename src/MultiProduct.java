public class MultiProduct extends Function {
    public Function[] functions;

    public MultiProduct(Function function1, Function function2, Function... moreFunctions) {
        this.functions = new Function[2 + moreFunctions.length];
        functions[0] = function1;
        functions[1] = function2;
        for (int i = 2; i < moreFunctions.length; i++) {
            functions[i] = moreFunctions[i];
        }
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
        StringBuilder sb = new StringBuilder();

        for (Function function : this.functions) {
            sb.append("(");
            sb.append(function.toString());
            sb.append(") * ");
        }
        for (int i = 0; i < 3; i++) { // eliminate the trailing symbol
            sb.deleteCharAt(sb.length() - 1); // check later if ok to use
        }

        return sb.toString();
    }


    @Override
    public Function derivative() {
        Function[] functionsDerivative = new Function[functions.length];
        int i = 0;

        for (Function function : functions) {
            functionsDerivative[i] = function.derivative();
            i++;
        }

        Function[] derivativeMultiProductI = new Function[functions.length];

        for (i = 0; i < functions.length; i++) {
            Function[] makeMultiProductI = new Function[functions.length - 1];
            for (int j = 0; j < makeMultiProductI.length; j++) {
                if (j != i) {
                    makeMultiProductI[j] = functions[j];
                }
            }

            Function[] makeMultiProductIConstructor = new Function[makeMultiProductI.length - 2];
            makeMultiProductIConstructor[0] = makeMultiProductI[0];
            makeMultiProductIConstructor[1] = makeMultiProductI[1];

            for (int k = 2; i < functions.length; i++) {
                makeMultiProductIConstructor[k] = makeMultiProductI[k];
            }


                Function multiProductI = new MultiProduct(makeMultiProductIConstructor[0], makeMultiProductIConstructor[1], makeMultiProductIConstructor);
            derivativeMultiProductI[i] = new Product(functionsDerivative[i], multiProductI);
        }

        Function[] derivativeMultiProductIConstructor = new Function[derivativeMultiProductI.length - 2];

        for (int k = 0; k < derivativeMultiProductIConstructor.length; k++) {
            derivativeMultiProductIConstructor[k] = derivativeMultiProductI[k+2];
        }
        return new MultiSum(derivativeMultiProductI[0], derivativeMultiProductI[1], derivativeMultiProductIConstructor);
    }
}
