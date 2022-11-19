module br.edu.cassio.projetoJavaFx {
    requires javafx.controls;
    requires javafx.fxml;
	requires java.sql;
	

    opens br.edu.cassio.projetoJavaFx to javafx.fxml;
    exports br.edu.cassio.projetoJavaFx;
}
