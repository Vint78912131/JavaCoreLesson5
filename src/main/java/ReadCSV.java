import java.io.*;
import java.util.ArrayList;

public class ReadCSV {
    private String fileName = "";
    private String cvsSplitBy = ";";

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public ReadCSV(String csvFile) {
        File file = new File(csvFile);
        if (file.exists()) {
            this.setFileName(csvFile);
        } else
            System.out.println("File " + csvFile + " not found.\n");
    }

    public void printFile() {
        String line = "";
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(this.getFileName()));
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("File " +this.getFileName() + " printed.\n");
    }

    public String[] getHeader() {
        String line = "";
        String[] newStr = null;
        RandomAccessFile ra = null;
        try {
            ra = new RandomAccessFile(this.getFileName(), "r");
            if ((line = ra.readLine()) != null) {
                newStr = line.split(cvsSplitBy);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ra != null) {
                try {
                    ra.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Header was returned.\n");
        return newStr;
    }

        public int[][] getData() {
            String line = "";
            ArrayList <String[]> lines = new ArrayList<>();
            RandomAccessFile ra = null;
            try {
                ra = new RandomAccessFile(this.getFileName(), "r");
                if (ra.readLine() == null)
                    System.out.println("Empty file.\n");
                else
                while ((line = ra.readLine()) != null) {
                    lines.add(line.split(cvsSplitBy));
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (ra != null) {
                    try {
                        ra.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                int[][] result = new int[lines.size()][lines.get(0).length];
                for (String[] arr : lines) {
                    for (int i = 0; i < arr.length; i++)
                        result[lines.indexOf(arr)][i] = Integer.valueOf(arr[i]);
                }
                System.out.println("Data was returned.\n");
                return result;
            }
        }
    }
