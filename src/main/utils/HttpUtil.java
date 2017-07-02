package utils;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by tangximing on 2017/7/1.
 * Util for HttpURLConnection
 */
public class HttpUtil {
    /**
     * send form file with HttpURLConnection
     * @param urlStr url string
     * @param path file path
     * @return true or false
     */
    public static boolean sendFile(String urlStr, String path) {
        String crlf = "\r\n";
        String twoHyphens = "--";
        String boundary =  "*****";
        String key = "file";

        URL url;
        HttpURLConnection conn = null;
        File file;
        DataOutputStream out = null;
        DataInputStream in = null;
        try {
            file = new File(path);
            if (!file.exists()) {
                return false;
            }

            url = new URL(urlStr);
            conn = (HttpURLConnection)url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type","multipart/form-data; boundary=" + boundary);
            conn.setRequestProperty("Cache-Control","no-cache");

            out = new DataOutputStream(conn.getOutputStream());
            out.writeBytes(twoHyphens + boundary + crlf);
            out.writeBytes("Content-Disposition: form-data; name=\"" +
                    key + "\";filename=\"" + file.getName() + "\"" + crlf);
            out.writeBytes(crlf);

            in = new DataInputStream(new FileInputStream(file));
            int bytes;
            byte[] bufferOut = new byte[8192];
            while ((bytes = in.read(bufferOut)) != -1) {
                out.write(bufferOut, 0, bytes);
            }
            out.writeBytes(crlf);
            out.writeBytes(twoHyphens + boundary +
                    twoHyphens + crlf);
            out.flush();

            // must invoke conn.getResponseCode() or conn.getInputStream() to send request
            int code = conn.getResponseCode();
            return code == 200;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.disconnect();
                }
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return false;
    }

    /**
     * send json string with Http
     * @param urlStr url string
     * @param content json content
     * @return
     */
    public static boolean sendJson(String urlStr, String content) {
        URL url;
        HttpURLConnection conn = null;
        DataOutputStream out = null;
        try {
            url = new URL(urlStr);
            conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");

            out = new DataOutputStream(conn.getOutputStream());
            out.writeBytes(content);
            out.flush();

            int code = conn.getResponseCode();
            return code == 200;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.disconnect();
                }
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return false;
    }
}
