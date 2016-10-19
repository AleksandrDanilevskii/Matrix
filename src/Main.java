import java.io.*;

public class Main {
    public static void main(String[] args) {

        try {
            BufferedReader s = new BufferedReader(new FileReader("C:\\Users\\Notebook\\IdeaProjects\\MulMatrix\\in1.txt"));
            SparseMatrix matrixASparse = new SparseMatrix(s);

            s = new BufferedReader(new FileReader("C:\\Users\\Notebook\\IdeaProjects\\MulMatrix\\in2.txt"));
            SparseMatrix matrixBSparse = new SparseMatrix(s);

            s = new BufferedReader(new FileReader("C:\\Users\\Notebook\\IdeaProjects\\MulMatrix\\in3.txt"));
            DenseMatrix matrixADense = new DenseMatrix(s);

            s = new BufferedReader(new FileReader("C:\\Users\\Notebook\\IdeaProjects\\MulMatrix\\in4.txt"));
            DenseMatrix matrixBDense = new DenseMatrix(s);

            SparseMatrix s_s = (SparseMatrix) matrixASparse.mul(matrixBSparse);
            BufferedWriter sp = new BufferedWriter(new FileWriter(("C:\\Users\\Notebook\\IdeaProjects\\MulMatrix\\SparseSparse.txt")));
            s_s.mapOut(sp);
            sp.close();


            DenseMatrix d_d = (DenseMatrix) matrixADense.mul(matrixBDense);
            BufferedWriter dn = new BufferedWriter(new FileWriter(("C:\\Users\\Notebook\\IdeaProjects\\MulMatrix\\DenseDense.txt")));
            d_d.matOut(dn);
            dn.close();

            SparseMatrix d_s = (SparseMatrix) matrixADense.mul(matrixBSparse);
            sp = new BufferedWriter(new FileWriter(("C:\\Users\\Notebook\\IdeaProjects\\MulMatrix\\DenseSparse.txt")));
            d_s.mapOut(sp);
            sp.close();

            SparseMatrix s_d = (SparseMatrix) matrixASparse.mul(matrixBDense);
            sp = new BufferedWriter(new FileWriter(("C:\\Users\\Notebook\\IdeaProjects\\MulMatrix\\SparseDense.txt")));
            s_d.mapOut(sp);
            sp.close();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
