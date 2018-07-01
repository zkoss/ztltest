package org.zkoss.zktest.test2.B50

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B50-ZK-926.zul")
class B50_ZK_926Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """<zk>
                    <listbox height="500px">
                      <custom-attributes org.zkoss.zul.listbox.rod="false"/>
                      <zscript>
                        Object[] o = new Object[100];
                      </zscript>
                      <zk forEach="${o}">
                        <listitem label="test"/>
                      </zk>
                    </listbox>
                    <script>
                      zk.afterMount(function(){
                        jq(zk.Widget.$(jq("@listbox")).ebody).scroll(function() {
                          zk.log("scroll", this.scrollTop);
                        });
                      }
                      );
                    </script>
                  </zk>"""

    runZTL(zscript,
      () => {
        jq(".z-listbox-body").toElement().set("scrollTop", 100)
        waitResponse()
        verifyContains("should see 'scroll, 100'", getZKLog(), "scroll, 100")
      })

  }
}
