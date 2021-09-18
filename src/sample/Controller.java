package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import sample.classes.Report;
import sample.classes.User;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Controller implements Initializable {

    private Stage stage;
    private Scene scene;

    @FXML
    private Button seeReports;

    @FXML
    TextField nameField = new TextField();

    @FXML
    TextField surnameField = new TextField();

    @FXML
    TextField passportField = new TextField();

    @FXML
    TextField phoneField = new TextField();

    @FXML
    TextField emailField = new TextField();

    @FXML
    ComboBox nationsList = new ComboBox();

    @FXML
    ToggleGroup genderGroup = new ToggleGroup();

    @FXML
    ToggleButton maleButton = new ToggleButton();

    @FXML
    ToggleButton femaleButton = new ToggleButton();

    @FXML
    ToggleGroup feverGroup = new ToggleGroup();

    @FXML
    ToggleButton feverYes = new ToggleButton();

    @FXML
    ToggleButton feverNo = new ToggleButton();

    @FXML
    ToggleGroup coughGroup = new ToggleGroup();

    @FXML
    ToggleButton coughYes = new ToggleButton();

    @FXML
    ToggleButton coughNo = new ToggleButton();

    @FXML
    ToggleGroup dyspneaGroup = new ToggleGroup();

    @FXML
    ToggleButton dyspneaYes = new ToggleButton();

    @FXML
    ToggleButton dyspneaNo = new ToggleButton();

    @FXML
    ToggleGroup soreGroup = new ToggleGroup();

    @FXML
    ToggleButton soreYes = new ToggleButton();

    @FXML
    ToggleButton soreNo = new ToggleButton();

    @FXML
    TextArea specificArea = new TextArea();

    @FXML
    Button submitDiagnoseButton = new Button();

    @FXML
    Button submitButton = new Button();

    @FXML
    Label versionLabel = new Label();

    @FXML
    Button selfDiagnose = new Button();

    @FXML
    Button callButton = new Button();

    @FXML
    Button editButton = new Button();

    @FXML
    Button faqButton = new Button();

    @FXML
    TextArea faqArea = new TextArea();

    @FXML
    ComboBox tempList = new ComboBox();

    @FXML
    Button reportsButton = new Button();

    @FXML
    ListView reportsListView = new ListView();

    String faq = "";

    @FXML
    Label nameErrorLabel = new Label();

    @FXML
    TextField emailLoginField = new TextField();

    @FXML
    TextField passwordLoginField = new TextField();

    @FXML
    Button loginButton2 = new Button();

    @FXML
    Button adminUsersListButton = new Button();

    @FXML
    ListView adminUsersList = new ListView();

    @FXML
    Button adminStatsButton = new Button();

    @FXML
    PieChart genderPieChart = new PieChart();

    @FXML
    Label adminUsersNumberLabel = new Label();

    @FXML
    Button userStatsButton = new Button();

    @FXML
    private TableView<User> tableViewAdminUsers = new TableView<>();

    @FXML
    private TableColumn<User, Integer> idColumn = new TableColumn<>("id");

    @FXML
    private TableColumn<User, String> surnameColumn = new TableColumn<>("surname");

    @FXML
    private TableColumn<User, LocalDate> qStartColumn = new TableColumn<>("qStart");

    @FXML
    private TableColumn<User, LocalDate> qEndColumn = new TableColumn<>("qEnd");

    @FXML
    private Button removeButton;

    @FXML
    private TableView<Report> userReportTable = new TableView<>();

    @FXML
    private TableColumn<Report, String> userDateColumn = new TableColumn<>("date");

    @FXML
    private TableColumn<Report, Float> userTempColumn=new TableColumn<>("temp");

    @FXML
    private TableColumn<Report, Boolean> userFeverColumn = new TableColumn<>("fever");

    @FXML
    private TableColumn<Report, Boolean> userCoughColumn = new TableColumn<>("cough");

    @FXML
    private TableColumn<Report, Boolean> userDyspneaColumn = new TableColumn<>("dyspnea");

    @FXML
    private TableColumn<Report, Boolean> userSoreColumn = new TableColumn<>("sore");

    @FXML
    private Button fakeUsers;

    @FXML
    private Label surnameErrorLabel= new Label();

    @FXML
    private Label passportErrorLabel=new Label();

    @FXML
    private Label phoneErrorLabel = new Label();

    @FXML
    private Label emailErrorLabel=new Label();

    @FXML
    private Label nationErrorLabel=new Label();

    @FXML
    private Label genderErrorLabel=new Label();

    @FXML
    private Label errorMailLogLabel;

    @FXML
    private Label errorPassLabel;

    @FXML
    private Button deleteUsersButton;

    @FXML
    void deleteUsers() {

        Alert deleteDialog = new Alert(Alert.AlertType.CONFIRMATION);
        deleteDialog.setTitle("C19 Test");
        deleteDialog.setHeaderText("Do you really want to delete the users?");

        Optional<ButtonType> result = deleteDialog.showAndWait();
        if (result.get() == ButtonType.OK) {
            Engine.usersList.removeAll(Engine.getUsersList());
        }
    }

    public void submitButton(ActionEvent event) throws IOException {

        if (genderGroup.getUserData() == null) {
            //System.out.println("Set gender");
            genderErrorLabel.setTextFill(Color.RED);
        }else{
            genderErrorLabel.setTextFill(Color.BLACK);
        }

        if (!nameCheck(nameField.getText())) {
            //System.out.println("Wrong name");
            nameErrorLabel.setTextFill(Color.RED);
        }else{nameErrorLabel.setTextFill(Color.BLACK);}

        if (!surnameCheck(surnameField.getText())) {
            //System.out.println("Wrong surname");
            surnameErrorLabel.setTextFill(Color.RED);
        }else{
            surnameErrorLabel.setTextFill(Color.BLACK);
        }

        if (!passportCheck(passportField.getText())) {
            //System.out.println("Wrong passport");
            passportErrorLabel.setTextFill(Color.RED);
        }else{
            passportErrorLabel.setTextFill(Color.BLACK);
        }

        if (nationsList.getValue() == null) {
            nationErrorLabel.setTextFill(Color.RED);
            //nationErrorLabel.setVisible(true);
        }else{
            nationErrorLabel.setTextFill(Color.BLACK);
            //nationErrorLabel.setVisible(false);
        }

        if (!phoneCheck(phoneField.getText())) {
            //System.out.println("Wrong phone");
            phoneErrorLabel.setTextFill(Color.RED);
        }else{
            phoneErrorLabel.setTextFill(Color.BLACK);
        }

        if (!emailCheck(emailField.getText())){
            //System.out.println("Wrong email");
            emailErrorLabel.setTextFill(Color.RED);
        }else{
            emailErrorLabel.setTextFill(Color.BLACK);
        }

        if (nameCheck(nameField.getText()) && surnameCheck(surnameField.getText()) &&
                passportCheck(passportField.getText()) &&
                nationsList.getValue() != null && phoneCheck(phoneField.getText()) &&
                emailCheck(emailField.getText()) && genderGroup.getUserData() != null &&
                uniqueDataCheck(passportField.getText(), phoneField.getText(), emailField.getText())) {

            LocalDate now = LocalDate.now();

            Engine.currentUser = new User(
                    nameField.getText(),
                    surnameField.getText(),
                    passportField.getText(),
                    nationsList.getValue().toString(),
                    phoneField.getText(),
                    (String) genderGroup.getUserData(),
                    emailField.getText(),
                    (Engine.usersList.size() + 1),
                    now);

            Engine.usersList.add(Engine.currentUser);
            //System.out.println(Engine.currentUser);

            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(Engine.getUserScenePath())));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    void seeAdminUserReports(ActionEvent event) throws IOException {

        if(tableViewAdminUsers.getSelectionModel().getSelectedItem()!=null){
            Engine.currentUser=tableViewAdminUsers.getSelectionModel().getSelectedItem();
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(Engine.getAdminSelectedUserReportsScenePath())));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    void generateFakeUsers() {

        if(Engine.usersList.size()<500){
            LocalDate now = LocalDate.now();

            Random rName = new Random();
            Random rSurname = new Random();
            Random rPassport = new Random();
            Random rMobile = new Random();
            Random rNation = new Random();
            Random rDays = new Random();
            Random rGender = new Random();

            for (int i = 0; i < 50; i++) {
                Engine.fakeGender=(rGender.nextInt(4)>1.8)?"male":"female";
                User fakeUser = new User(Engine.fakeName[rName.nextInt(Engine.fakeName.length)], Engine.fakeSurname[rSurname.nextInt(Engine.fakeSurname.length)],
                        Engine.fakePassport[rPassport.nextInt(Engine.fakePassport.length)], Engine.nations[rNation.nextInt(Engine.nations.length)],
                        Engine.fakeMobile[rMobile.nextInt(Engine.fakeMobile.length)], Engine.fakeGender, Engine.fakeEmail[0], (Engine.usersList.size())+1,
                        now.plusDays(rDays.nextInt(20)));
                generateFakeReport(fakeUser);
                Engine.usersList.add(fakeUser);
            }
        }else{

            Alert numberError = new Alert(Alert.AlertType.INFORMATION);
            numberError.setTitle("C19 Test");
            numberError.setHeaderText("Too many people!");

            numberError.showAndWait();
        }
    }

    void generateFakeReport(User user){

        String fDate;
        float rTemp;
        boolean rFever, rCough, rDyspnea, rSore;
        String fCommentary = "Neque porro quisquam est, qui dolorem ipsum.";
        BigDecimal bd;

        for(int i=0; i<14; i++){

            fDate=String.valueOf(user.getStartDate().plusDays(i));

            rTemp=(float)(Math.random()*3+35);
            bd = new BigDecimal(rTemp).setScale(1, RoundingMode.HALF_UP);
            rTemp=bd.floatValue();
            rFever= Math.random() > 0.8;
            rCough= Math.random() > 0.77;
            rDyspnea= Math.random() > 0.92;
            rSore= Math.random() > 0.68;

            Report report = new Report(fDate, rTemp, rFever, rCough, rDyspnea, rSore, fCommentary);
            user.getReportList().add(report);
        }
    }

    public void loadNations(){
        for (int i = 0; i < Engine.nations.length; i++) {nationsList.getItems().add(Engine.nations[i]);}
    }

    public void loadTemperatures(){

        for (float i = 0; i < 100; i++) {tempList.getItems().add(34 + (i / 10)); }
    }

    public void setFields(){
        nameField.setText(Engine.currentUser.getName());
        surnameField.setText(Engine.currentUser.getSurname());
        passportField.setText(Engine.currentUser.getPassportN());
        nationsList.setValue(Engine.currentUser.getNation());
        phoneField.setText(Engine.currentUser.getMobileN());
        emailField.setText(Engine.currentUser.getEmailAdress());
        if(nameField.getText()==null){
            genderGroup.selectToggle(null);
        }else{
            genderGroup.selectToggle((Engine.currentUser.getGender() == "male") ? maleButton : femaleButton);
        }
    }

    public void loadUserTempChart(){}

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        tableViewAdminUsers.setOnMouseClicked((MouseEvent event) -> {
            if (event.getButton().equals(MouseButton.PRIMARY) && event.getClickCount() == 2){
                Engine.currentUser=tableViewAdminUsers.getSelectionModel().getSelectedItem();
                Parent root = null;
                try {
                    root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(Engine.getAdminSelectedUserReportsScenePath())));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        });

        versionLabel.setText(Engine.version);
        adminUsersNumberLabel.setText("Number of users: " + (Engine.usersList.size()));

        loadNations();
        loadTemperatures();

        femaleButton.setToggleGroup(genderGroup);
        maleButton.setToggleGroup(genderGroup);

        if (Engine.currentUser != null) {

            try {setFaqArea();} catch (IOException e) {e.printStackTrace();}
            faqArea.setText(faq);

            setFields();

            loadUsers();

            loadGenderPie();

            setAdminColumns();

            setUserColumns();

            loadUserTempChart();

        }
    }

    @FXML
    void removeUserAdmin(ActionEvent event) throws IOException {
        if(tableViewAdminUsers.getSelectionModel().getSelectedItem()!=null){
            Engine.usersList.remove(tableViewAdminUsers.getSelectionModel().getSelectedItem());
            //System.out.println(tableViewAdminUsers.getSelectionModel().getSelectedItem());

            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(Engine.getAdminUsersScenePath())));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    public void signInScene(javafx.event.ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(Engine.getLoginScenePath())));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        //scene.getStylesheets().add("style.css");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void createUserScene(javafx.event.ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(Engine.getCreateUserPath())));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void goBack(ActionEvent event) throws IOException, ClassNotFoundException {

        //ObjectOutputStream objectOutputStream = new ObjectOutputStream((new FileOutputStream(Engine.getUsersFilePath())));
        //objectOutputStream.writeObject(Engine.usersList);
        //Engine.init();
        Engine.currentUser=new User();

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(Engine.getStartMenuPath())));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        //scene.getStylesheets().add("style.css");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void exitApp(ActionEvent event) throws IOException {

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Alert exitDialog = new Alert(Alert.AlertType.CONFIRMATION);
        exitDialog.setTitle("C19 Test");
        exitDialog.setHeaderText("Do you want to close the app?");

        Optional<ButtonType> result = exitDialog.showAndWait();
        if (result.get() == ButtonType.OK) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream((new FileOutputStream(Engine.getUsersFilePath())));
            objectOutputStream.writeObject(Engine.usersList);
            stage.close();
        }
    }

    public String passGenerator() {

        String pass = "";
        Random rChar = new Random();
        Random rDigit = new Random();
        String passPart;

        for (int i = 0; i < 5; i++) {

            if (Math.random() > 0.5) {
                char c = (char) (rChar.nextInt(26) + 'A');
                passPart = String.valueOf(c);
            } else {
                short digit = (short) (rDigit.nextInt(9));
                passPart = String.valueOf(digit);
            }
            pass = pass + passPart;
        }

        System.out.println(pass);
        Engine.setCurrentPassword(pass);
        return pass;
    }

    private void loadGenderPie() {

        int maleCounter = 0;
        int femaleCounter = 0;

        for (int i = 0; i < Engine.usersList.size(); i++) {
            if (Engine.usersList.get(i).getGender().equals("male")) {
                maleCounter++;
            } else {
                femaleCounter++;
            }
        }

        ObservableList<PieChart.Data> genderPieData = FXCollections.observableArrayList(
                new PieChart.Data("Male", maleCounter),
                new PieChart.Data("Female", femaleCounter)
        );

        genderPieChart.setData(genderPieData);
        genderPieChart.setTitle("Gender");
        genderPieChart.setLabelLineLength(0);
    }

    public void setFaqArea() throws IOException {
        Path path = Paths.get(Engine.getFaqFilePath());
        Scanner scanner = new Scanner(path);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine() + "\n";
            faq = faq + line;
        }
        scanner.close();
    }

    public boolean nameCheck(String text) {
        if(text==null){
            return false;
        }else{
            return text.matches(Engine.nameRegex);
        }
    }

    public boolean surnameCheck(String text) {
        if(text==null){
            return false;
        }else{
            return text.matches(Engine.surnameRegex);
        }
    }

    public boolean passportCheck(String text) {
        if(text==null){
            return false;
        }else{
            return text.matches(Engine.passportRegex);
        }
    }

    public boolean phoneCheck(String text) {
        if(text==null){
            return false;
        }else{
            return text.matches(Engine.mobileRegex);
        }
    }

    public boolean emailCheck(String text) {
        if(text==null) {
            return false;
        }else{
            return text.matches(Engine.emailRegex);
        }
    }

    public void setGenderButton(ActionEvent event) {

        if (event.getSource() == maleButton) {
            maleButton.isSelected();
            genderGroup.setUserData("male");
        } else if (event.getSource() == femaleButton) {
            femaleButton.isSelected();
            genderGroup.setUserData("female");
        }
    }

    public boolean uniqueDataCheck(String passportN, String mobileN, String emailAdress) {

        boolean passportUnique = true, mobileUnique = true, emailAdressUnique = true;

        for (int i = 0; i < Engine.usersList.size(); i++) {

            if (Engine.usersList.get(i).getPassportN().equals(passportN)) {
                passportUnique = false;
                break;
            }

            if (Engine.usersList.get(i).getMobileN().equals(mobileN)) {
                mobileUnique = false;
                break;
            }

            if (Engine.usersList.get(i).getEmailAdress().equals(emailAdress)) {
                emailAdressUnique = false;
                break;
            }
        }

        if (passportUnique) {
            if (mobileUnique) {
                if (emailAdressUnique) {
                    return true;
                } else {
                    System.out.println("This email number has already been used");
                    return false;
                }
            }else{
                System.out.println("This mobile number has already been used");
                return false;
                 }
        }else{
            System.out.println("This passport number has already been used");
            return false;
             }
    }

    public void diagnoseButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(Engine.getDiagnoseScenePath())));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void userBack(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(Engine.getUserScenePath())));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void callUs() {System.out.println("BRR BRR BRR");}

    public void editUserData(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(Engine.getEditUserPath())));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        if (Engine.currentUser.getGender().equals("male")) {
            maleButton.setSelected(true);
        } else if (Engine.currentUser.getGender().equals("female")) {
            femaleButton.setSelected(true);
        } else {
            //System.out.println(Engine.currentUser.getGender());
        }
    }

    public void faqScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(Engine.getFaqScenePath())));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void submitDiagnose() {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        if (tempList.getValue() != null && feverGroup.getUserData() != null
                && coughGroup != null && dyspneaGroup != null && soreGroup != null){

            //System.out.println(tempList.getValue());

            Report report = new Report(dtf.format(now), (float) tempList.getValue(),
                    (boolean) feverGroup.getUserData(), (boolean) coughGroup.getUserData(),
                    (boolean) dyspneaGroup.getUserData(),(boolean) soreGroup.getUserData(),specificArea.getText());
            //System.out.println(report);
            Engine.currentUser.getReportList().add(report);
        } else {System.out.println("Set all data");}
    }

    public void seeReports(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(Engine.getUserReportScenePath())));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void editInfoButton(ActionEvent event) throws IOException {

        if (phoneCheck(phoneField.getText()) && emailCheck(emailField.getText())) {
            Engine.currentUser.setMobileN(phoneField.getText());
            Engine.currentUser.setEmailAdress(emailField.getText());

            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(Engine.getUserScenePath())));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } else if (!phoneCheck(phoneField.getText()) && emailCheck(emailField.getText())) {
            System.out.println("Wrong phone number");
        } else if (phoneCheck(phoneField.getText()) && !emailCheck(emailField.getText())) {
            System.out.println("Wrong email format");
        } else {
            System.out.println("Wrong phone and email");
        }
    }

    public void loginUser(ActionEvent event) throws IOException {

        if (emailLoginField.getText().equals("admin") && passwordLoginField.getText().equals("1234")) {
            Engine.currentUser = new User();
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(Engine.getAdminScenePath())));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else {
            if (isEmailInDatabase(emailLoginField.getText())) {
                if (passwordLoginField.getText().equals(Engine.getCurrentPassword())) {

                    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(Engine.getUserScenePath())));
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                } else {
                    errorMailLogLabel.setTextFill(Color.RED);
                    errorMailLogLabel.setVisible(true);
                    //System.out.println("Wrong password. Try again");
                }
            }
        }
    }

    public boolean isEmailInDatabase(String email) {
        for (int i = 0; i < Engine.usersList.size(); i++) {
            if (email.equals(Engine.usersList.get(i).getEmailAdress())) {
                Engine.currentUser = Engine.usersList.get(i);
                errorMailLogLabel.setVisible(false);
                break;
            } else {
                errorMailLogLabel.setTextFill(Color.RED);
                errorMailLogLabel.setVisible(true);
               // System.out.println("We can not find your email. Try again.");
                return false;
            }
        }
        return true;
    }

    public void showUsers(ActionEvent event) throws IOException {

        tableViewAdminUsers.getColumns().addAll(idColumn, surnameColumn, qStartColumn, qEndColumn);

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(Engine.getAdminUserScreenPath())));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void loadUsers() {

        adminUsersList.getItems().removeAll();
        for (int i = 0; i < Engine.usersList.size(); i++) {
            adminUsersList.getItems().add(Engine.usersList.get(i).getID() + ": " +
                    Engine.usersList.get(i).getName() + " " +
                    Engine.usersList.get(i).getSurname());
        }

        reportsListView.getItems().removeAll();
        for (int i = 0; i < Engine.currentUser.getReportList().size(); i++) {
            reportsListView.getItems().add(Engine.currentUser.getReportList().get(i).getDate() + " | " +
                    Engine.currentUser.getReportList().get(i).getTemperature() + "°C");
        }
    }

    public void adminBack(ActionEvent event) throws IOException {
        Engine.currentUser=new User();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(Engine.getAdminScenePath())));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void loadStatsScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(Engine.getAdminStatsScenePath())));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void showUserStats(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(Engine.getUserStatsScenePath())));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void setFeverGroupButton(ActionEvent event) {
        if (event.getSource() == feverYes) {
            feverGroup.setUserData(true);
        } else if (event.getSource() == feverNo) {
            feverGroup.setUserData(false);
        }
    }

    public void setCoughGroupButton(ActionEvent event) {
        if (event.getSource() == coughYes) {
            coughGroup.setUserData(true);
        } else if (event.getSource() == coughNo) {
            coughGroup.setUserData(false);
        }
    }

    public void setDyspneaGroupButton(ActionEvent event) {
        if (event.getSource() == dyspneaYes) {
            dyspneaGroup.setUserData(true);
        } else if (event.getSource() == dyspneaNo) {
            dyspneaGroup.setUserData(false);
        }
    }

    public void setSoreGroupButton(ActionEvent event) {
        if (event.getSource() == soreYes) {
            soreGroup.setUserData(true);
        } else if (event.getSource() == soreNo) {
            soreGroup.setUserData(false);
        }
    }

    public void setAdminColumns(){
        ObservableList<User> usersData = FXCollections.observableArrayList();

        usersData.addAll(Engine.usersList);

        idColumn.setCellValueFactory(new PropertyValueFactory<>("ID"));
        surnameColumn.setCellValueFactory(new PropertyValueFactory<>("surname"));
        qStartColumn.setCellValueFactory(new PropertyValueFactory<>("StartDate"));
        qEndColumn.setCellValueFactory(new PropertyValueFactory<>("EndDate"));
        tableViewAdminUsers.setItems(usersData);
    }

    public void setUserColumns(){
        ObservableList<Report> usersReportsData = FXCollections.observableArrayList();

        usersReportsData.addAll(Engine.currentUser.getReportList());

        userDateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        userTempColumn.setCellValueFactory(new PropertyValueFactory<>("temperature"));
        userFeverColumn.setCellValueFactory(new PropertyValueFactory<>("fever"));
        userCoughColumn.setCellValueFactory(new PropertyValueFactory<>("cough"));
        userDyspneaColumn.setCellValueFactory(new PropertyValueFactory<>("dyspnea"));
        userSoreColumn.setCellValueFactory(new PropertyValueFactory<>("soreThroat"));

        userReportTable.setItems(usersReportsData);
    }

    public void adminUserBack(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(Engine.getAdminUsersScenePath())));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}