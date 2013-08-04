package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import scala.io.Source
import org.junit.Test

@Tags(tags = "B65-ZK-1600.zul")
class B65_ZK_1600Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript = """
    			   <zk>
                    <div>
                      type '123' in datebox, then click outside, you should see the err msg 'Vous devez spécifier une date. Format:'
                    </div>
                    <zscript><![CDATA[
    				  import java.util.Locale;
    				  import org.zkoss.web.Attributes;
    				  import org.zkoss.zk.ui.Sessions;
    				  import org.zkoss.util.Locales;
    				  import org.zkoss.zk.ui.util.Clients;
      
    				  Locale locale = new Locale("fr","FR");
    				  Sessions.getCurrent().setAttribute(Attributes.PREFERRED_LOCALE, locale);
    				  Clients.reloadMessages(locale);
    				  Locales.setThreadLocal(locale);
    				]]></zscript>
                    <datebox />
                  </zk>"""

    runZTL(zscript,
      () => {
        val datebox = jq(".z-datebox").toWidget().$n("real")
        sendKeys(datebox, "123")
        waitResponse()
        blur(datebox)
        waitResponse()
        
        verifyTrue("should see error message 'Vous devez spécifier une date.' .", jq(".z-errorbox-content").text().contains("cifier une date."))
      })

  }
}
