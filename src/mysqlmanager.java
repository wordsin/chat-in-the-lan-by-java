import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class mysqlmanager {

//	public static void main(String[] args) {
//		// TODO 自动生成的方法存根
//
//	}
	String user;
	String password;
	String url="jdbc:mysql://localhost:3306/mysql?useSSL=false";
	Connection conn=null;
	PreparedStatement pst=null;
	Statement sst=null;
	public mysqlmanager(String usr,String passwd) {
		user=usr;
		password=passwd;
		
	}
	//link to the mysql database
	void linkdb() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		
			conn = DriverManager.getConnection(url,user,password);
			DatabaseMetaData dbmd=conn.getMetaData();

            ResultSet tableRS = dbmd.getTables(null, null,  "chatusr", null );

            if (tableRS.next())
            	System.out.println(" the table is exsited");
            else {
            	String sql = "CREATE TABLE chatusr(";    
            	sql+= " ip char(15),";    
            	sql+= " port int(6),";    
            	sql+= " name char(255),";
            	sql+="PRIMARY KEY(ip))";
            	pst=conn.prepareStatement(sql);
            	pst.executeUpdate();
            }
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		System.out.println("连接数据库成功");
	}
	
	ResultSet queue(String sql) {
		ResultSet rest = null;
		try {
			pst=conn.prepareStatement(sql);
			rest = pst.executeQuery();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return rest;
	}
	boolean add(String sql) {
		boolean rest = false;
		try {
			pst=conn.prepareStatement(sql);
			pst.executeUpdate();
			rest = true;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return rest;
	}
	boolean del(String sql) {
		boolean rest = false;
		try {
			pst=conn.prepareStatement(sql);
			pst.executeUpdate();
			rest = true;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return rest;
	}
}
//public class mysqlmanager {
//
//	public static void main(String[] args) {
//		// TODO 自动生成的方法存根
//		mysqlmanagert t=new mysqlmanagert("root","ziv404");
//	}
//}