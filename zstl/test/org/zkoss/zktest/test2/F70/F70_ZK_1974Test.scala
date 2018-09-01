package org.zkoss.zktest.test2.F70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "F70-ZK-1974.zul")
class F70_ZK_1974Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """<zk>
	<div>
		1. for each rod or in accordion mold tabbox, all heights of
		tabpanels should be same
	</div>
	<div>
		2. click 'add', then the height of 4th tabpanel should not be
		same as other's height
	</div>
	<hbox>
		<window title="rod" border="normal" height="400px">
			<tabbox id="rod" maximalHeight="true" width="300px">
				<tabs id="tabs0">
					<tab label="Tab1" />
					<tab label="Tab2" />
					<tab label="Tab3" />
				</tabs>
				<tabpanels id="pnls0">
					<tabpanel>
						<div>Tabpanel Content 1</div>
						<div>Tabpanel Content 1</div>
						<div>Tabpanel Content 1</div>
					</tabpanel>
					<tabpanel>
						<div>Tabpanel Content 2</div>
						<div>Tabpanel Content 2</div>
					</tabpanel>
					<tabpanel>
						<div>Tabpanel Content 3</div>
						<div>Tabpanel Content 3</div>
						<div>Tabpanel Content 3</div>
						<div>Tabpanel Content 3</div>
					</tabpanel>
				</tabpanels>
			</tabbox>
			<button label="add tab and tabpanel">
				<attribute name="onClick"><![CDATA[
	Tab tab = new Tab("Tab4");
	tab.setParent(tabs0);
	Tabpanel tp = new Tabpanel();
	tp.setHeight("600");

	for (int i = 0; i < 6; i++) {
		Div d = new Div();
		d.appendChild(new Label("Tabpanel Content 4"));
		tp.appendChild(d);
	}
	tp.setParent(pnls0);
]]></attribute>
			</button>

		</window>
		<window title="accordion" border="normal" height="400px">
			<tabbox maximalHeight="true" mold="accordion"
				width="300px">
				<tabs>
					<tab label="Tab1" />
					<tab label="Tab2" />
					<tab label="Tab3" />
				</tabs>
				<tabpanels>
					<tabpanel>
						<div>Tabpanel Content 1</div>
						<div>Tabpanel Content 1</div>
						<div>Tabpanel Content 1</div>
					</tabpanel>
					<tabpanel>
						<div>Tabpanel Content 2</div>
						<div>Tabpanel Content 2</div>
					</tabpanel>
					<tabpanel>
						<div>Tabpanel Content 3</div>
						<div>Tabpanel Content 3</div>
						<div>Tabpanel Content 3</div>
						<div>Tabpanel Content 3</div>
						<div>Tabpanel Content 3</div>
						<div>Tabpanel Content 3</div>
					</tabpanel>
				</tabpanels>
			</tabbox>
		</window>
		<window title="non rod" border="normal" height="400px">
			<tabbox width="300px">
				<tabs>
					<tab label="Tab1" />
					<tab label="Tab2" />
					<tab label="Tab3" />
				</tabs>
				<tabpanels>
					<tabpanel>
						<div>Tabpanel Content 1</div>
						<div>Tabpanel Content 1</div>
						<div>Tabpanel Content 1</div>
					</tabpanel>
					<tabpanel>
						<div>Tabpanel Content 2</div>
						<div>Tabpanel Content 2</div>
					</tabpanel>
					<tabpanel>
						<div>Tabpanel Content 3</div>
						<div>Tabpanel Content 3</div>
						<div>Tabpanel Content 3</div>
						<div>Tabpanel Content 3</div>
						<div>Tabpanel Content 3</div>
						<div>Tabpanel Content 3</div>
					</tabpanel>
				</tabpanels>
			</tabbox>
		</window>
	</hbox>
</zk>"""
    runZTL(zscript,
      () => {
        for (index <- 0 to 1) {
          val tb = jq(".z-tabbox").eq(index)
          var h = 0
          for (tabIndex <- 0 to 2) {
            click(tb.find(".z-tab:eq(" + tabIndex + ")"))
            waitResponse()
            sleep(500)

            val tph = tb.find(".z-tabpanel").eq(tabIndex).height()
            if (tabIndex == 0) {
              h = tph
            } else {
              verifyTrue("all heights of tabpanels should be same", h == tph)
            }
          }
          h = 0
        }
        val tb = jq(".z-tabbox").eq(0)
        val h = tb.find(".z-tabpanel").eq(2)

        click(jq(".z-button"))
        waitResponse()

        click(tb.find(".z-tab:eq(3)"))
        waitResponse()

        verifyTrue("the height of 4th tabpanel should not be same as other's height", h != tb.find(".z-tabpanel").eq(3).height())

      })

  }
}