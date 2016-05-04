package com.huoyun.core.common.net;

import java.io.IOException;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.apache.log4j.Logger;

import com.huoyun.core.common.impl.BoFacadeImpl;

@SuppressWarnings("deprecation")
public class HttpClientUtils {

	private static Logger logger = Logger.getLogger(BoFacadeImpl.class);

	private static HttpClient httpClient;
	private final static int CONNECTION_TIMEOUT_MILLISECONDS = 3 * 1000;
	private final static int SOCKET_TIMEOUT_MILLISECONDS = 3 * 1000;

	public static HttpClient getHttpClient() {
		if (httpClient == null) {
			try {
				SSLContext sslcontext = SSLContext.getInstance("TLS");
				sslcontext.init(null,
						new TrustManager[] { new CustomX509TrustManager() },
						null);
				SSLSocketFactory sf = new SSLSocketFactory(sslcontext,
						SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
				Scheme httpsScheme = new Scheme("https", 443, sf);
				Scheme httpScheme = new Scheme("http", 80,
						PlainSocketFactory.getSocketFactory());
				SchemeRegistry schemeRegistry = new SchemeRegistry();
				schemeRegistry.register(httpsScheme);
				schemeRegistry.register(httpScheme);
				PoolingClientConnectionManager connectionManager = new PoolingClientConnectionManager(
						schemeRegistry);
				connectionManager.setDefaultMaxPerRoute(200);
				connectionManager.setMaxTotal(1000);
				httpClient = new DefaultHttpClient(connectionManager);
			} catch (Exception e) {
				logger.error(e);
			}
		}
		return httpClient;
	}

	public static HttpResponse sendPost(String url, StringEntity entity)
			throws ClientProtocolException, IOException {
		HttpPost httpPost = new HttpPost(url);
		RequestConfig config = RequestConfig.custom()
				.setConnectTimeout(CONNECTION_TIMEOUT_MILLISECONDS)
				.setSocketTimeout(SOCKET_TIMEOUT_MILLISECONDS).build();
		httpPost.setConfig(config);
		httpPost.setHeader("Content-type", "application/json");
		httpPost.setHeader("Accept", "application/json");
		if (entity != null) {
			httpPost.setEntity(entity);
		}

		return getHttpClient().execute(httpPost);
	}
}
