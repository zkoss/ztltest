package org.zkoss.zktest.test2.B65

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B65-ZK-2080.zul")
class B65_ZK_2080Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """<zk>
	<zscript><![CDATA[
		public class Item {
			private String name;
		
			public Item(String name) {
				super();
				this.name = name;
			}
		
			public String getName() {
				return name;
			}
		
			public void setName(String name) {
				this.name = name;
			}
		
			public int hashCode() {
				final int prime = 31;
				int result = 1;
				result = prime * result + ((name == null) ? 0 : name.hashCode());
				return result;
			}
		
			public boolean equals(Object obj) {
				if (this == obj)
					return true;
				if (obj == null)
					return false;
				if (getClass() != obj.getClass())
					return false;
				Item other = (Item) obj;
				if (name == null) {
					if (other.name != null)
						return false;
				} else if (!name.equals(other.name))
					return false;
				return true;
			}
			
			//public String toString() { return this.name; }
		}
		List l2 = Arrays.asList(new Item[]{
				new Item("AA"), new Item("BB"), new Item("CC"), new Item("DD"), new Item("EE")});
                ListModelList model1 = new ListModelList(l2);
		ListSubModel smodel2 = (ListSubModel) ListModels.toListSubModel(new ListModelList(l2));
	]]></zscript>
	<label multiline="true">
	Type A in the input, should see popup with "AA" option showed.
	</label>
	ListSubModel
	<chosenbox id="box2" width="200px" model="${smodel2}" >
		<template name="model">
			<label value="${each.name}"/>
		</template>
	</chosenbox>
</zk>"""
    runZTL(zscript,
      () => {
        val inp = jq(".z-chosenbox").toWidget().$n("inp")
        sendKeys(inp, "A")
        waitResponse(true)
        sleep(200)
        verifyTrue("should see popup with 'AA' option showed.", jq(".z-chosenbox-option:contains(AA)").exists)
      })

  }
}