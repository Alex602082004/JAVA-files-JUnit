package UI;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Settings {
    private String repoType;

    private static Settings instance;

    private Settings() {
    }

    public String getRepoType() {
        return repoType;
    }

    public static Settings getInstance() {
        if (instance == null) {
            // Citim fisierul de setari -- asta ruleaza o singura data
            Properties settings = new Properties();
            try {
                settings.load(new FileReader("C:\\Users\\alexp\\IdeaProjects\\a3-Alex602082004\\settings.properties"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            instance = new Settings();
            instance.repoType = settings.getProperty("repo_type");
        }
        return instance;
    }
}
