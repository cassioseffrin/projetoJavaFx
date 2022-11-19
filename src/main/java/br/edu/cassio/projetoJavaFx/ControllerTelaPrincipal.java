package br.edu.cassio.projetoJavaFx;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;

public class ControllerTelaPrincipal implements Initializable {

    @FXML
    private MenuItem menuItemCadastrarPaciente;

    @FXML
    private MenuItem menuItemCadastrarMedico;
    
    @FXML
    private MenuItem menuItemRelatorioMedico;

    @FXML
    private MenuItem menuItemAtendimento;
    
    @FXML
    private MenuItem menuTeste;
    
    @FXML
    private MenuItem menuAjuda;

    @FXML
    private AnchorPane anchorPaneFundo;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void handlerTelaCliente(javafx.event.ActionEvent event) throws IOException {
        AnchorPane a = FXMLLoader.load(getClass().getResource("/br/edu/cassio/projetoJavaFx/TelaCliente.fxml"));
        anchorPaneFundo.getChildren().setAll(a);
    }

    @FXML
    private void handlerTelaMedico(javafx.event.ActionEvent event) throws IOException {
        AnchorPane a = FXMLLoader.load(getClass().getResource("/br/edu/cassio/projetoJavaFx/TelaMedico.fxml"));
        anchorPaneFundo.getChildren().setAll(a);
    }

    @FXML
    private void handlerRealizarAtendimento(javafx.event.ActionEvent event) throws IOException {
        AnchorPane a = FXMLLoader.load(getClass().getResource("/br/edu/cassio/projetoJavaFx/TelaAtendimento.fxml"));
        anchorPaneFundo.getChildren().setAll(a);
    }

    @FXML
    private void handlerTelaAgenda(javafx.event.ActionEvent event) throws IOException {
        AnchorPane a = FXMLLoader.load(getClass().getResource("/br/edu/cassio/projetoJavaFx/TelaAgenda.fxml"));
        anchorPaneFundo.getChildren().setAll(a);
    }
    @FXML
    private void handlerRelatorioPaciente(javafx.event.ActionEvent event) throws IOException {
    	AnchorPane a = FXMLLoader.load(getClass().getResource("/br/edu/cassio/projetoJavaFx//Relatorios.fxml"));
    	anchorPaneFundo.getChildren().setAll(a);
    }
    
    @FXML
    private void handlerRelatorioMedico(javafx.event.ActionEvent event) throws IOException {
    	AnchorPane a = FXMLLoader.load(getClass().getResource("/br/edu/cassio/projetoJavaFx/TelaRelatorioMedico.fxml"));
    	anchorPaneFundo.getChildren().setAll(a);
    }

}
