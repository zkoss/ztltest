/* B30_2388345Test.java

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


class B30_2388345Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			

<?init class="org.zkoss.zkplus.databind.AnnotateDataBinderInit"?>
<window id="prods" xmlns="http://www.zkoss.org/2005/zul" 
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
	xsi:schemaLocation="http://www.zkoss.org/2005/zul 
		http://www.zkoss.org/2005/zul/zul.xsd">
	<html><![CDATA[
<p>If you see a Listbox with Listheader "Key | Value" header, and Listitem  "Name | Frank", it is OK.</p>
	]]>
	</html>
<zscript><![CDATA[
	public	class	Dummy
	{
		private	String		key;
		private	String		value;
		
		public Dummy()
		{
		}
		public Dummy(String k, String v)
		{
			key=k;
			value=v;
		}
		public String getKey()
		{
			return this.key;
		}
		public String getValue()
		{
			return this.value;
		}
	}
	
	ListModelList list = new ListModelList(new ArrayList(), true);
	list.add(new Dummy("Name","Frank"));
]]></zscript>
	<listbox model="${list}" width="200px">
		<listhead>
			<listheader label="Key"/>
			<listheader label="Value"/>
		</listhead>
		<listitem self="@{each='dummy1'}">
			<listcell label="@{dummy1.key}"/>
			<listcell label="@{dummy1.value}"/>
		</listitem>
	</listbox>
</window>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val prods = ztl$engine.$f("prods")
    runZTL(zscript, () => {
      sleep(1000); //for DataBinding
      verifyEquals("Key", jq("@listheader:eq(0)").text())
      verifyEquals("Value", jq("@listheader:eq(1)").text())
      verifyEquals("Name", jq("@listcell:eq(0)").text())
      verifyEquals("Frank", jq("@listcell:eq(1)").text())
    })
  }
}



