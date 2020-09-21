package top.datacluster.craw.worker;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;

public class ApplicationConfig {

    private Properties properties;

    private List<String> crawPaths;

    public ApplicationConfig() {
    }

    public ApplicationConfig(String file) {
        Properties properties = new Properties();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            properties.load(bufferedReader);
            this.properties = properties;
            String crawFile = properties.getProperty(ConfigConstants.CRAW_URLS_FILE);
            Path path = Paths.get(crawFile);
            this.crawPaths = Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Integer getNumberOfCrawlers(Integer defaultValue){
        return (Integer) this.properties.getOrDefault("crawler.num.thread", defaultValue);
    }
    
    public String getCrawlStorageFolder(){
        return this.properties.getProperty(ConfigConstants.CRAW_STORAGE_PATH);
    }

    public List<String> getCrawPath(){
        return this.crawPaths;
    }
}
