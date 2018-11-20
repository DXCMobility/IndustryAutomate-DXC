package Presenter;

import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/**
 * -----------------------------------------------------------------------------
 * Class Name: HttpConnection
 * Created By: Brindha A
 * Created Date: 11-03-2016
 * Modified By: Nikunj
 * Modified Date: 09-08-2016
 * Purpose: This is used to read url and get the data's from that url.
 * -----------------------------------------------------------------------------
 */
public class HttpConnection {
	private static final String TAG = "HttpConnection";

	public String readUrl(String mapsApiDirectionsUrl) throws Exception {
		String sData = "";
		//doTrustToCertificates();
		InputStream inputStream = null;
		HttpsURLConnection urlConnection = null;
		try {
			URL url = new URL(mapsApiDirectionsUrl);

			urlConnection = (HttpsURLConnection) url.openConnection();
			urlConnection.connect();

			inputStream = urlConnection.getInputStream();
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
					inputStream));
			StringBuffer stringBuffer = new StringBuffer();
			String line = "";
			while ((line = bufferedReader.readLine()) != null) {
				stringBuffer.append(line);
			}
			sData = stringBuffer.toString();

			Log.e("",sData);
			bufferedReader.close();
		} catch (Exception e) {
			Log.e(TAG,"Exception>>>"+e);
		} finally {
			inputStream.close();
			urlConnection.disconnect();
		}
		return sData;
	}
	/**
	 * -----------------------------------------------------------------------------
	 * Method Name: doTrustToCertificates
	 * Created By: Nikunj
	 * Created Date: 09-08-2016
	 * Modified By:
	 * Modified Date:
	 * Purpose:
	 * -----------------------------------------------------------------------------
	 */
	public void doTrustToCertificates() throws Exception {
		TrustManager[] trustAllCerts = new TrustManager[]{
				new X509TrustManager() {
					public X509Certificate[] getAcceptedIssuers() {
						return null;
					}

					public void checkServerTrusted(X509Certificate[] certs, String authType) throws CertificateException {
						return;
					}

					public void checkClientTrusted(X509Certificate[] certs, String authType) throws CertificateException {
						return;
					}
				}
		};

		/*SSLContext sslContext = SSLContext.getInstance(Constants.SSL);
		sslContext.init(null, trustAllCerts, new SecureRandom());
		HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());
		HostnameVerifier hnVerifier = new HostnameVerifier() {
			public boolean verify(String urlHostName, SSLSession session) {
				return true;
			}
		};
		HttpsURLConnection.setDefaultHostnameVerifier(hnVerifier);*/
	}
}