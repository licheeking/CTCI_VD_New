import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortFiles {

    String fileName = "D:\\12.1 OFFSHORE\\F0040(FD1A.01)-GPK\\Document Transmittal";

    public static void main(String[] args) {
        SortFiles sortFiles = new SortFiles();
        sortFiles.sort();
    }

    public void sort() {
        List<File> files = Arrays.asList(new File(fileName).listFiles());
        Collections.sort(files, new Comparator<File>(){
            @Override
            public int compare(File o1, File o2) {
                if(o1.isDirectory() && o2.isFile())
                    return -1;
                if(o1.isFile() && o2.isDirectory())
                    return 1;
                return o1.getName().compareTo(o2.getName());
            }
        });

        for(File f : files)
            System.out.println(f.getPath());
    }
}
