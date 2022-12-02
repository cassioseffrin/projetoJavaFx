module br.edu.cassio.projetoJavaFx {
    requires javafx.controls;
    requires javafx.fxml;
	requires java.sql;
	requires javafx.base;
	

    opens br.edu.cassio.projetoJavaFx to javafx.fxml;
 
    
    exports br.edu.cassio.projetoJavaFx.entidades;
    
    exports br.edu.cassio.projetoJavaFx;

}
