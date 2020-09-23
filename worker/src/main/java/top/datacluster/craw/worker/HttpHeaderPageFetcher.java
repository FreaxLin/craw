package top.datacluster.craw.worker;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;

public class HttpHeaderPageFetcher extends PageFetcher {

    public HttpHeaderPageFetcher(CrawlConfig config) {
        super(config);
    }

    @Override
    protected HttpUriRequest newHttpUriRequest(String url) {
        HttpGet get = new HttpGet(url);
        get.addHeader("cookie", "_cnzz_CV30020080=buzi_cookie%7C2a90a715.d183.028c.e7f6.76f048669ffd%7C-1; _dacevid3=2a90a715.d183.028c.e7f6.76f048669ffd; _HUPUSSOID=06514cd7-8198-4cb2-8828-d9cb26857e31; _CLT=918ebe7bb324d8673460f7af1d701a5c; c=fvfY0IkD-1594098517411-af7af0ae5fd5f2131457304; _fmdata=u329MyaXXWuWxj3tEB5FZ6O7j5pyHurY4dXwgEu4uAXB79X7FRDTWrYhyV%2B52QID2Ag6xh4j%2Bbrmk9ESZ2E1OTWnaFOouAnXlRB6xFxhOtw%3D; _xid=eNzBqENKK1tkjntRQ0eeF4pVKsERr5R88LA3%2BzQgrMDyenh2kei9pO7ilFgxy6rBDmAoXe4OiTcLXixcWGZjZw%3D%3D; PHPSESSID=h198r975963hm6em3blhonpt82; _cnzz_CV30020080=buzi_cookie%7C2a90a715.d183.028c.e7f6.76f048669ffd%7C-1; AUM=dgkZL-vRUOxAq4fyGbd2bJPHjN5nt-yqlWtWpTno5j7lw; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22172f5b6d394c7f-0f394d5d7ad237-1b386257-1296000-172f5b6d395e4e%22%2C%22first_id%22%3A%22%22%2C%22props%22%3A%7B%22%24latest_referrer%22%3A%22https%3A%2F%2Fwww.baidu.com%2Flink%22%2C%22%24latest_traffic_source_type%22%3A%22%E8%87%AA%E7%84%B6%E6%90%9C%E7%B4%A2%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC%22%7D%2C%22%24device_id%22%3A%22172f5b6d394c7f-0f394d5d7ad237-1b386257-1296000-172f5b6d395e4e%22%7D; Hm_lvt_4fac77ceccb0cd4ad5ef1be46d740615=1600668387,1600668404,1600735772,1600735773; Hm_lvt_b241fb65ecc2ccf4e7e3b9601c7a50de=1600668387,1600668404,1600735772,1600735773; u=18798712|5Zi/5Zi/55CD6L+3|1142|ddbcac6ca557653bfb2cc0f0cac18b71|a557653bfb2cc0f0|5Zi/5Zi/55CD6L+3; us=258c6262f84da6b2f0e99a0ecb5a444592763504119810feeb171ae096cd65fe36e34cb1c00d074ef9c80ac9c60b2727cf17b40a3af52b84113254babc6e315a; _fmdata=u329MyaXXWuWxj3tEB5FZ6O7j5pyHurY4dXwgEu4uAXB79X7FRDTWrYhyV%2B52QIDxDZL9JE%2FLSqNlD0HGAdO8wnOHKuhKU%2BMn3y4VoXL0F4%3D; acw_tc=76b20f7116008301808183051e55e2a30c3c44b502d21596cb2d612d1c5b5c; ua=123140783; __dacevst=9ec2dd7d.3182ec2a|1600832094119; Hm_lpvt_b241fb65ecc2ccf4e7e3b9601c7a50de=1600830294; Hm_lpvt_4fac77ceccb0cd4ad5ef1be46d740615=1600830294");
        get.addHeader(":authority", "my.hupu.com");
        get.addHeader(":method", "GET");
        get.addHeader(":scheme", "https");
        get.addHeader("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");

        return get;
    }
}
