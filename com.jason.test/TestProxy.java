import com.jason.Dproxy.ProxyHandle;


public class TestProxy {
public static void main(String[] args) {
	ProxyHandle proxy = new ProxyHandle();
	Test test =(Test) proxy.bind(new Test());
	Integer value = test.add(3, 6);
	System.out.println("value "+ value);
}
}
