package jogodavelha;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.Callback;

public class FXMLDocumentController {

    @FXML
    private TextField localName1;
    @FXML
    private TextField localName2;
    @FXML
    private Label infoNome;
    @FXML
    private Label jogosSalvos;
    @FXML
    private ComboBox<Nome> nome;

    private List<Nome> nomes = new ArrayList<>();
    private ObservableList<Nome> obsNome;
    private int qtd;

    @FXML
    protected void initialize() throws IOException, FileNotFoundException, ClassNotFoundException {

        JogoDaVelha.addOnChangeScreenListener(new JogoDaVelha.OnChangeScreen() {
            @Override
            public void onScreenChanged(String newScreen, String[][] informacao, String nome1, String nome2) {

                if (newScreen.compareTo("voltar") == 0) {

                    try {
                        carregarCategorias();
                    } catch (IOException ex) {
                        Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });

        carregarCategorias();
    }

    public void carregarCategorias() throws FileNotFoundException, IOException, ClassNotFoundException {
        boolean teste = false;
        File arquivo = new File("C:\\Users\\tiago\\Documents\\salvos");
        File[] arquivos = arquivo.listFiles();
        if (qtd == 0 && arquivos.length > 0) {
            for (int i = 0; i < arquivos.length; i++) {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivos[i]));
                String[][] aux = (String[][]) ois.readObject();
                Nome cat = new Nome(aux[3][1]);
                nomes.add(cat);
                obsNome = FXCollections.observableArrayList(nomes);
                nome.setItems(obsNome);
                ois.close();

            }
            qtd = arquivos.length;
        } else if (arquivos.length > 0) {
            for (int i = 0; i < arquivos.length; i++) {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivos[i]));
                String[][] aux = (String[][]) ois.readObject();
                Nome cat = new Nome(aux[3][1]);
                if (qtd > 0) {
                    for (int f = 0; f < qtd; f++) {
                        if (nomes.get(f).getId().compareTo(aux[3][1]) == 0) {
                            teste = true;

                        }

                    }
                    if (teste == false) {
                        nomes.add(cat);
                        obsNome = FXCollections.observableArrayList(nomes);
                        nome.setItems(obsNome);
                        ois.close();
                        qtd++;
                    }
                    teste = false;

                }

            }

        }

    }

    @FXML
    private void getClick(ActionEvent event) throws IOException, ClassNotFoundException {
        Button button = (Button) event.getSource();

        if (button.getId().compareTo("newGame") == 0) {
            if (localName1.getText().compareTo("") == 0 && localName2.getText().compareTo("") == 0) {
                infoNome.setVisible(true);

            } else {
                infoNome.setVisible(false);

                JogoDaVelha.chengeScreen(button.getId(), null, localName1.getText(), localName2.getText());
                localName1.setText("");
                localName2.setText("");
            }

        } else if (button.getId().compareTo("continuar") == 0) {
            if (obsNome == null) {
                jogosSalvos.setVisible(true);
            } else {
                JogoDaVelha.chengeScreen(button.getId(), null, nome.getValue().toString(), "");
            }

        }

    }

}
