package com.shengxin.test;

import com.shengxin.po.AccessToken;
import com.shengxin.util.WeixinUtil;

public class WeixinTest {
public static void main(String[] args) {
	AccessToken token = WeixinUtil.getAccessToken();
	System.out.println("token:"+token.getToken());
	System.out.println("expires_in:"+token.getExpiresIn());
}
}
