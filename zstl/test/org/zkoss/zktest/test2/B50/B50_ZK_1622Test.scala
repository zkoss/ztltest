package org.zkoss.zktest.test2.B50

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B50-ZK-1622.zul")
class B50_ZK_1622Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript = """<zk>
<zscript><![CDATA[
java.util.List items = new java.util.ArrayList();
for (int i = 1; i <= 70; ++i)
	items.add(i + "");
]]></zscript>
	<label multiline="true">
	1. Scroll down "Listbox" and select last item.
	2. Go to second page and scroll down, should not see blank area.
	3. Also test on "Tree".
	</label>
	<separator />
	<window height="400px" width="600px">
		<hlayout hflex="1" vflex="1">
			<listbox mold="paging" hflex="1" vflex="1" checkmark="true" pageSize="50">
				<listhead>
					<listheader label="Listbox" />
				</listhead>
				<listitem forEach="${items}">
						<listcell label="${each}" />
				</listitem>
			</listbox>
			<tree mold="paging" hflex="1" vflex="1" checkmark="true" pageSize="50">
				<treecols>
					<treecol label="Tree" />
				</treecols>
				<treechildren>
					<treeitem forEach="${items}">
						<treerow>
							<treecell label="${each}" />
						</treerow>
					</treeitem>
				</treechildren>
			</tree>
		</hlayout>
	</window>
</zk>"""
    runZTL(zscript,
      () => {
        List("listbox", "tree") foreach { compName =>
          val main = jq(".z-" + compName)
          val body = jq(".z-" + compName + "-body")
          verScroll(body, 1)
          
          val cell = if(compName == "listbox") "listcell" else "treecell"
          click(jq(".z-" + cell + ":contains(50)"))
          waitResponse()
          click(jq("[name=" + main.find(".z-paging").attr("id") + "-next]"))
          waitResponse()
          verScroll(body, 1)

          verifyTrue("should not see blank area.", body.scrollTop() < 350)
        }
      })

  }
}