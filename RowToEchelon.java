public class RowToEchelon {
    public static double[][] convertToEchelon(double[][] aug){
        int rows = aug.length;
        int cols = aug[0].length;
        int pivot = 0;
        for (int i = 0; i < cols-1; i++) {
            boolean pivotExists = false;
            for (int j = 0; j <rows ; j++) {
                if(aug[j][i]!=0){
                    pivotExists = true;
                    if(i !=pivot){
                        double[] temp = aug[j];
                        aug[j] = aug[pivot];
                        aug[pivot] = temp;
                    }
                    pivotExists = true;
                    break;
                }
            }
            if(pivotExists){
                double pivotValue = aug[pivot][i];
                for (int j = pivot+1; j <rows ; j++) {
                    double multiplier = aug[j][i]/pivotValue;
                    for (int k = i; k <cols ; k++) {
                        aug[j][k] -= multiplier*aug[pivot][k];
                    }
                }
                pivot++;
            }
        }
        return aug;
    }
    public static void printMatrix(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%.2f\t", matrix[i][j]);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        double[][] augmented_matrix = {
                {2, 0, 4, 5},
                {4, 4, 4, 7},
                {6, 8, 22, 4}
        };
        double[][] echelonForm = convertToEchelon(augmented_matrix);
        printMatrix(echelonForm);
    }
}
