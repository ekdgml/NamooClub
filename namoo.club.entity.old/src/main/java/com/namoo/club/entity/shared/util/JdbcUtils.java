package com.namoo.club.entity.shared.util;

public class JdbcUtils {
	//
	private JdbcUtils() {
		//
	}
	
	public static void closeQuietly(AutoCloseable ... targets) {
		//
		for (AutoCloseable target : targets) {
			if (target != null) {
				try { target.close(); } catch (Exception e) { }
			}
		}
	}
}
