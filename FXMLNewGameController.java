package jogodavelha;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class FXMLNewGameController {

    @FXML
    private Button jogar_novamente;
    @FXML
    private Button b11;
    @FXML
    private Button b12;
    @FXML
    private Button b13;
    @FXML
    private Button b21;
    @FXML
    private Button b22;
    @FXML
    private Button b23;
    @FXML
    private Button b31;
    @FXML
    private Button b32;
    @FXML
    private Button b33;
    @FXML
    private Label info;
    @FXML
    private Label labelVez;
    @FXML
    private Label pontosx;
    @FXML
    private Label pontoso;

    private String x;
    private String o;
    private int qtd;
    private int vez;
    private boolean vz;
    private String valor;
    private String nome1;
    private String nome2;
    private int pontx;
    private int ponto;

    public FXMLNewGameController() {
        this.qtd = 1;
    }

    @FXML
    protected void initialize() {
        JogoDaVelha.addOnChangeScreenListener(new JogoDaVelha.OnChangeScreen() {
            @Override
            public void onScreenChanged(String newScreen, String[][] informacao, String name1, String name2) {
                x = name1 + " (x)";
                o = name2 + " (o)";

                nome1 = name1;
                nome2 = name2;
                if (newScreen.compareTo("continuar") == 0) {
                    if (informacao != null) {
                        pontosx.setText("x: "+informacao[3][3]);
                        pontoso.setText("y: "+informacao[3][4]);
                        pontx = informacao[3][3].charAt(0);
                        ponto = informacao[3][4].charAt(0);
                        System.out.println(informacao[3][3].charAt(0));//ajuda para reosolver
                        File arquivo = new File("C:\\Users\\tiago\\Documents\\ola\\" + name1 + ".ser");

                        if (arquivo.exists()) {
                            manipular(informacao);

                            if (b11.getText().compareTo("") == 0 && b12.getText().compareTo("") == 0 && b13.getText().compareTo("") == 0 && b21.getText().compareTo("") == 0 && b22.getText().compareTo("") == 0 && b23.getText().compareTo("") == 0 && b31.getText().compareTo("") == 0 && b32.getText().compareTo("") == 0 && b33.getText().compareTo("") == 0) {

                                valor = buscarVez(qtd);
                                if (valor.compareTo("x") == 0) {
                                    labelVez.setText("o/a '" + x + "' começa");
                                } else {
                                    labelVez.setText("o/a '" + o + "' começa");
                                }

                            } else {
                                if (informacao[3][0].compareTo("o") == 0) {
                                    valor = informacao[3][0];
                                    vz = false;
                                    labelVez.setText("vez do " + o);

                                } else {
                                    valor = informacao[3][0];
                                    vz = true;
                                    labelVez.setText("vez do " + x);

                                }
                                qtd++;
                            }

                        }

                    }

                } else {
                    valor = buscarVez(qtd);
                    if (valor.compareTo("x") == 0) {
                        labelVez.setText("o/a '" + x + "' começa");
                    } else {
                        labelVez.setText("o/a '" + o + "' começa");
                    }
                }

            }

        });

    }

    public void manipular(String[][] informacao) {
        b11.setText(informacao[0][0]);
        b12.setText(informacao[0][1]);
        b13.setText(informacao[0][2]);
        b21.setText(informacao[1][0]);
        b22.setText(informacao[1][1]);
        b23.setText(informacao[1][2]);
        b31.setText(informacao[2][0]);
        b32.setText(informacao[2][1]);
        b33.setText(informacao[2][2]);
    }

    public void printVez(String valor, String s) {
        if (s.compareTo("salvar") != 0) {
            if (valor.compareTo("x") == 0) {

                labelVez.setText("vez do " + o);

            } else {
                labelVez.setText("vez do " + x);

            }

        }
    }

    @FXML
    private void getClick(ActionEvent event) throws IOException, ClassNotFoundException {
        Button click = (Button) event.getSource();

        switch (click.getId()) {
            case "b11":
                if (b11.getText().compareTo("") == 0) {
                    click.setText(valor);
                    checarVitoria(valor);
                    printVez(valor, "");
                    valor = buscarVez(qtd);
                }

                break;

            case "b12":
                if (b12.getText().compareTo("") == 0) {
                    click.setText(valor);
                    checarVitoria(valor);
                    printVez(valor, "");
                    valor = buscarVez(qtd);
                }
                break;

            case "b13":
                if (b13.getText().compareTo("") == 0) {
                    click.setText(valor);
                    checarVitoria(valor);
                    printVez(valor, "");
                    valor = buscarVez(qtd);
                }
                break;

            case "b21":
                if (b21.getText().compareTo("") == 0) {
                    click.setText(valor);
                    checarVitoria(valor);
                    printVez(valor, "");
                    valor = buscarVez(qtd);
                }
                break;

            case "b22":
                if (b22.getText().compareTo("") == 0) {
                    click.setText(valor);
                    checarVitoria(valor);
                    printVez(valor, "");
                    valor = buscarVez(qtd);
                }
                break;

            case "b23":
                if (b23.getText().compareTo("") == 0) {
                    click.setText(valor);
                    checarVitoria(valor);
                    printVez(valor, "");
                    valor = buscarVez(qtd);
                }
                break;

            case "b31":
                if (b31.getText().compareTo("") == 0) {
                    click.setText(valor);
                    checarVitoria(valor);
                    printVez(valor, "");
                    valor = buscarVez(qtd);
                }
                break;

            case "b32":
                if (b32.getText().compareTo("") == 0) {
                    click.setText(valor);
                    checarVitoria(valor);
                    printVez(valor, "");
                    valor = buscarVez(qtd);
                }
                break;

            case "b33":
                if (b33.getText().compareTo("") == 0) {
                    click.setText(valor);
                    checarVitoria(valor);
                    printVez(valor, "");
                    valor = buscarVez(qtd);

                }
                break;

            case "jogar_novamente":
                resetarTudo();
                break;

            case "voltar":
                resetarTudo();
                JogoDaVelha.chengeScreen(click.getId(), null, "", "");
                break;

            case "salvar":
                salvarJogo();
                break;

        }

    }

    private String buscarVez(int qtd) {

        if (qtd == 1) {
            this.vez = (int) (Math.random() * 2 + 1);
            this.qtd++;

            if (this.vez == 1) {
                this.vz = true;
                return "x";

            } else {
                this.vz = false;
                return "o";

            }
        } else {
            if (this.vz == true) {
                this.vz = false;
                return "o";
            } else {
                this.vz = true;
                return "x";
            }

        }

    }

    public void salvarJogo() throws IOException, FileNotFoundException, ClassNotFoundException {
        File arquivo = new File("C:\\Users\\tiago\\Documents\\ola\\" + nome1 + ".ser");
        if (!arquivo.exists()) {
            arquivo.createNewFile();
        }

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\tiago\\Documents\\ola\\" + nome1 + ".ser"));
        oos.writeObject(toMatriz());
        oos.close();

    }

    private String[][] toMatriz() {
        String[][] atual = new String[5][5];

        atual[0][0] = b11.getText();
        atual[0][1] = b12.getText();
        atual[0][2] = b13.getText();
        atual[1][0] = b21.getText();
        atual[1][1] = b22.getText();
        atual[1][2] = b23.getText();
        atual[2][0] = b31.getText();
        atual[2][1] = b32.getText();
        atual[2][2] = b33.getText();
        atual[3][0] = valor;
        atual[3][1] = nome1;
        atual[3][2] = nome2;
        atual[3][3] = "" + pontx + "";
        atual[3][4] = "" + ponto + "";

        return atual;

    }

    public void checarVitoria(String valor) {

        if (checarColuna() || checarLinha() || checarDiag()) {
            if (valor.compareTo("x") == 0) {
                labelVez.setVisible(false);
                info.setText("o '" + x + "' venceu!");
                pontx++;

            } else {
                labelVez.setVisible(false);
                info.setText("a '" + o + "' venceu!");
                ponto++;

            }
            labelVez.setVisible(false);
            jogar_novamente.setVisible(true);

        } else if (b11.getText().compareTo("") != 0 && b12.getText().compareTo("") != 0 && b13.getText().compareTo("") != 0 && b21.getText().compareTo("") != 0 && b22.getText().compareTo("") != 0 && b23.getText().compareTo("") != 0 && b31.getText().compareTo("") != 0 && b32.getText().compareTo("") != 0 && b33.getText().compareTo("") != 0) {
            info.setText("Deu velha!");
            labelVez.setVisible(false);
            jogar_novamente.setVisible(true);
        }
    }

    private boolean checarColuna() {
        if (b11.getText().compareTo("") != 0) {
            if (b11.getText().compareTo(b21.getText()) == 0 && b11.getText().compareTo(b31.getText()) == 0) {
                return true;

            }
        }
        if (b12.getText().compareTo("") != 0) {
            if (b12.getText().compareTo(b22.getText()) == 0 && b12.getText().compareTo(b32.getText()) == 0) {
                return true;

            }
        }
        if (b13.getText().compareTo("") != 0) {
            if (b13.getText().compareTo(b23.getText()) == 0 && b13.getText().compareTo(b33.getText()) == 0) {
                return true;

            }
        }

        return false;
    }

    private boolean checarLinha() {
        if (b11.getText().compareTo("") != 0) {
            if (b11.getText().compareTo(b12.getText()) == 0 && b11.getText().compareTo(b13.getText()) == 0) {
                return true;

            }
        }
        if (b21.getText().compareTo("") != 0) {
            if (b21.getText().compareTo(b22.getText()) == 0 && b21.getText().compareTo(b23.getText()) == 0) {
                return true;

            }
        }
        if (b31.getText().compareTo("") != 0) {
            if (b31.getText().compareTo(b32.getText()) == 0 && b31.getText().compareTo(b33.getText()) == 0) {
                return true;

            }
        }

        return false;
    }

    private boolean checarDiag() {
        if (b11.getText().compareTo("") != 0) {
            if (b11.getText().compareTo(b22.getText()) == 0 && b11.getText().compareTo(b33.getText()) == 0) {
                return true;
            }
        }

        if (b13.getText().compareTo("") != 0) {
            if (b13.getText().compareTo(b22.getText()) == 0 && b13.getText().compareTo(b31.getText()) == 0) {
                return true;

            }
        }

        return false;
    }

    public void resetarTudo() {
        b11.setText("");
        b12.setText("");
        b13.setText("");
        b21.setText("");
        b22.setText("");
        b23.setText("");
        b31.setText("");
        b32.setText("");
        b33.setText("");
        info.setText("");
        qtd = 1;
        vez = 0;
        labelVez.setVisible(true);
        jogar_novamente.setVisible(false);
        valor = buscarVez(qtd);
        if (valor.compareTo("x") == 0) {
            labelVez.setText("o/a '" + x + "' começa");
        } else {
            labelVez.setText("o/a '" + o + "' começa");
        }

    }
}
