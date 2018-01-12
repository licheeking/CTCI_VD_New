import filter.FilterTool;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

public class CTCI_GUI {
    private JButton filePath;
    private JButton fileName;
    private JPanel panel1;
    private JTextArea textArea1;
    private JTextField textField1;
    private JButton nameButton;
    private JButton readButton;
    private JButton addSufixButton;
    private JButton addPathButton;
    private int count = 35;


    public void ListFileFileter1(File dir){
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
//                    System.out.println(files[i].getName());
                    textArea1.append(files[i].getPath() + "\n");
                }else{//还是目录，继续遍历，直到是文件，再删除
                    ListFileFileter1(files[i]);
                }
            }
        }else{
            throw new RuntimeException("操作的文件或者目录不存在！");
        }
    }

    public void ListFileFileter2(File dir){
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
//                    System.out.println(files[i].getName());
                    textArea1.append(files[i].getName() + "\n");
                }else{//还是目录，继续遍历，直到是文件，再删除
                    ListFileFileter2(files[i]);
                }
            }
        }else{
            throw new RuntimeException("操作的文件或者目录不存在！");
        }
    }

    public void ListFileFileter3(File dir){
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
//                    System.out.println(files[i].getName());
                    String prefix = files[i].getName().substring(files[i].getName().lastIndexOf("."));
                    String realName = files[i].getName().replaceAll("[.][^.]+$", "");

                    textArea1.append(realName + "\n");
                }else{//还是目录，继续遍历，直到是文件，再删除
                    ListFileFileter3(files[i]);
                }
            }
        }else{
            throw new RuntimeException("操作的文件或者目录不存在！");
        }
    }


    public CTCI_GUI() {
        filePath.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File dir = new File(textField1.getText());
                FilterByFile filterByFile = new FilterByFile();
                textArea1.setText("");
                ListFileFileter1(dir);
            }
        });


        fileName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File dir = new File(textField1.getText());
                FilterByFile filterByFile = new FilterByFile();
                textArea1.setText("");
                ListFileFileter2(dir);
            }
        });

        nameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File dir = new File(textField1.getText());
                FilterByFile filterByFile = new FilterByFile();
                textArea1.setText("");
                ListFileFileter3(dir);
            }
        });
        readButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] split = textArea1.getText().split("\n");
                textArea1.setText("");
                String prefix = "F0040-";
                for (int i = 0; i < split.length; i++) {
                    textArea1.append(prefix + split[i] + "\n");
                }
            }
        });
        addSufixButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] split = textArea1.getText().split("\n");
                textArea1.setText("");
//                String sufix = textField1.getText();
                String sufix = ".pdf";
                for (int i = 0; i < split.length; i++) {
                    textArea1.append(split[i] + sufix + "\n");
                }
            }
        });
        addPathButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] split = textArea1.getText().split("\n");
                textArea1.setText("");
//                String prefix = textField1.getText() + "\\";
                count++;
                for (int i = 0; i < split.length; i++) {
                    String prefix = "D:\\12.1 OFFSHORE\\F0040(FD1A.01)-GPK\\Document Transmittal\\F0040-GPK-00" + count + "-T\\";
                    textArea1.append(prefix + split[i] + "\n");
                }


            }
        });
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("CTCI");

        frame.setContentPane(new CTCI_GUI().panel1);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocation(600, 200);
//        frame.pack();
        frame.setVisible(true);




    }



}
