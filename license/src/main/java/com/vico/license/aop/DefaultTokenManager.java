package com.vico.license.aop;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

import com.github.pagehelper.StringUtil;

@Component
public class DefaultTokenManager implements TokenManager {
	
	private static Map<String, String> tokenMap = new ConcurrentHashMap<>();
	
	@Override
	public String createToken(String username) {
		String token = UUID.randomUUID().toString();
		tokenMap.put(token, username);
		return token;
	}

	@Override
	public boolean checkToken(String token) {
		return !StringUtil.isEmpty(token) && tokenMap.containsKey(token);  //检查令牌容器中是否存在该令牌
	}

}