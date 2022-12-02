package br.edu.cassio.projetoJavaFx;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import br.edu.cassio.projetoJavaFx.dao.ClienteDao;
import br.edu.cassio.projetoJavaFx.entidades.Cliente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Cassio
 */
public class ControllerTelaCliente implements Initializable {


	@FXML
	private TextField textFieldId;

	@FXML
	private TextField textFieldNome;

	@FXML
	private TextField textFieldRg;

	@FXML
	private TextField textFieldCpf;

	@FXML
	private TextField textFieldEndereco;

	@FXML
	private DatePicker datePickerNascimento;

	@FXML
	private TextField textFieldTelefone;

	@FXML
	private Button buttonSalvar;

	@FXML
	private TableView<Cliente> tableViewCliente;

	@FXML
	private TableColumn<Cliente, Integer> tableColumnId;

	@FXML
	private TableColumn<Cliente, String> tableColumnNome;

	@FXML
	private TableColumn<Cliente, Integer> tableColumnRg;

	@FXML
	private TableColumn<Cliente, Integer> tableColumnCpf;

//    @FXML
//    private TableColumn<Cliente, String> tableColumnSexo;

//    @FXML
//    private TableColumn<Cliente, LocalDate> tableColumnNascimento;

	@FXML
	private TableColumn<Cliente, Integer> tableColumnTelefone;

	@FXML
	private Button buttonExcluir;
	private ObservableList<Cliente> olCliente;
	private Integer idClienteSelecionado;
	private Cliente clienteSelecionado;
	@FXML
	private Button buttonNovo;

	private ClienteDao clienteDao;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		clienteDao = new ClienteDao();
		popularTabelaCliente();
		tableViewCliente.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> selecionarCliente(newValue));
	}

	@FXML
	private void handlerSalvar(ActionEvent event) {
		try {
			String strId = textFieldId.getText();
			Integer id = null;
			if (strId != null && strId.length() > 0) {

				id = Integer.valueOf(Integer.parseInt(strId));
			}
			String nome = textFieldNome.getText();
			String rg = textFieldRg.getText();
			String cpf = textFieldCpf.getText();
			String endereco = textFieldEndereco.getText();
//            LocalDate nascimento = datePickerNascimento.getValue();
			String telefone = textFieldTelefone.getText();

			Cliente c = new Cliente();

			c.setNome(nome);
			c.setCpf(cpf);
			c.setRg(rg);
			c.setEndereco(endereco);
			c.setTelefone(telefone);

			if (id != null) {
				c.setId(id);
				clienteDao.alterar(c);
			} else {
				clienteDao.inserir(c);
				limpar();
			}

			popularTabelaCliente();
		} catch (NumberFormatException e) {
			System.out.println("Alguma coisa errada!");
		}
	}

	public void popularTabelaCliente() {
//    	 module-info.java
//    	  Quando você define o groupId apenas como "projetoJavaFx" (vver  no pom.xml)
		List<Cliente> lst = clienteDao.listar();
		tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
		tableColumnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		tableColumnRg.setCellValueFactory(new PropertyValueFactory<>("rg"));
		tableColumnCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
		tableColumnTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
		olCliente = FXCollections.observableArrayList(lst);
		tableViewCliente.setItems(olCliente);
	}

	private void selecionarCliente(Cliente cliente) {
		clienteSelecionado = cliente;
		textFieldId.setText(String.valueOf(cliente.getId()));
		textFieldNome.setText(cliente.getNome());
		textFieldRg.setText(String.valueOf(cliente.getRg()));
		textFieldCpf.setText(String.valueOf(cliente.getCpf()));
//        datePickerNascimento.setValue(cliente.getDataNascimento());
		textFieldTelefone.setText(String.valueOf(cliente.getTelefone()));

	}

	@FXML
	private void handlerExcluirCliente(ActionEvent event) {
		if (idClienteSelecionado != null) {
			clienteDao.remover(clienteSelecionado);
			popularTabelaCliente();
		}

	}

	@FXML
	private void handlerNovoCliente(ActionEvent event) {
		limpar();

	}

	private void limpar() {
		textFieldId.setText(null);
		textFieldNome.setText(null);
		textFieldRg.setText(null);
		textFieldCpf.setText(null);
		textFieldEndereco.setText(null);
		datePickerNascimento.setValue(null);
		textFieldTelefone.setText(null);
	}

}
