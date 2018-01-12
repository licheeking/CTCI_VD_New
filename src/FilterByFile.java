import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class FilterByFile {
    public static void main(String[] args){
        File dir = new File("D:\\12.1 OFFSHORE\\F0040(FD1A.01)-GPK\\Document Transmittal\\F0040-GPK-0004-T");
        new FilterByFile().ListFileFileter(dir);
    }
    /**
     * 　现在要求输入一个文件的目录，之后将里面所有的备份文件删除，备份文件都是以“.bak”或".BAK"结尾，过滤文件类型为.bak文件
     */
    public void ListFileFileter(File dir){
        if(dir.exists()){
            //匿名内部类，把FileFilter接口对象作为参数
            File[] files = dir.listFiles(new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    if(pathname.isDirectory()){
                        return true;
                    }
                    String name = pathname.getName();//获取文件的名称E:\复件 demodir\Learn\sgim_piccell.v1.bin.bak
//                    System.out.println("****************"+pathname);
                    return name.endsWith(".pdf")|| name.endsWith(".PDF");//过滤文件类型为.bak或者.BAK文件，而不包含.BAK或者.bak的文件
                }
            });
            //深度遍历文件，递归
            for(int i=0;i<files.length;i++){
                if(files[i].isFile()){//如果遍历到的是文件，直接删除
//                    files[i].delete();
                    System.out.println(files[i].getName());
                }else{//还是目录，继续遍历，直到是文件，再删除
                    ListFileFileter(files[i]);
                }
            }
        }else{
            throw new RuntimeException("操作的文件或者目录不存在！");
        }
    }
}
