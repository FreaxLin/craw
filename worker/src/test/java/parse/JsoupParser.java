package parse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;
import org.junit.Test;
import top.datacluster.craw.worker.HupuUser;

import java.io.IOException;
import java.util.List;

public class JsoupParser {

    @Test
    public void parseUrlJIN10() throws IOException {
        Document doc = Jsoup.connect("https://xnews.jin10.com").get();
        System.out.println(doc.title());
        Elements newsHeadlines = doc.select(".news-i-content");
        for (Element headline : newsHeadlines) {
            System.out.println(headline.child(0).attr("title"));
            System.out.println(headline.child(1).text());
            System.out.println(headline.child(2).text());
            System.out.println(headline.parent().parent().attr("href"));

        }
    }

    @Test
    public void parseUrlhupu() throws IOException {
        Document doc = Jsoup.connect("https://bbs.hupu.com/bxj").get();
        System.out.println(doc.title());
        Elements newsHeadlines = doc.select(".for-list");
        for (Element headline : newsHeadlines) {
            List<Node> nodes = headline.childNodes();
            for (Node node : nodes){
                if (node instanceof Element){
                    Element e = (Element) node;

                    String[] data = e.text().split(" ");
                    String title = data[0];
                    String[] authorTime = e.child(1).text().split(" ");
                    String author = authorTime[0];
                    String time = authorTime[1];
                    String pv = e.child(2).text();


                    System.out.println(e);
                }
            }


        }
    }

