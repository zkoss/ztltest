package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.annotation.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B70-ZK-2100.zul")
class B70_ZK_2100Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript = """<zk>
	should show correct
	<tabbox id="outer" orient="left" width="400px" height="300px">
		<tabs width="70px">
			<tab forEach="1,2,3,4,5,6,7,8,9,10" label="Tab 1" closable="true" />
		</tabs>
		<tabpanels>
			<tabpanel>
				<tabbox id="inner" orient="top" hflex="1" vflex="1">
					<tabs width="70px">
						<tab forEach="1,2,3,4,5,6,7,8,9,10" label="Tab 1" closable="true" />
					</tabs>
					<tabpanels>
						<tabpanel forEach="1,2,3,4,5,6,7,8,9,10">Panel 1</tabpanel>
					</tabpanels>
				</tabbox>
			</tabpanel>
			<tabpanel forEach="1,2,3,4,5,6,7,8,9">Panel 1</tabpanel>
		</tabpanels>
	</tabbox>
	<hlayout>
		<label value="outer orient" />
		<combobox onSelect="outer.orient=self.value">
			<comboitem label="top" />
			<comboitem label="left" />
			<comboitem label="right" />
			<comboitem label="bottom" />
		</combobox>
	</hlayout>
	<hlayout>
		<label value="inner orient" />
		<combobox onSelect="inner.orient=self.value">
			<comboitem label="top" />
			<comboitem label="left" />
			<comboitem label="right" />
			<comboitem label="bottom" />
		</combobox>
	</hlayout>
</zk>
"""
    runZTL(zscript,
      () => {
        val cb0 = jq(".z-combobox").eq(0).toWidget()
        val cb0btn = cb0.$n("btn")
        val cb0pp = jq(cb0.$n("pp"))
        val cb1 = jq(".z-combobox").eq(1).toWidget()
        val cb1btn = cb1.$n("btn")
        val cb1pp = jq(cb1.$n("pp"))

        List("top", "bottom", "left", "right") foreach { outer =>
          click(cb0btn)
          waitResponse()
          click(cb0pp.find(".z-comboitem:contains(" + outer + ")"))
          waitResponse()
          List("top", "bottom", "left", "right") foreach { inner =>
            click(cb1btn)
            waitResponse()
            click(cb1pp.find(".z-comboitem:contains(" + inner + ")"))
            waitResponse()
            verifyImage()
          }
        }
      })

  }
}