import java.util.Arrays;

public class AppData {
    private String [] header;
    private int [][] data;

    public AppData(String[] header, int[][] data) {
        this.setHeader(header);
        this.setData(data);
    }

    public String[] getHeader() {
        return header;
    }

    public void setHeader(String[] header) {
        this.header = header;
    }

    public int[][] getData() {
        return data;
    }

    public void setData(int[][] data) {
        this.data = data;
    }

    public void printHeader() {
        for (String h : this.getHeader()) {
            System.out.print(h + " ");
        }
        System.out.println("\n");
    }

    public void printData() {
        for (int [] h : this.getData()) {
            System.out.print(Arrays.toString(h) + "\n");
        }
        System.out.println("\n");
    }
}
