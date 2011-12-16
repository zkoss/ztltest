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

  var _engine: Widget = null;
  
  def runZTL(zscript: String, executor: () => Unit) {
    for (browser <- browsers) {
      try {
        start(browser);
        windowFocus();
        windowMaximize();
        _engine = new Widget(new StringBuffer("zk.Desktop._dt"))

        if (!zscript.isEmpty())
	        runRawZscript(
	          zscript 
	          toString())

        waitResponse();

        executor();
		} catch {
			case e : SeleniumException =>
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

  def engine(): Widget = _engine;
}