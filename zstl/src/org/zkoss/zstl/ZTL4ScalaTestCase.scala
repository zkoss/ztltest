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
    val executorService = Executors.newCachedThreadPool();
    for (browser <- browsers) {    
      executorService.execute(new Runnable() {
        def run() {
          try {
            start(browser);
            windowFocus();
            windowMaximize();
            _engine.set(new Widget(new StringBuffer("zk.Desktop._dt")));

            if (!zscript.isEmpty())
              runRawZscript(
                zscript
                  toString ())

            waitResponse();

            executor();
          } catch {
            case e: SeleniumException =>
              val zbrowser = browser.asInstanceOf[ZKSelenium]
              ConfigHelper.getInstance().clearCache(zbrowser);
              zbrowser.shutdown();
              throw e;
            case other =>
              throw other;
          } finally {
            stop();
          }
        }
      })
    }
    executorService.shutdown();
    executorService.awaitTermination(_timeout, TimeUnit.MILLISECONDS);
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