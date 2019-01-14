package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private TextArea chat;

    @FXML
    private TextField message;

    @FXML
    private Button send;

    @FXML
    protected void click(ActionEvent event) {
        chat.appendText("Yor message: " + message.getText() + "\n");
        message.setText("");
    }
    @FXML
    protected void onEnter(ActionEvent ev) {
        chat.appendText("Yor message: " + message.getText() + "\n");
        message.setText("");
    }
}
