/* B50_3288779Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:59 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B50_3288779Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			


<zk>
	<html><![CDATA[
		<ol>
			<li>Click "model1 button".</li>
			<li>Click header twice.</li>
			<li>The Grid shall be sorted well.</li>
			<li>Click "model2 button".</li>
			<li>Click header twice.</li>
			<li>It shall not appear any error, and the Grid shall be sorted well.</li>
		</ol>
	]]></html>
	<zscript><![CDATA[
		import org.zkoss.zul.*;
		import java.util.*;
		public class Person {
			private String name;
	
			public Person(String name) {
				this.name = name;
			}
	
			public void setName(String name) {
				this.name = name;
			}
	
			public String getName() {
				return name;
			}
		}
		List list = new ArrayList();
		list.add(new Person("Jimmy"));
		list.add(new Person("Katrina"));
		ListModel model1 = new ListModelList(list);
		list = new ArrayList();
		list.add(new String[] { "Jimmy" });
		list.add(new String[] { "Katrina" });
		ListModel model2 = new ListModelList(list);
		void model1() {
			grid.model = null;
			col.setSort("auto(name)");
			grid.rowRenderer = new RowRenderer() {
				public void render(Row row, Object data, int index) throws Exception {
					row.appendChild(new Label(((Person) data).getName()));
				}
			};
			grid.model = model1;
		}
		void model2() {
			grid.model = null;
			col.setSort("auto(0)");
			grid.rowRenderer = new RowRenderer() {
				public void render(Row row, Object data, int index) throws Exception {
					row.appendChild(new Label(((String[]) data)[0]));
				}
			};
			grid.model = model2;
		}
	]]></zscript>
	<button label="model1" onClick="model1();" />
	<button label="model2" onClick="model2();" />
	<grid id="grid" width="300px">
		<columns>
			<column id="col" label="column" />
		</columns>
	</grid>
</zk>

		"""
    val ztl$engine = engine()
    val grid = ztl$engine.$f("grid")
    val col = ztl$engine.$f("col")
    runZTL(zscript, () => {
      click(jq("@button:eq(0)"));
      waitResponse()
      click(jq("@column"))
      waitResponse()
      click(jq("@column"))
      waitResponse()
      verifyEquals("Katrina", jq(".z-row:eq(0)").text())
      verifyEquals("Jimmy", jq(".z-row:eq(1)").text())
      click(jq("@button:eq(1)"));
      waitResponse()
      click(jq("@column"))
      waitResponse()
      click(jq("@column"))
      waitResponse()
      verifyFalse(jq(".z-error").exists())
      verifyEquals("Katrina", jq(".z-row:eq(0)").text())
      verifyEquals("Jimmy", jq(".z-row:eq(1)").text())
    })
  }
}



