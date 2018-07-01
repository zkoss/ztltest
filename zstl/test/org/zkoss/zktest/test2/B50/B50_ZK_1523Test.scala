package org.zkoss.zktest.test2.B50

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B50-ZK-1523.zul")
class B50_ZK_1523Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """<zk>
	<label multiline="true">
	1. Click "test one", will alert "button one on later".
	2. Click "test two", will alert "button two on later".
	
	NOTICE: 
	* CAN'T CLICK "Tab 2" BEFORE TESTING!!
	* "button one" is not visible.
	</label>
	<separator />
	<tabbox width="400px" id="tbx">
		<tabs>
			<tab label="Tab 1" />
			<tab label="Tab 2" />
		</tabs>
		<tabpanels>
			<tabpanel id="tp">
				This is panel 1
				<button id="btnOne" visible="false">
					<attribute name="onLater"><![CDATA[
						alert("button one on later");
					]]></attribute>
				</button>
			</tabpanel>
			<tabpanel id="tp2">
				<button id="btnTwo">
					<attribute name="onLater"><![CDATA[
						alert("button two on later");
					]]></attribute>
				</button>
			</tabpanel>
		</tabpanels>
	</tabbox>
	<button label="test one">
		<attribute name="onClick"><![CDATA[
			Events.echoEvent("onLater", btnOne, null); //echo an event back
		]]></attribute>
	</button>
	<button label="test two">
		<attribute name="onClick"><![CDATA[
			Events.echoEvent("onLater", btnTwo, null); //echo an event back
		]]></attribute>
	</button>
</zk>"""
    runZTL(zscript,
      () => {
        var list = List("one", "two")
        for (text <- list) {
          click(jq(".z-button:contains(test " + text + ")"))
          waitResponse()
          val win = jq(".z-messagebox-window")
          verifyTrue("button one on later", win.find(".z-label:contains(button " + text + " on later)").exists())
          click(win.find(".z-button:eq(0)"))
          waitResponse()
        }
      })
  }
}