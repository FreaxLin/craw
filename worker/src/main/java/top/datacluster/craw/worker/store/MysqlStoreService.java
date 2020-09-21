package top.datacluster.craw.worker.store;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.parser.ParseData;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;
import org.springframework.jdbc.core.JdbcTemplate;
import top.datacluster.craw.worker.HupuFollower;
import top.datacluster.craw.worker.HupuUser;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MysqlStoreService implements StoreService {

    private JdbcTemplate jdbcTemplate;

    public MysqlStoreService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public String store(Page data) {

        if (data.getParseData() instanceof HtmlParseData){
            String html = ((HtmlParseData) data.getParseData()).getHtml();
            Document doc = Jsoup.parse(html);
            List<Object[]> batchArgs=new ArrayList<Object[]>();
            Elements userTable = doc.select(".bgcolor");
            HupuFollower f = new HupuFollower();
            String name = doc.select("#headtop").text();
            f.setName(name);
            String url = data.getWebURL().getURL();
            int last = url.lastIndexOf("/");
            url = url.substring(0, last);
            last = url.lastIndexOf("/");
            String id = url.substring(last);
            f.setUserId(id);
            for (Element user : userTable) {
                Elements follower = user.select(".u");
                f.setFollower(follower.text());
                Elements href = user.select(".headpic");
                f.setFollowerId(href.attr("href"));
                batchArgs.add(f.getSqlObject());
            }
            String sql = "insert into hupu_follower (name, user_id, follower, follower_id, collection_time)" +
                    " values (?,?,?,?,?)";
            jdbcTemplate.batchUpdate(sql, batchArgs);
        }
        return null;
    }
}
