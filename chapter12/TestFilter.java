package chapter12;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class TestFilter implements Filter {
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("���� ���� ��...");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
//		System.out.println("JSP ó�� �� ���� ����");
//		System.out.println("Request ���Ϳ� Response ���� �ΰ����� �ִٰ� ����");
//		System.out.println("�� ���Ϳ� Request ���Ϳ� Response ���� �ΰ��� ��� �ۼ��� �� ����");
//		
//		System.out.println("doFilter �ż������� ó���ϴ� ������ Request ������ ��Ȱ");
//	
//		System.out.println("��) �α����� �ʿ��� �������� �����ϱ����� �α��� ���� Ȯ��");
//		System.out.println("�α����� �Ǿ��� �ʴٰ� ���Ͱ� �Ǵ����� ���� foFilter�޼��带 ȣ������ �ʰ�");
//		System.out.println("response.sendRedirest �Ǵ� RequestDispatcher �� ����ؼ� ���");
//		System.out.println("������ �ٸ� ������ �ű��");
		
		//��� �ٸ� ���� �Ǵ� ����ڰ� ��û�� ���ҽ��� ����
		chain.doFilter(request, response);
		
		System.out.println("JSP ó�� �� ���� ����");
		System.out.println("doFilter �޼��� �Ʒ����ٰ� �ڵ带 �ۼ��ϸ�");
		System.out.println("������ ������� ��û�� ó�� �� �� ������ �� ���͸� �� �� ����");
		System.out.println("���� Ŭ������ Request�� ���ͷ� Response�� ���ͷ� ���� ����� �ƴϰ�");
		System.out.println("���� Ŭ������ ����� doFilter �޼��� �ȿ��� ������ �Ű�����(chain)��");
		System.out.println("doFilter ��, �ķ� Request�� ó�� Response�� ó���� ���� ������");
	
		System.out.println("��) Mime Type�� ����������, content-Length�� �ʹ� ���� ������, gizpó���� �Ǿ��ִ��� ");
	}
	public void destroy() {
		System.out.println("���� ��ü");
	}
	
}
