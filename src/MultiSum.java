public class MultiSum extends Function {
    private Function[] functions;

    public MultiSum(Function... functions) {
        this.functions = functions;
        // add test to make compile-time error for less than 2 functions
    }

    public Function[] getFunctions() {
        return functions;
    }

    public void setFunctions(Function[] functions) {
        this.functions = functions;
    }


    @Override
    public double valueAt(double x) {
        double sum = 0.0;
        for (Function function : functions) {
            sum += function.valueAt(x);
        }
        return sum;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Function function : functions) {
            String functionString = function.toString();
            sb.append(functionString);
            sb.append(" + ");
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
        return new MultiSum(functionsDerivative);
    }
}
