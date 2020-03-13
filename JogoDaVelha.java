package jogodavelha;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class JogoDaVelha extends Application {

    private static Stage stage;
    private static Scene menuScene;
    private static Scene newGameScene;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        primaryStage.setTitle("Jogo da velha");

        Parent fxmlMain = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        menuScene = new Scene(fxmlMain, 640, 400);
        Parent fxmlDetail = FXMLLoader.load(getClass().getResource("FXMLnewGame.fxml"));
        newGameScene = new Scene(fxmlDetail, 640, 400);

        primaryStage.setScene(menuScene);
        primaryStage.show();

    }


    public static void chengeScreen(String scr, String[][] informacao, String nome1, String nome2) throws FileNotFoundException, IOException, ClassNotFoundException {

        switch (scr) {

            case "newGame":
                stage.setTitle("Novo jogo");
                stage.setScene(newGameScene);

                notifyAllListeners("newGame", null, nome1, nome2);
                break;

            case "continuar":
                stage.setTitle("Jogo de " + nome1);

                File arquivo = new File("C:\\Users\\tiago\\Documents\\ola\\" + nome1 + ".ser");
                
                String[][] matriz = null;
                if (arquivo.exists()) {
                    ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo));
                    matriz = (String[][]) ois.readObject();
                    ois.close();

                }
                notifyAllListeners("continuar", matriz, matriz[3][1], matriz[3][2]);
                stage.setScene(newGameScene);
                break;

            case "voltar":
                stage.setTitle("Jogo da velha");
                stage.setScene(menuScene);
                notifyAllListeners("voltar", null, nome1, nome2);

                break;
            case "sair":
                stage.close();
                
                break;

        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    private static ArrayList<OnChangeScreen> listeners = new ArrayList<>();

    public static interface OnChangeScreen {

        void onScreenChanged(String newScreen, String[][] informacao, String nome1, String nome2);
    }

    public static void addOnChangeScreenListener(OnChangeScreen newListener) {
        listeners.add(newListener);
    }

    private static void notifyAllListeners(String newScreen, String[][] informacao, String nome1, String nome2) {
        for (OnChangeScreen l : listeners) {
            l.onScreenChanged(newScreen, informacao, nome1, nome2);
        }
    }

}
