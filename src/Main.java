import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            //reading
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Notebook\\IdeaProjects\\MulMatrix\\in1.txt"));
            SMatrix matrixAS = new SMatrix(br);

            br = new BufferedReader(new FileReader("C:\\Users\\Notebook\\IdeaProjects\\MulMatrix\\in2.txt"));
            SMatrix matrixBS = new SMatrix(br);

            br = new BufferedReader(new FileReader("C:\\Users\\Notebook\\IdeaProjects\\MulMatrix\\in3.txt"));
            DMatrix matrixAD = new DMatrix(br);

            br = new BufferedReader(new FileReader("C:\\Users\\Notebook\\IdeaProjects\\MulMatrix\\in4.txt"));
            DMatrix matrixBD = new DMatrix(br);

            //writing
            SMatrix sxs = (SMatrix) matrixAS.mul(matrixBS);
            BufferedWriter bw = new BufferedWriter(new FileWriter(("C:\\Users\\Notebook\\IdeaProjects\\MulMatrix\\SxS.txt")));
            sxs.mapOut(bw);
            bw.close();

            SMatrix dxs = (SMatrix) matrixAD.mul(matrixBS);
            bw = new BufferedWriter(new FileWriter(("C:\\Users\\Notebook\\IdeaProjects\\MulMatrix\\DxS.txt")));
            dxs.mapOut(bw);
            bw.close();

            SMatrix sxd = (SMatrix) matrixAS.mul(matrixBD);
            bw = new BufferedWriter(new FileWriter(("C:\\Users\\Notebook\\IdeaProjects\\MulMatrix\\SxD.txt")));
            sxd.mapOut(bw);
            bw.close();

            DMatrix dxd = (DMatrix) matrixAD.mul(matrixBD);
            BufferedWriter bw2 = new BufferedWriter(new FileWriter(("C:\\Users\\Notebook\\IdeaProjects\\MulMatrix\\DxD.txt")));
            dxd.matOut(bw2);
            bw2.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
