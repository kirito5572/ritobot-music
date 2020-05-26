package BOT.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileReader;
import java.sql.*;

public class SQL {
    private static final Logger logger = LoggerFactory.getLogger(SQL.class);
    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet6;
    private static String url;
    private static String user;
    private static String password;

    public SQL() {
        //init
        StringBuilder SQLPassword = new StringBuilder();
        try {
            File file = new File("C:\\DiscordServerBotSecrets\\rito-bot\\SQLPassword.txt");
            FileReader fileReader = new FileReader(file);
            int singalCh;
            while((singalCh = fileReader.read()) != -1) {
                SQLPassword.append((char) singalCh);
            }
        } catch (Exception e) {

            StackTraceElement[] eStackTrace = e.getStackTrace();
            StringBuilder a = new StringBuilder();
            for (StackTraceElement stackTraceElement : eStackTrace) {
                a.append(stackTraceElement).append("\n");
            }
            logger.warn(a.toString());
        }
        StringBuilder endPoint = new StringBuilder();
        try {
            File file = new File("C:\\DiscordServerBotSecrets\\rito-bot\\endPoint.txt");
            FileReader fileReader = new FileReader(file);
            int singalCh;
            while((singalCh = fileReader.read()) != -1) {
                endPoint.append((char) singalCh);
            }
        } catch (Exception e) {

            StackTraceElement[] eStackTrace = e.getStackTrace();
            StringBuilder a = new StringBuilder();
            for (StackTraceElement stackTraceElement : eStackTrace) {
                a.append(stackTraceElement).append("\n");
            }
            logger.warn(a.toString());
        }
        url = "jdbc:mysql://" + endPoint.toString() + "/ritobotDB?serverTimezone=UTC";
        user = "ritobot";
        password = SQLPassword.toString();
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String configDownLoad_botchannel(String guildId) {
        String return_data = "error";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String queryString;
            queryString = "SELECT * FROM ritobot_config.bot_channel WHERE guildId=" + guildId;
            statement = connection.createStatement();
            resultSet6 = statement.executeQuery(queryString);
            if (resultSet6.next()) {
                if(resultSet6.getString("disable").equals("0")) {
                    return_data = resultSet6.getString("channelId");
                }
            }
            resultSet6.close();
        } catch (Exception e) {
            e.printStackTrace();
            return_data = "error";
        }
        return return_data;
    }

    public static void setConnection() {
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
