package org.zkoss.zktest.test2.B65

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B65-ZK-1768.zul")
class B65_ZK_1768Test extends ZTL4ScalaTestCase {
  val zscript =
    """<zk>
	<window xmlns:n="native">
		<zscript><![CDATA[
				ArrayList list = new ArrayList();
				list.add("Item 1");
				list.add("Item 2");
				list.add("Item 3");
				ListModel model = new ListModelList(list);
		]]></zscript>
		<button label="Replace Model" onClick="grid.setModel(new ListModelList(list));"/>
		<button label="Update Model">
			<attribute name="onClick">
				<![CDATA[
				    ListModelList listModelList = (ListModelList)grid.getModel();
					String a = listModelList.remove(0);
					String b = listModelList.remove(1);
					listModelList.add(b);
					listModelList.add(a);
				]]>
			</attribute>
		</button>
		<button label="Show Index" onClick='msg.value="index: "+rg.selectedIndex;'/>
		<radiogroup id="rg"/>

		<grid width="350px" id="grid" model="${model}" >
			<template name="model">
				<row>
					<radio label="${each}" radiogroup="rg"/>
				</row>
			</template>
		</grid>
		
		<label id="msg"/>
		
		<div>
			Case 1:
			<n:ol>
				<n:li>select "Item 2"</n:li>
				<n:li>click [Show Index] -> label appears "index: 1"</n:li>
				<n:li>click [Replace Model]</n:li>
				<n:li>click [Show Index] -> label appears "index: -1"</n:li>
				<n:li>select "Item 2"</n:li>
				<n:li>click [Show Index] -> label appears "index: 1"</n:li>
			</n:ol>
	
			Case 2:
			<n:ol>
				<n:li>select "Item 2"</n:li>
				<n:li>click [Show Index] -> label appears "index: 1"</n:li>
				<n:li>click [Update Model]</n:li>
				<n:li>click [Show Index] -> label appears "index: 0"</n:li>
				<n:li>select "Item 3"</n:li>
				<n:li>click [Show Index] -> label appears "index: 1"</n:li>
			</n:ol>
			
			in any case the index label should never show a value > 2 after updates to the model
		</div>
	</window>
</zk>"""

  @Test
  def test1() = {

    runZTL(zscript,
      () => {
        val item2 = jq(".z-row:contains(Item 2) input")
        val show = jq(".z-button:contains(Show Index)")
        check(item2)
        waitResponse()
        click(show)
        waitResponse()
        verifyTrue(jq(".z-label:contains(index: 1)").exists())

        click(jq(".z-button:contains(Replace Model)"))
        waitResponse()
        click(show)
        waitResponse()
        verifyTrue(jq(".z-label:contains(index: -1)").exists())

        check(item2)
        waitResponse()
        click(show)
        waitResponse()
        verifyTrue(jq(".z-label:contains(index: 1)").exists())
      })

  }

  @Test
  def test2() = {

    runZTL(zscript,
      () => {
        val item2 = jq(".z-row:contains(Item 2) input")
        val show = jq(".z-button:contains(Show Index)")
        check(item2)
        waitResponse()
        click(show)
        waitResponse()
        verifyTrue(jq(".z-label:contains(index: 1)").exists())

        click(jq(".z-button:contains(Update Model)"))
        waitResponse()
        click(show)
        waitResponse()
        verifyTrue(jq(".z-label:contains(index: 0)").exists())

        check(jq(".z-row:contains(Item 3) input"))
        waitResponse()
        click(show)
        waitResponse()
        verifyTrue(jq(".z-label:contains(index: 1)").exists())
      })

  }
}