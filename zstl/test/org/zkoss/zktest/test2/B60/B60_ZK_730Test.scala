package org.zkoss.zktest.test2.B65

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B60-ZK-730.zul")
class B60_ZK_730Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """<zk:zk xmlns:zul="zul" xmlns:zk="zk">
                    You shall see two buttons below that look the same.
                    <separator bar="true"/>
                    <button label="01234">
                      <attribute name="width">
                        <![CDATA[ 200px ]]>
                      </attribute>
                    </button>
                    <zul:button label="01234">
                      <zk:attribute name="width">
                        <![CDATA[ 200px ]]>
                      </zk:attribute>
                    </zul:button>
                  </zk:zk>"""

    runZTL(zscript,
      () => {
        var btn0 = jq(".z-button[style]").eq(0)
        var btn1 = jq(".z-button[style]").eq(1)
        val msg = "You shall see two buttons below that look the same."
        verifyEquals(msg, btn0.width(), btn1.width())
        verifyEquals(msg, btn0.find(".z-button").text(), btn1.find(".z-button").text())
      })

  }
}
