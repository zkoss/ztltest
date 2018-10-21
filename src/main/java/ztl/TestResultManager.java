package ztl;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TestResultManager {
	public static void main(String[] args) throws IOException {
		String dir = null;
		int i = 0;
		for (String s : args) {
			// ex. "./test/ztl/1010",
			if ("-dir".equalsIgnoreCase(s)) {
				dir = args[i + 1];
			}
			i++;
		}
		OutputStreamWriter out = null;
		try {
			File sourceFolder = new File(dir);
			if (!sourceFolder.isDirectory()) {
				System.err.println("invalid source folder");
				System.exit(-1);
			}
			Map<String, Set<String>> testInfo = new HashMap<String, Set<String>>();
			for (File file : sourceFolder.listFiles()) {
				String content = FileUtils.readFileToString(file, "UTF-8");
				String fileName = file.getName();
				if (!fileName.contains("merge") && !fileName.startsWith(".")) {
					System.out.println("handle file -> " + fileName);
					if (content.contains("ZTL TEST -")) {
						parseZTLTestCafeTestResult(testInfo, content, fileName.substring(0, fileName.lastIndexOf(".")));
					} else {
						parseZTLTestResult(testInfo, content);
					}
				}
			}
			
			StringBuilder output = new StringBuilder();
			for (Map.Entry entry : testInfo.entrySet()) {
				output.append(entry.getKey());
				output.append(" browsers: ");
				for (String browser : (Set<String>) entry.getValue())
					output.append(browser + ",");
				output.append("\n");
			}
			out = new OutputStreamWriter(
					new FileOutputStream(
							new File(dir + "/merged.txt")),
					"UTF-8");
			out.write(output.toString());
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}

	//org.zkoss.zktest.test2.F70.F70_ZK_2410Test  browsers: ie10,ie9
	private static void parseZTLTestResult(Map<String, Set<String>> testInfo, String content) {
		String lines[] = content.split("\n");
		System.out.println("lines: " + lines.length);
		for (String line : lines) {
			int browserIndex = line.indexOf("browsers");
			if (browserIndex != -1) {
				String key = line.substring(line.lastIndexOf(".") + 1, browserIndex).trim();
				String browserStr = line.substring(browserIndex).replaceAll("browsers:", "").trim();
				Set<String> browsers;
				if (testInfo.containsKey(key)) {
					browsers = testInfo.get(key);
				} else {
					browsers = new HashSet<String>();
				}
				if (browserStr.contains(",")) {
					String[] browserArr = browserStr.split(",");
					for (String browser : browserArr) {
						browsers.add(browser.trim());
					}
				} else {
					browsers.add(browserStr);
				}
				testInfo.put(key, browsers);
			}
		}
	}

	private static void parseZTLTestCafeTestResult(Map<String, Set<String>> testInfo, String content, String browser) {
		String lines[] = content.split("\n");
		System.out.println("lines: " + lines.length);
		for (String line : lines) {
			int browserIndex = line.indexOf("  ZTL TEST - ");
			if (browserIndex != -1) {
				line = line.substring(0, line.indexOf(".")).replace("ZTL TEST -", "").trim();
				String key = line.replace("-", "_").replace("TestCafe", "Test");
				Set<String> browsers;
				if (testInfo.containsKey(key)) {
					browsers = testInfo.get(key);
				} else {
					browsers = new HashSet<String>();
				}
				browsers.add(browser);
				testInfo.put(key, browsers);
			}
		}
	}
}