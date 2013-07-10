package org.zkoss.zktest.test2.B65
import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "B65-ZK-1217.zul")
class B65_ZK_1217Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = """
      <zk>
<label multiline="true"><![CDATA[
1. Please click upon "Contacts" to close the groupbox, and then open/close panel or borderlayout's north.
2. Please click upon "Contacts" to open the groupbox, and then its content shouldn't be hidden.
]]></label>
	<panel title="panel" border="normal" width="100px"
		collapsible="true">
		<panelchildren>
			<groupbox mold="3d" height="100%">
				<caption label="Contacts" />
				<div>a</div>
				<div>a</div>
			</groupbox>
		</panelchildren>
	</panel>
	
	<borderlayout  width="100px">
		<west title="north" collapsible="true">
			<div>
				<groupbox mold="3d" height="100%">
					<caption label="Contacts" />
					<div>a</div>
					<div>a</div>
				</groupbox>
			</div>
		</west>
	</borderlayout>
</zk>
    """;

    runZTL(zscript,
      () => {
        0 to 1 foreach (n => captionTest(n))

      })

    def captionTest(n: Int) {
      val nthCaption = jq("@caption:eq(" + n + ")")
      val collapsibleWidget = jq(jq(".z-groupbox:eq(" + n + ")").toWidget().$n("cave"))
      val block = collapsibleWidget.css("display")

      click(nthCaption)
      waitResponse()
      sleep(1000)

      verifyNotEquals("panel or borderlayout should be open/close", collapsibleWidget.css("display"), block)

      click(nthCaption)
      waitResponse()
      sleep(1000)

      verifyEquals("its content shouldn't be hidden", collapsibleWidget.css("display"), block)
    }

  }
}
