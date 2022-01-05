import java.io.*;

public class WriteCSV {
    private String fileName = "";
    private File file;

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    private String cvsSplitBy = ";";

    public String getCvsSplitBy() {
        return cvsSplitBy;
    }

    public File getFile() {
        return file;
    }

    public String getFileName() {
        return fileName;
    }

    public WriteCSV() {
        file = new File("src/outputFile.csv");
        this.setFileName("src/outputFile.csv");
        System.out.println("File " +this.getFileName() + " was created.\n");
    }

    public void writeString(String line) {
        PrintWriter out = null;
        try {
            out = new PrintWriter(new FileOutputStream(this.getFile()));
            out.write(line);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            out.flush();
            out.close();
        }
    }

    public void save(AppData ad) {
        StringBuilder sb = new StringBuilder();
        for (String s : ad.getHeader()) {
            sb.append(s + this.getCvsSplitBy());
        }
        PrintWriter out = null;
        try {
            out = new PrintWriter(new FileOutputStream(this.getFile()));
            out.write(sb.substring(0,sb.length()-1) + "\n");
            int [][] arr = ad.getData();
            for (int j = 0; j <  arr.length; j++) {
                sb.setLength(0);
                for (int i = 0; i < arr[j].length; i++)
                    sb.append(arr[j][i] + this.getCvsSplitBy());
                out.write(sb.substring(0,sb.length()-1) + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            out.flush();
            out.close();
        }
    }

}
