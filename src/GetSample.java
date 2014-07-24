
import java.io.IOException;

import org.apache.commons.httpclient.*;

import org.apache.commons.httpclient.methods.GetMethod;

import org.apache.commons.httpclient.params.HttpMethodParams;

public class GetSample{

	public static void main(String[] args) {

		//����HttpClient��ʵ��

		HttpClient httpClient = new HttpClient();

		//����GET������ʵ��
		String url = "http://c.360doo.com/zmddh/zmywx/mobile/home/index.aspx?c=3583&s=2103&p=13359&a=63&v=894DB3182CE2096AF2A80910CDC99166EE7ACAF794154760AE98FE58204C37B0264E271BF08CB6B89485D6E2B7556D951B6166A81CEF2732";
		GetMethod getMethod = new GetMethod(url);

		//ʹ��ϵͳ�ṩ��Ĭ�ϵĻָ�����

		getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,	new DefaultHttpMethodRetryHandler());

		try {

			//ִ��getMethod

			int statusCode = httpClient.executeMethod(getMethod);

			if (statusCode != HttpStatus. SC_OK) {

				System.err.println("Method failed: "+ getMethod.getStatusLine());

			}

			//��ȡ����

			byte[] responseBody = getMethod.getResponseBody();

			//��������
			
			System.out.println(new String(responseBody));
			System.out.println("Ddddddddddddddddddd");
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

	}

}