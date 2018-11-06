package zxjt.inte.report;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.io.FileUtils;

import zxjt.inte.util.FolderTypes;
import zxjt.inte.util.GetFolderPath;

public abstract class DBConnection {
	private static Connection conn;

	public static Connection getConnection(Boolean isFirst) throws SQLException, IOException, ClassNotFoundException {
		if (conn == null) {
			System.out.println("Start to prepare the local report DB...");
			String desDbFilePath = GetFolderPath.getFolderPath(FolderTypes.REPORT) + "cache.db";
			String desCssFilePath = GetFolderPath.getFolderPath(FolderTypes.REPORT) + "extent.css";
			String desJsFilePath = GetFolderPath.getFolderPath(FolderTypes.REPORT) + "extent.js";

			File desDbFile = new File(desDbFilePath);
			File desCssFile = new File(desCssFilePath);
			File desJsFile = new File(desJsFilePath);
			if (isFirst) {
				FileUtils.copyInputStreamToFile(DBConnection.class.getResourceAsStream("/report-style/template.db"),
						desDbFile);
			}
			if (!desCssFile.exists()) {
				FileUtils.copyInputStreamToFile(DBConnection.class.getResourceAsStream("/report-style/extent.css"),
						desCssFile);
			}
			if (!desJsFile.exists()) {
				FileUtils.copyInputStreamToFile(DBConnection.class.getResourceAsStream("/report-style/extent.js"),
						desJsFile);
			}
			Class.forName("org.sqlite.JDBC");
//			Class.forName("com.mysql.jdbc.Driver");
			String vConnStr = "jdbc:sqlite://" + desDbFilePath;
//			String vConnStr = "jdbc:mysql://localhost:3306/light?useUnicode=true&characterEncoding=utf8";
//			String user = "web";
//			String password = "123123";
			conn = DriverManager.getConnection(vConnStr);
//			conn = DriverManager.getConnection(vConnStr,user,password);
			if (conn == null) {
				System.out.println("conn is null");
			}

			// 开启外键
			Statement vStmt = conn.createStatement();
			vStmt.execute("PRAGMA foreign_keys = ON;");
			vStmt.close();
		}
		System.out.println("Local report DB is ready.");
		return conn;
	}

	public static void close() {
		if (conn != null) {
			System.out.println("Close db!");
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn = null;
		}
	}

}
