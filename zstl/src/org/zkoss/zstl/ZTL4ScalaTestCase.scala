/**
 *
 */
package org.zkoss.zstl
import org.zkoss.ztl.ZKClientTestCase
import org.zkoss.ztl.util.ConfigHelper
import org.zkoss.ztl.Widget
import scala.collection.JavaConversions._
import com.thoughtworks.selenium.SeleniumException
import org.zkoss.ztl.util.ZKSelenium
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import java.util.ArrayList
import java.util.concurrent.Callable
import java.util.HashSet
import org.zkoss.ztl.ConnectionManager
import org.apache.commons.exec.CommandLine
import org.apache.commons.exec.DefaultExecutor
import java.util.Date

/**
 * ZTL for Scala to test
 * @author jumperchen
 */
class ZTL4ScalaTestCase extends ZKClientTestCase {
  var ch = ConfigHelper.getInstance()
  target = ch.getServer() + ch.getContextPath() + "/" + ch.getAction()
  browsers = getBrowsers(ch.getBrowser())
  _timeout = ch.getTimeout().toInt
  caseID = getClass().getSimpleName()
  val _engine = new ThreadLocal[Widget]();
  
  def runZTL(zscript: String, executor: () => Unit) {
    val luuid = new Date().getTime();
    println(getTimeUUID() + "-" + luuid + ":log 1");
    val executorService = Executors.newCachedThreadPool();
    val callables = new ArrayList[Callable[String]];
    val browserSet = new HashSet[String];
        
    for (browser <- browsers) { 
      
      println(getTimeUUID() + "-" + luuid + ":log 2");
      
      val zkSelenium = browser.asInstanceOf[ZKSelenium];
      browserSet.add(zkSelenium.getBrowserName());
      println("add browser: " + zkSelenium.getBrowserName());

      callables.add(new Callable[String] {
        def call():String = {
          println(getTimeUUID() + "-" + luuid + ":log 3");
          try {
            println(getTimeUUID() + "-" + luuid + ":log 4-1");
            start(browser);
            windowFocus();
            windowMaximize();
            _engine.set(new Widget(new StringBuffer("zk.Desktop._dt")));
            println(getTimeUUID() + "-" + luuid + ":log 4-2");
            if (!zscript.isEmpty())
              runRawZscript(
                zscript
                  toString ());
              waitResponse();
	          executor();
	          println(getTimeUUID() + "-" + luuid + ":log 4-3");
			} catch {
				case e : SeleniumException =>
					ConfigHelper.getInstance().clearCache(zkSelenium);
					zkSelenium.shutdown();
					throw e;
				case other: Throwable =>
					throw other;
			} finally {
				println(getTimeUUID() + "-" + luuid + ":log 4-4");
				stop();
				println(getTimeUUID() + "-" + luuid + ":log 4-5");
			}
			return zkSelenium.getBrowserName();
        }
      });
    }

    val futures = executorService.invokeAll(callables, _timeout, TimeUnit.MILLISECONDS);
    println(getTimeUUID() + "-" + luuid + ":log 5");
    
    try{
    	for( f <- futures) browserSet.remove(f.get(0, TimeUnit.MILLISECONDS));      
    } catch {
    	case t:Exception => println(getTimeUUID() + "-" + luuid + ": in catch: " + t.getMessage());  
    }
    
    println(getTimeUUID() + "-" + luuid + ":log 5-1");
    
    val iter = browserSet.iterator();
    while (iter.hasNext()) {
      val b = iter.next();
      println("kill thread belong to browser:" + b);
      
      val url = ConnectionManager.getInstance().getOpenedRemote(b);
      
      // get URL means it got block ....
      if(url != null) {
    	val cl = new CommandLine(ClassLoader.getSystemResource("restartVm.sh").getFile());
        cl.addArgument(b);
        cl.addArgument(url.replaceAll(".*//", "").replaceAll(":.*", ""));
        new DefaultExecutor().execute(cl);
      } else
        iter.remove();
    }
    
    println(getTimeUUID() + "-" + luuid + ":log 6");
        
    if(browserSet.size() > 0) Thread.sleep(ch.getRestartSleep());
    
    for(b <- browserSet) {
      ConnectionManager.getInstance().releaseRemote(b);
    }
    
    println(getTimeUUID() + "-" + luuid + ":log 7");
    
    executorService.shutdownNow();
  }
  
  def runRawZscript(zscript: String) {
	runZscript(
		zscript
			trim ()
			replace ("\\", "\\\\")
			replace ("'", "\\'")
			replaceAll ("\r", "")
			replaceAll ("\n", "\\\\n"))
  }
  def runZTL(zscript: scala.xml.Elem, executor: () => Unit){
	runZTL(zscript.toString(),executor);
  }  

  def engine(): Widget = _engine.get();
  def driver() = getWebDriver()
}