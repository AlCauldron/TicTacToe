import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class TicTacToeApplication extends Application{
    private boolean end;
    private boolean choice;
    private Label turn;
    private  Button[] buttons;
    public TicTacToeApplication(){
        this.end = false;
        this.choice = true;
        this.turn= new Label("Turn: X");
        this.buttons = new Button[9];
        for (int i = 0; i < 9; i++) {
            this.buttons[i] = createButton();
        }
    }

    @Override
    public void start(Stage window){

        BorderPane pane = new BorderPane();
        GridPane layout = new GridPane();
        layout.add(buttons[0],0,0);
        layout.add(buttons[1],1,0);
        layout.add(buttons[2],2,0);

        layout.add(buttons[3],0,1);
        layout.add(buttons[4],1,1);
        layout.add(buttons[5],2,1);

        layout.add(buttons[6],0,2);
        layout.add(buttons[7],1,2);
        layout.add(buttons[8],2,2);

        pane.setTop(turn);
        pane.setCenter(layout);

        Scene scene = new Scene(pane);
        window.setScene(scene);
        window.show();
    }

    public Button createButton(){
        Button btn = new Button(" ");
        btn.setFont(Font.font("Monospaced", 40));
        btn.setOnAction((event) ->{
            if (end){return;}
            if (choice){
                btn.setText("X");
                turn.setText("Turn: O");
                choice = false;
            }else{
                btn.setText("O");
                turn.setText("Turn: X");
                choice = true;
            }
            if (gameWon()){
                turn.setText("Game over!");
                end = true;
            }
        });

        return btn;
    }

    public boolean gameWon(){
        //row
        if(!buttons[0].getText().equals(" ")){
            if (buttons[0].getText().equals(buttons[3].getText()) && buttons[0].getText().equals(buttons[6].getText())){
                return true;
            }
        }
        if(!buttons[1].getText().equals(" ")) {
            if (buttons[1].getText().equals(buttons[4].getText()) && buttons[1].getText().equals(buttons[7].getText())) {
                return true;
            }
        }
        if(!buttons[2].getText().equals(" ")) {
            if (buttons[2].getText().equals(buttons[5].getText()) && buttons[2].getText().equals(buttons[8].getText())) {
                return true;
            }
        }

        //column

        if(!buttons[0].getText().equals(" ")) {
            if (buttons[0].getText().equals(buttons[1].getText()) && buttons[0].getText().equals(buttons[2].getText())) {
                return true;
            }
        }
        if(!buttons[3].getText().equals(" ")) {
            if (buttons[3].getText().equals(buttons[4].getText()) && buttons[3].getText().equals(buttons[5].getText())) {
                return true;
            }
        }
        if(!buttons[6].getText().equals(" ")) {
            if (buttons[6].getText().equals(buttons[7].getText()) && buttons[7].getText().equals(buttons[8].getText())) {
                return true;
            }
        }

        //Diagonals
        if(!buttons[0].getText().equals(" ")) {
            if (buttons[0].getText().equals(buttons[4].getText()) && buttons[0].getText().equals(buttons[8].getText())) {
                return true;
            }
        }
        if(!buttons[6].getText().equals(" ")) {
            if (buttons[6].getText().equals(buttons[4].getText()) && buttons[6].getText().equals(buttons[2].getText())) {
                return true;
            }
        }

        return  false;
    }

    public static void main(String[] args) {
        launch(TicTacToeApplication.class);
    }

}
