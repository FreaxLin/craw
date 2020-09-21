package top.datacluster.craw.worker;

import com.zaxxer.hikari.HikariDataSource;
import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;
import org.apache.commons.cli.*;
import org.springframework.jdbc.core.JdbcTemplate;
import top.datacluster.craw.worker.store.MysqlStoreServiceFactory;

import javax.sql.DataSource;

import java.util.List;
import java.util.Map;

public class CrawApplication {

    private CrawlController controller;

    private ApplicationConfig applicationConfig;

    private DataSource dataSource;

    public CrawApplication(ApplicationConfig config, List<String> urls) {

        this.applicationConfig = config;
        String crawlStorageFolder = config.getCrawlStorageFolder();

        CrawlConfig crawlConfig = new CrawlConfig();
        crawlConfig.setCrawlStorageFolder(crawlStorageFolder);
        crawlConfig.setUserAgentString("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/85.0.4183.83 Safari/537.36");

        PageFetcher pageFetcher = new HttpHeaderPageFetcher(crawlConfig);
        RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
        RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);


        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setConnectionTimeout(10000);
        hikariDataSource.setPassword("123456");
        hikariDataSource.setUsername("root");
        hikariDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/craw_data");
        this.dataSource = hikariDataSource;

        try {
            CrawlController controller = new CrawlController(crawlConfig, pageFetcher, robotstxtServer);
            JdbcTemplate jdbcTemplate = new JdbcTemplate(hikariDataSource);
            List<Map<String, Object>> result = jdbcTemplate.queryForList("SELECT hupu_id FROM craw_data.hupu_bxj_user;");

            for (Map<String, Object> url : result){
                controller.addSeed("https://my.hupu.com" + url.get("hupu_id").toString() + "/follower");
            }
//            controller.addSeed("https://my.hupu.com/96258335640997/follower");

            this.controller = controller;

        } catch (Exception e) {
            e.printStackTrace();
        }

//        Executors.newFixedThreadPool(1);

    }

    public void start(){
        int numberOfCrawlers = this.applicationConfig.getNumberOfCrawlers(1);
        this.controller.start(new MysqlStoreServiceFactory(this.dataSource), numberOfCrawlers);
    }

    public static void main(String[] args) {

        Options options = new Options();
        Option opt = new Option("h", "help", false, "Print help");
        opt.setRequired(false);
        options.addOption(opt);

        opt = new Option("c", "config", true, "application config properties file");
        opt.setRequired(true);
        options.addOption(opt);

        HelpFormatter hf = new HelpFormatter();
        hf.setWidth(110);
        CommandLine commandLine = null;
        CommandLineParser parser = new PosixParser();
        try {
            commandLine = parser.parse(options, args);
            if (commandLine.hasOption('h')) {
                // 打印使用帮助
                hf.printHelp("app", options, true);
            }

        }
        catch (ParseException e) {
            hf.printHelp("app", options, true);
        }

        ApplicationConfig applicationConfig = new ApplicationConfig(commandLine.getOptionValue("c"));
        List<String> lines = applicationConfig.getCrawPath();
        CrawApplication crawApplication = new CrawApplication(applicationConfig, lines);
        crawApplication.start();

    }
}
