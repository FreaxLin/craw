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
//        get.addHeader("Cookie", "_HUPUSSOID=40192800-04f4-4098-a75d-a54b64d46cad");
        get.addHeader("cookie", "_cnzz_CV30020080=buzi_cookie%7C2a90a715.d183.028c.e7f6.76f048669ffd%7C-1; _dacevid3=2a90a715.d183.028c.e7f6.76f048669ffd; _HUPUSSOID=06514cd7-8198-4cb2-8828-d9cb26857e31; _CLT=918ebe7bb324d8673460f7af1d701a5c; c=fvfY0IkD-1594098517411-af7af0ae5fd5f2131457304; _fmdata=u329MyaXXWuWxj3tEB5FZ6O7j5pyHurY4dXwgEu4uAXB79X7FRDTWrYhyV%2B52QID2Ag6xh4j%2Bbrmk9ESZ2E1OTWnaFOouAnXlRB6xFxhOtw%3D; _xid=eNzBqENKK1tkjntRQ0eeF4pVKsERr5R88LA3%2BzQgrMDyenh2kei9pO7ilFgxy6rBDmAoXe4OiTcLXixcWGZjZw%3D%3D; Hm_lvt_b241fb65ecc2ccf4e7e3b9601c7a50de=1598071393,1600047100; Hm_lvt_4fac77ceccb0cd4ad5ef1be46d740615=1600047100; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22172f5b6d394c7f-0f394d5d7ad237-1b386257-1296000-172f5b6d395e4e%22%2C%22first_id%22%3A%22%22%2C%22props%22%3A%7B%22%24latest_referrer%22%3A%22%22%2C%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%7D%2C%22%24device_id%22%3A%22172f5b6d394c7f-0f394d5d7ad237-1b386257-1296000-172f5b6d395e4e%22%7D; PHPSESSID=h198r975963hm6em3blhonpt82; _cnzz_CV30020080=buzi_cookie%7C2a90a715.d183.028c.e7f6.76f048669ffd%7C-1; AUM=dgkZL-vRUOxAq4fyGbd2bJPHjN5nt-yqlWtWpTno5j7lw; u=18798712|5Zi/5Zi/55CD6L+3|1142|ddbcac6ca557653bfb2cc0f0cac18b71|a557653bfb2cc0f0|5Zi/5Zi/55CD6L+3; us=e497688156b1fbd31d5128dc4e80d09e10d52745bf9b0eadffeeb547b40c617cae88e617bd0f963053810c10730bc662e56a82ceddd8e7d6742a5ad26a21e6be; _fmdata=u329MyaXXWuWxj3tEB5FZ6O7j5pyHurY4dXwgEu4uAXB79X7FRDTWrYhyV%2B52QIDlpfKp5ZAcDwWg4Jzaak35aCzmCmT%2FZbwIAH3GsbgDl8%3D; ua=123126852; acw_tc=76b20f6a16006490785604240e49618abf6886d4255c5d100a0be3477cbf84; __dacevst=c1ec8428.b62fb058|1600651756471; Hm_lpvt_4fac77ceccb0cd4ad5ef1be46d740615=1600649957; Hm_lpvt_b241fb65ecc2ccf4e7e3b9601c7a50de=1600649957");
        get.addHeader(":authority", "my.hupu.com");
        get.addHeader(":method", "GET");
//        get.addHeader(":path", "my.hupu.com");
        get.addHeader(":scheme", "https");
        get.addHeader("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");

        return get;
    }
}
