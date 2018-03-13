package com.weicheng.ssm.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * 自定义日期参数转换器
 * 将格式为yyyy-MM-dd HH:mm:ss的日期传入参数转化为Date格式的参数
 * 需要将此文件配置到springmvc.xml中
 * */
public class CustomDateConverter implements Converter<String,Date /*注意这里的目标类型一定要和pojo中的目标属性类型一致*/>{

	@Override
	public Date convert(String source){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return simpleDateFormat.parse(source);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

}
