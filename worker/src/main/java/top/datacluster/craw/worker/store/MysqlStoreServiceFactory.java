package top.datacluster.craw.worker.store;

import edu.uci.ics.crawler4j.crawler.CrawlController;
import org.springframework.jdbc.core.JdbcTemplate;
import top.datacluster.craw.worker.Crawler;

import javax.sql.DataSource;


public class MysqlStoreServiceFactory implements CrawlController.WebCrawlerFactory<Crawler>{

    private DataSource dataSource;

    public MysqlStoreServiceFactory(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Crawler newInstance() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        String filter = ".*(\\\\.(\" +\n" +
                "            \"css|js\" +\n" +
                "            \"|bmp|gif|jpe?g|JPE?G|png|tiff?|ico|nef|raw\" +\n" +
                "            \"|mid|mp2|mp3|mp4|wav|wma|flv|mpe?g\" +\n" +
                "            \"|avi|mov|mpeg|ram|m4v|wmv|rm|smil\" +\n" +
                "            \"|pdf|doc|docx|pub|xls|xlsx|vsd|ppt|pptx\" +\n" +
                "            \"|swf\" +\n" +
                "            \"|zip|rar|gz|bz2|7z|bin\" +\n" +
                "            \"|xml|txt|java|c|cpp|exe\" +\n" +
                "            \"))$";
        return new Crawler(filter, new MysqlStoreService(jdbcTemplate));

    }
}
