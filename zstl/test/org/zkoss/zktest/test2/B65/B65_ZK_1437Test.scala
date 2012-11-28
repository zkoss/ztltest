
package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import java.util.Calendar

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
        val now = Calendar.getInstance
        click(jq("@button:contains(reload)"))
        waitResponse(1000)
        val headerText = jq(".z-window-embedded-header").text()

        val isBound = 1 to 30 map { i =>
          now.add(Calendar.SECOND, 1)
          "Hello World!! %1$ta %1$tb %1$td %1$tT %1$tZ %1$tY" format now
        } exists (_ == headerText)

        verifyTrue("window3's title was changed to current time", isBound)
        verifyTrue("should not see any error message.", !jq(".z-errbox").exists())
      })

  }
}