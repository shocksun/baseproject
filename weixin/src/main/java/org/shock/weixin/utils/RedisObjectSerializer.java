package org.shock.weixin.utils;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.serializer.support.DeserializingConverter;
import org.springframework.core.serializer.support.SerializingConverter;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

public class RedisObjectSerializer implements RedisSerializer<Object>{

	private Converter<Object, byte[]> serializingConverter = new SerializingConverter();
	private Converter<byte[], Object> deserializingConverter = new DeserializingConverter();
	private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
	
	@Override
	public Object deserialize(byte[] arg0) throws SerializationException {
		if(arg0 == null || arg0.length == 0) {
			return null;
		}
		return this.deserializingConverter.convert(arg0);
	}

	@Override
	public byte[] serialize(Object arg0) throws SerializationException {
		if(arg0 == null) {
			return EMPTY_BYTE_ARRAY;
		}
		return this.serializingConverter.convert(arg0);
	}

}
