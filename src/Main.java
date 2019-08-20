import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 * @Author:wzh
 * @Description:
 * @Date:Createed in 2019/8/13 9:06
 **/
public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        try{
            Parent root = FXMLLoader.load(getClass().getResource("/view/Frame.fxml"));
            Scene scene = new Scene(root,600,500);
            scene.getStylesheets().add("/view/view_css.css");
            stage.setScene(scene);
            stage.setTitle("文本相似度比较");
            stage.show();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String...args){
        Application.launch(args);
    }
}
