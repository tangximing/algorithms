package utils;

import org.junit.Test;

/**
 * Created by tangximing on 2017/7/2.
 */
public class HttpUtilTest {
    @Test
    public void sendFile() throws Exception {
        HttpUtil.sendFile("", "");
    }

    @Test
    public void sendJson() throws Exception {
        HttpUtil.sendJson("", "");
    }

}