/* B30_1873021Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B30_1873021Test extends ZTL4ScalaTestCase {
  @Test
  def testLoading() = {
    var zscript =
      """
			<zk>
			<html><![CDATA[
			If you did not see any Exception like below, then it is OK.<br/>
			<br/>
			java.lang.IndexOutOfBoundsException: Index: 16, Size: 4<br/>
				at org.zkoss.zk.ui.AbstractComponent$ChildIter.<init>(AbstractComponent.java:1606)<br/>
				at org.zkoss.zk.ui.AbstractComponent$ChildIter.<init>(AbstractComponent.java:1599)<br/>
				at org.zkoss.zk.ui.AbstractComponent$1.listIterator(AbstractComponent.java:234)<br/>
				at java.util.AbstractSequentialList.get(AbstractSequentialList.java:71)<br/>
				at org.zkoss.zul.Listbox$1.get(Listbox.java:168)<br/>
				at org.zkoss.zul.Listbox.getItemAtIndex(Listbox.java:490)<br/>
				at org.zkoss.zul.Listbox.onInitRender(Listbox.java:1331)<br/>
				at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)<br/>
				at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:39)<br/>
			]]></html>
			<window title="Live Data Demo" border="normal">
				<zscript>
					String[] data = new String[3];
					for(int j=0; j &lt; data.length; ++j) {
						data[j] = "option "+j;
					}
					ListModel strset = new SimpleListModel(data);
				</zscript>
				<listbox id="list" width="200px" rows="10" model="&#36;{strset}">
					<listhead>
						<listheader label="Load on Demand" sort="auto"/>
					</listhead>
				</listbox>
			</window>
			</zk>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val list = ztl$engine.$f("list")
    runZTL(zscript, () => {
      verifyTrue(jq(list).exists())
      verifyEquals(3, jq(list).find(".z-listcell").length())
    })
  }
}



