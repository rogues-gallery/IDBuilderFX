package viewMultiParsed;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ViewMuliParsedController implements Initializable {
	@FXML
	private TableView<EmployeeClass> table;
	@FXML
	private TableColumn<EmployeeClass,String> name;
	@FXML
	private TableColumn<EmployeeClass,String> email;
	@FXML
	private TableColumn<EmployeeClass,String> mobile;
	@FXML
	private TableColumn<EmployeeClass,String> add;
	@FXML
	private TableColumn<EmployeeClass,String> dob;
	@FXML
	private TableColumn<EmployeeClass,String> sex;
	@FXML
	private TableColumn<EmployeeClass,String> fname;
	
	private ObservableList<EmployeeClass> data;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		name.setCellValueFactory(new PropertyValueFactory<EmployeeClass,String>("name"));
		email.setCellValueFactory(new PropertyValueFactory<EmployeeClass,String>("email"));
		mobile.setCellValueFactory(new PropertyValueFactory<EmployeeClass,String>("mobile"));
		add.setCellValueFactory(new PropertyValueFactory<EmployeeClass,String>("add"));
		dob.setCellValueFactory(new PropertyValueFactory<EmployeeClass,String>("dob"));
		sex.setCellValueFactory(new PropertyValueFactory<EmployeeClass,String>("sex"));
		fname.setCellValueFactory(new PropertyValueFactory<EmployeeClass,String>("fname"));
		
	    try {
			buildData();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
	    
	    
	}
	
	public void buildData() throws SQLException{
		data = FXCollections.observableArrayList();
		Connection c ;	
		c = database.SqliteConnection.getConnection();
		String SQL = "SELECT * from Employee";
	    ResultSet rs = c.createStatement().executeQuery(SQL);
	    
	    while(rs.next()){
	    	EmployeeClass ec = new EmployeeClass(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7), rs.getString(8));
	    	data.add(ec);
	}
	    table.setItems(data);
}}