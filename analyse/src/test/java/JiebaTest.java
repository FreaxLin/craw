import com.huaban.analysis.jieba.JiebaSegmenter;
import com.huaban.analysis.jieba.WordDictionary;
import junit.framework.TestCase;
import org.junit.Test;

import java.nio.file.Paths;

public class JiebaTest extends TestCase {

    private JiebaSegmenter segmenter = new JiebaSegmenter();
    String sentences = "上海市闵行区";

    /**
     * 读取conf目录下所有的自定义词库**.dict文件。
     */
    @Override
    protected void setUp() throws Exception {
        WordDictionary.getInstance().init(Paths.get("conf"));
    }

    @Test
    public void testCutForSearch() {
        System.out.println(segmenter.sentenceProcess(sentences));
    }
}
