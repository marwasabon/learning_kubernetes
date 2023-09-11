package com.zain.shortcode.services;


import com.zain.shortcode.util.BaseResponse;;

/**
 * @author m.sabon
 *
 */
public interface NotificationService {
    BaseResponse<String> sendSMS(String msisdn, String msg);
}