public class SkyView {

    private double[][] view;

    public SkyView(int numRows, int numCols, double[] scanned){
        double[][] view = new double[numRows][numCols];
        for(int i = 0; i < numRows; i += 2){
            for(int j = 0; j < numCols; j++){
                view[i][j] = scanned[j + (numCols * i)];
            }
        }
        for(int i = 1; i < numRows; i+=2){
            int k = i * numCols;
            for(int j = numCols-1; j >= 0; j--){
                view[i][j] = scanned[k];
                k++;
            }
        }
        this.view = view;
    }

    public double getAverage(int startRow, int endRow, int startCol, int endCol){
        double sum = 0;
        int divisor = 0;
        for(int i = startRow; i <= endRow; i++){
            for(int j = startCol; j <= endCol; j++){
                sum += view[i][j];
                divisor++;
            }
        }
        return sum / divisor;
    }

    public String toString(){
        String output = "";
        for(int i = 0; i < view.length; i++){
            for(int j = 0; j < view[i].length; j++){
                output += view[i][j] + " ";
            }
            output += "\n";
        }
        return output;
    }

}
