package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "B65-ZK-1076.zul")
class B65_ZK_1076Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = """<zk>
	<window title="Hello World!!" border="normal" width="800px"
		height="500px">
                  <zscript>
                    ListModelList model = new ListModelList();
                    model.add("a");
                    model.add("b");
                    model.add("c");
                  </zscript>
        <label multiline="true">
        1. Please click the button "Show Items" to see if the combobox is shown in the tab "Items"
        2. Please click the tab "tab 1" and then click the button "Show Items" again
        3. Check whether the combobox is shown in the tab "Items"
        </label>
		<tabbox hflex="1" vflex="1">
			<tabs>
				<tab label="tab 1" />
				<tab label="Items" id="tabItems" />
			</tabs>
			<tabpanels>
				<tabpanel>
					<button label="Show Items"
						onClick='listbox.invalidate();tabItems.setSelected(true)' />
				</tabpanel>
				<tabpanel>
					<borderlayout height="100%" width="100%">
						<north size="30px" flex="true" splittable="true" minsize="30" maxsize="30" >
							<combobox />
						</north>
						<center autoscroll="true">
							<listbox id="listbox" model="${model}" >
								<listhead>
									<listheader label="id" />
									<listheader label="descricao" />
								</listhead>
                                               <!--            <template name="model">
                                                          <listitem >
										<listcell
											label="${eacn}-1" />
										<listcell
											label="${each}-2" />
									</listitem>
                                                          </template> -->
							</listbox>
						</center>
					</borderlayout>
				</tabpanel>
			</tabpanels>
		</tabbox>
	</window>
</zk>"""

    runZTL(zscript,
      () => {
        click(jq(".z-button:contains(Show Items)"))
        waitResponse()

        verifyTrue("should see the combobox is shown", jq(".z-tabpanel[style!=none] .z-combobox-input").exists())

        click(jq(".z-tab:contains(tab 1)"))
        waitResponse()
        click(jq(".z-button:contains(Show Items)"))
        waitResponse()

        verifyTrue("should see the combobox is shown", jq(".z-tabpanel[style!=none] .z-combobox-input").exists())

      })

  }
}
