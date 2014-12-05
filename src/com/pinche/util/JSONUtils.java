package com.pinche.util;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * json格式转换工具类
 */
public class JSONUtils {

	static ObjectMapper objectMapper;

	static {
		if (objectMapper == null) {
			objectMapper = new ObjectMapper();
		}

		objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		objectMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
		// 允许出现特殊字符和转义符
		objectMapper.configure(Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
		objectMapper.configure(Feature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER, true);
		// 允许出现单引号
		objectMapper.configure(Feature.ALLOW_SINGLE_QUOTES, true);
		objectMapper.configure(Feature.ALLOW_NON_NUMERIC_NUMBERS, true);
	}

	/**
	 * 使用泛型方法，把json字符串转换为相应的JavaBean对象。
	 * (1)转换为普通JavaBean：readValue(json,Student.class)
	 * (2)转换为List:readValue(json,List
	 * .class).但是如果我们想把json转换为特定类型的List，比如List<Student>，就不能直接进行转换了。
	 * 因为readValue(json
	 * ,List.class)返回的其实是List<Map>类型，你不能指定readValue()的第二个参数是List<
	 * Student>.class，所以不能直接转换。
	 * 我们可以把readValue()的第二个参数传递为Student[].class.然后使用Arrays
	 * .asList();方法把得到的数组转换为特定类型的List。 (3)转换为Map：readValue(json,Map.class)
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;我们使用泛型，得到的也是泛型
	 * 
	 * @param content
	 *            要转换的JavaBean类型
	 * @param valueType
	 *            原始json字符串数据
	 * @return JavaBean对象
	 */
	public static <T> T readValue(String content, Class<T> valueType) {

		try {
			return objectMapper.readValue(content, valueType);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * 把JavaBean转换为json字符串 (1)普通对象转换：toJson(Student) (2)List转换：toJson(List)
	 * (3)Map转换:toJson(Map) 我们发现不管什么类型，都可以直接传入这个方法
	 * 
	 * @param object
	 *            JavaBean对象
	 * @return json字符串
	 */
	public static Object toJSon(Object object) {
		try {
			StringWriter stringWriter = new StringWriter();
			// JsonGenerator jsonGenerator =
			// objectMapper.getJsonFactory().createJsonGenerator(stringWriter);
			objectMapper.writeValue(stringWriter, object);
			// stringWriter.getBuffer().toString();
			objectMapper.writeValueAsString(object);
			//return stringWriter.getBuffer().toString();
			return objectMapper.writeValueAsString(object);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public static void main(String args[]) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "sssss\\ssssssss");
		map.put("account", "3333333333333");
		System.out.println(JSONUtils.toJSon(map));
	}
}