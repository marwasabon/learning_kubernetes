package com.zain.shortcode.services;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;

import com.zain.shortcode.util.BaseResponse;
import com.zain.shortcode.util.ResponseCode;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author m.sabon
 *
 */
@Service
public class NotificationServiceImpl implements NotificationService {

    private Logger log = LogManager.getLogger();

    @Value("${jmr.password}")
    private String password;

    @Value("${jmr.url}")
    private String jmrUrl;

    @Value("${jmr.account}")
    public String jmrAccount;

    @Value("${jmr.sender}")
    public String jmrSender;

    @Override
    
    public BaseResponse<String> sendSMS(String msisdn, String msg) {
        msisdn = msisdn.replace("+", "");
        log.info("sending message to:{}, with content: {}", msisdn, msg);
        BaseResponse<String> response = new BaseResponse<>();
        try {
            String ud_type = "text";
            String dcs = "0";
            String esm_class = "1";
            URL u = new URL(jmrUrl);

            if (msg.matches("[a-zA-Z0-9!@#$*()/.,\\]\\[{}_\\-? ]+")) {
                ud_type = "text";
                dcs = "0";
                esm_class = "1";
                if (msg.length() > 160) {
                    esm_class = "64";
                }
            } else {
                ud_type = "unicode";
                dcs = "8";
                esm_class = "40";
                int msgIntLength = msg.length() * 4;

                msg = String.format("%x", new Object[] { new BigInteger(1, msg.getBytes("UTF-16BE")) });

                while (msg.length() < msgIntLength) {
                    msg = "0" + msg;
                }

                if (msg.length() > 280) {
                    esm_class = "64";
                }
            }
            String account = jmrAccount;
            response.setResponseBean(account);

            String body = "<?xml version=\"1.0\"?><!DOCTYPE message SYSTEM \"/home/jinny/init/jxml_sai.dtd\"><message>        <authentication>                <username>"
                    +

                    account + "</username><password>" + password + "</password>" +
                    "        </authentication>" +
                    "        <submit>" +
                    "                <dton>1</dton>" +
                    "                <ston>5</ston>" +
                    "                <dnpi>1</dnpi>" +
                    "                <snpi>1</snpi>" +
                    "\t\t\t\t  <da>" +
                    "                     <number>" + msisdn + "</number>" +
                    "\t\t\t      </da>" +
                    "\t\t\t\t  <oa>" +
                    "\t\t\t\t\t\t<number>" + jmrSender + "</number>" +
                    "\t\t    \t  </oa>" +
                    "                <ud type=\"" + ud_type + "\">" +
                    "                <text>" + msg + "</text>" +
                    "\t\t\t\t  </ud>" +
                    "                <dcs>" + dcs + "</dcs>" +
                    "                <esm_class>" + esm_class + "</esm_class>" +
                    "</submit>" +
                    "</message>";

            URLConnection uc = u.openConnection();
            uc.setRequestProperty("Host", "172.20.12.134 80");
            uc.setRequestProperty("Content-Type", "application/json");
            // uc.setRequestProperty("Content-Length", "722");
            uc.setRequestProperty("Accept-Encoding", "gzip,deflate");
            HttpURLConnection connection = (HttpURLConnection) uc;
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("POST");

            OutputStream out = connection.getOutputStream();
            OutputStreamWriter wout = new OutputStreamWriter(out, "UTF-8");

            wout.write(body);
            wout.flush();

            InputStream in = connection.getInputStream();

            InputStreamReader is = new InputStreamReader(in);

            BufferedReader br = new BufferedReader(is);
            String read = br.readLine();
            while (read != null) {
                read = br.readLine();
                if (read.contains("<ack status=\"ok\">")) {
                	log.info("message sent successfuly to msisdn: "+msisdn);
                    break;
                }
                if (read.contains("<ack status=\"error\">")) {
                	log.info("message not sent to msisdn: "+msisdn);
                    response.setResponseCode(ResponseCode.API_ERROR.getCode());
                    String resMsg = ResponseCode.API_ERROR.getMessage() + br.readLine() + br.readLine();
                    response.setResponseMessage(resMsg);
                    break;
                }
            }

            in.close();
            out.close();
            connection.disconnect();
        } catch (SocketTimeoutException e) {
            e.printStackTrace();
            response.setResponseCode(ResponseCode.API_TIMEOUT_ERROR.getCode());
            String resMsg = ResponseCode.API_TIMEOUT_ERROR.getMessage() + e.getCause() + e.getMessage();
            response.setResponseMessage(resMsg);
        } catch (Exception e) {
            e.printStackTrace();
            response.setResponseCode(ResponseCode.API_EXCEPTION_ERROR.getCode());
            String resMsg = ResponseCode.API_EXCEPTION_ERROR.getMessage() + e.getCause() + e.getMessage();
            response.setResponseMessage(resMsg);
        }

        return response;

    }

}