    @Test
    public void parseUser() throws IOException {
        Document doc = Jsoup.parse("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
                "<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\" />\n" +
                "<meta name=\"renderer\" content=\"webkit\" />\n" +
                "<meta http-equiv=\"Cache-Control\" content=\"no-transform\" />\n" +
                "<meta http-equiv=\"Cache-Control\" content=\"no-siteapp\" />\n" +
                "<link rel=\"dns-prefetch\" href=\"//b1.hoopchina.com.cn\"/>\n" +
                "<link rel=\"dns-prefetch\" href=\"//b3.hoopchina.com.cn\"/>\n" +
                "<title>重新开始学走路的档案</title>\n" +
                "<meta name=\"keywords\" content=\"重新开始学走路,重新开始学走路的档案,重新开始学走路的资料\" /><meta name=\"description\" content=\"重新开始学走路的个人档案资料.\" /><script type='text/javascript'>var __daceDataNameOfForum='0';var __daceDataNameOfCategory = '0'; var __daceDataNameOfProject='hupu';var __daceDataNameOfChannel='';</script>\n" +
                "<meta name=\"apple-itunes-app\" content=\"app-id=906632439\" />\n" +
                "<link rel=\"shortcut icon\" href=\"//w1.hoopchina.com.cn/images/pc/old/favicon.ico\" />\n" +
                "<link type=\"text/css\" rel=\"stylesheet\" href=\"//b3.hoopchina.com.cn/common/common-v1.css\" />\n" +
                "<script src=\"//b3.hoopchina.com.cn/web/module/dace/1.0.0/dace.js\"></script> \n" +
                "<script src=\"//b3.hoopchina.com.cn/common/common-v1.js\"></script>\n" +
                "<link rel='stylesheet' type='text/css' href='//b3.hoopchina.com.cn/css/hupu-v56.css?2018122221' />\n" +
                "<link rel='apple-touch-icon' href='https://b1.hoopchina.com.cn/common/apple-touch-icon.png'/>\n" +
                "<script type=\"text/javascript\" src=\"//b1.hoopchina.com.cn/pcbbs/js/j15.js\"></script>\n" +
                "</head>\n" +
                "<body>\n" +
                "<!--topbarNav star-->\n" +
                "                        <div id=\"hp-topbarNav\">\n" +
                "                            <div class=\"hp-topbarNav-bd\">\n" +
                "                                <ul class=\"hp-quickNav\">\n" +
                "                                    <li class=\"mobileWeb\"><a href=\"javascript:void(0)\" onclick=\"hp_quick_touch()\"><i class=\"ico-mobile\"></i>手机虎扑</a></li>\n" +
                "                                    <li class=\"line\">|</li>\n" +
                "                                    <li class=\"mobileclientDown\"><a class=\"red\" href=\"https://mobile.hupu.com/?_r=globalNav\" target=\"_blank\">虎扑客户端</a></li>\n" +
                "                                    <li class=\"line\">|</li>\n" +
                "                                    <li class=\"hp-dropDownMenu topFollowBlog\">\n" +
                "                                        <a href=\"javascript:void(0)\" class=\"hp-set\">关注虎扑<s class=\"setArrow\"></s></a>\n" +
                "                                        <div class=\"hp-drapDown followLayer\">\n" +
                "                                            <a class=\"weibo\" target=\"_blank\" rel=\"nofollow\" href=\"//weibo.com/liangle4u\"><i class=\"hp-ico-weibo\"></i>新浪微博</a>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<a class=\"weixin\" target=\"_blank\" href=\"https://voice.hupu.com/other/1581560.html\"><i class=\"hp-ico-weixin\"></i>官方微信</a>\n" +
                "                                            <a class=\"instagram\" target=\"_blank\" rel=\"nofollow\" href=\"https://voice.hupu.com/other/1634334.html\"><i class=\"hp-ico-instagram\"></i>Instagram</a>\n" +
                "                                        </div>\n" +
                "                                    </li>\n" +
                "                                </ul>\n" +
                "                                <div class=\"hp-topLogin-info\"></div>\n" +
                "                            </div>\n" +
                "                        </div>\n" +
                "                        <!--topbarNav ent--><!--header star--><div class=\"hp-header hp-header-B\"><div class=\"hp-logo\" style=\"width:60px;\"><a title=\"空间\" href=\"https://my.hupu.com/\"><img src=\"https://w1.hoopchina.com.cn/images/pc/old/hp_logo_sports.png\" alt=\"空间\" width=\"60px\" height=\"50px\"/></a>\n" +
                "                            </div>\n" +
                "                            <div class=\"hp-mainNav hp-mainNav-B\" style=\"margin-left:80px;\">\n" +
                "                                <div class=\"hp-nav\">\n" +
                "                                    <div class=\"hp-nav-bd\">\n" +
                "                                        <ul class=\"hp-nav-item\"><li><a href=\"https://www.hupu.com/\" >虎扑首页</a></li><li class=\"line\">|</li><li><a href=\"https://nba.hupu.com/\" >NBA</a></li><li class=\"line\">|</li><li><a href=\"https://cba.hupu.com/\" >CBA</a></li><li class=\"line\">|</li><li><a href=\"https://gg.hupu.com\" >电竞</a></li><li class=\"line\">|</li><li><a href=\"https://soccer.hupu.com\" >国际足球</a></li><li class=\"line\">|</li><li><a href=\"https://soccer.hupu.com/china/\" >中国足球</a></li><li class=\"line\">|</li><li><a href=\"http://zb.hupu.com/\" target=\"_blank\">装备</a></li><li class=\"line\">|</li><li><a href=\"http://www.shihuo.cn/\" target=\"_blank\">识货</a></li><li class=\"line\">|</li><li><a href=\"https://bbs.hupu.com/\" >社区</a></li><li class=\"line\">|</li><li><a href=\"https://bbs.hupu.com/all-gambia\" >步行街</a></li><li class=\"line\">|</li><li class=\"on\"><a href=\"https://my.hupu.com/\" target=\"_blank\">空间</a></li><li class=\"line\">|</li><li><a href=\"http://www.liangle.com\" target=\"_blank\">路人王</a></li><li class=\"line\">|</li><li class=\"hp-dropDownMenu hp-moreNav\">\n" +
                "                                                <a href=\"javascript:void(0)\" class=\"hp-set\">更多<s class=\"setArrow\"></s></a>\n" +
                "                                                <div class=\"hp-drapDown hp-moreNav-drapDown\"><a href=\"https://shop311048929.taobao.com/\" target=\"_blank\">虎扑优选</a><a href=\"http://outdoor.hupu.com/\" >户外</a><a href=\"http://run.hupu.com/\" >健身</a><a href=\"http://ymq.hupu.com/\" >羽毛球</a><a href=\"http://xgame.hupu.com/\" target=\"_blank\">xgames</a><a href=\"http://www.nflchina.com/\" target=\"_blank\">NFL</a><s class=\"arrow-top\"><s class=\"arrowbd\"></s></s>\n" +
                "                                                </div>\n" +
                "                                            </li>\n" +
                "                                        </ul>\n" +
                "                                    </div>\n" +
                "                                </div>\n" +
                "                                <div class=\"hp-subNav\">\n" +
                "\t<ul class=\"hp-subNav-item\">\n" +
                "\t\t<li><a href=\"https://my.hupu.com/\">我的首页</a></li>\n" +
                "\t\t<li><a href=\"https://my.hupu.com/\" id=\"my-subNav-uid\">我的空间</a></li>\n" +
                "\t\t<li><a href=\"https://my.hupu.com/public/verified\">认证用户</a></li>\n" +
                "\t</ul>\n" +
                "</div>\n" +
                "\n" +
                "                                <i class=\"hp-roundPoint-br-tl roundPoint-br-tl\"></i>\n" +
                "                                <i class=\"hp-roundPoint-br-tr roundPoint-br-tr\"></i>\n" +
                "                                <i class=\"hp-roundPoint-br-bl roundPoint-br-bl\"></i>\n" +
                "                                <i class=\"hp-roundPoint-br-br roundPoint-br-br\"></i>\n" +
                "                            </div>\n" +
                "                        </div>\n" +
                "<div class=\"hp-wrap\"><div id=\"container\">\n" +
                "<div id=\"container_padd\">\n" +
                "<div id=\"sidenav\"><ul>\n" +
                "<li><a title=\"重新开始学走路\" href=\"/241006596043827\" >空间首页</a></li>\n" +
                "<li><a title=\"重新开始学走路的动态\" href=\"/241006596043827/playbyplay\" >动　　态</a></li>\n" +
                "<li><a title=\"重新开始学走路的日志\" href=\"/241006596043827/blog\" >日　　志</a></li>\n" +
                "<li><a title=\"重新开始学走路的碎碎念\" href=\"/241006596043827/note\" >碎 碎 念</a></li>\n" +
                "<li><a title=\"重新开始学走路的帖子\" href=\"/241006596043827/topic\" >帖　　子</a></li><li><a title=\"重新开始学走路推荐的内容\" href=\"/241006596043827/recs\" >推　　荐</a></li>\n" +
                "<li><a title=\"重新开始学走路的留言板\" href=\"/241006596043827/board\" >留 言 板</a></li>\n" +
                "<li><a title=\"重新开始学走路的档案\" href=\"/241006596043827/profile\" class=\"selected\">档　　案</a></li>\n" +
                "<li><a title=\"重新开始学走路关注的人\" href=\"/241006596043827/following\" >关　　注</a></li>\n" +
                "</ul></div><div id=\"content\">\n" +
                "<div id=\"headtop\"><a href=\"/241006596043827\" class=\"headpic\"><img src=\"https://i1.hoopchina.com.cn/user/default_small.jpg\" alt=\"重新开始学走路\" /></a>\n" +
                "<h1 class=\"t1\">重新开始学走路的档案</h1>\n" +
                "</div>\n" +
                "<h3>基本信息</h3>\n" +
                "<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"profile_table\">\n" +
                "  \t<tr>\n" +
                "\t<td class=\"a1\">性别：</td>\n" +
                "\t<td>保密</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "\t<td  class=\"a1\">所在地：</td>\n" +
                "\t<td>辽宁省 沈阳市</td>\n" +
                "  </tr>  <tr>\n" +
                "\t<td  class=\"a1\">论坛等级：</td>\n" +
                "\t<td>6</td>\n" +
                "   </tr>\n" +
                "    \t<tr>\n" +
                "\t<td  class=\"a1\">所属社团：</td>\n" +
                "\t<td>hooper</td>\n" +
                "   </tr>      <tr>\n" +
                "\t<td  class=\"a1\">银行现金：</td>\n" +
                "\t<td>10卡路里</td>\n" +
                "   </tr>\n" +
                "   <tr>\n" +
                "\t<td  class=\"a1\">在线时间：</td>\n" +
                "\t<td>30小时</td>\n" +
                "   </tr>\n" +
                "   <tr>\n" +
                "\t<td  class=\"a1\">注册时间：</td>\n" +
                "\t<td>2017-04-23</td>\n" +
                "   </tr>   \n" +
                "   <tr>\n" +
                "\t<td  class=\"a1\">最后登录：</td>\n" +
                "\t<td>2020-03-31</td>\n" +
                "   </tr>\n" +
                "</table>\n" +
                "<h3>个人兴趣</h3>\n" +
                "<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"profile_table\">\n" +
                "  <tr>\n" +
                "\t<td class=\"a1\">喜欢的运动：</td>\n" +
                "\t<td></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "\t<td class=\"a1\">喜欢的联赛：</td>\n" +
                "\t<td></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "\t<td class=\"a1\">喜欢的队伍：</td>\n" +
                "\t<td></td>\n" +
                "  </tr>\n" +
                "  \n" +
                "</table>\n" +
                "</div>\n" +
                "<div class=\"clearfix\"></div>\n" +
                "</div></div>\n" +
                "<div class=\"f_re\"><div class=\"rr_port\"><a class=\"r_port\" href=\"/report.php\" onclick=\"report(4);return false;\" target=\"_blank\">举报本页不良内容&raquo;</a></div></div></div>\n" +
                "</div>\n" +
                "<div class=\"hp-w\">\n" +
                "\t<div class=\"fback\"><a class=\"btop\" href=\"#\">回顶部</a></div>\n" +
                "\t<b id=\"footer-loadedError\"></b>\n" +
                "</div>\n" +
                "<div class=\"hp-footer\">\n" +
                "                    \n" +
                "                    <div class=\"hp-copyright\">\n" +
                "                    \n" +
                "                    Copyright by 虎扑JRs &amp;\n" +
                "                    <a href=\"https://www.hupu.com/\" target=\"_blank\" title=\"虎扑\">虎扑</a> -\n" +
                "                    <a href=\"https://m.hupu.com/\" target=\"_blank\">手机虎扑网</a> -\n" +
                "                    <a href=\"https://mobile.hupu.com/\" target=\"_blank\">虎扑App</a> -\n" +
                "                    <a href=\"https://www.hupu.com/policies/terms\" target=\"_blank\">服务协议</a> -\n" +
                "                    <a href=\"https://www.hupu.com/sitemap.html\" target=\"_blank\">网站地图</a> -\n" +
                "                    <a href=\"https://nba.hupu.com/\" target=\"_blank\" title=\"NBA\">NBA</a> -\n" +
                "                    <a href=\"https://cba.hupu.com/\" target=\"_blank\" title=\"CBA\">CBA</a>  -\n" +
                "                    <a href=\"https://soccer.hupu.com/\" target=\"_blank\" title=\"足球\">足球</a> -\n" +
                "                    <a href=\"https://soccer.hupu.com/china/\" target=\"_blank\" title=\"中超\">中超</a>\n" +
                "                    </div>\n" +
                "                    \n" +
                "                </div>\n" +
                "<script>\n" +
                "var commonProject = \"basketball\";\n" +
                "\n" +
                "_common.init({project: commonProject,countGATrackPageview: (location.pathname+location.search + '|' + commonProject),countGASetVar: ''});\n" +
                "\n" +
                "</script>\n" +
                "<script async=\"true\" src=\"//b3.hoopchina.com.cn/pcbbs/js/g85.js?20180313\"></script>\n" +
                "<div id=\"user_info\" style=\"display: none\" safety=\"\"></div>\n" +
                "</body>\n" +
                "</html>");
        Elements userTable = doc.select(".profile_table");
        for (Element details : userTable) {
            Elements elements = details.select(".a1");
            String name = doc.select("#headtop").text();
            HupuUser hupuUser = new HupuUser();
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
            System.out.println(hupuUser);
        }
    }

