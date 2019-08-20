package controler;

import enity.Calculate;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.layout.GridPane;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.io.*;

/**
 * @Author:wzh
 * @Description:
 * @Date:Createed in 2019/8/13 8:48
 **/
public class Control {
    @FXML
    private GridPane pane;
    @FXML
    private javafx.scene.control.Button addtext1;
    @FXML
    private javafx.scene.control.Button addtext2;
    @FXML
    private javafx.scene.control.Button result;
    @FXML
    private javafx.scene.control.TextArea text1;
    @FXML
    private javafx.scene.control.TextArea text2;
    @FXML
    private javafx.scene.control.TextArea text3;;

    public void addFile1(){
        JFileChooser fileChooser = new JFileChooser();
        FileSystemView fsv =FileSystemView.getFileSystemView();
        fileChooser.setCurrentDirectory(fsv.getHomeDirectory());
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setDialogTitle("文本一");
        fileChooser.showDialog(new JLabel(),"添加");
        File file =fileChooser.getSelectedFile();
        StringBuffer buffer = new StringBuffer();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            while(line!=null){
                buffer.append(line);
                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        text1.setText(buffer.toString());
    }

    public void addFile2(){
        JFileChooser fileChooser = new JFileChooser();
        FileSystemView fsv =FileSystemView.getFileSystemView();
        fileChooser.setCurrentDirectory(fsv.getHomeDirectory());
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setDialogTitle("文本二");
        fileChooser.showDialog(new JLabel(),"添加");
        File file =fileChooser.getSelectedFile();
        StringBuffer buffer = new StringBuffer();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            while(line!=null){
                buffer.append(line);
                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        text2.setText(buffer.toString());
    }

    public void calculate(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("文本相似度比较");
        alert.setContentText("文本相似度为:"+Calculate.paraseToDigit(Calculate.Similarity(text1.getText(),text2.getText())));
        alert.show();
        text3.setText(Calculate.longestCommonSubstring(Calculate.removeSign(text1.getText()),Calculate.removeSign(text2.getText())));
    }


}
