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
            List<Object[]> barchArgs = new ArrayList<>();
            Elements userTable = doc.select(".profile_table");
            if (userTable.size() > 0){
                Element details = userTable.get(0);

                Elements elements = details.select(".a1");
                String name = doc.select("#headtop").text();
                HupuUser hupuUser = new HupuUser();
                hupuUser.setName(name);
                String url = data.getWebURL().getURL();
                int last = url.lastIndexOf("/");
                url = url.substring(0, last);
                last = url.lastIndexOf("/");
                String id = url.substring(last + 1);
                hupuUser.setId(id);
                for (Element detail : elements){
                    String[] infos = detail.parent().text().split(" ", 2);
                    if (infos[0].equals("性别：")){
                        hupuUser.setSex(infos[1]);
                    }
                    if (infos[0].equals("所在地：")){
                        hupuUser.setCity(infos[1]);
                    }
                    if (infos[0].equals("论坛等级：")){
                        hupuUser.setLevel(Integer.valueOf(infos[1]));
                    }
                    if (infos[0].equals("所属社团：")){
                        hupuUser.setMass(infos[1]);
                    }
                    if (infos[0].equals("银行现金：")){
                        hupuUser.setCash(infos[1]);
                    }
                    if (infos[0].equals("在线时间：")){
                        hupuUser.setOnlive_time(infos[1]);
                    }
                    if (infos[0].equals("最后登录：")){
                        hupuUser.setLast_lgoin_time(infos[1]);
                    }
                    if (infos[0].equals("注册时间：")){
                        hupuUser.setRegister_time(infos[1]);
                    }


                }
                barchArgs.add(hupuUser.getSqlObject());
                jdbcTemplate.batchUpdate("insert into craw_data.hupu_bxj_user (hupu_bxj_user, hupu_id, sex, level, mass, cash, onlive_time, register_time,last_login_time, city, update_time) values (?,?,?,?,?,?,?,?,?,?,?) ON DUPLICATE KEY UPDATE update_time = values(update_time)",barchArgs);
            }
        }
        return null;
    }

//    @Override
//    public String store(Page data) {
//
//        if (data.getParseData() instanceof HtmlParseData){
//            String html = ((HtmlParseData) data.getParseData()).getHtml();
//            Document doc = Jsoup.parse(html);
//            List<Object[]> batchArgs=new ArrayList<Object[]>();
//            Elements userTable = doc.select(".bgcolor");
//            HupuFollower f = new HupuFollower();
//            String name = doc.select("#headtop").text();
//            f.setName(name);
//            String url = data.getWebURL().getURL();
//            int last = url.lastIndexOf("/");
//            url = url.substring(0, last);
//            last = url.lastIndexOf("/");
//            String id = url.substring(last);
//            f.setUserId(id);
//            for (Element user : userTable) {
//                Elements follower = user.select(".u");
//                f.setFollower(follower.text());
//                Elements href = user.select(".headpic");
//                f.setFollowerId(href.attr("href"));
//                batchArgs.add(f.getSqlObject());
//            }
//            String sql = "insert into hupu_follower (name, user_id, follower, follower_id, collection_time)" +
//                    " values (?,?,?,?,?)";
//            jdbcTemplate.batchUpdate(sql, batchArgs);
//        }
//        return null;
//    }
}
