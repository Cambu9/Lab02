package it.polito.tdp.alien;

import java.net.URL;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	LinkedHashMap<String, LinkedList<String>> listaParole = new LinkedHashMap<String, LinkedList<String>>();
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}
	
	@Override
	public boolean equals (Object obj) {
		return super.equals(obj);
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea txtMessaggio;

    @FXML
    private TextField txtTesto;

    @FXML
    void onHandleClear(ActionEvent event) {
    	txtMessaggio.clear();
    	txtTesto.clear();
    }

    @FXML
    void onHandleTranslate(ActionEvent event) {
    	
    	String parole = txtTesto.getText();
    	parole = parole.toLowerCase();
    	String coppia[] = parole.split(" ");
    	
    	if (coppia[0].contains("?")) {
    		String aliena = coppia[0].replace('?', '.');
    		for (String str : listaParole.keySet()) {
    			if (str.matches(aliena)) {
    				coppia[0] = str;
    				break;
    			}
    		}
    	
    	parole = coppia[0];
    	}
    
    if ((parole.matches("[a-zA-Z ]+"))) {
    	if (coppia.length == 2) {
    		if(!listaParole.containsKey(coppia[0])) {
    			listaParole.put(coppia[0], new LinkedList<String>());
    			listaParole.get(coppia[0]).add(coppia[1]);
    			txtMessaggio.setText("Aggiunta la parola: " + coppia[0] + " e la traduzione: " + coppia [1]);
    		} else {
    			listaParole.get(coppia[0]).add(coppia[1]);
    			txtMessaggio.setText("Aggiunta la parola: " + coppia[0] + " e la traduzione: " + coppia [1]);
    		}
    	} else if (coppia.length == 1) {
    		LinkedList<String> traduzioni = listaParole.get(coppia[0]);
    		txtMessaggio.setText("La possibile traduzione di " + coppia[0] + " è: \n");
    		for (String str: traduzioni) {
    			txtMessaggio.appendText(str + "\n");
    		}
    		
    	}
    } else {
    	txtMessaggio.appendText("Sono ammesse solo lettere dell'alfabeto");
    }
    	
    }

    @FXML
    void initialize() {
        assert txtMessaggio != null : "fx:id=\"txtMessaggio\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTesto != null : "fx:id=\"txtTesto\" was not injected: check your FXML file 'Scene.fxml'.";

    }

}
