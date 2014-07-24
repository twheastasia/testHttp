
import java.io.IOException;

import org.apache.commons.httpclient.*;

import org.apache.commons.httpclient.methods.GetMethod;

import org.apache.commons.httpclient.params.HttpMethodParams;

public class GetSample{

	public static void main(String[] args) {

		//构造HttpClient的实例

		HttpClient httpClient = new HttpClient();

		//创建GET方法的实例
		String url = "http://c.360doo.com/zmddh/zmywx/mobile/home/index.aspx?c=3583&s=2103&p=13359&a=63&v=894DB3182CE2096AF2A80910CDC99166EE7ACAF794154760AE98FE58204C37B0264E271BF08CB6B89485D6E2B7556D951B6166A81CEF2732";
		GetMethod getMethod = new GetMethod(url);

		//使用系统提供的默认的恢复策略

		getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,	new DefaultHttpMethodRetryHandler());

		try {

			//执行getMethod

			int statusCode = httpClient.executeMethod(getMethod);

			if (statusCode != HttpStatus. SC_OK) {

				System.err.println("Method failed: "+ getMethod.getStatusLine());

			}

			//读取内容

			byte[] responseBody = getMethod.getResponseBody();

			//处理内容
			
			System.out.println(new String(responseBody));
			System.out.println("Ddddddddddddddddddd");
		} catch (HttpException e) {

			//发生致命的异常，可能是协议不对或者返回的内容有问题

			System.out.println("Please check your provided http address!");

			e.printStackTrace();

		} catch (IOException e) {

			//发生网络异常

			e.printStackTrace();

		} finally {

			//释放连接

			getMethod.releaseConnection();

		}

	}

}