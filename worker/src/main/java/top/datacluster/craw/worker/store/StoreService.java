package top.datacluster.craw.worker.store;

import edu.uci.ics.crawler4j.crawler.Page;

public interface StoreService {

    String store(Page data);
}
