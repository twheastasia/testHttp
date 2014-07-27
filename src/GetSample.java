
import java.io.IOException;

import org.apache.commons.httpclient.*;

import org.apache.commons.httpclient.methods.GetMethod;

import org.apache.commons.httpclient.params.HttpMethodParams;

public class GetSample{

	public static void main(String[] args) {
		String responseBodyStr = "";
		String url = "http://www.sojump.com/Handler/joinawardactivitymobo.ashx?t=1406426410199&activity=3674412&joinactivity=114869487";

		for(int i=0; i< 10; i++){
			responseBodyStr = getResponseFromUrl(url);
			System.out.println("response: " + responseBodyStr);
		}
	}
	
	private static String getResponseFromUrl(String url)
	{
		String body = "";
		byte[] responseBody = null;
		//����HttpClient��ʵ��
		HttpClient httpClient = new HttpClient();
		//����GET������ʵ��
		GetMethod getMethod = new GetMethod(url);
		//ʹ��ϵͳ�ṩ��Ĭ�ϵĻָ�����
		getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,	new DefaultHttpMethodRetryHandler());
		try {
			//ִ��getMethod
			int statusCode = httpClient.executeMethod(getMethod);
			if (statusCode != HttpStatus.SC_OK) {
				System.err.println("Method failed: "+ getMethod.getStatusLine());
			}
			//��ȡ����
			responseBody = getMethod.getResponseBody();
			//��������
			System.out.println(new String(responseBody));
		} catch (HttpException e) {
			//�����������쳣��������Э�鲻�Ի��߷��ص�����������
			System.out.println("Please check your provided http address!");
			e.printStackTrace();
		} catch (IOException e) {
			//���������쳣
			e.printStackTrace();
		} finally {
			//�ͷ�����
			getMethod.releaseConnection();
		}
		body = new String(responseBody);
		return body;
	}
	

}