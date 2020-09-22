import com.zaxxer.hikari.HikariDataSource;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import top.datacluster.craw.worker.HupuUser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UpdateUserDataTest {

    private HttpClient client;

    private JdbcTemplate jdbcTemplate;

    @Before
    public void build(){
        this.client = HttpClientBuilder.create().build();
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setConnectionTimeout(10000);
        hikariDataSource.setPassword("123456");
        hikariDataSource.setUsername("root");
        hikariDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/craw_data");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(hikariDataSource);
        this.jdbcTemplate = jdbcTemplate;
    }

    @Test
    public void test() throws IOException {
        int i = 36000;
        int step = 100;
        HttpClient client = HttpClientBuilder.create().build();
        while (true){
            String sql = String.format("SELECT follower_id FROM craw_data.hupu_follower where follower != '' order by id asc limit %s, 100;", i);
            List<Map<String, Object>> result = jdbcTemplate.queryForList(sql);
            if (result.size() == 0){
                break;
            }
            for (Map<String, Object> d : result){
                String url = d.get("follower_id").toString() + "/profile";
                HttpGet get = new HttpGet(url);
                get.addHeader("cookie", "_dacevid3=2a90a715.d183.028c.e7f6.76f048669ffd; _HUPUSSOID=06514cd7-8198-4cb2-8828-d9cb26857e31; _CLT=918ebe7bb324d8673460f7af1d701a5c; c=fvfY0IkD-1594098517411-af7af0ae5fd5f2131457304; _fmdata=u329MyaXXWuWxj3tEB5FZ6O7j5pyHurY4dXwgEu4uAXB79X7FRDTWrYhyV%2B52QID2Ag6xh4j%2Bbrmk9ESZ2E1OTWnaFOouAnXlRB6xFxhOtw%3D; _xid=eNzBqENKK1tkjntRQ0eeF4pVKsERr5R88LA3%2BzQgrMDyenh2kei9pO7ilFgxy6rBDmAoXe4OiTcLXixcWGZjZw%3D%3D; PHPSESSID=h198r975963hm6em3blhonpt82; _cnzz_CV30020080=buzi_cookie%7C2a90a715.d183.028c.e7f6.76f048669ffd%7C-1; AUM=dgkZL-vRUOxAq4fyGbd2bJPHjN5nt-yqlWtWpTno5j7lw; u=18798712|5Zi/5Zi/55CD6L+3|1142|ddbcac6ca557653bfb2cc0f0cac18b71|a557653bfb2cc0f0|5Zi/5Zi/55CD6L+3; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22172f5b6d394c7f-0f394d5d7ad237-1b386257-1296000-172f5b6d395e4e%22%2C%22first_id%22%3A%22%22%2C%22props%22%3A%7B%22%24latest_referrer%22%3A%22https%3A%2F%2Fwww.baidu.com%2Flink%22%2C%22%24latest_traffic_source_type%22%3A%22%E8%87%AA%E7%84%B6%E6%90%9C%E7%B4%A2%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC%22%7D%2C%22%24device_id%22%3A%22172f5b6d394c7f-0f394d5d7ad237-1b386257-1296000-172f5b6d395e4e%22%7D; us=; Hm_lvt_4fac77ceccb0cd4ad5ef1be46d740615=1600668387,1600668404,1600735772,1600735773; Hm_lvt_b241fb65ecc2ccf4e7e3b9601c7a50de=1600668387,1600668404,1600735772,1600735773; ua=123134236; acw_tc=781bad0816007450732658973e1818fd6ae1c2c06c0f4d12c3d522d296a459; Hm_lpvt_b241fb65ecc2ccf4e7e3b9601c7a50de=1600745086; Hm_lpvt_4fac77ceccb0cd4ad5ef1be46d740615=1600745086; _fmdata=u329MyaXXWuWxj3tEB5FZ6O7j5pyHurY4dXwgEu4uAXB79X7FRDTWrYhyV%2B52QIDdOlXuxMLKXQPCAXsgxqJkfN8gPTAfuRlGvg5E%2BgyMKM%3D; __dacevst=9368ccc6.3d670f00|1600746891373");
                get.addHeader(":authority", "my.hupu.com");
                get.addHeader(":method", "GET");
                get.addHeader(":scheme", "https");
                get.addHeader("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");

                HttpResponse response = client.execute(get);
                Document doc = Jsoup.parse(EntityUtils.toString(response.getEntity()));
                List<Object[]> barchArgs = new ArrayList<>();
                Elements userTable = doc.select(".profile_table");
                if (userTable.size() > 0){
                    Element details = userTable.get(0);

                    Elements elements = details.select(".a1");
                    String name = doc.select("#headtop").text();
                    HupuUser hupuUser = new HupuUser();
                    hupuUser.setName(name);
                    int last = url.lastIndexOf("/");
                    url = url.substring(0, last);
                    last = url.lastIndexOf("/");
                    String id = url.substring(last);
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

            Files.write(Paths.get("/Users/sai/IdeaProject/craw/data/limit"), String.valueOf(i).getBytes());

            i += step;
        }
    }
}
