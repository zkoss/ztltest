package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "Touch,Android")
class Thm_Anchor_Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = """<zk>
                    <div>
                      Normal:<a href="http://www.zkoss.org" label="ZK"/>
                      /<a href="http://www.zkoss.xyz" label="Unknown"/>
                    </div>
                    <div>
                      Disabled:<a href="http://www.zkoss.org" disabled="true" label="ZK"/>
                      /<a href="http://www.zkoss.xyz" disabled="true" label="Unknown"/>
                    </div>
                    <window>
                      <caption>
                        <div>
                          Normal:<a href="http://www.zkoss.org" label="ZK"/>
                          /<a href="http://www.zkoss.xyz" label="Unknown"/>
                        </div>
                        <div>
                          Disabled:<a href="http://www.zkoss.org" disabled="true" label="ZK"/>
                          /<a href="http://www.zkoss.xyz" disabled="true" label="Unknown"/>
                        </div>
                      </caption>
                    </window>
                    <combobox>
                      <comboitem/>
                    </combobox>
                  </zk>"""

    runZTL(zscript,
      () => {
        verifyImage()
      })

  }
}
