public class MultiSum extends Function {
    private Function[] functions;

    public MultiSum(Function... functions) {
        this.functions = functions;
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
            sb.append("+");
        }
        sb.deleteCharAt(-1); // check later if ok to use
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
