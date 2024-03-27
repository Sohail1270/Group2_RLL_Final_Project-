
package listerner;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Iretry implements IRetryAnalyzer{

	private int retryCount = 1;
    private static final int maxRetryCount = 3;
	
	@Override
	public boolean retry(ITestResult result) {
	
		 if (retryCount < maxRetryCount) {
	            retryCount++;
	            return true;	
		 }
		return false;
	}

}
