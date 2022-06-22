import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.web.WebView;
import javafx.scene.web.WebHistory.Entry;

public class MainController{
    
    @FXML
    WebView webView;
    
    @FXML
    TextField navigationBar;
    
    @FXML
    TextField searchBar;
    
    @FXML
    ProgressBar progressBar;

    private ObservableList<Entry> historyList;

    @FXML
    private void goHome(){
        goTo("https://www.google.com");
    }

    @FXML
    private void goBack(){
        historyList =  webView.getEngine().getHistory().getEntries();
        goTo(historyList.get(historyList.size()-2).getUrl());
        historyList.remove(historyList.size()-1);
    }

    @FXML
    private void go(){
        goTo("https://www." + navigationBar.getText());
    }

    @FXML
    private void search(){
        goTo("https://www.google.com" + "/search?q=" + searchBar.getText());
        searchBar.setText("");
    }

    @FXML
    private void updateNavigationBar(){
        navigationBar.setText(webView.getEngine().getLocation());
        progressBar.progressProperty().bind(webView.getEngine().getLoadWorker().progressProperty());
    }

    private void goTo(String url){
        webView.getEngine().load(url);
        updateNavigationBar();
    }
}