package digital.fms.tests;

import com.codeborne.selenide.SelenideElement;
import digital.fms.utils.readers.Config;
import digital.fms.utils.readers.TestData;
import jakarta.mail.*;
import jakarta.mail.search.FlagTerm;
import org.openqa.selenium.Keys;
import java.io.File;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Date;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BaseE2ETest {
    public static Config config = new Config();
    public TestData testData = new TestData();
    public static String applicantIDLocalStorage = "";

    public int generateRandomNumber() {
        int min = 10;
        int max = 1000;
        return (int) (Math.random() * (max - min + 1) + min);
    }

    // Method to search recursively in given folder for search
    public boolean searchFile(File file, String search) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                boolean found = searchFile(f, search);
                if (found)
                    return true;
            }
        } else {
            if (search.equals(file.getName())) {
                return true;
            }
        }
        return false;
    }

    public void clearFieldInput(SelenideElement element) {

        for (int i = 0; i < 20; i++) {
            element.doubleClick().sendKeys(Keys.BACK_SPACE);
        }
    }

    public void clearInput(SelenideElement element) {
        while (!element.getValue().equals("")) {
            element.sendKeys(Keys.BACK_SPACE);
        }
    }

    public void scrollToElement(SelenideElement element) {
        element.scrollIntoView("{behavior: \"smooth\", block: \"center\", inline: \"nearest\"}");
    }

    public String getTodaysDate(String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        Date date = new Date();
        return dateFormat.format(date);
    }

    // Method to get the current day of the week
    public String getCurrentDay() {
        LocalDate currentDate = LocalDate.now();
        DayOfWeek currentDayOfWeek = currentDate.getDayOfWeek();
        return currentDayOfWeek.toString();
    }

    public String mailOTPReader() throws Exception {
        String host = "imap.gmail.com";
        String mailStoreType = "imaps";
        String username = "peter.parkeruserxlongevity@gmail.com";
        // String password = "";
        String password = "ezlw tbeq obsn uize";
        String OTP = "";
        try {

            // create properties
            Properties properties = new Properties();

            properties.put("mail.imap.host", host);
            properties.put("mail.imap.port", "993");
            properties.put("mail.imap.starttls.enable", "true");
            properties.put("mail.imap.ssl.trust", host);

            Session emailSession = Session.getDefaultInstance(properties);

            // create the imap store object and connect to the imap server
            Store store = emailSession.getStore(mailStoreType);

            store.connect(host, username, password);

            // create the inbox object and open it
            Folder inbox = store.getFolder("Inbox");
            inbox.open(Folder.READ_WRITE);

            // retrieve the messages from the folder in an array and print it
            Message[] messages = inbox.search(new FlagTerm(new Flags(Flags.Flag.SEEN), false));

            if (messages.length > 0) {
                Message message = messages[messages.length - 1];
                message.setFlag(Flags.Flag.SEEN, true);
                String emailSubject = "xlongevity account email verification code";

                if (message.getSubject().contains(emailSubject)) {
                    Pattern pattern = Pattern.compile("\\d{6}");
                    Matcher matcher = pattern.matcher(message.getContent().toString());

                    while (matcher.find()) {
                        OTP = matcher.group();
                    }
                }
            }
            inbox.close(false);
            store.close();

        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return OTP;
    }
}