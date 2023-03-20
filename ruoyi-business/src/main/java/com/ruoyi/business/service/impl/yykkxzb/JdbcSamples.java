package com.ruoyi.business.service.impl.yykkxzb;
import com.ruoyi.business.toolUtil.ToolUtils;
import com.ruoyi.business.vo.ResultConfigureVo;
import com.ruoyi.business.vo.YueYangKeKaoXingZhiBiaoQianDuanVo;
import com.ruoyi.business.vo.YueYangKeKaoXingZhiBiaoVo;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class JdbcSamples {


	static final String JDBC_DRIVER = "com.shenku.JdbcDriver";
	static final String DB_URL = "jdbc:skd://172.22.192.237:8628/default";
	static final String USER = "default";
	static final String PASS = "usbw";


//	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
//	static final String DB_URL = "jdbc:mysql://localhost:3306/huaneng_db?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8";
//	static final String USER = "root";
//	static final String PASS = "123456";
	


	// mysql-connector-java-5.1.38  �� -5.1.48
	/*static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://192.168.2.252:3308/information_schema?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8";
	static final String USER = "myroot";
	static final String PASS = "usbw";*/

	//mysql-connector-java-8
	/*static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://192.168.2.252:3308/information_schema?use_ssl=false&serverTimezone=UTC&useUnicode=true&characterEncoding=utf8";
	static final String USER = "myroot";
	static final String PASS = "usbw";*/


	public static ResultConfigureVo getRs(String sql,String type)  {
		ResultConfigureVo returnResult = new ResultConfigureVo();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try{
			//STEP 2: Register JDBC driver
			Class.forName(JDBC_DRIVER);

			//STEP 3: Open a connection
			System.out.println("Connecting to database...");
			Properties p = new Properties();
			p.put("user",USER);
			p.put("password",PASS);

			// ʹ�� ssl ��ȫ���� >>>>>>>>>>>>>>>
//		      p.put("ssl","true");
//		      p.put("sslmode","none");
			// ʹ�� ssl ��ȫ���� <<<<<<<<<<<<<<<

			// Now try to connect
			conn = DriverManager.getConnection(DB_URL,p);

			//conn = DriverManager.getConnection(DB_URL,USER,PASS);

			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			System.out.println("Execute query...");
			//rs = stmt.executeQuery("show databases");
			//stmt.executeQuery("SHOW VARIABLES ");
			//rs = stmt.executeQuery("select * from information_schema.TABLES");
//			rs = stmt.executeQuery("select event_date,event_time from hnskdb.REPORT_KKXZB_JZZT order by event_time desc limit 10 ");
			if ("1".equals(type))rs = stmt.executeQuery(sql);
			int result= 0;
			if ("2".equals(type)) result = stmt.executeUpdate(sql);
			returnResult.setConn(conn);
			returnResult.setRs(rs);
			returnResult.setStmt(stmt);
			stmt.close();
			conn.close();
		}
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new Exception(e);
//		}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		finally{
			// finally block used to close resources
			try{
				if(stmt!=null)
					stmt.close();
			}catch(SQLException se2){
				se2.printStackTrace();
			}// nothing we can do
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}//end finally try
		}//end try
		return returnResult;
	}
	//新增可靠性指标
	public static void demo_update(String sql) {
		ResultConfigureVo returnResult = new ResultConfigureVo();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try{
			//STEP 2: Register JDBC driver
			Class.forName(JDBC_DRIVER);

			//STEP 3: Open a connection
			System.out.println("Connecting to database...");
			Properties p = new Properties();
			p.put("user",USER);
			p.put("password",PASS);

			// ʹ�� ssl ��ȫ���� >>>>>>>>>>>>>>>
//		      p.put("ssl","true");
//		      p.put("sslmode","none");
			// ʹ�� ssl ��ȫ���� <<<<<<<<<<<<<<<

			// Now try to connect
			conn = DriverManager.getConnection(DB_URL,p);

			//conn = DriverManager.getConnection(DB_URL,USER,PASS);

			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			System.out.println("Execute query...");
			//rs = stmt.executeQuery("show databases");
			//stmt.executeQuery("SHOW VARIABLES ");
			//rs = stmt.executeQuery("select * from information_schema.TABLES");
//			rs = stmt.executeQuery("select event_date,event_time from hnskdb.REPORT_KKXZB_JZZT order by event_time desc limit 10 ");
			int result = stmt.executeUpdate(sql);
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			// finally block used to close resources
			try{
				if(stmt!=null)
					stmt.close();
			}catch(SQLException se2){
				se2.printStackTrace();
			}// nothing we can do
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}//end finally try
		}//end try
	}

	public static List<YueYangKeKaoXingZhiBiaoVo> demo_query(String sql) {
		ResultConfigureVo rs1 = getRs(sql,"1");

		Connection conn = rs1.getConn();
		Statement stmt = rs1.getStmt();
		ResultSet rs = rs1.getRs();
		List<YueYangKeKaoXingZhiBiaoVo> list = new ArrayList<>();

		try{
			//STEP 2: Register JDBC driver
//			Class.forName(JDBC_DRIVER);

			//STEP 3: Open a connection
//			System.out.println("Connecting to database...");
//			Properties p = new Properties();
//			p.put("user",USER);
//			p.put("password",PASS);

			// ʹ�� ssl ��ȫ���� >>>>>>>>>>>>>>>
//		      p.put("ssl","true");
//		      p.put("sslmode","none");
			// ʹ�� ssl ��ȫ���� <<<<<<<<<<<<<<<

			// Now try to connect
//			conn = DriverManager.getConnection(DB_URL,p);

			//conn = DriverManager.getConnection(DB_URL,USER,PASS);

//			System.out.println("Creating statement...");
//			stmt = conn.createStatement();
//			System.out.println("Execute query...");
			//rs = stmt.executeQuery("show databases");
			//stmt.executeQuery("SHOW VARIABLES ");
			//rs = stmt.executeQuery("select * from information_schema.TABLES");
//			rs = stmt.executeQuery("select event_date,event_time from hnskdb.REPORT_KKXZB_JZZT order by event_time desc limit 10 ");
//			rs = stmt.executeQuery(sql);

			//STEP 5: Extract data from result set
			while(rs.next()){
				// Retrieve by column name
				// int id  = rs.getInt("name");
				// float ia = rs.getFloat("IA");
//				int id  = rs.getInt(1);
//				String type = rs.getString(1);
//				String machineNo = rs.getString(2);
//				String stateChangeBefore = rs.getString(3);

				// Timestamp event_time=rs.getTimestamp("event_time");
//				Long stateChangeTime=rs.getTimestamp(1).getTime()/1000;
//				Date stateChangeTime = rs.getDate(1);
//				String editUserName = rs.getString(4);
//				String editUserNo = rs.getString(5);
//				String editTime = rs.getString(6);
//				Date event_date=rs.getDate("event_date");

				//Display values
//				System.out.print( type);
//				System.out.print("\t,"+ event_date);
//				System.out.print("\t,"+ stateChangeTime);

				//System.out.print(", IA: " + ia);
				//System.out.print(", DATATIME: " + datatime);
//				System.out.print("");
				YueYangKeKaoXingZhiBiaoVo yueyang = new YueYangKeKaoXingZhiBiaoVo(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8));
				yueyang.setEditTime(rs.getString(9));
				System.out.println(yueyang);
				list.add(yueyang);
			}
			//STEP 6: Clean-up environment
			//rs.close();
//			stmt.close();
//
//			conn.close();
		} catch (SQLException ex){
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
			ex.printStackTrace();
		}catch(Exception e){
			// Handle errors for Class.forName
			// System.out.print("222222222222222222 ");
			e.printStackTrace();
		}finally{
			// finally block used to close resources
			try{
				if(stmt!=null)
					stmt.close();
			}catch(SQLException se2){
				se2.printStackTrace();
			}// nothing we can do
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}//end finally try

		}//end try
		System.out.println("Goodbye!");
		return list;
	}//end main

	//火电指标导出数据
	public static List<YueYangKeKaoXingZhiBiaoQianDuanVo> export_hdquery(String sql) {
		ResultConfigureVo rs1 = getRs(sql,"1");
		Connection conn = rs1.getConn();
		Statement stmt = rs1.getStmt();
		ResultSet rs = rs1.getRs();
		List<YueYangKeKaoXingZhiBiaoQianDuanVo> list = new ArrayList<>();

		try{
			while(rs.next()){
//				YueYangKeKaoXingZhiBiaoQianDuanVo list9 = new YueYangKeKaoXingZhiBiaoQianDuanVo("平均利用率","%",rs.getString(51),rs.getString(52),rs.getString(53),rs.getString(54),rs.getString(55),rs.getString(56),rs.getString(80)+"");
//				YueYangKeKaoXingZhiBiaoQianDuanVo list10 = new YueYangKeKaoXingZhiBiaoQianDuanVo("平均可调出力","%",rs.getString(57),rs.getString(58),rs.getString(59),rs.getString(60),rs.getString(61),rs.getString(62),rs.getString(81)+"");
//				YueYangKeKaoXingZhiBiaoQianDuanVo list11 = new YueYangKeKaoXingZhiBiaoQianDuanVo("非停次数","次",rs.getString(63),rs.getString(64),rs.getString(65),rs.getString(66),rs.getString(67),rs.getString(68),rs.getString(82)+"");
//				YueYangKeKaoXingZhiBiaoQianDuanVo list12 = new YueYangKeKaoXingZhiBiaoQianDuanVo("非停时间","小时",rs.getString(69),rs.getString(70),rs.getString(71),rs.getString(72),rs.getString(73),rs.getString(74),rs.getString(83)+"");

//				YueYangKeKaoXingZhiBiaoQianDuanVo list1 = new YueYangKeKaoXingZhiBiaoQianDuanVo("机组状态","",getRJZZT(rs.getString("YYDC_RJZZT1")),getRJZZT(rs.getString("YYDC_RJZZT2")),getRJZZT(rs.getString("YYDC_RJZZT3")),getRJZZT(rs.getString("YYDC_RJZZT4")),getRJZZT(rs.getString("YYDC_RJZZT5")),getRJZZT(rs.getString("YYDC_RJZZT3")),"");
//				YueYangKeKaoXingZhiBiaoQianDuanVo list2 = new YueYangKeKaoXingZhiBiaoQianDuanVo("日运行小时","小时",rs.getString("YYDC_RYXXSS1"),rs.getString("YYDC_RYXXSS2"),rs.getString("YYDC_RYXXSS3"),rs.getString("YYDC_RYXXSS4"),rs.getString("YYDC_RYXXSS5"),rs.getString("YYDC_RYXXSS6"),rs.getString("YYDC_RYXXSS"));
//				YueYangKeKaoXingZhiBiaoQianDuanVo list3 = new YueYangKeKaoXingZhiBiaoQianDuanVo("连续运行","天",rs.getString("YYDC_LXYXTS1"),rs.getString("YYDC_LXYXTS2"),rs.getString("YYDC_LXYXTS3"),rs.getString("YYDC_LXYXTS4"),rs.getString("YYDC_LXYXTS5"),rs.getString("YYDC_LXYXTS6"),"");
//				YueYangKeKaoXingZhiBiaoQianDuanVo list4 = new YueYangKeKaoXingZhiBiaoQianDuanVo("停备（计停）","小时",rs.getString("YYDC_RTBXSS1"),rs.getString("YYDC_RTBXSS2"),rs.getString("YYDC_RTBXSS3"),rs.getString("YYDC_RTBXSS4"),rs.getString("YYDC_RTBXSS5"),rs.getString("YYDC_RTBXSS6"),"");
//				YueYangKeKaoXingZhiBiaoQianDuanVo list5 = new YueYangKeKaoXingZhiBiaoQianDuanVo("累计检修","天",rs.getString("YYDC_NLJJXTS1"),rs.getString("YYDC_NLJJXTS2"),rs.getString("YYDC_NLJJXTS3"),rs.getString("YYDC_NLJJXTS4"),rs.getString("YYDC_NLJJXTS5"),rs.getString("YYDC_NLJJXTS6"),"");
//				YueYangKeKaoXingZhiBiaoQianDuanVo list6 = new YueYangKeKaoXingZhiBiaoQianDuanVo("等效可用小时","%",rs.getString("YYDC_DXKYXSS1"),rs.getString("YYDC_DXKYXSS2"),rs.getString("YYDC_DXKYXSS3"),rs.getString("YYDC_DXKYXSS4"),rs.getString("YYDC_DXKYXSS5"),rs.getString("YYDC_DXKYXSS6"),rs.getString("YYDC_DXKYXSS"));
//				YueYangKeKaoXingZhiBiaoQianDuanVo list7 = new YueYangKeKaoXingZhiBiaoQianDuanVo("等效可用系数","%",rs.getString("YYDC_DXKYXS1"),rs.getString("YYDC_DXKYXS2"),rs.getString("YYDC_DXKYXS3"),rs.getString("YYDC_DXKYXS4"),rs.getString("YYDC_DXKYXS5"),rs.getString("YYDC_DXKYXS6"),rs.getString("YYDC_DXKYXS"));
//				YueYangKeKaoXingZhiBiaoQianDuanVo list8 = new YueYangKeKaoXingZhiBiaoQianDuanVo("出力系数","%",rs.getString("YYDC_CLXS1"),rs.getString("YYDC_CLXS2"),rs.getString("YYDC_CLXS3"),rs.getString("YYDC_CLXS4"),rs.getString("YYDC_CLXS5"),rs.getString("YYDC_CLXS6"),rs.getString("YYDC_CLXS"));
//				YueYangKeKaoXingZhiBiaoQianDuanVo list9 = new YueYangKeKaoXingZhiBiaoQianDuanVo("平均利用率","%",rs.getString("YYDC_PJLYLV1"),rs.getString("YYDC_PJLYLV2"),rs.getString("YYDC_PJLYLV3"),rs.getString("YYDC_PJLYLV4"),rs.getString("YYDC_PJLYLV5"),rs.getString("YYDC_PJLYLV6"),rs.getString("YYDC_PJLYLV"));
//				YueYangKeKaoXingZhiBiaoQianDuanVo list10 = new YueYangKeKaoXingZhiBiaoQianDuanVo("平均可调出力","%",rs.getString("YYDC_PJKTCL1"),rs.getString("YYDC_PJKTCL2"),rs.getString("YYDC_PJKTCL3"),rs.getString("YYDC_PJKTCL4"),rs.getString("YYDC_PJKTCL5"),rs.getString("YYDC_PJKTCL6"),rs.getString("YYDC_PJKTCL"));
//				YueYangKeKaoXingZhiBiaoQianDuanVo list11 = new YueYangKeKaoXingZhiBiaoQianDuanVo("非停次数","次",rs.getString("YYDC_NLJFTCS1"),rs.getString("YYDC_NLJFTCS2"),rs.getString("YYDC_NLJFTCS3"),rs.getString("YYDC_NLJFTCS4"),rs.getString("YYDC_NLJFTCS5"),rs.getString("YYDC_NLJFTCS6"),rs.getString("YYDC_NLJFTCS"));
//				YueYangKeKaoXingZhiBiaoQianDuanVo list12 = new YueYangKeKaoXingZhiBiaoQianDuanVo("非停时间","小时",rs.getString("YYDC_NLJFTXSS1"),rs.getString("YYDC_NLJFTXSS2"),rs.getString("YYDC_NLJFTXSS3"),rs.getString("YYDC_NLJFTXSS4"),rs.getString("YYDC_NLJFTXSS5"),rs.getString("YYDC_NLJFTXSS6"),rs.getString("YYDC_NLJFTXSS"));
				YueYangKeKaoXingZhiBiaoQianDuanVo list1 = new YueYangKeKaoXingZhiBiaoQianDuanVo("机组状态","",getRJZZT(rs.getString("YYDC_RJZZT1"))
						,getRJZZT(rs.getString("YYDC_RJZZT2")),getRJZZT(rs.getString("YYDC_RJZZT3")),getRJZZT(rs.getString("YYDC_RJZZT4"))
						,getRJZZT(rs.getString("YYDC_RJZZT5")),getRJZZT(rs.getString("YYDC_RJZZT3")),"");
				YueYangKeKaoXingZhiBiaoQianDuanVo list2 = new YueYangKeKaoXingZhiBiaoQianDuanVo("日运行小时","小时", ToolUtils.size2(rs.getString("YYDC_RYXXSS1"))
						,ToolUtils.size2(rs.getString("YYDC_RYXXSS2")),ToolUtils.size2(rs.getString("YYDC_RYXXSS3"))
						,ToolUtils.size2(rs.getString("YYDC_RYXXSS4")),ToolUtils.size2(rs.getString("YYDC_RYXXSS5"))
						,ToolUtils.size2(rs.getString("YYDC_RYXXSS6")),ToolUtils.size2(rs.getString("YYDC_RYXXSS")));
				YueYangKeKaoXingZhiBiaoQianDuanVo list3 = new YueYangKeKaoXingZhiBiaoQianDuanVo("连续运行","天",ToolUtils.size2(rs.getString("YYDC_LXYXTS1"))
						,ToolUtils.size2(rs.getString("YYDC_LXYXTS2")),ToolUtils.size2(rs.getString("YYDC_LXYXTS3"))
						,ToolUtils.size2(rs.getString("YYDC_LXYXTS4")),ToolUtils.size2(rs.getString("YYDC_LXYXTS5"))
						,ToolUtils.size2(rs.getString("YYDC_LXYXTS6")),"");
				YueYangKeKaoXingZhiBiaoQianDuanVo list4 = new YueYangKeKaoXingZhiBiaoQianDuanVo("停备（计停）","小时",ToolUtils.size2(rs.getString("YYDC_RTBXSS1"))
						,ToolUtils.size2(rs.getString("YYDC_RTBXSS2")),ToolUtils.size2(rs.getString("YYDC_RTBXSS3"))
						,ToolUtils.size2(rs.getString("YYDC_RTBXSS4")),ToolUtils.size2(rs.getString("YYDC_RTBXSS5"))
						,ToolUtils.size2(rs.getString("YYDC_RTBXSS6")),"");
				YueYangKeKaoXingZhiBiaoQianDuanVo list5 = new YueYangKeKaoXingZhiBiaoQianDuanVo("累计检修","天",ToolUtils.size2(rs.getString("YYDC_NLJJXTS1"))
						,ToolUtils.size2(rs.getString("YYDC_NLJJXTS2")),ToolUtils.size2(rs.getString("YYDC_NLJJXTS3"))
						,ToolUtils.size2(rs.getString("YYDC_NLJJXTS4")),ToolUtils.size2(rs.getString("YYDC_NLJJXTS5"))
						,ToolUtils.size2(rs.getString("YYDC_NLJJXTS6")),"");
				YueYangKeKaoXingZhiBiaoQianDuanVo list6 = new YueYangKeKaoXingZhiBiaoQianDuanVo("等效可用小时","%",ToolUtils.size2(rs.getString("YYDC_DXKYXSS1"))
						,ToolUtils.size2(rs.getString("YYDC_DXKYXSS2")),ToolUtils.size2(rs.getString("YYDC_DXKYXSS3"))
						,ToolUtils.size2(rs.getString("YYDC_DXKYXSS4")),ToolUtils.size2(rs.getString("YYDC_DXKYXSS5"))
						,ToolUtils.size2(rs.getString("YYDC_DXKYXSS6")),ToolUtils.size2(rs.getString("YYDC_DXKYXSS")));
				YueYangKeKaoXingZhiBiaoQianDuanVo list7 = new YueYangKeKaoXingZhiBiaoQianDuanVo("等效可用系数","%",ToolUtils.size2(rs.getString("YYDC_DXKYXS1"))
						,ToolUtils.size2(rs.getString("YYDC_DXKYXS2")),ToolUtils.size2(rs.getString("YYDC_DXKYXS3"))
						,ToolUtils.size2(rs.getString("YYDC_DXKYXS4")),ToolUtils.size2(rs.getString("YYDC_DXKYXS5"))
						,ToolUtils.size2(rs.getString("YYDC_DXKYXS6")),ToolUtils.size2(rs.getString("YYDC_DXKYXS")));
				YueYangKeKaoXingZhiBiaoQianDuanVo list8 = new YueYangKeKaoXingZhiBiaoQianDuanVo("出力系数","%",ToolUtils.size2(rs.getString("YYDC_CLXS1"))
						,ToolUtils.size2(rs.getString("YYDC_CLXS2")),ToolUtils.size2(rs.getString("YYDC_CLXS3"))
						,ToolUtils.size2(rs.getString("YYDC_CLXS4")),ToolUtils.size2(rs.getString("YYDC_CLXS5"))
						,ToolUtils.size2(rs.getString("YYDC_CLXS6")),ToolUtils.size2(rs.getString("YYDC_CLXS")));
				YueYangKeKaoXingZhiBiaoQianDuanVo list9 = new YueYangKeKaoXingZhiBiaoQianDuanVo("平均利用率","%",ToolUtils.size2(rs.getString("YYDC_PJLYLV1"))
						,ToolUtils.size2(rs.getString("YYDC_PJLYLV2")),ToolUtils.size2(rs.getString("YYDC_PJLYLV3"))
						,ToolUtils.size2(rs.getString("YYDC_PJLYLV4")),ToolUtils.size2(rs.getString("YYDC_PJLYLV5"))
						,ToolUtils.size2(rs.getString("YYDC_PJLYLV6")),ToolUtils.size2(rs.getString("YYDC_PJLYLV")));
				YueYangKeKaoXingZhiBiaoQianDuanVo list10 = new YueYangKeKaoXingZhiBiaoQianDuanVo("平均可调出力","%",ToolUtils.size2(rs.getString("YYDC_PJKTCL1"))
						,ToolUtils.size2(rs.getString("YYDC_PJKTCL2")),ToolUtils.size2(rs.getString("YYDC_PJKTCL3"))
						,ToolUtils.size2(rs.getString("YYDC_PJKTCL4")),ToolUtils.size2(rs.getString("YYDC_PJKTCL5"))
						,ToolUtils.size2(rs.getString("YYDC_PJKTCL6")),ToolUtils.size2(rs.getString("YYDC_PJKTCL")));
				YueYangKeKaoXingZhiBiaoQianDuanVo list11 = new YueYangKeKaoXingZhiBiaoQianDuanVo("非停次数","次",ToolUtils.size2(rs.getString("YYDC_NLJFTCS1"))
						,ToolUtils.size2(rs.getString("YYDC_NLJFTCS2")),ToolUtils.size2(rs.getString("YYDC_NLJFTCS3"))
						,ToolUtils.size2(rs.getString("YYDC_NLJFTCS4")),ToolUtils.size2(rs.getString("YYDC_NLJFTCS5"))
						,ToolUtils.size2(rs.getString("YYDC_NLJFTCS6")),ToolUtils.size2(rs.getString("YYDC_NLJFTCS")));
				YueYangKeKaoXingZhiBiaoQianDuanVo list12 = new YueYangKeKaoXingZhiBiaoQianDuanVo("非停时间","小时",ToolUtils.size2(rs.getString("YYDC_NLJFTXSS1"))
						,ToolUtils.size2(rs.getString("YYDC_NLJFTXSS2")),ToolUtils.size2(rs.getString("YYDC_NLJFTXSS3"))
						,ToolUtils.size2(rs.getString("YYDC_NLJFTXSS4")),ToolUtils.size2(rs.getString("YYDC_NLJFTXSS5"))
						,ToolUtils.size2(rs.getString("YYDC_NLJFTXSS6")),ToolUtils.size2(rs.getString("YYDC_NLJFTXSS")));
//				System.out.println(list1);
				list.add(list1);
				list.add(list2);
				list.add(list3);
				list.add(list4);
				list.add(list5);
				list.add(list6);
				list.add(list7);
				list.add(list8);
				list.add(list9);
				list.add(list10);
				list.add(list11);
				list.add(list12);
				System.out.println(list);

			}
		} catch (SQLException ex){
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
			ex.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(stmt!=null)
					stmt.close();
			}catch(SQLException se2){
				se2.printStackTrace();
			}// nothing we can do
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}//end finally try

		}//end try
		System.out.println("Goodbye!");
		return list;
	}//end main
	//火电指标前端展示
	public static List<YueYangKeKaoXingZhiBiaoQianDuanVo> demo_hdquery(String sql) {
		ResultConfigureVo rs1 = getRs(sql,"1");
		Connection conn = rs1.getConn();
		Statement stmt = rs1.getStmt();
		ResultSet rs = rs1.getRs();
		List<YueYangKeKaoXingZhiBiaoQianDuanVo> list = new ArrayList<>();

		try{
			while(rs.next()){
				YueYangKeKaoXingZhiBiaoQianDuanVo list1 = new YueYangKeKaoXingZhiBiaoQianDuanVo("机组状态","",getRJZZT(rs.getString("YYDC_RJZZT1"))
						,getRJZZT(rs.getString("YYDC_RJZZT2")),getRJZZT(rs.getString("YYDC_RJZZT3")),getRJZZT(rs.getString("YYDC_RJZZT4"))
						,getRJZZT(rs.getString("YYDC_RJZZT5")),getRJZZT(rs.getString("YYDC_RJZZT6")),"");
				YueYangKeKaoXingZhiBiaoQianDuanVo list2 = new YueYangKeKaoXingZhiBiaoQianDuanVo("日运行小时","小时", ToolUtils.size2(rs.getString("YYDC_RYXXSS1"))
						,ToolUtils.size2(rs.getString("YYDC_RYXXSS2")),ToolUtils.size2(rs.getString("YYDC_RYXXSS3"))
						,ToolUtils.size2(rs.getString("YYDC_RYXXSS4")),ToolUtils.size2(rs.getString("YYDC_RYXXSS5"))
						,ToolUtils.size2(rs.getString("YYDC_RYXXSS6")),ToolUtils.size2(rs.getString("YYDC_RYXXSS")));
				YueYangKeKaoXingZhiBiaoQianDuanVo list3 = new YueYangKeKaoXingZhiBiaoQianDuanVo("连续运行","天",ToolUtils.size2(rs.getString("YYDC_LXYXTS1"))
						,ToolUtils.size2(rs.getString("YYDC_LXYXTS2")),ToolUtils.size2(rs.getString("YYDC_LXYXTS3"))
						,ToolUtils.size2(rs.getString("YYDC_LXYXTS4")),ToolUtils.size2(rs.getString("YYDC_LXYXTS5"))
						,ToolUtils.size2(rs.getString("YYDC_LXYXTS6")),"");
				YueYangKeKaoXingZhiBiaoQianDuanVo list4 = new YueYangKeKaoXingZhiBiaoQianDuanVo("停备（计停）","小时",ToolUtils.size2(rs.getString("YYDC_RTBXSS1"))
						,ToolUtils.size2(rs.getString("YYDC_RTBXSS2")),ToolUtils.size2(rs.getString("YYDC_RTBXSS3"))
						,ToolUtils.size2(rs.getString("YYDC_RTBXSS4")),ToolUtils.size2(rs.getString("YYDC_RTBXSS5"))
						,ToolUtils.size2(rs.getString("YYDC_RTBXSS6")),"");
				YueYangKeKaoXingZhiBiaoQianDuanVo list5 = new YueYangKeKaoXingZhiBiaoQianDuanVo("累计检修","天",ToolUtils.size2(rs.getString("YYDC_NLJJXTS1"))
						,ToolUtils.size2(rs.getString("YYDC_NLJJXTS2")),ToolUtils.size2(rs.getString("YYDC_NLJJXTS3"))
						,ToolUtils.size2(rs.getString("YYDC_NLJJXTS4")),ToolUtils.size2(rs.getString("YYDC_NLJJXTS5"))
						,ToolUtils.size2(rs.getString("YYDC_NLJJXTS6")),"");
				YueYangKeKaoXingZhiBiaoQianDuanVo list6 = new YueYangKeKaoXingZhiBiaoQianDuanVo("等效可用小时","%",ToolUtils.size2(rs.getString("YYDC_DXKYXSS1"))
						,ToolUtils.size2(rs.getString("YYDC_DXKYXSS2")),ToolUtils.size2(rs.getString("YYDC_DXKYXSS3"))
						,ToolUtils.size2(rs.getString("YYDC_DXKYXSS4")),ToolUtils.size2(rs.getString("YYDC_DXKYXSS5"))
						,ToolUtils.size2(rs.getString("YYDC_DXKYXSS6")),ToolUtils.size2(rs.getString("YYDC_DXKYXSS")));
				YueYangKeKaoXingZhiBiaoQianDuanVo list7 = new YueYangKeKaoXingZhiBiaoQianDuanVo("等效可用系数","%",ToolUtils.size2(rs.getString("YYDC_DXKYXS1"))
						,ToolUtils.size2(rs.getString("YYDC_DXKYXS2")),ToolUtils.size2(rs.getString("YYDC_DXKYXS3"))
						,ToolUtils.size2(rs.getString("YYDC_DXKYXS4")),ToolUtils.size2(rs.getString("YYDC_DXKYXS5"))
						,ToolUtils.size2(rs.getString("YYDC_DXKYXS6")),ToolUtils.size2(rs.getString("YYDC_DXKYXS")));
				YueYangKeKaoXingZhiBiaoQianDuanVo list8 = new YueYangKeKaoXingZhiBiaoQianDuanVo("出力系数","%",ToolUtils.size2(rs.getString("YYDC_CLXS1"))
						,ToolUtils.size2(rs.getString("YYDC_CLXS2")),ToolUtils.size2(rs.getString("YYDC_CLXS3"))
						,ToolUtils.size2(rs.getString("YYDC_CLXS4")),ToolUtils.size2(rs.getString("YYDC_CLXS5"))
						,ToolUtils.size2(rs.getString("YYDC_CLXS6")),ToolUtils.size2(rs.getString("YYDC_CLXS")));
//				YueYangKeKaoXingZhiBiaoQianDuanVo list9 = new YueYangKeKaoXingZhiBiaoQianDuanVo("平均利用率","%",rs.getString(51),rs.getString(52),rs.getString(53),rs.getString(54),rs.getString(55),rs.getString(56),rs.getString(80)+"");
//				YueYangKeKaoXingZhiBiaoQianDuanVo list10 = new YueYangKeKaoXingZhiBiaoQianDuanVo("平均可调出力","%",rs.getString(57),rs.getString(58),rs.getString(59),rs.getString(60),rs.getString(61),rs.getString(62),rs.getString(81)+"");
//				YueYangKeKaoXingZhiBiaoQianDuanVo list11 = new YueYangKeKaoXingZhiBiaoQianDuanVo("非停次数","次",rs.getString(63),rs.getString(64),rs.getString(65),rs.getString(66),rs.getString(67),rs.getString(68),rs.getString(82)+"");
//				YueYangKeKaoXingZhiBiaoQianDuanVo list12 = new YueYangKeKaoXingZhiBiaoQianDuanVo("非停时间","小时",rs.getString(69),rs.getString(70),rs.getString(71),rs.getString(72),rs.getString(73),rs.getString(74),rs.getString(83)+"");

				list.add(list1);
				list.add(list2);
				list.add(list3);
				list.add(list4);
				list.add(list5);
				list.add(list6);
				list.add(list7);
				list.add(list8);
				System.out.println(list);

			}
		}catch (SQLException ex){
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
			ex.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
//		catch(Exception e){
//			throw new Exception(e);
////			e.printStackTrace();
//		}
		finally{
			try{
				if(stmt!=null)
					stmt.close();
			}catch(SQLException se2){
				se2.printStackTrace();
			}// nothing we can do
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}//end finally try

		}//end try
		System.out.println("Goodbye!");
		return list;
	}//end main

	private static String getRJZZT(String RJZZT) {
		RJZZT = "0".equals(RJZZT)?"":"1".equals(RJZZT)?"运行":"2".equals(RJZZT)?"停用":"3".equals(RJZZT)?"检修":"4".equals(RJZZT)?"备用":"5".equals(RJZZT)?"非停":"";
		return RJZZT;
	}

	public static void main(String[] args) {
//		String sql = "select * from hnskdb.REPORT_KKXZB_JZZT  ";
//		demo_query(sql);

//		String sql = "select * from hnskdb.REPORT_KKXZB_JZZT where StateChangeBefore = '运行' ";
//		demo_query(sql);
//		String sql0 = "select ID,StateType,EditStateAfter,MachineNo,EditStateBefore from hnskdb.REPORT_KKXZB_JZZT  ";
//		demo_query(sql0);
//		String sql2 = "update hnskdb.REPORT_KKXZB_JZZT  set StateChangeTime = '2021-07-06 16:05:00' where EditStateBefore='检修'and EditStateAfter='运行' ";
//		demo_update(sql2);
//		String sql2 = "insert into hnskdb.REPORT_KKXZB_JZZT(ID,StateType,MachineNo,StateChangeBefore,StateChangeAfter,StateChangeTime,EditUserName,EditUserNo)  values(2,'岳阳电厂','1#机组','停用','运行','2021-07-06 16:08:00','若依','admin') ";
//		demo_update(sql2);
//		String sql3 = "select * from hnskdb.REPORT_KKXZB_JZZT  ";
//		demo_query(sql3);
//		String sql4 = "select * from HNHN.REPORT_KKXZB_RESULT  where data_time>='2021-06-01 00:00:00' and data_time<='2021-06-03 00:00:00'";
//		demo_hdquery(sql4);
		String sql4 = "truncate HNHN.REPORT_KKXZB_RESULT";
		demo_update(sql4);
	}
	   

}
