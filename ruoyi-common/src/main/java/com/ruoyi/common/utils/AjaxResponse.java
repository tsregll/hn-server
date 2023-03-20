package com.ruoyi.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * AJAX 请求时返回字符工具类；
 * 
 * @author 460098508@qq.com
 * @date 2010-5-30 下午05:21:45
 */
public class AjaxResponse {

	private static final Logger log = LoggerFactory.getLogger(AjaxResponse.class);

	/**
	 * 返回JSONP方式返回请求结果，以javascript执行体格式的字符串返回，如果对象为空，则返回${callback}("")；
	 * 通过"callback"参数从request中获取回调函数名称，如果获取为空，则以json方式返回。
	 * 
	 * @param json     返回JSON数据
	 * @param response
	 * @param request
	 */
	public static void sendAjaxJSONP(String json, HttpServletResponse response, HttpServletRequest request) {
		sendAjaxJSONP(json, "callback", response, request);
	}

	/**
	 * 返回JSONP方式返回请求结果，以javascript执行体格式的字符串返回，如果对象为空，则返回${callback}("")；
	 * 将从request中取到回调函数名称，如果不为空，则以JSONP方式返回，如果为空,则会以json格式返回
	 * 
	 * @param json              返回的JSON数据;
	 * @param callbackParamName 回调函数名称的参数名,如果为空，则为“callback”。
	 * @param response
	 * @param request
	 */
	public static void sendAjaxJSONP(String json, String callbackParamName, HttpServletResponse response,
			HttpServletRequest request) {
		String callback = request.getParameter(callbackParamName);
		if (StringUtils.isEmpty(callback)) {
			sendAjaxJSON(json, response);
		} else {
			String resultStr = null;
			if (callback.contains("<|>|&")) {
				resultStr = "JOSNP请求回调函数名包含非法字符！";
				log.error(resultStr);
			} else if (json == null) {
				resultStr = callback + "()";
			} else {
				resultStr = callback + "(" + json.toString() + ")";
			}
			sendAjaxText(resultStr, response, ContentType.JAVASCRIPT, null);
		}

	}

	/**
	 * 返回JSON格式的字符串对象，如果对象为空，则返回“”；
	 * 
	 * @param json
	 * @param response
	 */
	public static void sendAjaxJSON(String json, HttpServletResponse response) {
		String resultStr = null;
		if (json == null) {
			resultStr = "{}";
		} else {
			resultStr = json.toString();
		}
		sendAjaxText(resultStr, response, ContentType.JSON, null);
	}

	/**
	 * 返回指定格式的字符串对象，如果对象为空，则返回“”；
	 * 
	 * @param content     需要返回的字符串
	 * @param response    响应对象，用来获取返回的输出流
	 * @param contentType 返回类型：
	 * @param charset     返回字符编码：默认为：UTF－8
	 */
	public static void sendAjaxText(String content, HttpServletResponse response, String contentType, String charset) {
		if (!response.isCommitted()) {

			// response.setHeader("Access-Control-Allow-Origin",
			// "http://newportal.intra.cntaiping.com");
			/*
			 * 启用资源共享，设置跨域访问权限。 response.setHeader("Access-Control-Allow-Origin", "*");
			 * response.setHeader("Access-Control-Allow-Credentials", "true");
			 * response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE, OPTIONS");
			 * response.setHeader( "Access-Control-Allow-Headers",
			 * "Authorization,Origin, Accept, Content-Type, X-HTTP-Method, X-HTTP-METHOD-OVERRIDE,XRequestedWith,X-Requested-With,xhr,x-devicetype"
			 * );
			 */
			String charset1 = (charset == null ? "UTF-8" : charset);
			String cType = (contentType == null ? ContentType.TEXT : contentType) + ";charset=" + charset1;
			response.setContentType(cType);
			response.setCharacterEncoding(charset1);

			try {
				PrintWriter writer = response.getWriter();
				if (content == null) {
					writer.write("");
				} else {
					writer.write(content);
				}
				writer.close();
			} catch (Exception ex) {
				log.error("response error!", ex);
			}
		}
	}
}
