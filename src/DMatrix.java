import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DMatrix implements Matrix {
    public int size;
    public int matrix[][];

    public DMatrix(int[][] matrix, int size) {
        this.size = size;
        this.matrix = matrix;
    }

    public DMatrix(int size) {
        this.matrix = new int[size][size];
        this.size = size;
    }

    public DMatrix(BufferedReader br) {
        try {
            String t = br.readLine();
            String[] array = t.split(" ");
            int k = array.length;
            this.size = k;
            this.matrix = new int[size][size];
            int number;

            for (int j = 0; j < k; j++) {
                number = Integer.parseInt(array[j]);
                this.matrix[0][j] = number;
            }

            for (int i = 1; i < k; i++) {
                t = br.readLine();
                array = t.split(" ");

                for (int j = 0; j < k; j++) {
                    number = Integer.parseInt(array[j]);
                    this.matrix[i][j] = number;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Matrix mul(Matrix other) {
        if (other instanceof DMatrix) return this.mulDD((DMatrix) other);
        else return this.mulDS((SMatrix) other);
    }

    public DMatrix mulDD(DMatrix other) {
        other = other.MatrixSTrans();
        DMatrix res = new DMatrix(size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    res.matrix[i][j] += this.matrix[i][k] * other.matrix[j][k];
                }
            }
        }
        return res;
    }

    public SMatrix mulDS(SMatrix other) {
        other = other.MatrixSTrans();
        SMatrix res = new SMatrix(size);
        for (int i = 0; i < size; i++) {
            row resRow = new row();
            Iterator<Map.Entry<Integer, row>> iter1 = other.map.entrySet().iterator();// итератор строк
            while (iter1.hasNext()) {
                Map.Entry entry1 = iter1.next();
                Integer key1 = (Integer) entry1.getKey();// ключ строки
                HashMap<Integer, Integer> value1 = (HashMap<Integer, Integer>) entry1.getValue();// сама строка
                Iterator iterElement = value1.entrySet().iterator();// итератор элементов
                int resValue = 0;
                while (iterElement.hasNext()) {
                    Map.Entry entryElement = (Map.Entry) iterElement.next();
                    Integer keyElement = (Integer) entryElement.getKey();// ключ элемента
                    Integer valueElement = (Integer) entryElement.getValue();//значение элемента
                    resValue = resValue + this.matrix[i][keyElement] * valueElement;
                }
                if (resValue != 0) {
                    resRow.put(key1, resValue);
                }
            }
            if (resRow != null) {
                res.map.put(i, resRow);
            }
        }
        return res;
    }

    public DMatrix MatrixSTrans() {
        int[][] mTr = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = i; j < size; j++) {
                int aT = this.matrix[i][j];
                mTr[i][j] = this.matrix[j][i];
                mTr[j][i] = aT;
            }
        }
        return new DMatrix(mTr, size);
    }

    public void matOut(BufferedWriter bw) {
        try {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    bw.write(matrix[i][j] + " ");
                }
                bw.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean equals(Object o) {
        boolean t = true;
        if (!(o instanceof DMatrix)) {
            return false;
        }
        DMatrix other = (DMatrix) o;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (this.matrix[i][j] != other.matrix[i][j]) {
                    t = false;
                }
            }
        }
        return t;
    }
}


