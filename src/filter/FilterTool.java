package filter;

import java.io.File;
import java.io.FileFilter;

public class FilterTool implements FileFilter {
    @Override
    public boolean accept(File pathname) {
        if (pathname.isDirectory()) {
            return true;
        }
        String name = pathname.getName();
        System.out.println(name);
        return name.endsWith("*.pdf") || name.endsWith("*.PDF");
    }
}
