package com.huoyun.core.tools;

import java.util.Random;

import org.joda.time.LocalDateTime;

public class CodeGeneratorUtils {

	public static String generator() {
		Random random = new Random();
		random.setSeed(LocalDateTime.now().getMillisOfSecond());
		int num = random.nextInt(1000000);
		return String.format("%06d", num);
	}
}