    @Test
    public void parseFollower() throws IOException {
        String html = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
                "<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\" />\n" +
                "<meta name=\"renderer\" content=\"webkit\" />\n" +
                "<meta http-equiv=\"Cache-Control\" content=\"no-transform\" />\n" +
                "<meta http-equiv=\"Cache-Control\" content=\"no-siteapp\" />\n" +
                "<link rel=\"dns-prefetch\" href=\"//b1.hoopchina.com.cn\"/>\n" +
                "<link rel=\"dns-prefetch\" href=\"//b3.hoopchina.com.cn\"/>\n" +
                "<script type='text/javascript'>var __daceDataNameOfForum='0';var __daceDataNameOfCategory = '0'; var __daceDataNameOfProject='hupu';var __daceDataNameOfChannel='';</script>\n" +
                "<meta name=\"apple-itunes-app\" content=\"app-id=906632439\" />\n" +
                "<link rel=\"shortcut icon\" href=\"//w1.hoopchina.com.cn/images/pc/old/favicon.ico\" />\n" +
                "<link type=\"text/css\" rel=\"stylesheet\" href=\"//b3.hoopchina.com.cn/common/common-v1.css\" />\n" +
                "<script src=\"//b3.hoopchina.com.cn/web/module/dace/1.0.0/dace.js\"></script> \n" +
                "<script src=\"//b3.hoopchina.com.cn/common/common-v1.js\"></script>\n" +
                "<link rel='stylesheet' type='text/css' href='//b3.hoopchina.com.cn/css/hupu-v56.css?2018122221' />\n" +
                "<link rel='apple-touch-icon' href='https://b1.hoopchina.com.cn/common/apple-touch-icon.png'/>\n" +
                "<script type=\"text/javascript\" src=\"//b1.hoopchina.com.cn/pcbbs/js/j15.js\"></script>\n" +
                "</head>\n" +
                "<body>\n" +
                "<!--topbarNav star-->\n" +
                "                        <div id=\"hp-topbarNav\">\n" +
                "                            <div class=\"hp-topbarNav-bd\">\n" +
                "                                <ul class=\"hp-quickNav\">\n" +
                "                                    <li class=\"mobileWeb\"><a href=\"javascript:void(0)\" onclick=\"hp_quick_touch()\"><i class=\"ico-mobile\"></i>手机虎扑</a></li>\n" +
                "                                    <li class=\"line\">|</li>\n" +
                "                                    <li class=\"mobileclientDown\"><a class=\"red\" href=\"https://mobile.hupu.com/?_r=globalNav\" target=\"_blank\">虎扑客户端</a></li>\n" +
                "                                    <li class=\"line\">|</li>\n" +
                "                                    <li class=\"hp-dropDownMenu topFollowBlog\">\n" +
                "                                        <a href=\"javascript:void(0)\" class=\"hp-set\">关注虎扑<s class=\"setArrow\"></s></a>\n" +
                "                                        <div class=\"hp-drapDown followLayer\">\n" +
                "                                            <a class=\"weibo\" target=\"_blank\" rel=\"nofollow\" href=\"//weibo.com/liangle4u\"><i class=\"hp-ico-weibo\"></i>新浪微博</a>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<a class=\"weixin\" target=\"_blank\" href=\"https://voice.hupu.com/other/1581560.html\"><i class=\"hp-ico-weixin\"></i>官方微信</a>\n" +
                "                                            <a class=\"instagram\" target=\"_blank\" rel=\"nofollow\" href=\"https://voice.hupu.com/other/1634334.html\"><i class=\"hp-ico-instagram\"></i>Instagram</a>\n" +
                "                                        </div>\n" +
                "                                    </li>\n" +
                "                                </ul>\n" +
                "                                <div class=\"hp-topLogin-info\"></div>\n" +
                "                            </div>\n" +
                "                        </div>\n" +
                "                        <!--topbarNav ent--><!--header star--><div class=\"hp-header hp-header-B\"><div class=\"hp-logo\" style=\"width:60px;\"><a title=\"空间\" href=\"https://my.hupu.com/\"><img src=\"https://w1.hoopchina.com.cn/images/pc/old/hp_logo_sports.png\" alt=\"空间\" width=\"60px\" height=\"50px\"/></a>\n" +
                "                            </div>\n" +
                "                            <div class=\"hp-mainNav hp-mainNav-B\" style=\"margin-left:80px;\">\n" +
                "                                <div class=\"hp-nav\">\n" +
                "                                    <div class=\"hp-nav-bd\">\n" +
                "                                        <ul class=\"hp-nav-item\"><li><a href=\"https://www.hupu.com/\" >虎扑首页</a></li><li class=\"line\">|</li><li><a href=\"https://nba.hupu.com/\" >NBA</a></li><li class=\"line\">|</li><li><a href=\"https://cba.hupu.com/\" >CBA</a></li><li class=\"line\">|</li><li><a href=\"https://gg.hupu.com\" >电竞</a></li><li class=\"line\">|</li><li><a href=\"https://soccer.hupu.com\" >国际足球</a></li><li class=\"line\">|</li><li><a href=\"https://soccer.hupu.com/china/\" >中国足球</a></li><li class=\"line\">|</li><li><a href=\"http://zb.hupu.com/\" target=\"_blank\">装备</a></li><li class=\"line\">|</li><li><a href=\"http://www.shihuo.cn/\" target=\"_blank\">识货</a></li><li class=\"line\">|</li><li><a href=\"https://bbs.hupu.com/\" >社区</a></li><li class=\"line\">|</li><li><a href=\"https://bbs.hupu.com/all-gambia\" >步行街</a></li><li class=\"line\">|</li><li class=\"on\"><a href=\"https://my.hupu.com/\" target=\"_blank\">空间</a></li><li class=\"line\">|</li><li><a href=\"http://www.liangle.com\" target=\"_blank\">路人王</a></li><li class=\"line\">|</li><li class=\"hp-dropDownMenu hp-moreNav\">\n" +
                "                                                <a href=\"javascript:void(0)\" class=\"hp-set\">更多<s class=\"setArrow\"></s></a>\n" +
                "                                                <div class=\"hp-drapDown hp-moreNav-drapDown\"><a href=\"https://shop311048929.taobao.com/\" target=\"_blank\">虎扑优选</a><a href=\"http://outdoor.hupu.com/\" >户外</a><a href=\"http://run.hupu.com/\" >健身</a><a href=\"http://ymq.hupu.com/\" >羽毛球</a><a href=\"http://xgame.hupu.com/\" target=\"_blank\">xgames</a><a href=\"http://www.nflchina.com/\" target=\"_blank\">NFL</a><s class=\"arrow-top\"><s class=\"arrowbd\"></s></s>\n" +
                "                                                </div>\n" +
                "                                            </li>\n" +
                "                                        </ul>\n" +
                "                                    </div>\n" +
                "                                </div>\n" +
                "                                <div class=\"hp-subNav\">\n" +
                "\t<ul class=\"hp-subNav-item\">\n" +
                "\t\t<li><a href=\"https://my.hupu.com/\">我的首页</a></li>\n" +
                "\t\t<li><a href=\"https://my.hupu.com/\" id=\"my-subNav-uid\">我的空间</a></li>\n" +
                "\t\t<li><a href=\"https://my.hupu.com/public/verified\">认证用户</a></li>\n" +
                "\t</ul>\n" +
                "</div>\n" +
                "\n" +
                "                                <i class=\"hp-roundPoint-br-tl roundPoint-br-tl\"></i>\n" +
                "                                <i class=\"hp-roundPoint-br-tr roundPoint-br-tr\"></i>\n" +
                "                                <i class=\"hp-roundPoint-br-bl roundPoint-br-bl\"></i>\n" +
                "                                <i class=\"hp-roundPoint-br-br roundPoint-br-br\"></i>\n" +
                "                            </div>\n" +
                "                        </div>\n" +
                "<div class=\"hp-wrap\"><script src=\"https://b1.hoopchina.com.cn/pcbbs/js/friend7.js\"></script>\n" +
                "<div id=\"container\">\n" +
                "<div id=\"container_padd\">\n" +
                "<div id=\"sidenav\"><ul>\n" +
                "<li><a title=\"川骚258\" href=\"/96258335640997\" >空间首页</a></li>\n" +
                "<li><a title=\"川骚258的动态\" href=\"/96258335640997/playbyplay\" >动　　态</a></li>\n" +
                "<li><a title=\"川骚258的日志\" href=\"/96258335640997/blog\" >日　　志</a></li>\n" +
                "<li><a title=\"川骚258的碎碎念\" href=\"/96258335640997/note\" >碎 碎 念</a></li>\n" +
                "<li><a title=\"川骚258的帖子\" href=\"/96258335640997/topic\" >帖　　子</a></li><li><a title=\"川骚258推荐的内容\" href=\"/96258335640997/recs\" >推　　荐</a></li>\n" +
                "<li><a title=\"川骚258的留言板\" href=\"/96258335640997/board\" >留 言 板</a></li>\n" +
                "<li><a title=\"川骚258的档案\" href=\"/96258335640997/profile\" >档　　案</a></li>\n" +
                "<li><a title=\"川骚258关注的人\" href=\"/96258335640997/following\" class=\"selected\">关　　注</a></li>\n" +
                "</ul></div><div id=\"content\">\n" +
                "<div id=\"headtop\"><a href=\"/96258335640997\" class=\"headpic\"><img src=\"https://i3.hoopchina.com.cn/user/header/20180726/153260539773863_small_2.jpg\" alt=\"川骚258\" /></a><h1 class=\"t1\">川骚258的粉丝 (关注川骚258的人)</h1></div>\n" +
                "<div class=\"friend\">\n" +
                "<div class=\"tabs_header\">\n" +
                "<p class=\"right\"><input name=\"Input\" type=\"text\" class=\"tabs_input\" title=\"搜索成员用户名\" onfocus=\"searchUsername()\" value=\"搜索成员用户名\" id=\"searchuser\"/><input name=\"Input2\" type=\"button\" class=\"tabs_btn\" onclick=\"search_user()\"/></p>\n" +
                "<ul>\n" +
                "<li><a href=\"/96258335640997/following\"><span>关注 (1)</span></a></li>\n" +
                "<li class=\"selected\"><a href=\"/96258335640997/follower\"><span>粉丝 (28144)</span></a></li>\n" +
                "</ul>\n" +
                "<div class=\"tabs_border\"></div>\n" +
                "</div>\n" +
                " \n" +
                "<div class=\"search_user_list index_bbs\">\n" +
                "<h4></h4>\n" +
                "<ul>\n" +
                "\t\t<li id=\"buddyid_\"  class=\"bgcolor\" >\n" +
                "\t\t<div class=\"contact_item\">\n" +
                "\t\t\t<p class=\"user_pic\"><a class=\"headpic\" target=\"_blank\" href=\"https://my.hupu.com/149484065057995\"><img alt=\"我想进国足\" src=\"https://i2.hoopchina.com.cn/user/995/149484065057995/149484065057995-1571743690.jpeg@45h_45w_2e\" width=\"45\" height=\"45\" /></a></p>\n" +
                "\t\t\t<div class=\"contact_item_main\"> <strong><a class=\"u\" target=\"_blank\" href=\"https://my.hupu.com/149484065057995\">我想进国足</a></strong><span> 　男 　山东省,淄博市</span> \n" +
                "\t\t\t\t<p class=\"brief\">\n" +
                "\t\t\t\t\t<span class=\"f444\">和我的共同兴趣：暂无</span><br/>\t\t\t\t</p>\n" +
                "\t\t    </div>\n" +
                "\t\t\t<div class=\"acts\">\n" +
                "\t\t\t\t<ul>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<li><span id=\"attend_\"><a class=\"blue\" href=\"javascript:;\" title=\"关注我想进国足\" onclick=\"attend();\">关注此人</a></span></li>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t</ul>\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t</li>\n" +
                "\t\t<li id=\"buddyid_\" >\n" +
                "\t\t<div class=\"contact_item\">\n" +
                "\t\t\t<p class=\"user_pic\"><a class=\"headpic\" target=\"_blank\" href=\"https://my.hupu.com/227860650160615\"><img alt=\"帅气的怪蜀黍\" src=\"https://i1.hoopchina.com.cn/user/615/227860650160615/227860650160615-1530844025.jpg@45h_45w_2e\" width=\"45\" height=\"45\" /></a></p>\n" +
                "\t\t\t<div class=\"contact_item_main\"> <strong><a class=\"u\" target=\"_blank\" href=\"https://my.hupu.com/227860650160615\">帅气的怪蜀黍</a></strong><span> 　 　地球</span> \n" +
                "\t\t\t\t<p class=\"brief\">\n" +
                "\t\t\t\t\t<span class=\"f444\">和我的共同兴趣：暂无</span><br/>\t\t\t\t</p>\n" +
                "\t\t    </div>\n" +
                "\t\t\t<div class=\"acts\">\n" +
                "\t\t\t\t<ul>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<li><span id=\"attend_\"><a class=\"blue\" href=\"javascript:;\" title=\"关注帅气的怪蜀黍\" onclick=\"attend();\">关注此人</a></span></li>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t</ul>\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t</li>\n" +
                "\t\t<li id=\"buddyid_\"  class=\"bgcolor\" >\n" +
                "\t\t<div class=\"contact_item\">\n" +
                "\t\t\t<p class=\"user_pic\"><a class=\"headpic\" target=\"_blank\" href=\"https://my.hupu.com/10901421765450\"><img alt=\"许小霖\" src=\"https://i2.hoopchina.com.cn/user/187/14520187/14520187-1493864425.jpg@45h_45w_2e\" width=\"45\" height=\"45\" /></a></p>\n" +
                "\t\t\t<div class=\"contact_item_main\"> <strong><a class=\"u\" target=\"_blank\" href=\"https://my.hupu.com/10901421765450\">许小霖</a></strong><span> 　男 　辽宁省,沈阳市</span> \n" +
                "\t\t\t\t<p class=\"brief\">\n" +
                "\t\t\t\t\t<span class=\"f444\">和我的共同兴趣：暂无</span><br/>\t\t\t\t</p>\n" +
                "\t\t    </div>\n" +
                "\t\t\t<div class=\"acts\">\n" +
                "\t\t\t\t<ul>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<li><span id=\"attend_\"><a class=\"blue\" href=\"javascript:;\" title=\"关注许小霖\" onclick=\"attend();\">关注此人</a></span></li>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t</ul>\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t</li>\n" +
                "\t\t<li id=\"buddyid_\" >\n" +
                "\t\t<div class=\"contact_item\">\n" +
                "\t\t\t<p class=\"user_pic\"><a class=\"headpic\" target=\"_blank\" href=\"https://my.hupu.com/141899997009298\"><img alt=\"Uanyan\" src=\"https://i3.hoopchina.com.cn/user/298/141899997009298/141899997009298-1532513669.jpeg@45h_45w_2e\" width=\"45\" height=\"45\" /></a></p>\n" +
                "\t\t\t<div class=\"contact_item_main\"> <strong><a class=\"u\" target=\"_blank\" href=\"https://my.hupu.com/141899997009298\">Uanyan</a></strong><span> 　 　</span> \n" +
                "\t\t\t\t<p class=\"brief\">\n" +
                "\t\t\t\t\t<span class=\"f444\">和我的共同兴趣：暂无</span><br/>\t\t\t\t</p>\n" +
                "\t\t    </div>\n" +
                "\t\t\t<div class=\"acts\">\n" +
                "\t\t\t\t<ul>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<li><span id=\"attend_\"><a class=\"blue\" href=\"javascript:;\" title=\"关注Uanyan\" onclick=\"attend();\">关注此人</a></span></li>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t</ul>\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t</li>\n" +
                "\t\t<li id=\"buddyid_\"  class=\"bgcolor\" >\n" +
                "\t\t<div class=\"contact_item\">\n" +
                "\t\t\t<p class=\"user_pic\"><a class=\"headpic\" target=\"_blank\" href=\"https://my.hupu.com/28793345840150\"><img alt=\"虎扑JR0892276606\" src=\"https://w1.hoopchina.com.cn/games/images/man_pic.png\" width=\"45\" height=\"45\" /></a></p>\n" +
                "\t\t\t<div class=\"contact_item_main\"> <strong><a class=\"u\" target=\"_blank\" href=\"https://my.hupu.com/28793345840150\">虎扑JR0892276606</a></strong><span> 　 　</span> \n" +
                "\t\t\t\t<p class=\"brief\">\n" +
                "\t\t\t\t\t<span class=\"f444\">和我的共同兴趣：暂无</span><br/>\t\t\t\t</p>\n" +
                "\t\t    </div>\n" +
                "\t\t\t<div class=\"acts\">\n" +
                "\t\t\t\t<ul>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<li><span id=\"attend_\"><a class=\"blue\" href=\"javascript:;\" title=\"关注虎扑JR0892276606\" onclick=\"attend();\">关注此人</a></span></li>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t</ul>\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t</li>\n" +
                "\t\t<li id=\"buddyid_\" >\n" +
                "\t\t<div class=\"contact_item\">\n" +
                "\t\t\t<p class=\"user_pic\"><a class=\"headpic\" target=\"_blank\" href=\"https://my.hupu.com/91283392757786\"><img alt=\"无畏铲车戴JAVA\" src=\"https://i1.hoopchina.com.cn/user/786/91283392757786/91283392757786-1591903741.jpg@45h_45w_2e\" width=\"45\" height=\"45\" /></a></p>\n" +
                "\t\t\t<div class=\"contact_item_main\"> <strong><a class=\"u\" target=\"_blank\" href=\"https://my.hupu.com/91283392757786\">无畏铲车戴JAVA</a></strong><span> 　男 　浙江省 宁波市</span> \n" +
                "\t\t\t\t<p class=\"brief\">\n" +
                "\t\t\t\t\t<span class=\"f444\">和我的共同兴趣：暂无</span><br/>\t\t\t\t</p>\n" +
                "\t\t    </div>\n" +
                "\t\t\t<div class=\"acts\">\n" +
                "\t\t\t\t<ul>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<li><span id=\"attend_\"><a class=\"blue\" href=\"javascript:;\" title=\"关注无畏铲车戴JAVA\" onclick=\"attend();\">关注此人</a></span></li>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t</ul>\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t</li>\n" +
                "\t\t<li id=\"buddyid_\"  class=\"bgcolor\" >\n" +
                "\t\t<div class=\"contact_item\">\n" +
                "\t\t\t<p class=\"user_pic\"><a class=\"headpic\" target=\"_blank\" href=\"https://my.hupu.com/crownyoung0303\"><img alt=\"oCROWNo\" src=\"https://i1.hoopchina.com.cn/user/996/200452864115996/200452864115996-1530536053.jpg@45h_45w_2e\" width=\"45\" height=\"45\" /></a></p>\n" +
                "\t\t\t<div class=\"contact_item_main\"> <strong><a class=\"u\" target=\"_blank\" href=\"https://my.hupu.com/crownyoung0303\">oCROWNo</a></strong><span> 　男 　广东省 广州市</span> \n" +
                "\t\t\t\t<p class=\"brief\">\n" +
                "\t\t\t\t\t<span class=\"f444\">和我的共同兴趣：暂无</span><br/>\t\t\t\t</p>\n" +
                "\t\t    </div>\n" +
                "\t\t\t<div class=\"acts\">\n" +
                "\t\t\t\t<ul>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<li><span id=\"attend_\"><a class=\"blue\" href=\"javascript:;\" title=\"关注oCROWNo\" onclick=\"attend();\">关注此人</a></span></li>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t</ul>\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t</li>\n" +
                "\t\t<li id=\"buddyid_\" >\n" +
                "\t\t<div class=\"contact_item\">\n" +
                "\t\t\t<p class=\"user_pic\"><a class=\"headpic\" target=\"_blank\" href=\"https://my.hupu.com/237390042893306\"><img alt=\"虎扑JR1019333236\" src=\"https://w1.hoopchina.com.cn/games/images/man_pic.png\" width=\"45\" height=\"45\" /></a></p>\n" +
                "\t\t\t<div class=\"contact_item_main\"> <strong><a class=\"u\" target=\"_blank\" href=\"https://my.hupu.com/237390042893306\">虎扑JR1019333236</a></strong><span> 　 　</span> \n" +
                "\t\t\t\t<p class=\"brief\">\n" +
                "\t\t\t\t\t<span class=\"f444\">和我的共同兴趣：暂无</span><br/>\t\t\t\t</p>\n" +
                "\t\t    </div>\n" +
                "\t\t\t<div class=\"acts\">\n" +
                "\t\t\t\t<ul>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<li><span id=\"attend_\"><a class=\"blue\" href=\"javascript:;\" title=\"关注虎扑JR1019333236\" onclick=\"attend();\">关注此人</a></span></li>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t</ul>\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t</li>\n" +
                "\t\t<li id=\"buddyid_\"  class=\"bgcolor\" >\n" +
                "\t\t<div class=\"contact_item\">\n" +
                "\t\t\t<p class=\"user_pic\"><a class=\"headpic\" target=\"_blank\" href=\"https://my.hupu.com/152285266163020\"><img alt=\"教小简闪现\" src=\"https://i2.hoopchina.com.cn/user/20/152285266163020/152285266163020-1567477349.jpeg@45h_45w_2e\" width=\"45\" height=\"45\" /></a></p>\n" +
                "\t\t\t<div class=\"contact_item_main\"> <strong><a class=\"u\" target=\"_blank\" href=\"https://my.hupu.com/152285266163020\">教小简闪现</a></strong><span> 　 　</span> \n" +
                "\t\t\t\t<p class=\"brief\">\n" +
                "\t\t\t\t\t<span class=\"f444\">和我的共同兴趣：暂无</span><br/>\t\t\t\t</p>\n" +
                "\t\t    </div>\n" +
                "\t\t\t<div class=\"acts\">\n" +
                "\t\t\t\t<ul>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<li><span id=\"attend_\"><a class=\"blue\" href=\"javascript:;\" title=\"关注教小简闪现\" onclick=\"attend();\">关注此人</a></span></li>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t</ul>\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t</li>\n" +
                "\t\t<li id=\"buddyid_\" >\n" +
                "\t\t<div class=\"contact_item\">\n" +
                "\t\t\t<p class=\"user_pic\"><a class=\"headpic\" target=\"_blank\" href=\"https://my.hupu.com/7627279870224\"><img alt=\"威野猪骑士少\" src=\"https://w1.hoopchina.com.cn/games/images/man_pic.png\" width=\"45\" height=\"45\" /></a></p>\n" +
                "\t\t\t<div class=\"contact_item_main\"> <strong><a class=\"u\" target=\"_blank\" href=\"https://my.hupu.com/7627279870224\">威野猪骑士少</a></strong><span> 　 　</span> \n" +
                "\t\t\t\t<p class=\"brief\">\n" +
                "\t\t\t\t\t<span class=\"f444\">和我的共同兴趣：暂无</span><br/>\t\t\t\t</p>\n" +
                "\t\t    </div>\n" +
                "\t\t\t<div class=\"acts\">\n" +
                "\t\t\t\t<ul>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<li><span id=\"attend_\"><a class=\"blue\" href=\"javascript:;\" title=\"关注威野猪骑士少\" onclick=\"attend();\">关注此人</a></span></li>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t</ul>\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t</li>\n" +
                "\t\t<li id=\"buddyid_\"  class=\"bgcolor\" >\n" +
                "\t\t<div class=\"contact_item\">\n" +
                "\t\t\t<p class=\"user_pic\"><a class=\"headpic\" target=\"_blank\" href=\"https://my.hupu.com/69298593993713\"><img alt=\"吃巧乐滋的小红帽\" src=\"https://i3.hoopchina.com.cn/user/713/69298593993713/69298593993713-1578280656.jpg@45h_45w_2e\" width=\"45\" height=\"45\" /></a></p>\n" +
                "\t\t\t<div class=\"contact_item_main\"> <strong><a class=\"u\" target=\"_blank\" href=\"https://my.hupu.com/69298593993713\">吃巧乐滋的小红帽</a></strong><span> 　男 　湖南省 长沙市</span> \n" +
                "\t\t\t\t<p class=\"brief\">\n" +
                "\t\t\t\t\t<span class=\"f444\">和我的共同兴趣：暂无</span><br/>\t\t\t\t</p>\n" +
                "\t\t    </div>\n" +
                "\t\t\t<div class=\"acts\">\n" +
                "\t\t\t\t<ul>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<li><span id=\"attend_\"><a class=\"blue\" href=\"javascript:;\" title=\"关注吃巧乐滋的小红帽\" onclick=\"attend();\">关注此人</a></span></li>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t</ul>\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t</li>\n" +
                "\t\t<li id=\"buddyid_\" >\n" +
                "\t\t<div class=\"contact_item\">\n" +
                "\t\t\t<p class=\"user_pic\"><a class=\"headpic\" target=\"_blank\" href=\"https://my.hupu.com/248175964680427\"><img alt=\"犹望一稔\" src=\"https://i2.hoopchina.com.cn/user/427/248175964680427/248175964680427-1595301762.jpeg@45h_45w_2e\" width=\"45\" height=\"45\" /></a></p>\n" +
                "\t\t\t<div class=\"contact_item_main\"> <strong><a class=\"u\" target=\"_blank\" href=\"https://my.hupu.com/248175964680427\">犹望一稔</a></strong><span> 　 　</span> \n" +
                "\t\t\t\t<p class=\"brief\">\n" +
                "\t\t\t\t\t<span class=\"f444\">和我的共同兴趣：暂无</span><br/>\t\t\t\t</p>\n" +
                "\t\t    </div>\n" +
                "\t\t\t<div class=\"acts\">\n" +
                "\t\t\t\t<ul>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<li><span id=\"attend_\"><a class=\"blue\" href=\"javascript:;\" title=\"关注犹望一稔\" onclick=\"attend();\">关注此人</a></span></li>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t</ul>\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t</li>\n" +
                "\t\t<li id=\"buddyid_\"  class=\"bgcolor\" >\n" +
                "\t\t<div class=\"contact_item\">\n" +
                "\t\t\t<p class=\"user_pic\"><a class=\"headpic\" target=\"_blank\" href=\"https://my.hupu.com/13231474102114\"><img alt=\"虎扑JR0293827562\" src=\"https://w1.hoopchina.com.cn/games/images/man_pic.png\" width=\"45\" height=\"45\" /></a></p>\n" +
                "\t\t\t<div class=\"contact_item_main\"> <strong><a class=\"u\" target=\"_blank\" href=\"https://my.hupu.com/13231474102114\">虎扑JR0293827562</a></strong><span> 　 　</span> \n" +
                "\t\t\t\t<p class=\"brief\">\n" +
                "\t\t\t\t\t<span class=\"f444\">和我的共同兴趣：暂无</span><br/>\t\t\t\t</p>\n" +
                "\t\t    </div>\n" +
                "\t\t\t<div class=\"acts\">\n" +
                "\t\t\t\t<ul>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<li><span id=\"attend_\"><a class=\"blue\" href=\"javascript:;\" title=\"关注虎扑JR0293827562\" onclick=\"attend();\">关注此人</a></span></li>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t</ul>\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t</li>\n" +
                "\t\t<li id=\"buddyid_\" >\n" +
                "\t\t<div class=\"contact_item\">\n" +
                "\t\t\t<p class=\"user_pic\"><a class=\"headpic\" target=\"_blank\" href=\"https://my.hupu.com/18795367840623\"><img alt=\"哈登夺冠改名\" src=\"https://i2.hoopchina.com.cn/user/623/18795367840623/18795367840623-1563256199.jpg@45h_45w_2e\" width=\"45\" height=\"45\" /></a></p>\n" +
                "\t\t\t<div class=\"contact_item_main\"> <strong><a class=\"u\" target=\"_blank\" href=\"https://my.hupu.com/18795367840623\">哈登夺冠改名</a></strong><span> 　男 　河南省 信阳市</span> \n" +
                "\t\t\t\t<p class=\"brief\">\n" +
                "\t\t\t\t\t<span class=\"f444\">和我的共同兴趣：暂无</span><br/>\t\t\t\t</p>\n" +
                "\t\t    </div>\n" +
                "\t\t\t<div class=\"acts\">\n" +
                "\t\t\t\t<ul>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<li><span id=\"attend_\"><a class=\"blue\" href=\"javascript:;\" title=\"关注哈登夺冠改名\" onclick=\"attend();\">关注此人</a></span></li>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t</ul>\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t</li>\n" +
                "\t\t<li id=\"buddyid_\"  class=\"bgcolor\" >\n" +
                "\t\t<div class=\"contact_item\">\n" +
                "\t\t\t<p class=\"user_pic\"><a class=\"headpic\" target=\"_blank\" href=\"https://my.hupu.com/118313604058526\"><img alt=\"不透露姓名的我军名宿\" src=\"https://w1.hoopchina.com.cn/games/images/man_pic.png\" width=\"45\" height=\"45\" /></a></p>\n" +
                "\t\t\t<div class=\"contact_item_main\"> <strong><a class=\"u\" target=\"_blank\" href=\"https://my.hupu.com/118313604058526\">不透露姓名的我军名宿</a></strong><span> 　 　</span> \n" +
                "\t\t\t\t<p class=\"brief\">\n" +
                "\t\t\t\t\t<span class=\"f444\">和我的共同兴趣：暂无</span><br/>\t\t\t\t</p>\n" +
                "\t\t    </div>\n" +
                "\t\t\t<div class=\"acts\">\n" +
                "\t\t\t\t<ul>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<li><span id=\"attend_\"><a class=\"blue\" href=\"javascript:;\" title=\"关注不透露姓名的我军名宿\" onclick=\"attend();\">关注此人</a></span></li>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t</ul>\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t</li>\n" +
                "\t\t<li id=\"buddyid_\" >\n" +
                "\t\t<div class=\"contact_item\">\n" +
                "\t\t\t<p class=\"user_pic\"><a class=\"headpic\" target=\"_blank\" href=\"https://my.hupu.com/96378284242854\"><img alt=\"芭朵斯\" src=\"https://i3.hoopchina.com.cn/user/854/96378284242854/96378284242854-1585825612.jpg@45h_45w_2e\" width=\"45\" height=\"45\" /></a></p>\n" +
                "\t\t\t<div class=\"contact_item_main\"> <strong><a class=\"u\" target=\"_blank\" href=\"https://my.hupu.com/96378284242854\">芭朵斯</a></strong><span> 　 　四川省,宜宾市</span> \n" +
                "\t\t\t\t<p class=\"brief\">\n" +
                "\t\t\t\t\t<span class=\"f444\">和我的共同兴趣：暂无</span><br/>\t\t\t\t</p>\n" +
                "\t\t    </div>\n" +
                "\t\t\t<div class=\"acts\">\n" +
                "\t\t\t\t<ul>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<li><span id=\"attend_\"><a class=\"blue\" href=\"javascript:;\" title=\"关注芭朵斯\" onclick=\"attend();\">关注此人</a></span></li>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t</ul>\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t</li>\n" +
                "\t\t<li id=\"buddyid_\"  class=\"bgcolor\" >\n" +
                "\t\t<div class=\"contact_item\">\n" +
                "\t\t\t<p class=\"user_pic\"><a class=\"headpic\" target=\"_blank\" href=\"https://my.hupu.com/16451119356599\"><img alt=\"虎扑JR1381730883\" src=\"https://w1.hoopchina.com.cn/games/images/man_pic.png\" width=\"45\" height=\"45\" /></a></p>\n" +
                "\t\t\t<div class=\"contact_item_main\"> <strong><a class=\"u\" target=\"_blank\" href=\"https://my.hupu.com/16451119356599\">虎扑JR1381730883</a></strong><span> 　 　</span> \n" +
                "\t\t\t\t<p class=\"brief\">\n" +
                "\t\t\t\t\t<span class=\"f444\">和我的共同兴趣：暂无</span><br/>\t\t\t\t</p>\n" +
                "\t\t    </div>\n" +
                "\t\t\t<div class=\"acts\">\n" +
                "\t\t\t\t<ul>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<li><span id=\"attend_\"><a class=\"blue\" href=\"javascript:;\" title=\"关注虎扑JR1381730883\" onclick=\"attend();\">关注此人</a></span></li>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t</ul>\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t</li>\n" +
                "\t\t<li id=\"buddyid_\" >\n" +
                "\t\t<div class=\"contact_item\">\n" +
                "\t\t\t<p class=\"user_pic\"><a class=\"headpic\" target=\"_blank\" href=\"https://my.hupu.com/162017314078278\"><img alt=\"想听单身情歌\" src=\"https://i1.hoopchina.com.cn/user/278/162017314078278/162017314078278-1587609842.jpg@45h_45w_2e\" width=\"45\" height=\"45\" /></a></p>\n" +
                "\t\t\t<div class=\"contact_item_main\"> <strong><a class=\"u\" target=\"_blank\" href=\"https://my.hupu.com/162017314078278\">想听单身情歌</a></strong><span> 　男 　河北省 唐山市</span> \n" +
                "\t\t\t\t<p class=\"brief\">\n" +
                "\t\t\t\t\t<span class=\"f444\">和我的共同兴趣：暂无</span><br/>\t\t\t\t</p>\n" +
                "\t\t    </div>\n" +
                "\t\t\t<div class=\"acts\">\n" +
                "\t\t\t\t<ul>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<li><span id=\"attend_\"><a class=\"blue\" href=\"javascript:;\" title=\"关注想听单身情歌\" onclick=\"attend();\">关注此人</a></span></li>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t</ul>\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t</li>\n" +
                "\t\t<li id=\"buddyid_\"  class=\"bgcolor\" >\n" +
                "\t\t<div class=\"contact_item\">\n" +
                "\t\t\t<p class=\"user_pic\"><a class=\"headpic\" target=\"_blank\" href=\"https://my.hupu.com/112422464679344\"><img alt=\"Wavinflags\" src=\"https://i2.hoopchina.com.cn/user/344/112422464679344/112422464679344-1598176442.jpg@45h_45w_2e\" width=\"45\" height=\"45\" /></a></p>\n" +
                "\t\t\t<div class=\"contact_item_main\"> <strong><a class=\"u\" target=\"_blank\" href=\"https://my.hupu.com/112422464679344\">Wavinflags</a></strong><span> 　男 　广东省 佛山市</span> \n" +
                "\t\t\t\t<p class=\"brief\">\n" +
                "\t\t\t\t\t<span class=\"f444\">和我的共同兴趣：暂无</span><br/>\t\t\t\t</p>\n" +
                "\t\t    </div>\n" +
                "\t\t\t<div class=\"acts\">\n" +
                "\t\t\t\t<ul>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<li><span id=\"attend_\"><a class=\"blue\" href=\"javascript:;\" title=\"关注Wavinflags\" onclick=\"attend();\">关注此人</a></span></li>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t</ul>\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t</li>\n" +
                "\t</ul>\n" +
                "</div> \n" +
                "<div class=\"page\"><span class=\"right\"><span class=\"selected\">1</span><a href=\"/96258335640997/follower?page=2\">2</a><a href=\"/96258335640997/follower?page=3\">3</a>...<a href=\"/96258335640997/follower?page=1408\">1408</a><input title=\"输入页码数，回车即可到达指定页码\" onkeydown=\"javascript:if(event.keyCode==13) {location='/96258335640997/follower?page='+this.value;return false;}\" type=\"text\" /><a id=\"j_next\" class=\"next\" href=\"/96258335640997/follower?page=2\">下一页&raquo;</a></span>共28146人</div>\n" +
                "</div>\n" +
                "  </div>\n" +
                "<div class=\"clearfix\"></div>\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "<div class=\"pop\" id=\"addfriend\" style=\"display:none; width:402px;\" ><div class=\"pop_content\"><div class=\"pop_border\"><h2 class=\"mpop\"><a onclick=\"closepop();\" title=\"关闭\"></a><span id=\"addfriend_uname\"></span></h2><ul class=\"album_create\">\n" +
                "<form name=\"addfriend\" method=\"post\" action=\"\"><li><em class=\"friendadd\">请求加为好友的验证词：</em><span><textarea name=\"fmsgs\" id=\"fmsgs\" cols=\"25\" rows=\"5\"></textarea></span></li><li class=\"addact\"><em></em><input name=\"\" type=\"button\" class=\"btns2\" value=\"提 交\" onclick=\"addfriend2()\" />&nbsp;&nbsp;&nbsp;&nbsp;<input name=\"\" type=\"button\" class=\"btnb2\" value=\"取 消\" onclick=\"closepop();\" /><input type=\"hidden\" id=\"buddyid\"></li></form>\n" +
                "</ul></div></div></div>\n" +
                "<script>\n" +
                "\n" +
                "\n" +
                "var isIE = navigator.userAgent.indexOf(\"MSIE\")>0;\n" +
                "//创建事件的通用函数\n" +
                "var EventUtil = function(){};\n" +
                "EventUtil.winWidth   = 0;\n" +
                "EventUtil.winHeight = 0;\n" +
                "EventUtil.addEventHandler = function(obj,EventType,Handler)\n" +
                "{\n" +
                "\t//如果是FF\n" +
                "\tif(obj.addEventListener)\n" +
                "\t{\n" +
                "\t   obj.addEventListener(EventType,Handler,false);\n" +
                "\t}\n" +
                "\t//如果是IE\n" +
                "\telse if(obj.attachEvent)\n" +
                "\t{\n" +
                "\t   obj.attachEvent('on'+EventType,Handler);\n" +
                "\t}\n" +
                "\telse\n" +
                "\t{\n" +
                "\t   obj['on'+EventType] = Handler;\n" +
                "\t}\n" +
                "}\n" +
                "\n" +
                "/**\n" +
                "* @deprecated 获取浏览器 Event 事件\n" +
                "* @return evt\n" +
                "*/\n" +
                "EventUtil.getEvent = function (evt)\n" +
                "{\n" +
                "\treturn (evt ? evt : (window.event ? window.event : EventUtil.getEvent.caller.arguments[0]));\n" +
                "}\n" +
                "\n" +
                "\n" +
                "$(\"#searchuser\").keydown( function() { \n" +
                "\tif (window.attachEvent)\n" +
                "    {\n" +
                "\t\tif(event.keyCode==13){\n" +
                "\t\t\tsearch_user(); \n" +
                "\t\t}\n" +
                "    }else{\n" +
                "\t\tvar eventnew = EventUtil.getEvent(eventnew);\n" +
                "\t\tif(eventnew.keyCode==13){\n" +
                "\t\t\tsearch_user();\n" +
                "\t\t}\n" +
                "\t}\n" +
                "});\n" +
                "\n" +
                "</script>\n" +
                "</div>\n" +
                "<div class=\"hp-w\">\n" +
                "\t<div class=\"fback\"><a class=\"btop\" href=\"#\">回顶部</a></div>\n" +
                "\t<b id=\"footer-loadedError\"></b>\n" +
                "</div>\n" +
                "<div class=\"hp-footer\">\n" +
                "                    \n" +
                "                    <div class=\"hp-copyright\">\n" +
                "                    \n" +
                "                    Copyright by 虎扑JRs &amp;\n" +
                "                    <a href=\"https://www.hupu.com/\" target=\"_blank\" title=\"虎扑\">虎扑</a> -\n" +
                "                    <a href=\"https://m.hupu.com/\" target=\"_blank\">手机虎扑网</a> -\n" +
                "                    <a href=\"https://mobile.hupu.com/\" target=\"_blank\">虎扑App</a> -\n" +
                "                    <a href=\"https://www.hupu.com/policies/terms\" target=\"_blank\">服务协议</a> -\n" +
                "                    <a href=\"https://www.hupu.com/sitemap.html\" target=\"_blank\">网站地图</a> -\n" +
                "                    <a href=\"https://nba.hupu.com/\" target=\"_blank\" title=\"NBA\">NBA</a> -\n" +
                "                    <a href=\"https://cba.hupu.com/\" target=\"_blank\" title=\"CBA\">CBA</a>  -\n" +
                "                    <a href=\"https://soccer.hupu.com/\" target=\"_blank\" title=\"足球\">足球</a> -\n" +
                "                    <a href=\"https://soccer.hupu.com/china/\" target=\"_blank\" title=\"中超\">中超</a>\n" +
                "                    </div>\n" +
                "                    \n" +
                "                </div>\n" +
                "<script>\n" +
                "var commonProject = \"basketball\";\n" +
                "\n" +
                "_common.init({project: commonProject,countGATrackPageview: (location.pathname+location.search + '|' + commonProject),countGASetVar: ''});\n" +
                "\n" +
                "</script>\n" +
                "<script async=\"true\" src=\"//b3.hoopchina.com.cn/pcbbs/js/g85.js?20180313\"></script>\n" +
                "<div id=\"user_info\" style=\"display: none\" safety=\"\"></div>\n" +
                "</body>\n" +
                "</html>";
        Document doc = Jsoup.parse(html);
        Elements userTable = doc.select(".bgcolor");
        for (Element user : userTable) {
            System.out.println(doc.select("#headtop").text());
            Elements follower = user.select(".u");
            System.out.println(follower.text());
            Elements href = user.select(".headpic");
            System.out.println(href.attr("href"));
        }
    }
}
