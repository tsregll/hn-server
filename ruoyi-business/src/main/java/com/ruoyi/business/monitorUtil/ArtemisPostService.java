package com.ruoyi.business.monitorUtil;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.hikvision.artemis.sdk.ArtemisHttpUtil;
import com.hikvision.artemis.sdk.config.ArtemisConfig;
import com.ruoyi.business.monitorUtil.mapper.CameraRequest;
import com.ruoyi.business.monitorUtil.mapper.CamerasRequest;
import com.ruoyi.business.monitorUtil.mapper.PreviewURLsRequest;
import com.ruoyi.business.monitorUtil.mapper.SearchRequest;


/**
 * Auto Create on 2021-04-01 09:25:37
 */
public class ArtemisPostService {
	/**
	 * STEP1：设置平台参数，根据实际情况,设置host appkey appsecret 三个参数.
	 */
	static {//443or9999
		ArtemisConfig.host = "172.22.192.227:443";// 平台门户/nginx的IP和端口（必须使用https协议，https端口默认为443）
		ArtemisConfig.appKey = "24909690"; // 秘钥appkey
		ArtemisConfig.appSecret = "GbhfoTEF4ZeD0oItDTfj";// 秘钥appSecret
	}
	/**
	 * STEP2：设置OpenAPI接口的上下文
	 */
	private static final String ARTEMIS_PATH = "/artemis";

	//查询监控点列表v2
	public static String cameras(CamerasRequest camerasRequest ){
		String camerasDataApi = ARTEMIS_PATH +"/api/resource/v1/cameras";
		Map<String,String> path = new HashMap<String,String>(2){
			{
				put("https://",camerasDataApi);
			}
		};
		String body=JSON.toJSONString(camerasRequest);
		String result =ArtemisHttpUtil.doPostStringArtemis(path,body,null,null,"application/json");
		return result;
	}
	//查询区域// /api/resource/v1/regions
	public static String cameras2(CamerasRequest camerasRequest ){
		String camerasDataApi = ARTEMIS_PATH +"/api/resource/v1/regions";
		Map<String,String> path = new HashMap<String,String>(2){
			{
				put("https://",camerasDataApi);
			}
		};
		String body=JSON.toJSONString(camerasRequest);
		String result =ArtemisHttpUtil.doPostStringArtemis(path,body,null,null,"application/json");
		return result;
	}
	//查询监控点列表v2
	public static String search(SearchRequest searchRequest ){
		String camerasDataApi = ARTEMIS_PATH +"/api/resource/v2/camera/search";
		Map<String,String> path = new HashMap<String,String>(2){
			{
				put("https://",camerasDataApi);
			}
		};
		String body=JSON.toJSONString(searchRequest);
		String result =ArtemisHttpUtil.doPostStringArtemis(path,body,null,null,"application/json");
		return result;
	}

	//查询监控点列表v2
	public static String search2(CameraRequest cameraRequest ){
		String camerasDataApi = ARTEMIS_PATH +"/api/resource/v1/regions/regionIndexCode/cameras";
		Map<String,String> path = new HashMap<String,String>(2){
			{
				put("https://",camerasDataApi);
			}
		};
		String body=JSON.toJSONString(cameraRequest);
		String result =ArtemisHttpUtil.doPostStringArtemis(path,body,null,null,"application/json");
		return result;
	}
	//获取监控点预览取流URLv2
	public static String previewURLs(PreviewURLsRequest previewURLsRequest ){
		String previewURLsDataApi = ARTEMIS_PATH +"/api/video/v2/cameras/previewURLs";
		Map<String,String> path = new HashMap<String,String>(2){
			{
				put("https://",previewURLsDataApi);
			}
		};
		String body=JSON.toJSONString(previewURLsRequest);
		String result =ArtemisHttpUtil.doPostStringArtemis(path,body,null,null,"application/json");
		return result;
	}
}
