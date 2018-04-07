package top.keking.utils;

import java.util.UUID;

public class UUIDUtil {

	public static String creatUUID() {
		UUID randomUUID = UUID.randomUUID();
		return randomUUID.toString().replaceAll("-", "");
	}
}
