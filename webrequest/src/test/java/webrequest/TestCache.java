package webrequest;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

public class TestCache {
	@Test
	public void testName() throws Exception {
		long last = System.currentTimeMillis();
		System.out.println(last);
		Cache<Object, Object> cache = CacheBuilder.newBuilder().expireAfterAccess(2, TimeUnit.SECONDS)
				.removalListener((notification)->{
					System.out.println(notification.getValue()+"-------------"+System.currentTimeMillis());
				})
				.build();
		cache.put("2t", "两秒回收");
		System.out.println(cache.get("2t", ()->"没有了"));
		Thread.sleep(3000);
		System.out.println(cache.get("2t", ()->"没有了"));
	}
}
