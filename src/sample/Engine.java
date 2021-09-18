package sample;

import sample.classes.User;
import java.io.*;
import java.util.*;

public class Engine {

    public static String version="1.3.5";
    public static User currentUser;
    public static int screenHeight=450;
    public static int screenWidth=350;

    private static final String adminUserScreenPath="view\\admin\\AdminUsersScene2.fxml";
    private static final String startMenuPath="view\\StartMenu.fxml";
    private static final String adminScenePath="view\\admin\\AdminScene.fxml";
    private static final String adminStatsScenePath="view\\admin\\AdminStatsScene.fxml";
    private static final String adminSelectedUserReportsScenePath="view\\admin\\AdminSelectedUserReportsScene.fxml";
    private static final String loginScenePath="view\\LoginScene.fxml";
    private static final String createUserPath="view\\CreateUserScene.fxml";
    private static final String diagnoseScenePath="view\\user\\DiagnoseScene.fxml";
    private static final String faqScenePath="view\\user\\FaqScene.fxml";
    private static final String editUserPath="view\\user\\EditUser.fxml";
    private static final String userScenePath="view\\user\\UserScene.fxml";
    private static final String userReportScenePath="view\\user\\UserReportScene2.fxml";
    private static final String userStatsScenePath="view\\user\\UserStatsScene.fxml";
    private static final String faqFilePath= "src/sample/files/faq.txt";
    private static final String adminUsersScenePath="view\\admin\\AdminUsersScene2.fxml";
    private static final String usersFilePath="src\\sample\\files\\users.txt";

    public static String nameRegex = "[A-Z]{3,14}";
    public static String surnameRegex = "[A-Z]{3,20}";
    public static String passportRegex= "[A-Z]{2}[0-9]{7}";
    public static String mobileRegex = "[0-9]{7,12}";
    public static String emailRegex = "[\\w]{3,10}@[\\w]{1,7}.[a-z]{2,3}";

    public static String[] nations = {
            "Angola", "Australia", "Belarus", "Belgium",
            "Chile", "China", "Columbia", "Denmark", "Ecuador",
            "France", "Georgia", "Germany", "Hungary", "Italy", "Japan", "Kosovo",
            "Lithuania", "Malta", "Norway", "Oman", "Poland", "Russia", "Slovakia",
            "Spain", "Taiwan", "United Kingdom", "United States", "Wales","Zimbabwe"};

    static String[] fakeName = {
            "ADAM","BENEDYKT","CYPRIAN","DONALD","EDWARD","FRANCISZEK", "GRZEGORZ",
            "HENRYK", "IRENEUSZ", "JULIUSZ", "KAROL", "LEOPOLD", "MICHAL", "NIKODEM",
            "OSKAR", "PIOTR", "RYSZARD", "SZYMON", "TYTUS", "WITOLD", "ZYGMUNT",
            "ANIA", "BEATA", "CECYLIA", "DOROTA", "EUGENIA", "FRANCISZKA",
            "GENOWEFA", "HALINA", "IDA", "JOLANTA", "KAROLINA", "MARIA", "OLA",
            "PATRYCJA", "ROKSANA", "SŁAWA", "TOLA", "URSZULA", "WIESŁAWA", "ŻANETA"
    };
    static String[] fakeSurname = {
            "ADAMIAK", "BANAŚ", "CZECZOT", "DOMANCZYK", "FRĄTCZAK", "GÓRNIAK",
            "HAN", "INN", "JAROSZ", "KRAWIEC","KOWAL", "MISZTA", "NOWAK",
            "POTOK", "RODRIGUEZ", "STAŃCZYK", "TYM", "WAWRZYNIEC", "ZELT"};

    static String[] fakePassport = {"PL1234567", "DE1234567", "GB1234567", "US1234567", "SK1234567"};
    static String[] fakeMobile = {"1234567", "987654321", "123123123"};
    static String[] fakeEmail = {"malpa@malpa.pl"};
    static String fakeGender;

    private static String currentPassword;

    public static String getCurrentPassword() {
        return currentPassword;
    }

    public static void setCurrentPassword(String currentPassword) {
        Engine.currentPassword = currentPassword;
    }

    public static List<User> usersList = new ArrayList<>();

    public static List<User> getUsersList() {
        return usersList;
    }

    public static void setUsersList(List<User> usersList) {
        Engine.usersList = usersList;
    }

    public static String getUserReportScenePath() {
        return userReportScenePath;
    }

    public static String getFaqScenePath() {
        return faqScenePath;
    }

    public static String getEditUserPath() {
        return editUserPath;
    }

    public static String getDiagnoseScenePath() {
        return diagnoseScenePath;
    }

    public static String getUserScenePath() {
        return userScenePath;
    }

    public static String getStartMenuPath() {
        return startMenuPath;
    }

    public static String getCreateUserPath() {
        return createUserPath;
    }

    public static String getLoginScenePath() {
        return loginScenePath;
    }

    public static String getAdminUsersScenePath() {
        return adminUsersScenePath;
    }

    public static String getUsersFilePath() {
        return usersFilePath;
    }

    public static String getAdminSelectedUserReportsScenePath() {
        return adminSelectedUserReportsScenePath;
    }

    public static String getAdminStatsScenePath() {
        return adminStatsScenePath;
    }

    public static String getAdminUserScreenPath() {
        return adminUserScreenPath;
    }

    public static String getUserStatsScenePath() {
        return userStatsScenePath;
    }

    public static String getAdminScenePath() {
        return adminScenePath;
    }

    public static String getFaqFilePath() {
        return faqFilePath;
    }

    public static void init() throws IOException, ClassNotFoundException {

        //ObjectOutputStream objectOutputStream = new ObjectOutputStream((new FileOutputStream("src\\sample\\files\\users.txt")));
        //objectOutputStream.writeObject(Engine.usersList);

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("src\\sample\\files\\users.txt"));
        Engine.usersList = (List<User>)objectInputStream.readObject();

    }
}