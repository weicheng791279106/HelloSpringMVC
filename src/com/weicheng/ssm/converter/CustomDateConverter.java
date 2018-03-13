package com.weicheng.ssm.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * �Զ������ڲ���ת����
 * ����ʽΪyyyy-MM-dd HH:mm:ss�����ڴ������ת��ΪDate��ʽ�Ĳ���
 * ��Ҫ�����ļ����õ�springmvc.xml��
 * */
public class CustomDateConverter implements Converter<String,Date /*ע�������Ŀ������һ��Ҫ��pojo�е�Ŀ����������һ��*/>{

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
