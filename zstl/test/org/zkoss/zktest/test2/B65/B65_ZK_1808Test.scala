package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B65-ZK-1808.zul")
class B65_ZK_1808Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript = """<?page title="new page title" contentType="text/html;charset=UTF-8"?>
<zk xmlns:n="native">
select tab2 and close it, should not cause an error, also creation of new tabs should not be affected

	<tabbox id="tabbox" >
		<tabs id="tabs">
			<tab id="tab1" label="Tab 1" closable="true"/>
			<tab id="tab2" label="Tab 2" closable="true"/>
		</tabs>
		<tabpanels id="tabpanels">
			<tabpanel id="panel1">
				Panel 1
			</tabpanel>
			<tabpanel id="panel2">
				Panel 2
			</tabpanel>
		</tabpanels>
	</tabbox>
	<button label="add" >
		<attribute name="onClick">
			<![CDATA[
			         Tab tab = new Tab("Tab new");
			         tab.setClosable(true);
			         tabs.appendChild(tab);
			         Tabpanel tabpanel = new Tabpanel();
			         tabpanel.appendChild(new Label("Content new"));
			         tabpanels.appendChild(tabpanel);			 
			]]>
		</attribute>
	</button>
	<idspace>
	same should work in accordion mold
	
		<tabbox id="tabbox-accordion" mold="accordion" width="200px">
			<tabs id="tabs">
				<tab id="tab1" label="Tab 1" closable="true"/>
				<tab id="tab2" label="Tab 2" closable="true"/>
			</tabs>
			<tabpanels id="tabpanels">
				<tabpanel id="panel1">
					Panel 1
				</tabpanel>
				<tabpanel id="panel2">
					Panel 2
				</tabpanel>
			</tabpanels>
		</tabbox>
		<button label="add" >
			<attribute name="onClick">
				<![CDATA[
				         Tab tab = new Tab("Tab new");
				         tab.setClosable(true);
				         tabs.appendChild(tab);
				         Tabpanel tabpanel = new Tabpanel();
				         tabpanel.appendChild(new Label("Content new"));
				         tabpanels.appendChild(tabpanel);			 
				]]>
			</attribute>
		</button>
			
	</idspace>
</zk>"""
    runZTL(zscript,
      () => {
        List("tab", "tab-accordion").zipWithIndex foreach {
          case (value, index) =>
            val tab = jq(".z-" + value + ":contains(Tab 2)").toWidget()
            click(tab)
            waitResponse()

            click(tab.$n("close"))
            waitResponse()
            verifyFalse("should see no javascript error", jq(".z-error").exists())

            click(jq(".z-button:contains(add)").eq(index))
            waitResponse()
            verifyFalse("should see no javascript error", jq(".z-error").exists())
        }

      })

  }
}