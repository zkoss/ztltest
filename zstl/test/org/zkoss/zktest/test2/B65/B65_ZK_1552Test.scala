package org.zkoss.zktest.test2.B65

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B65-ZK-1552.zul")
class B65_ZK_1552Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """<window height="100%" border="normal">
	<div>
		<div>1. click the btn of combobox</div>
		<div>2. scroll to bottom, then scroll back to top</div>
		<div>3. should not show popup</div>
		<div>4. repeat these steps on datebox and bandbox</div>
	</div>
	<borderlayout>
		<center autoscroll="true">
			<div style="height: 1500px">
				<div style="margin-top: 200px">
					<combobox>
						<comboitem>First</comboitem>
						<comboitem>Second</comboitem>
						<comboitem>Third</comboitem>
					</combobox>
					<datebox></datebox>
					<bandbox id="bd">
						<bandpopup>
							<vbox>
								<hbox>
									Search
									<textbox />
								</hbox>
								<listbox width="200px"
									onSelect="bd.value=self.selectedItem.label;bd.close();">
									<listhead>
										<listheader label="Name" />
										<listheader label="Description" />
									</listhead>
									<listitem>
										<listcell label="John" />
										<listcell label="CEO" />
									</listitem>
									<listitem>
										<listcell label="Joe" />
										<listcell label="Engineer" />
									</listitem>
									<listitem>
										<listcell label="Mary" />
										<listcell label="Supervisor" />
									</listitem>
								</listbox>
							</vbox>
						</bandpopup>
					</bandbox>
				</div>
			</div>
		</center>
	</borderlayout>
</window>"""
    runZTL(zscript,
      () => {
        var center = jq(".z-center")
        val compList = List("combobox", "datebox", "bandbox")
        for (comp <- compList) {
          var wgt = jq(".z-" + comp).toWidget()
          click(wgt.$n("btn"))
          waitResponse()
          verScroll(center, 1)
          verScroll(center, 0)
          verifyTrue("should not show the " + comp + " popup", !jq(wgt.$n("pp")).isVisible())
        }
      })

  }
}