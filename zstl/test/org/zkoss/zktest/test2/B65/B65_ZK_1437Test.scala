
package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import java.util.Calendar
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.Date
import java.text.DateFormat

@Tags(tags = "B65-ZK-1437.zul")
class B65_ZK_1437Test extends ZTL4ScalaTestCase {

  def testClick() = {
    // for test, add 'test2' path into the src of include tag
    val zscript = """<zk>
                    <label multiline="true">
                      Click on "reload" button, you will see window3's title was changed to current time without error.
                    </label>
                    <window>
                      <include id="inc" src="test2/B65-ZK-1437-1.zul" mode="auto"/>
                      <button label="reload" onClick='inc.src = "test2/B65-ZK-1437-1.zul?ts=1"'/>
                    </window>
                  </zk>"""

    runZTL(zscript,
      () => {
        val fmt = new SimpleDateFormat("'Hello World!!' EEE MMM dd HH:mm:ss z yyyy", Locale.US)
        val header = jq(".z-window-embedded-header")
        val past = fmt.parse(header.text())
        
        // it verify sec is diff
        sleep(1000)
        click(jq(".z-button:contains(reload)"))
        waitResponse()
        
        val current = fmt.parse(header.text())

        verifyTrue("window3's title was changed to current time", current.after(past))
        verifyTrue("should not see any error message.", !jq(".z-errorbox").exists())
      })

  }
}