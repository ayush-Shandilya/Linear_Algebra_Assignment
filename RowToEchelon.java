public class RowToEchelon {
    public static double[][] convertToEchelon(double[][] augmented_matrix){
        int rows = augmented_matrix.length;
        int cols = augmented_matrix[0].length;
        int pivot = 0;
        for (int i = 0; i < cols-1; i++) {
            boolean pivotExists = false;
            for (int j = 0; j <rows ; j++) {
                if(augmented_matrix[j][i]!=0){
                    pivotExists = true;
                    if(i !=pivot){
                        double[] temp = augmented_matrix[j];
                        augmented_matrix[j] = augmented_matrix[pivot];
                        augmented_matrix[pivot] = temp;
                    }
                    pivotExists = true;
                    break;
                }
            }
            if(pivotExists){
                double pivotValue = augmented_matrix[pivot][i];
                for (int j = pivot+1; j <rows ; j++) {
                    double multiplier = augmented_matrix[j][i]/pivotValue;
                    for (int k = i; k <cols ; k++) {
                        augmented_matrix[j][k] -= multiplier*augmented_matrix[pivot][k];
                    }
                }
                pivot++;
            }
        }
        return augmented_matrix;
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
                {7, 0, 4, 5},
                {88, 4, 4, 72},
                {9, 8, 22, 7}
        };
        double[][] echelonForm = convertToEchelon(augmented_matrix);
        printMatrix(echelonForm);
    }
}
